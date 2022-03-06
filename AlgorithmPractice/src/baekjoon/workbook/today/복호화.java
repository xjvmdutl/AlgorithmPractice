package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class º¹È£È­ {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		while(t-- > 0) {
			System.out.println(solution(reader.readLine()));
		}
	}

	private static String solution(String str) {
		String answer = "";
		Map<Character, Integer> map = new HashMap<>();
		int max = 0;
		for(char c : str.toCharArray()) {
			if(Character.isAlphabetic(c)) {
				map.put(c, map.getOrDefault(c, 0)+1);
				max = Math.max(max, map.get(c));
			}
		}
		boolean isFirst = false;
		for(char c : map.keySet()) {
			if(map.get(c)  == max && !isFirst) {
				answer = String.valueOf(c);
				isFirst = true;
			}else if(map.get(c) == max && isFirst) {
				answer = "?";
				break;
			}
		}
		
		return answer;
	}

}
