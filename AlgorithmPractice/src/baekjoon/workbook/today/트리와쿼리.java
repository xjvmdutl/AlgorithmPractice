package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Æ®¸®¿ÍÄõ¸® {
	public static List<Integer>[] map;
	public static List<Integer>[] tree;
	public static int[] parents;
	public static int[] size;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int r = Integer.parseInt(tokens.nextToken());
		int q = Integer.parseInt(tokens.nextToken());
		map = new ArrayList[n];
		tree = new ArrayList[n];
		size = new int[n];
		parents = new int[n];
		for(int i=0;i<n;++i) {
			tree[i] = new ArrayList<Integer>();
			map[i] = new ArrayList<Integer>();
		}
		for(int i=1;i<n;++i) {
			tokens = new StringTokenizer(reader.readLine());
			int start = Integer.parseInt(tokens.nextToken()) - 1;
			int end = Integer.parseInt(tokens.nextToken()) - 1;
			map[start].add(end);
			map[end].add(start);
		}
		makeTree(r-1, -1);
		countSubtreeNodes(r-1);
		for(int i=0;i<q;++i) {
			int query = Integer.parseInt(reader.readLine()) - 1;
			System.out.println(size[query]);
		}
	}

	private static void countSubtreeNodes(int curentNode) {
		size[curentNode] = 1;
		for(int node : tree[curentNode]) {
			countSubtreeNodes(node);
			size[curentNode] += size[node];
		}
	}

	private static void makeTree(int curentNode, int parent) {
		for(int node : map[curentNode]) {
			if(node != parent) {
				tree[curentNode].add(node);
				parents[node] = curentNode;
				makeTree(node, curentNode);
			}
		}
	}

}
