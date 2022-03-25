package baekjoon.workbook.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class °ãÄ¡´Â°Ç½È¾î {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int k = Integer.parseInt(tokens.nextToken());
		int[] arr = new int[n];
		tokens = new StringTokenizer(reader.readLine());
		for(int i=0;i<n;++i) {
			arr[i] = Integer.parseInt(tokens.nextToken());
		}
		System.out.println(solution(arr, n, k));
	}

	private static int solution(int[] arr, int n, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		int start = 0;
		int end = 0;
		int max = 0;
		while(end < n) {
			if(!map.containsKey(arr[end]) ) {
				max = Math.max(max, end - start);
				map.put(arr[end++], 1);
			}else if(map.containsKey(arr[end])) {
				int count = map.get(arr[end]);
				if(count < k) {
					max = Math.max(max, end - start);
					map.put(arr[end], map.getOrDefault(arr[end], 0) + 1);
					end++;
				}else {
					map.put(arr[start], map.get(arr[start]) - 1);
					if(map.get(arr[start]) == 0) {
						map.remove(arr[start]);
					}
					start++;
				}
			}
		}
		return max + 1;
	}

}
