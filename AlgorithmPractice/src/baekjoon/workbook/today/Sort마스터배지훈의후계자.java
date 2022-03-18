package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Sort마스터배지훈의후계자 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		int[] arr = new int[n];
		for(int i=0;i<n;++i) {
			arr[i] = Integer.parseInt(reader.readLine());
		}
		Map<Integer, Integer> map = solution(arr, n);
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<m;++i) {
			int d = Integer.parseInt(reader.readLine());
			if(!map.containsKey(d))
				sb.append("-1\n");
			else
				sb.append(map.get(d)+ "\n");
		}
		System.out.println(sb.toString());
	}

	private static Map<Integer, Integer> solution(int[] arr, int n) {
		Map<Integer, Integer> map = new HashMap<>();
		Arrays.sort(arr);
		for(int i=0;i<n;++i) {
			if(!map.containsKey(arr[i])) {
				map.put(arr[i], i);
			}
		}
		return map;
	}

}
