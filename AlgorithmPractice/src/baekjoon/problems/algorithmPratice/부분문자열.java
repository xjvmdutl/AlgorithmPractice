package baekjoon.problems.algorithmPratice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 부분문자열 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String s = reader.readLine();
		String p = reader.readLine();
		System.out.println(solution(s,p));
	}

	private static int solution(String s, String p) {
		int[] table = makeTable(p);
		int sLen = s.length();
		int pLen = p.length();
		int idx = 0;
		for(int i=0; i< sLen; i++) {
			while(idx>0 && s.charAt(i) != p.charAt(idx)) {
				idx = table[idx-1];
			}
			
			if(s.charAt(i) == p.charAt(idx)) {
				if(idx == pLen-1) {
					idx = table[idx];
					return 1; // 매칭이 되었으면 1  
				}else {
					idx += 1;
				}
			}
		}
		return 0;
	}

	private static int[] makeTable(String s) {
		int n = s.length();
		int[] table = new int[n];
		int idx = 0;
		for(int i=1;i<n;++i) {
			while(idx > 0 && s.charAt(i) != s.charAt(idx)) {
				idx = table[idx-1];
			}
			if(s.charAt(i) == s.charAt(idx)) {
				idx += 1;
				table[i] = idx;  
			}
		}
		return table;
	}

}
