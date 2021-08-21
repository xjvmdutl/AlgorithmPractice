package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 카드문자열 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		for(int i=0;i<t;++i) {
			int n = Integer.parseInt(reader.readLine());
			String[] strs = reader.readLine().split(" ");
			char[] arr = new char[n];
			for(int j=0;j<n;++j)
				arr[j] = strs[j].charAt(0);
			System.out.println(solution(arr,n));
		}
	}

	private static String solution(char[] arr, int n) {
		ArrayList<Character> list = new ArrayList<>();
		list.add(arr[0]);
		for(int i=1;i<n;++i) {
			char c = arr[i];
			if(c <= list.get(0)) {
				list.add(0, c);
			}else {
				list.add(c);
			}
		}
		StringBuilder sb = new StringBuilder();
		for(char c : list) {
			sb.append(c);
		}
		return sb.toString();
	}

}
