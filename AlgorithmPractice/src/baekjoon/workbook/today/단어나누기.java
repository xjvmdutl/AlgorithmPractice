package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 단어나누기 {
	public static String answer;
	public static boolean isFirst;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new  InputStreamReader(System.in));
		String str = reader.readLine();
		System.out.println(solution(str));
	}

	private static String solution(String str) {
		answer = "";
		isFirst = true;
		for(int i=1;i<str.length()-1;++i) {
			for(int j=i+1;j<str.length();++j) {
				StringBuilder sb1 = new StringBuilder(str.substring(0, i));
				StringBuilder sb2 = new StringBuilder(str.substring(i, j));
				StringBuilder sb3 = new StringBuilder(str.substring(j));
				StringBuilder last = new StringBuilder();
				last.append(sb1.reverse().toString());
				last.append(sb2.reverse().toString());
				last.append(sb3.reverse().toString());
				if(isFirst) {
					isFirst = false;
					answer = last.toString();
					continue;
				}
				if(last.toString().compareTo(answer) < 0) {
					answer = last.toString();
				} 
			}	
		}
		return answer;
	}
}
