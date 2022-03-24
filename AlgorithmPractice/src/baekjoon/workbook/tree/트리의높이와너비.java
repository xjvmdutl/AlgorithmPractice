package baekjoon.workbook.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 트리의높이와너비 {
	static class Node{
		int num;
		int left;
		int right;
		public Node(int num) {
			this.num = num;
		}
	}
	public static int[] levelMax;
	public static int[] levelMin;
	public static int maxLevel;
	public static int point;
	public static int[] parents;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		Node[] map = new Node[n + 1];
		parents = new int[n + 1];
		Arrays.fill(parents, -1);
		for(int i=0;i<n;++i) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			int root = Integer.parseInt(tokens.nextToken());
			int left = Integer.parseInt(tokens.nextToken());
			int right = Integer.parseInt(tokens.nextToken());
			map[root] = new Node(root);
			map[root].left = left;
			if(left != -1) {
				parents[left] = root;
			}
			map[root].right = right;
			if(right != -1) {
				parents[right] = root;
			}
		}
		System.out.println(solution(map, n));
	}

	private static String solution(Node[] map, int n) {
		levelMax = new int[n + 1];
		levelMin = new int[n + 1];
		maxLevel = 1;
		int max = 0;
		int maxLev = 1;
		Arrays.fill(levelMin, n);
		int root = -1;
		for(int i=1;i<=n;++i) {
			if(parents[i] == -1) {
				root = i;
				break;
			}
		}
		dfs(map, root, 1, n);
		
		for(int i=1;i<=maxLevel;++i) {
			if(max < levelMax[i] - levelMin[i]) {
				max = levelMax[i] - levelMin[i];
				maxLev = i;
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(maxLev + " " + (max + 1));
		return sb.toString();
	}

	private static void dfs(Node[] map, int root, int depth, int n) {
		if(maxLevel < depth) {
			maxLevel = depth;
		}
		if(map[root].left != -1) {
			dfs(map, map[root].left, depth + 1, n);
		}
		levelMin[depth] = Math.min(levelMin[depth], point);
		levelMax[depth] = point++;
		if(map[root].right != -1) {
			dfs(map, map[root].right, depth + 1, n);
		}
	}

}
