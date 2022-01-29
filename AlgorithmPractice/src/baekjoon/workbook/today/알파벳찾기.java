package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class ¾ËÆÄºªÃ£±â {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String str = reader.readLine();
		System.out.println(solution(str));
	}

	private static String solution(String str) {
		StringBuilder sb = new StringBuilder();
		Map<Character, Integer> map = new HashMap<>();
		for(int i=0;i<str.length();++i) {
			char c = str.charAt(i);
			if(!map.containsKey(c)) {
				map.put(c, i);
			}
		}
		for(int i='a';i<='z';++i) {
			int now = -1;
			if(map.containsKey((char)i)) {
				now = map.get((char)i);
			}
			sb.append(now + " ");
		}
		return sb.toString();
	}

}
