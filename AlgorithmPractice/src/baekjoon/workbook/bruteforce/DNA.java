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
			
			for(int j=0;j<n;++j) {
				char c = strs[j].charAt(i);
				map.put(c, map.getOrDefault(c, 0) + 1);
			}
			int[] arr = getItem(map);
			int idx = 0;
			int max = 0;
			for (int k = 0; k < 4; k++) {
				if (arr[k] > max || (arr[k] == max && k < idx)) {
					max = arr[k];
					idx = k;
				}
			}
			char result = getCharacter(idx);
			answer.append(result);
			sum += n - max;
		}
		answer.append("\n" + sum + "\n");
		return answer.toString();
	}
	
	private static char getCharacter(int idx) {
		char result = '0';
		switch (idx) {
		case 0:
			result = 'A';
			break;
		case 1:
			result = 'C';
			break;
		case 2:
			result = 'G';
			break;
		case 3:
			result = 'T';
			break;
		}		
		return result;
	}

	private static int[] getItem(Map<Character, Integer> map) {
		int[] result = new int[4];
		for(char c : map.keySet()) {		
			switch (c) {
			case 'A':
				result[0] = map.get(c);
				break;
			case 'C':
				result[1] = map.get(c);
				break;
			case 'G':
				result[2] = map.get(c);
				break;
			case 'T':
				result[3] = map.get(c);
				break;
			}
		}
		return result;
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
