package baekjoon.workbook.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class 트리순회 {
	 static class SearchNode{
		char c;
		char left = '.';
		char right = '.';
		public SearchNode(char c) {
			this.c = c;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		SearchNode[] map = new SearchNode[n];
		for(int i= 0;i<n;++i) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			char root = tokens.nextToken().charAt(0);
			char left = tokens.nextToken().charAt(0);
			char right = tokens.nextToken().charAt(0);
			map[root - 'A'] = new SearchNode(root);
			map[root - 'A'].left = left;
			map[root - 'A'].right = right;
		}
		System.out.println(solution(map, n));
	}

	private static String solution(SearchNode[] map, int n) {
		StringBuilder preSearch = new StringBuilder();
		StringBuilder inSearch = new StringBuilder();
		StringBuilder postSearch = new StringBuilder();
		preOrder(map, 0, n, preSearch);
		inOrder(map, 0, n, inSearch);
		postOrder(map, 0, n, postSearch);
		
		
		StringBuilder sb = new StringBuilder();
		sb.append(preSearch.toString() + "\n");
		sb.append(inSearch.toString() + "\n");
		sb.append(postSearch.toString() + "\n");
		return sb.toString();
	}
	private static void preOrder(SearchNode[] map, int root, int n, StringBuilder preSearch) {
		preSearch.append(map[root].c);
		if(map[root].left != '.') {
			preOrder(map, map[root].left - 'A', n, preSearch);
		}
		if(map[root].right != '.') {
			preOrder(map, map[root].right - 'A', n, preSearch);
		}
	}
	
	private static void inOrder(SearchNode[] map, int root, int n, StringBuilder inSearch) {
		if(map[root].left != '.') {
			inOrder(map, map[root].left - 'A', n, inSearch);
		}
		inSearch.append(map[root].c);
		if(map[root].right != '.') {
			inOrder(map, map[root].right - 'A', n, inSearch);
		}
	}
	
	
	private static void postOrder(SearchNode[] map, int root, int n, StringBuilder postSearch) {
		if(map[root].left != '.') {
			postOrder(map, map[root].left - 'A', n, postSearch);
		}
		if(map[root].right != '.') {
			postOrder(map, map[root].right - 'A', n, postSearch);
		}
		postSearch.append(map[root].c);
	}



	

}
