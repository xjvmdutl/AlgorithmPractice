package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 최고의팀만들기 {
	public static int[][][] dp = new int[1001][16][16];
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int[] white = new int[1001];
		int[] black = new int[1001];
		int idx = 0;
		String str;
		while((str = reader.readLine()) != null) {
			StringTokenizer tokens = new StringTokenizer(str);
			white[idx] = Integer.parseInt(tokens.nextToken());
			black[idx] = Integer.parseInt(tokens.nextToken());
			idx++;
		}
		System.out.println(solution(white, black, idx));
	}

	private static int solution(int[] white, int[] black, int n) {
		return permulate(white, black, 0, 0, 0, n);
	}

	private static int permulate(int[] white, int[] black, int wCount, int bCount, int count, int n) {
		if(wCount == 15 && bCount == 15)
			return 0;
		if(count == n)
			return 0;
        if(dp[count][wCount][bCount] != 0) 
        	return dp[count][wCount][bCount];
        int ans = permulate(white, black, wCount, bCount, count + 1, n);
        if(wCount < 15) ans = Math.max(ans, permulate(white, black, wCount + 1, bCount, count + 1 ,n) + white[count]);
        if(bCount < 15) ans = Math.max(ans, permulate(white, black, wCount, bCount + 1, count + 1 ,n) + black[count]);
        //black
        dp[count][wCount][bCount] = ans;
        return dp[count][wCount][bCount];
	}

}
