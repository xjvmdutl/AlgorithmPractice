package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ������ {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(solution(reader.readLine()));
	}

	private static int solution(String str) {
		int answer = 0;
		for(int i=0;i<str.length();++i) {
			//��� 0���� �ٲٱ�
			if(str.charAt(i) == '1') {
				int j = i+1;
				for(;j<str.length();++j) {
					if(str.charAt(j) == '0')
						break;
				}
				i = j;
				answer++;
			}
		}
		int count = 0;
		for(int i=0;i<str.length();++i) {
			//��� 1���� �ٲٱ�
			if(str.charAt(i) == '0') {
				int j = i+1;
				for(;j<str.length();++j) {
					if(str.charAt(j) == '1')
						break;
				}
				i = j;
				count++;
			}
		}
		return Math.min(answer, count);
	}

}
