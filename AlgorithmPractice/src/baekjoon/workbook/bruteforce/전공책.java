package baekjoon.workbook.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Àü°øÃ¥ {
	private static int answer;
	private static boolean[] visit;
	private static int solution(Map<Character, Integer>[] map, int[] moneies, int n, String str) {
		answer = Integer.MAX_VALUE;
		visit = new boolean[n];
		Map<Character, Integer> result = getResult(str);
		for(int i=1; i<=n; ++i) {
			permutation(map, moneies, 0, 0, i, n, result, new int[i]);
		}
		return answer == Integer.MAX_VALUE ? -1 : answer;
	}
	
	private static Map<Character, Integer> getResult(String str) {
		Map<Character, Integer> result = new HashMap<>();
		for(char c : str.toCharArray()) {
			result.put(c, result.getOrDefault(c, 0) + 1);
		}
		return result;
	}
	
	private static void permutation(Map<Character, Integer>[] map, int[] moneies, int index, int count, int size, int n,
			Map<Character, Integer> result, int[] arr) {
		if(count == size) {
			if(isOkay(map, arr, result)) {
				int money = 0;
				for(int idx : arr) {
					money += moneies[idx];
				}
				answer = Math.min(answer, money);
			}
			return;
		}
		for(int i=index;i<n;++i) {
			if(!visit[i]) {
				visit[i] = true;
				arr[count] = i;
				permutation(map, moneies, i, count + 1, size, n, result, arr);
				visit[i] = false;
			}
		}
	}
	private static boolean isOkay(Map<Character, Integer>[] map, int[] arr, Map<Character, Integer> result) {
		for(char key : result.keySet()) {
			int count = 0;
			for(int i=0;i <arr.length;++i) {
				count += map[arr[i]].getOrDefault(key, 0);
			}
			if(result.get(key) > count) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String str = reader.readLine();
		int n = Integer.parseInt(reader.readLine());
		Map<Character, Integer>[] map = new HashMap[n];
		int[] moneies = new int[n];
		for(int i=0;i<n;++i) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			moneies[i] = Integer.parseInt(tokens.nextToken());
			map[i] = new HashMap<>();
			String word = tokens.nextToken();
			for(char c : word.toCharArray()) {
				map[i].put(c, map[i].getOrDefault(c, 0) + 1);
			}
		}
		System.out.println(solution(map, moneies, n, str));
	}

	

}
