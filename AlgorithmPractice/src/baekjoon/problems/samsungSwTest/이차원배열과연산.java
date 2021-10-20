package baekjoon.problems.samsungSwTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class 이차원배열과연산 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int r = Integer.parseInt(tokens.nextToken());
		int c = Integer.parseInt(tokens.nextToken());
		int k = Integer.parseInt(tokens.nextToken());
		int[][] arr = new int[3][3];
		for(int i=0;i<3;++i) {
			tokens = new StringTokenizer(reader.readLine());
			for(int j=0;j<3;++j) {
				arr[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		System.out.println(solution(arr,r,c,k));
	}

	private static int solution(int[][] arr, int r, int c, int k) {
		int time = 0;
		while(time < 100) {
			if(r-1 < arr.length && c-1 < arr[0].length) {
				if(arr[r-1][c-1] == k)
					return time;
			}
			int n = arr.length;
			int m = arr[0].length;
			if(n >= m) {
				arr = Rsolution(arr,r,c,k);
			}else {
				arr = Csolution(arr,r,c,k);
			}
			time++;
		}
		return -1;
	}

	private static int[][] Csolution(int[][] arr, int r, int c, int k) {
		int max = 0;
		List<Map<Integer,Integer>> list = new ArrayList<>();
		for(int i=0;i<arr[0].length;++i) {
			Map<Integer,Integer> map = new HashMap<>();
			if(arr.length < 101) {
				for(int j=0;j<arr.length;++j)
					if(arr[j][i] != 0)
						map.put(arr[j][i], map.getOrDefault(arr[j][i], 0)+1);
			}else {
				for(int j=0;j<100;++j)
					if(arr[j][i] != 0)
						map.put(arr[j][i], map.getOrDefault(arr[j][i], 0)+1);
			}
			max = Math.max(max, map.size());
			list.add(map);
		}
		int[][] tmp = new int[max*2][arr[0].length];
		for(int i=0;i<list.size();++i) {
			Map<Integer,Integer> map = list.get(i);
			// Map.Entry 리스트 작성
			List<Entry<Integer, Integer>> list_entries = new ArrayList<Entry<Integer, Integer>>(map.entrySet());
			// 비교함수 Comparator를 사용하여 오름차순으로 정렬
			Collections.sort(list_entries, new Comparator<Entry<Integer, Integer>>() {
				@Override
				public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
					if(o1.getValue() == o2.getValue()) {
						return o1.getKey()-o2.getKey();
					}
					return o1.getValue() - o2.getValue();
				}
			});
			int idx = 0;
			for(Entry<Integer, Integer> entry:list_entries) {
				tmp[idx++][i] = entry.getKey();
				tmp[idx++][i] = entry.getValue();
			}
		}
		return tmp;
	}

	private static int[][] Rsolution(int[][] arr, int r, int c, int k) {
		int max = 0;
		List<Map<Integer,Integer>> list = new ArrayList<>();
		for(int i=0;i<arr.length;++i) {
			Map<Integer,Integer> map = new HashMap<>();
			if(arr[0].length < 101) {
				int[] datas = arr[i];
				for(int number:datas) {
					if(number != 0) {
						map.put(number, map.getOrDefault(number, 0)+1);
					}
				}
			}else {
				int[] datas = Arrays.copyOfRange(arr[i], 0, 100);
				for(int number:datas) {
					if(number != 0) {
						map.put(number, map.getOrDefault(number, 0)+1);
					}
				}
			}
			
			max = Math.max(max, map.size());
			list.add(map);
		}
		int[][] tmp = new int[arr.length][max*2];
		for(int i=0;i<list.size();++i) {
			Map<Integer,Integer> map = list.get(i);
			// Map.Entry 리스트 작성
			List<Entry<Integer, Integer>> list_entries = new ArrayList<Entry<Integer, Integer>>(map.entrySet());
			// 비교함수 Comparator를 사용하여 오름차순으로 정렬
			Collections.sort(list_entries, new Comparator<Entry<Integer, Integer>>() {
				@Override
				public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
					if(o1.getValue() == o2.getValue()) {
						return o1.getKey()-o2.getKey();
					}
					return o1.getValue() - o2.getValue();
				}
			});
			int idx = 0;
			for(Entry<Integer, Integer> entry:list_entries) {
				tmp[i][idx++] = entry.getKey();
				tmp[i][idx++] = entry.getValue();
			}
		}
		return tmp;
	}

}
