package baekjoon.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
class Computer implements Comparable<Computer>{
	int end;
	int time;
	public Computer(int end,int time) {
		this.end = end;
		this.time = time;
	}
	@Override
	public int compareTo(Computer o) {
		return this.time - o.time;
	}
}
public class ÇØÅ· {
	public static int[] distance;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		while(t-- > 0) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			int n = Integer.parseInt(tokens.nextToken());
			int d = Integer.parseInt(tokens.nextToken());
			int c = Integer.parseInt(tokens.nextToken())-1;
			List<Computer>[] list = new ArrayList[n];
			for(int i=0;i<n;++i)
				list[i] = new ArrayList<>();
			for(int i=0;i<d;++i) {
				tokens = new StringTokenizer(reader.readLine());
				int a = Integer.parseInt(tokens.nextToken()) - 1;
				int b = Integer.parseInt(tokens.nextToken()) - 1 ;
				int s = Integer.parseInt(tokens.nextToken());
				list[b].add(new Computer(a, s));
			}
			System.out.println(solution(list,c,n));
		}
		
	}

	private static String solution(List<Computer>[] list, int c, int n) {
		StringBuilder sb = new StringBuilder();
		distance = new int[n];
		Arrays.fill(distance, Integer.MAX_VALUE);
		dijkstra(list,n,c);
		int max = 0;
		int count = 0;
		for(int i=0;i<distance.length;++i) {
			if(distance[i] != Integer.MAX_VALUE && max < distance[i] ) {
				max = distance[i];
			}
			if(distance[i] != Integer.MAX_VALUE) {
				count++;
			}
		}
		sb.append(count + " " + max);
		return sb.toString();
	}

	private static void dijkstra(List<Computer>[] list, int n, int start) {
		Queue<Computer> pq = new PriorityQueue<>();
		pq.offer(new Computer(start, 0));
		distance[start] = 0;
		while(!pq.isEmpty()) {
			Computer c = pq.poll();
			for(Computer computer : list[c.end]) {
				if(distance[computer.end] > distance[c.end] + computer.time) {
					distance[computer.end] = distance[c.end] + computer.time;
					pq.offer(new Computer(computer.end, distance[computer.end]));
				}
			}
		}
	}

}
