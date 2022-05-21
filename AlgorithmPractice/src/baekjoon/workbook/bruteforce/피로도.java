package baekjoon.workbook.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ÇÇ·Îµµ {
	private static final int ONE_DAY = 24;
	private static int solution(int a, int b, int c, int m) {
		int answer = 0;
		int fatigue = 0;
		for(int i=0;i < ONE_DAY;++i) {
			if(fatigue + a <= m) {
				fatigue += a;
				answer += b;
			}else {
				fatigue -= c;
				if(fatigue < 0 ) {
					fatigue = 0;
				}
			}
		}
		return answer;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int a = Integer.parseInt(tokens.nextToken());
		int b = Integer.parseInt(tokens.nextToken());
		int c = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		System.out.println(solution(a,b,c,m));
	}
}
