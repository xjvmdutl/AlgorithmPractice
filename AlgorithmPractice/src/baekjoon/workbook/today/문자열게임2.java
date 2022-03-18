package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class 문자열게임2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		while(t-- > 0) {
			String w = reader.readLine();
			int k = Integer.parseInt(reader.readLine());
			System.out.println(solution(w, k));
		}
	}

	private static String solution(String w, int k) {
		if(k == 1) {
			return "1 1";
		}
		Map<Character, Integer> map = new HashMap<>();
		for(int i=0;i<w.length();++i) {
			map.put(w.charAt(i), map.getOrDefault(w.charAt(i), 0)+ 1);
		}
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		OUTER:for(int i=0;i<w.length();++i) {
			if(map.get(w.charAt(i)) < k)
				continue;
			int count = 1;
			for(int j=i+1;j<w.length();++j) {
				if(w.charAt(i) == w.charAt(j)) {
					count++;
				}
				if(count == k) {
					min = Math.min(min, j - i + 1); 
					max = Math.max(max, j - i + 1);
					continue OUTER;
				}
			}
		}
		if(min == Integer.MAX_VALUE || max == Integer.MIN_VALUE) {
			return "-1";
		}
		return min + " " + max;
	}

}
