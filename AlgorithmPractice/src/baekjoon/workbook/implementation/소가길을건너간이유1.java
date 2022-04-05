package baekjoon.workbook.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 소가길을건너간이유1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[][] arr = new int[n][2];
		for(int i=0;i<n;++i) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());	
			arr[i][0] = Integer.parseInt(tokens.nextToken());
			arr[i][1] = Integer.parseInt(tokens.nextToken());
		}
		System.out.println(solution(arr, n));
	}

	private static int solution(int[][] arr, int n) {
		int answer = 0;
		Map<Integer, Integer> map = new HashMap<>();
		answer = checkCow(map, arr);
		return answer;
	}

	private static int checkCow(Map<Integer, Integer> map, int[][] arr) {
		int count = 0;
		for(int i=0;i<arr.length;++i) {
			if(map.containsKey(arr[i][0])) {
				if(!isSame(map.get(arr[i][0]),arr[i][1])) {
					map.put(arr[i][0], arr[i][1]);
					count++;
				}
			}else {
				map.put(arr[i][0], arr[i][1]);
			}
		}
		return count;
	}

	private static boolean isSame(Integer before, int after) {
		return before == after;
	}
}
