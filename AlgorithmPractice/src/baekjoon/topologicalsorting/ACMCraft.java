package baekjoon.topologicalsorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
public class ACMCraft {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t= Integer.parseInt(reader.readLine());
		while(t-- > 0) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			int n = Integer.parseInt(tokens.nextToken());
			int k = Integer.parseInt(tokens.nextToken());
			List<Integer>[] list = new ArrayList[n];
			int[] buildTimes = new int[n];
			tokens = new StringTokenizer(reader.readLine());
			for(int i=0;i<n;++i) {
				list[i] = new ArrayList<>();
				buildTimes[i] = Integer.parseInt(tokens.nextToken());
			}
			int[] dis = new int[n];
			for(int i=0;i<k;++i) {
				tokens = new StringTokenizer(reader.readLine());
				int start = Integer.parseInt(tokens.nextToken()) - 1;
				int end = Integer.parseInt(tokens.nextToken()) - 1;
				list[start].add(end);
				dis[end]++;
			}
			int w = Integer.parseInt(reader.readLine());
			System.out.println(solution(list,buildTimes,dis,n,w));
		}
	}

	private static int solution(List<Integer>[] list, int[] buildTimes, int[] dis, int n, int w) {
		Queue<Integer> que = new PriorityQueue<>();
		int[] result = new int[n];
		for(int i=0;i<n;++i) {
			result[i] = buildTimes[i];
			if(dis[i] == 0) {
				que.offer(i);
			}
		}
		while(!que.isEmpty()) {
			int number = que.poll();
			for(int now : list[number]) {
				result[now] = Math.max(result[now], result[number] + buildTimes[now]);
				dis[now]--;
				if(dis[now] == 0)
					que.offer(now);
			}
		}
		return result[w-1];
	}

}
