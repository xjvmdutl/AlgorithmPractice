package baekjoon.stepbystep.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

public class 단어공부 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String str = reader.readLine();
		System.out.println(solution(str));
	}

	private static String solution(String str) {
		str = str.toUpperCase();
		Map<Character, Integer> map = new HashMap<>();
		for(int i=0;i<str.length();++i) {
			map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0)+1);
		}
		int max = 0;
		for(Character c : map.keySet()) {
			if(map.get(c) > max)
				max = map.get(c);
		}
		StringBuilder sb = new StringBuilder();
		for(Character c : map.keySet()) {
			if(map.get(c) == max)
				sb.append(c);
		}
		
		return sb.length() > 1 ? "?" : sb.toString();
	}

}
