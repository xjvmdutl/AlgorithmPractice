package baekjoon.workbook.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 트리순회 {
	private static int answer;
	private static int count;
	static class BinaryTreeNode {
		int left;
		int right;
		public BinaryTreeNode(int left, int right) {
			this.left = left;
			this.right = right;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[][] arr = new int[n][3];
		for(int i=0;i<n;++i) {
			StringTokenizer token = new StringTokenizer(reader.readLine());
			arr[i][0] = Integer.parseInt(token.nextToken());
			arr[i][1] = Integer.parseInt(token.nextToken());
			arr[i][2] = Integer.parseInt(token.nextToken());
		}
		System.out.println(solution(arr, n));
	}

	private static int solution(int[][] arr, int n) {
		answer = 0;
		count = 0;
		List<BinaryTreeNode>[] map = createTree(n);
		InterLink(map, arr, n);
		List<Integer> inOrder = new ArrayList<>();
		preOrder(map, inOrder, 1, 0, true);
		preOrder(map, inOrder, 1, 0, false);
		return answer;
	}
	

	private static void preOrder(List<BinaryTreeNode>[] map, List<Integer> inOrder, int now, int pa, boolean flag) {
		for(BinaryTreeNode node : map[now]) {
			if(node.left != -1) {
				preOrder(map, inOrder, node.left, now, flag);
				if(!flag) {
					count++;
				}
			}
			if(flag) {
				inOrder.add(now);
			}else {
				if(inOrder.get(inOrder.size()-1) == now) {
					answer = count;
					return;
				}
				count++;
			}
			if(node.right != -1) {
				preOrder(map, inOrder, node.right, now, flag);
				if(!flag) {
					count++;
				}
			}
			
		}
	}

	private static List<BinaryTreeNode>[] createTree(int n) {
		List<BinaryTreeNode>[] map = new ArrayList[n+1]; 
		for(int i=0;i<=n;++i) {
			map[i] = new ArrayList<>();
		}
		return map;
	}

	private static void InterLink(List<BinaryTreeNode>[] map, int[][] arr, int n) {
		for(int i=0;i<n;++i) {
			int node = arr[i][0];
			int left = arr[i][1];
			int right = arr[i][2];
			map[node].add(new BinaryTreeNode(left, right));
		}
	}

}
