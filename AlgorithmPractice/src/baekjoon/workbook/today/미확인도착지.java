package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
class Goal implements Comparable<Goal>{
	int goal;
	int value;
	public Goal(int goal, int value) {
		this.goal = goal;
		this.value = value;
	}
	@Override
	public int compareTo(Goal o) {
		return this.value - o.value;
	}
}
public class 미확인도착지 {
	public static int[] dis;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(reader.readLine());
		while(T-- > 0) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			int n = Integer.parseInt(tokens.nextToken());
			int m = Integer.parseInt(tokens.nextToken());
			int t = Integer.parseInt(tokens.nextToken());
			tokens = new StringTokenizer(reader.readLine());
			int s = Integer.parseInt(tokens.nextToken())-1;
			int g = Integer.parseInt(tokens.nextToken())-1;
			int h = Integer.parseInt(tokens.nextToken())-1;
			List<Goal>[] map = new ArrayList[n];
			for(int i=0;i<n;++i)
				map[i] = new ArrayList<>();
			for(int i=0;i<m;++i) {
				tokens = new StringTokenizer(reader.readLine());
				int start = Integer.parseInt(tokens.nextToken()) - 1;
				int end = Integer.parseInt(tokens.nextToken()) - 1;
				int value = Integer.parseInt(tokens.nextToken());
				if((start == g && end == h) || (start == h && end == g)){
					map[start].add(new Goal(end, (value * 2) - 1));
					map[end].add(new Goal(start, (value * 2) - 1));
				}else {
					map[start].add(new Goal(end, value * 2));
					map[end].add(new Goal(start, value * 2));
				}
		
			}
			int[] arr = new int[t];
			for(int i=0;i<t;++i) {
				arr[i] = Integer.parseInt(reader.readLine()) - 1;
			}
			System.out.println(solution(map, arr, n, m, t, s, g, h));
		}
	}

	private static String solution(List<Goal>[] map, int[] arr, int n, int m, int t, int s, int g, int h) {
		StringBuilder sb = new StringBuilder();
		dis = new int[n];
		Arrays.fill(dis, Integer.MAX_VALUE/2*2);
		dijkstra(map, s);
		Arrays.sort(arr);
		int index = 0;
		for(int i=0;i<dis.length;++i) {
			if(i == arr[index]) {
				if(dis[i] % 2 == 1) {
					sb.append((arr[index] + 1) + " ");
				}
				index++;
				if(index >= arr.length)
					break;
			}
		}
		if(sb.length() < 1)
			return "";
		return sb.toString();
	}

	private static void dijkstra(List<Goal>[] map, int s) {
		Queue<Goal> pq = new PriorityQueue<>();
		dis[s] = 0;
		pq.offer(new Goal(s, 0));
		while(!pq.isEmpty()) {
			Goal now = pq.poll();
			for(Goal next: map[now.goal]) {
				if(dis[next.goal] > dis[now.goal] + next.value) {
					dis[next.goal] = dis[now.goal] + next.value;
					pq.offer(new Goal(next.goal, dis[next.goal]));
				}
			}
		}
	}

}
