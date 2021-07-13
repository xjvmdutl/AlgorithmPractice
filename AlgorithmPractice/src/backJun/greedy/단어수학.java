package backJun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 단어수학 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		String[] str = new String[n];
		for(int i=0;i<n;++i)
			str[i] = reader.readLine();
		System.out.println(solution(str,n));
	}

	private static int solution(String[] str, int n) {
		int answer = 0;
		char[] data = new char[10];
		Arrays.sort(str,(o1,o2)->o2.length()-o1.length());
		for(int i=0;i<str.length-1;++i) {
			if(str[i].length() > str[i+1].length()) {
				
			}
		}
		return answer;
	}

}
