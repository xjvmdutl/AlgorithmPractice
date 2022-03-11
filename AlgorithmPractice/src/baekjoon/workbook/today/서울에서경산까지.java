package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
class Fundraising{
	int length;
	int money;
	public Fundraising(int length, int money) {
		this.length = length;
		this.money = money;
	}
	
}
public class 서울에서경산까지 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int k = Integer.parseInt(tokens.nextToken());
		Fundraising[][] map = new Fundraising[n][2];
		for(int i=0;i<n;++i) {
			tokens = new StringTokenizer(reader.readLine());
			map[i][0] = new Fundraising(Integer.parseInt(tokens.nextToken()), Integer.parseInt(tokens.nextToken()));
			map[i][1] = new Fundraising(Integer.parseInt(tokens.nextToken()), Integer.parseInt(tokens.nextToken()));
		}
		System.out.println(solution(map, n, k));
	}

	private static int solution(Fundraising[][] map, int n, int k) {
		int[][] dp = new int[n][k+1];
		boolean[][] visit = new boolean[n][k+1];
	
		dp[0][map[0][0].length] = map[0][0].money;
		dp[0][map[0][1].length] = Math.max(map[0][1].money, dp[0][map[0][1].length]);
		visit[0][map[0][0].length] = true;
		visit[0][map[0][1].length] = true;
		
		for(int i=1;i<map.length;++i) {
			for(int j=0;j<=k;++j) {
				if(!visit[i-1][j])
					continue;
				Fundraising fundraisingWork = map[i][0];
				if(fundraisingWork.length + j <= k) {
					visit[i][fundraisingWork.length+j] = true;
					dp[i][fundraisingWork.length + j] = Math.max(dp[i][fundraisingWork.length + j]
							, dp[i-1][j] + fundraisingWork.money);
				}
				Fundraising fundraisingBike = map[i][1];
				if(fundraisingBike.length + j <= k) {
					visit[i][fundraisingBike.length+j] = true;
					dp[i][fundraisingBike.length + j] = Math.max(dp[i][fundraisingBike.length + j]
							, dp[i-1][j] + fundraisingBike.money);
				}
			}
		}
		int answer = 0;
		for(int i=0;i<=k;i++) {
			answer=Math.max(answer, dp[n-1][i]);
		}
		return answer;
	}

}
