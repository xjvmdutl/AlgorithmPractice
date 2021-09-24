package baekjoon.kruscal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Planet{
	int num;
	int x;
	int y;
	int z;
	public Planet(int num,int x,int y,int z) {
		this.num = num;
		this.x = x;
		this.y = y;
		this.z = z;
	}
}
class Edge implements Comparable<Edge>{
	int weight;
	int start;
	int end;
	public Edge(int start,int end,int weight) {
		this.weight = weight;
		this.start = start;
		this.end = end;
	}
	
	@Override
	public int compareTo(Edge o) {
		return this.weight - o.weight;
	}
	
}
public class 행성터널 {
	public static int[] parents;
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

	private static long solution(int[][] arr,int n) {
		long answer = 0;
		parents = new int[n];
		for(int i=0;i<n;++i) {
			parents[i] = i;
		}
		Planet[] planets = new Planet[n];
		for(int i=0;i<arr.length;++i) {
			planets[i] = new Planet(i, arr[i][0], arr[i][1], arr[i][2]);
		}
		Queue<Edge> pq = new PriorityQueue<>();
		Arrays.sort(planets,(o1,o2)->o1.x - o2.x);
		for(int i=0;i<planets.length-1;++i) {
			Planet p1 = planets[i];
			Planet p2 = planets[i+1];
			pq.offer(new Edge(p1.num, p2.num, Math.abs(p1.x - p2.x)));
		}
		Arrays.sort(planets,(o1,o2)->o1.y - o2.y);
		for(int i=0;i<planets.length-1;++i) {
			Planet p1 = planets[i];
			Planet p2 = planets[i+1];
			pq.offer(new Edge(p1.num, p2.num, Math.abs(p1.y - p2.y)));
		}
		Arrays.sort(planets,(o1,o2)->o1.z - o2.z);
		for(int i=0;i<planets.length-1;++i) {
			Planet p1 = planets[i];
			Planet p2 = planets[i+1];
			pq.offer(new Edge(p1.num, p2.num, Math.abs(p1.z - p2.z)));
		}
		while(!pq.isEmpty()) {
			Edge e = pq.poll();
			int parent = findNode(e.start);
			int child = findNode(e.end);
			if(parent == child)
				continue;
			answer += e.weight;
			parents[child] = parent;
		}
		return answer;
	}

	private static int findNode(int node) {
		if(node == parents[node])
			return node;
		return parents[node] = findNode(parents[node]);
	}

}
