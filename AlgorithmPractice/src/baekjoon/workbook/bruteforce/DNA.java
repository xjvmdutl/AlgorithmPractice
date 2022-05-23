package baekjoon.workbook.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class DNA {
	private static String solution(String[] strs, int n, int m) {
		StringBuilder answer = new StringBuilder();
		int sum = 0;
		for(int i=0;i<m;++i) {
			Map<Character, Integer> map = new HashMap<>();
			map.put('A', 0);
			map.put('C', 0);
			map.put('G', 0);
			map.put('T', 0);
			for(int j=0;j<n;++j) {
				char c = strs[j].charAt(i);
				if(isDNA(c)) {
					map.put(c, map.get(c) + 1);
				}
			}
			List<Entry<Character, Integer>> entries = new ArrayList<>(map.entrySet());
			Collections.sort(entries, (o1, o2) -> {
				if(o2.getValue() == o1.getValue()) {
					return o2.getKey().compareTo(o1.getKey());
				}
				return o2.getValue() - o1.getValue();
			});
			answer.append(entries.get(0).getKey());
			sum += n - entries.get(0).getValue();
		}
		answer.append("\n" + sum + "\n");
		return answer.toString();
	}
	
	private static boolean isDNA(char c) {
		return c == 'A' || c == 'C' || c == 'G' || c == 'T';
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		String[] strs = new String[n];
		for(int i=0;i<n;++i) {
			strs[i] = reader.readLine();
		}
		System.out.println(solution(strs, n , m));
	}

}
