package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 소셜네트워킹어플리케이션 {
	public static int[] parents;
	private static int find(int node) {
		if(parents[node] < 0)
			return node;
		return parents[node] = find(parents[node]);
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		int index = 1;
		while(t-- > 0) {
			StringBuilder sb = new StringBuilder();
			System.out.println("Scenario " + index++ + ":");
			int n = Integer.parseInt(reader.readLine());
			int k = Integer.parseInt(reader.readLine());
			parents = new int[n];
			Arrays.fill(parents, -1);
			for(int i=0;i<k;++i) {
				StringTokenizer tokens = new StringTokenizer(reader.readLine());
				int start = Integer.parseInt(tokens.nextToken());
				int end = Integer.parseInt(tokens.nextToken());
				union(start,end);
			}
			int m = Integer.parseInt(reader.readLine());
			for(int i=0;i<m;++i) {
				StringTokenizer tokens = new StringTokenizer(reader.readLine());
				int u = Integer.parseInt(tokens.nextToken());
				int v = Integer.parseInt(tokens.nextToken());
				if(find(u) == find(v)) {
					sb.append("1\n");
				}else {
					sb.append("0\n");
				}
			}
			System.out.println(sb.toString());
		}
	}
	private static void union(int start, int end) {
		int u = find(start);
		int v = find(end);
        if(u == v)
            return;
		if(parents[u] < parents[v]) {
			parents[u] += parents[v];
			parents[v] = u;
		}else {
			parents[v] += parents[u];
			parents[u] = v;
		}
	}
}
