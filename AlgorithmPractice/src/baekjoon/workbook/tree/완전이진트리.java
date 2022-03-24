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
		que.offer(new BinaryTree(0, (int) Math.pow(2, n) - 1));
		for(int i=1;i<=n;++i) {
			int size = que.size();
			for(int j=0;j<size;++j) {
				BinaryTree binaryTree = que.poll();
				int mid = (binaryTree.left + binaryTree.right) / 2;
				sb.append(arr[mid] + " ");
				que.offer(new BinaryTree(binaryTree.left, mid - 1));
				que.offer(new BinaryTree(mid + 1, binaryTree.right));
			}
			sb.append("\n");
		}
		return sb.toString();
	}

}
