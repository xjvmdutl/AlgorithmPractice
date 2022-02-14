package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 명령프롬프트 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		String[] arr = new String[n];
		for(int i=0;i<n;++i) {
			arr[i] = reader.readLine();
		}
		System.out.println(solution(arr, n));
	}

	private static String solution(String[] arr, int n) {
		StringBuilder sb = new StringBuilder();
		OUTER:for(int i = 0;i< arr[0].length();++i) {
			char c = arr[0].charAt(i);
			for(int j=1;j<n;++j) {
				if(c != arr[j].charAt(i)) {
					sb.append("?");
					continue OUTER;
				}
			}
			sb.append(c);
		}
		return sb.toString();
	}

}
