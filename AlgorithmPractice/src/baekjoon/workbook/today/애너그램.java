package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 애너그램 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		while(t-- > 0) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			String a = tokens.nextToken();
			String b = tokens.nextToken();
			System.out.println(solution(a, b));
		}
	}

	private static String solution(String a, String b) {
		String answer = "";
		if(a.length() != b.length()) {
			answer = "NOT ";
		}else {
			Map<Character, Integer> map = new HashMap<>();
			for(char c : a.toCharArray()) {
				map.put(c, map.getOrDefault(c, 0) + 1);
			}
			for(char c : b.toCharArray()) {
				if(!map.containsKey(c) || map.get(c) <= 0) {
					answer = "NOT ";
					break;
				}
				map.put(c, map.get(c)-1);
			}
			
		}
		StringBuilder sb = new StringBuilder(a + " & " + b + " are "+ answer + "anagrams.");
		return sb.toString();
	}

}
