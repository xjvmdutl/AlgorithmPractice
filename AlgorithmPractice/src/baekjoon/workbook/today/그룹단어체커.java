package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class 그룹단어체커 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		String[] strs = new String[n];
		for(int i=0;i<n;++i) {
			strs[i] = reader.readLine();
		}
		System.out.println(solution(strs, n));
	}

	private static int solution(String[] strs, int n) {
		int answer = 0;
		OUTER:for(String str : strs) {
			Set<Character> set = new HashSet<>();
			char now = str.charAt(0);
			set.add(now);
			for(int j=1;j<str.length();++j) {
				char c = str.charAt(j);
				if(now != c) {
					if(set.contains(c)) {
						continue OUTER;
					}
					now = c;
					set.add(c);
				}
			}
			answer++;
		}
		return answer;
	}

}
