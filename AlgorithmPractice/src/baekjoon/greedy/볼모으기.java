package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 볼모으기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		char[] arr = new char[n];
		String strs = reader.readLine();
		System.out.println(solution(strs,n));		
	}

	private static int solution(String colors, int N) {
		int result = N;
		int rCnt = 0;
		int bCnt = 0;
		
		for(int i=0; i<N; i++) {
			if(colors.charAt(i)=='R') 
				rCnt ++;
			else
				bCnt ++;
		}
		
		int cnt = 0;
		// 4가지 경우
		// 1. R만 움직여서 RRRBBB(R을 다 왼쪽으로)
		for(int i=0; i<N; i++) {
			if(colors.charAt(i)=='R')
				cnt++;
			else
				break;
		}
		result = Math.min(result, rCnt-cnt);
		
		// 2. R만 움직여서 BBBRRR
		cnt = 0;
		for(int i=N-1; i>=0; i--) {
			if(colors.charAt(i)=='R')
				cnt++;
			else
				break;
		}
		
		result = Math.min(result, rCnt-cnt);
		
		// 3. B만 움직여서 BBBRRR
		cnt = 0;
		for(int i=0; i<N; i++) {
			if(colors.charAt(i)=='B')
				cnt++;
			else
				break;
		}
		result = Math.min(result, bCnt-cnt);
		
		// 4. B만 움직여서RRRBBB
		cnt = 0;
		for(int i=N-1; i>=0; i--) {
			if(colors.charAt(i)=='B')
				cnt++;
			else
				break;
		}
		
		result = Math.min(result, bCnt-cnt);
		
		return result;
	}

}
