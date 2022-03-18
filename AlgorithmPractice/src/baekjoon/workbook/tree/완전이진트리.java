package baekjoon.workbook.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class BinaryTree{
	int left;
	int right;
	public BinaryTree(int left, int right) {
		this.left = left;
		this.right = right;
	}
}
public class 완전이진트리 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[] arr = new int[(int) Math.pow(2, n) - 1];
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		for(int i=0;i<Math.pow(2, n) - 1;++i) {
			arr[i] = Integer.parseInt(tokens.nextToken());
		}
		System.out.println(solution(arr, n));
	}

	private static String solution(int[] arr, int n) {
		StringBuilder sb = new StringBuilder();
		Queue<BinaryTree> que = new LinkedList<>();
		que.offer(new BinaryTree(0, (int) (Math.pow(2, n) - 1)));
		for(int k=0;k<n;++k) {
			int size = que.size();
			for(int i=0;i<size;++i) {
				BinaryTree tree = que.poll();
				int mid = (tree.left + tree.right) / 2;
				sb.append(arr[mid] + " ");
				if(tree.left != tree.right) {
					que.offer(new BinaryTree(tree.left, mid - 1));
					que.offer(new BinaryTree(mid + 1, tree.right));
				}
			}
			sb.append("\n");
		}
		return sb.toString();
	}

}
