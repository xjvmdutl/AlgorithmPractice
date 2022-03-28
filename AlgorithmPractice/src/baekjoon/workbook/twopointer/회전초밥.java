package baekjoon.workbook.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class »∏¿¸√ π‰ {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int d = Integer.parseInt(tokens.nextToken());
		int k = Integer.parseInt(tokens.nextToken());
		int c = Integer.parseInt(tokens.nextToken());
		int[] arr = new int[n];
		for(int i=0;i<n;++i) {
			arr[i] = Integer.parseInt(reader.readLine());
		}
		System.out.println(solution(arr, n, d, k ,c));
	}

	private static int solution(int[] arr, int n, int d, int k, int c) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0;i<k;++i) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}
		int answer = map.size();
		for(int i=0;i<arr.length;++i) {
			int end = arr[(i+k) % n];
			map.put(end, map.getOrDefault(end, 0) + 1);
			map.put(arr[i], map.get(arr[i]) - 1);
			if(map.get(arr[i]) == 0) {
				map.remove(arr[i]);
			}
			answer = Math.max(answer, map.size());
			if(!map.containsKey(c)) {
				answer = Math.max(answer, map.size() + 1);
			}
		}
		
		return answer;
	}

}
