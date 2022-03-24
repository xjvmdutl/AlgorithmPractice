package baekjoon.workbook.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Æ®¸®2 {
	public static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		while(t-- > 0) {
			int n = Integer.parseInt(reader.readLine());
			int[] preOrder = new int[n + 1];
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			for(int i=0;i<n;++i) {
				preOrder[i] = Integer.parseInt(tokens.nextToken());
			}
			int[] inOrder = new int[n + 1];
			tokens = new StringTokenizer(reader.readLine());
			for(int i=0;i<n;++i) {
				inOrder[i] = Integer.parseInt(tokens.nextToken());
			}
			System.out.println(solution(preOrder, inOrder, n));
		}
	}

	private static String solution(int[] preOrder, int[] inOrder, int n) {
		sb = new StringBuilder();
		preInToPostOrder(preOrder, inOrder, 0, n-1, 0);
		return sb.toString();
	}

	private static void preInToPostOrder(int[] preOrder, int[] inOrder, int start, int end, int root) {
		for(int i=start;i<=end;++i) {
			if(preOrder[root] == inOrder[i]) {
				preInToPostOrder(preOrder, inOrder, start, i-1, root + 1);
				preInToPostOrder(preOrder, inOrder, i+1, end, root + i - start + 1);
				sb.append(preOrder[root] + " ");
			}
		}
	}



}
