package baekjoon.stepbystep.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class 그룹단어 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int count = 0;
		int n = Integer.parseInt(reader.readLine());
		for(int i=0;i<n;++i) {
			String str = reader.readLine();
			count += solution(str);
		}
		System.out.println(count);
	}

	private static int solution(String str) {
		int answer = 1;
		HashSet<Character> set = new HashSet<>();
		for(int i=0;i<str.length();++i) {
			char c = str.charAt(i);
			if(!set.contains(c)) {
				set.add(c);
				while(i<str.length() && str.charAt(i) == c) {
					i++;
				}
				i--;
			}else {
				answer = 0;
				break;
			}
		}
		return answer;
	}

}
