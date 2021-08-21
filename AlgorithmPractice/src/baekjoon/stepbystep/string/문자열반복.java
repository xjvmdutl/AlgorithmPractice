package baekjoon.stepbystep.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열반복 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		for(int i =0;i<t;++i) {
			String[] strs = reader.readLine().split(" ");
			int n = Integer.parseInt(strs[0]);
			String str = strs[1];
			System.out.println(solution(n,str));
		}
	}

	private static String solution(int n, String str) {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<str.length();++i) {
			for(int j=0;j<n;++j) {
				sb.append(str.charAt(i));
			}
		}
		return sb.toString();
	}

}
