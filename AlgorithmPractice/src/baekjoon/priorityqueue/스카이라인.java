package baekjoon.priorityqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;
class Building{
	int x;
	int h;
	public Building(int x,int h) {
		this.x =x;
		this.h = h;
	}
}
public class 스카이라인 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[][] arr = new int[n][3];
		for(int i=0;i<n;++i) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			arr[i][0] = Integer.parseInt(tokens.nextToken());
			arr[i][1] = Integer.parseInt(tokens.nextToken());
			arr[i][2] = Integer.parseInt(tokens.nextToken());
		}
		System.out.println(solution(arr,n));
	}

	private static String solution(int[][] arr, int n) {
		StringBuilder sb = new StringBuilder();
		Queue<Building> pq = new PriorityQueue<>((o1,o2)->{
			if(o1.x == o2.x)
				return o2.h - o1.h;
			return o1.x - o2.x;
		});
		for(int i=0;i<arr.length;++i) {
			pq.offer(new Building(arr[i][0], arr[i][1]));
			pq.offer(new Building(arr[i][2], -arr[i][1]));
		}
		TreeMap<Integer,Integer> map = new TreeMap<>(Collections.reverseOrder());
		int maxX = 0;
		int maxH = 0;
		map.put(0, 1);
		while(!pq.isEmpty()) {
			Building b = pq.poll();
			if(b.h > 0) {//시작점
				map.put(b.h, map.getOrDefault(b.h, 0)+1);
			}else {
				int val = map.get(-b.h);
				if(val == 1)
					map.remove(-b.h);
				else
					map.replace(-b.h , val-1);
			}
			int height = map.firstKey();
			if(maxX != b.x && maxH != height) {
				sb.append(b.x + " " + height + " ");
				maxX = b.x;
				maxH = height;
			}
		}
		
		
		return sb.toString().trim();
	}

}
