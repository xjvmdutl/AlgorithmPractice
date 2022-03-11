package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

class Pair implements Comparable<Pair>{
	int start;
	int end;
	public Pair(int start, int end) {
		this.end = end;
		this.start = start;
	}
	@Override
	public int compareTo(Pair o) {
		if(this.start == o.start) {
			return this.end - o.end;
		}
		return this.start - o.start;
	}
}
public class 동방프로젝트Large {
	public static int[] parents;
	public static Queue<Pair> pq;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int m = Integer.parseInt(reader.readLine());
		parents = new int[n + 1];
		for(int i=1;i<=n;++i) {
			parents[i] = i;
		}
		int[][] arr= new int[m][2];
		pq = new PriorityQueue<>();
		for(int i=0;i<arr.length;++i) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			arr[i][0] = Integer.parseInt(tokens.nextToken());
			arr[i][1] = Integer.parseInt(tokens.nextToken());
			pq.offer(new Pair(Math.min(arr[i][0], arr[i][1]), Math.max(arr[i][0], arr[i][1])));
		}
		System.out.println(solution(arr, n, m));
	}
	private static int solution(int[][] arr, int n, int m) {
		int right = 0;
		while(!pq.isEmpty()) {
			Pair p = pq.poll();
			int n1 = p.start;
			int n2 = p.end;
			if(n1 < right ) {
				n1 = right;
			}
			if(find(n1) != find(n2)) {
				union(n1, n2);
			}
			if(n2 > right){
				right = n2;
			}
		}
		Set<Integer> set = new HashSet<>();
		for(int i=1;i<=n;++i) {
			set.add(parents[i]);
		}
		return set.size();
	}
	private static void union(int n1, int n2) {
		Arrays.fill(parents, n1, n2+1, parents[n1]);
	}
	private static int find(int node) {
		if(node == parents[node])
			return node;
		return parents[node] = find(parents[node]);
	}
}
