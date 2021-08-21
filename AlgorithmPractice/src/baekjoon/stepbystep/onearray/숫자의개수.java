package baekjoon.stepbystep.onearray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 숫자의개수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(reader.readLine());
		int b = Integer.parseInt(reader.readLine());
		int c = Integer.parseInt(reader.readLine());
		System.out.println(solution(a,b,c));
	}

	private static String solution(int a, int b, int c) {
		long num = a * b * c;
		int[] arr = new int[10];
		char[] charData = String.valueOf(num).toCharArray();
		for(int i=0;i<arr.length;++i) {
			char data = (char) ('0' + i);
			int cnt = 0;
			for(int j=0;j<charData.length;++j) {
				if(charData[j] == data) {
					cnt++;
				}
			}
			arr[i] = cnt;
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<arr.length;++i) {
			sb.append(arr[i] + "\n");
		}
		return sb.toString();
	}

}
