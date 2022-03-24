package baekjoon.workbook.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 트리의순회 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[] inOrder = new int[n + 1];
		int[] postOrder = new int[n + 1];
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		for(int i=0;i<n;++i) {
			inOrder[i] = Integer.parseInt(tokens.nextToken());
		}
		tokens = new StringTokenizer(reader.readLine());
		for(int i=0;i<n;++i) {
			postOrder[i] = Integer.parseInt(tokens.nextToken());
		}
		System.out.println(solution(inOrder, postOrder, n));
	}

	private static String solution(int[] inOrder, int[] postOrder, int n) {
		StringBuilder sb = new StringBuilder();
		inPostToPreOrder(inOrder, postOrder, 0, n-1, 0, n-1, sb);
		return sb.toString();
	}

	private static void inPostToPreOrder(int[] inOrder, int[] postOrder, int inStart, int inEnd, int postStart, int postEnd, StringBuilder sb) {
		if(inStart > inEnd || postStart > postEnd)
			return;
		int root = postOrder[postEnd];
		sb.append(root + " ");
		for(int i=inStart;i<=inEnd;++i) {
			if(postOrder[postEnd] == inOrder[i]) {
				inPostToPreOrder(inOrder, postOrder, inStart, i-1, postStart, postStart + i - inStart - 1, sb);
				inPostToPreOrder(inOrder, postOrder, i+1, inEnd, postStart + i - inStart, postEnd - 1, sb);
			}
		}
	}

}
