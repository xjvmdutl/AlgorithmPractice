package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class Road{
	int start;
	int end;
	public Road(int start, int end) {
		this.end = end;
		this.start = start;
	}
}
public class µµ·Î {
	public static int[] parents;
	public static Queue<Road> edge;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		char[][] map = new char[n][n];
		for(int i=0;i<n;++i) {
			tokens = new StringTokenizer(reader.readLine());
			map[i] = tokens.nextToken().toCharArray();
		}
		System.out.println(solution(map, n, m));
	}

	private static String solution(char[][] map, int n, int m) {
		StringBuilder sb = new StringBuilder();
		int[] answer = new int[n];
		
		int roadCount = 0;
		parents = new int[n];
		edge = new LinkedList<>();
		for(int i=0;i<n;++i)
			parents[i] = i;
		for(int i=0;i<n;++i) {
			for(int j=i+1;j<n;++j) {
				if(map[i][j] == 'Y') {
					if(find(i) != find(j)) {
						union(i, j);
						roadCount++;
						answer[i]++;
						answer[j]++;
					}else {
						edge.offer(new Road(i, j));
					}
				}
			}
		}
		if(roadCount != n-1) {
			sb.append("-1");
			return sb.toString();
		}
		
		for(int i=n-1;i<m;++i) {
			if(edge.isEmpty()) {
				sb.append("-1");
				return sb.toString();
			}
			Road road = edge.poll();
			answer[road.start]++;
			answer[road.end]++;
		}
		for(int i=0;i<n;++i) {
			sb.append(answer[i] + " ");
		}
		return sb.toString();
	}

	private static void union(int a, int b) {
		parents[find(b)] = find(a);
	}

	private static int find(int node) {
		if(node == parents[node])
			return node;
		return parents[node] = find(parents[node]);
	}

}
