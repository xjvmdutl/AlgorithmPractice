package baekjoon.priorityqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 이중우선순위큐 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		while(t-- > 0) {
			int k = Integer.parseInt(reader.readLine());
			String[] str = new String[k];
			int[] arr = new int[k];
			for(int i=0;i<k;++i) {
				StringTokenizer tokens = new StringTokenizer(reader.readLine());
				str[i] = tokens.nextToken();
				arr[i] = Integer.parseInt(tokens.nextToken());
			}
			System.out.println(solution(str,arr,k));
		}
	}

	private static String solution(String[] str, int[] arr, int k) {
		StringBuilder sb = new StringBuilder();
		Queue<Integer> pq1 = new PriorityQueue<>((o1,o2)->o1-o2);
		Queue<Integer> pq2 = new PriorityQueue<>((o1,o2)->o2-o1);
		Map<Integer,Integer> map = new HashMap<>();
		for(int i=0;i<k;++i) {
			if(str[i].equals("D")) {
				if(map.size() < 1) {
					continue; 
				}
				if(arr[i] == 1) {
					while(!pq2.isEmpty() ) {
						int num = pq2.poll();
						if(map.containsKey(num)) {
							if(map.get(num) > 0) {
								if(map.get(num) - 1 == 0) {
									map.remove(num);
								}else {
									map.put(num, map.get(num)-1);
								}
								break;
							}else {
								map.remove(num);
							}
						}
					}
				}else {
					while(!pq1.isEmpty() ) {
						int num = pq1.poll();
						if(map.containsKey(num)) {
							if(map.get(num) > 0) {
								if(map.get(num) - 1 == 0) {
									map.remove(num);
								}else {
									map.put(num, map.get(num)-1);
								}
								break;
							}else {
								map.remove(num);
							}
						}
					}
				}
			}else {
				pq1.offer(arr[i]);
				pq2.offer(arr[i]);
				map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
			}
		}
		for(int data : map.keySet()) {
			if(map.get(data) == 0)
				map.remove(data);
		}
		// 키로 정렬
		Object[] mapkey = map.keySet().toArray();
		Arrays.sort(mapkey);
		
		if(map.size() < 1)
			sb.append("EMPTY");
		else
			sb.append(mapkey[mapkey.length-1] + " " + mapkey[0]);
		
		return sb.toString();
	}

}
