package baekjoon.workbook.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 트리순회 {
	private static int answer;
	private static int count;
	private static boolean finish;
	static class BinaryTreeNode {
		int left;
		int right;
		public BinaryTreeNode() {
			left = -1;
			right = -1;
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
		BinaryTreeNode[] map = createTree(n);
		InterLink(map, arr, n);
		preOrder(map, 0, n);
		return answer;
	}
	

	private static void preOrder(BinaryTreeNode[] map, int now, int n) {
		int left = map[now].left;
		int right = map[now].right;
		count++;
		if(isFinish(n)) {
			finish = true;
		}
		if(!isExist(left)) {
			answer++;
			preOrder(map, left, n);
			if(!finish) {
				answer++;	
			}
		}
		if(!isExist(right)) {
			answer++;
			preOrder(map, right, n);
			if(!finish) {
				answer++;
			}
		}
		
	}

	private static boolean isFinish(int n) {
		return count == n;
	}

	private static BinaryTreeNode[] createTree(int n) {
		BinaryTreeNode[] map = new BinaryTreeNode[n]; 
		for(int i=0;i<n;++i) {
			map[i] = new BinaryTreeNode();
		}
		return map;
	}

	private static void InterLink(BinaryTreeNode[] map, int[][] arr, int n) {
		for(int i=0;i<n;++i) {
			int node = arr[i][0] - 1;
			int left = arr[i][1];
			int right = arr[i][2];
			if(!isExist(left)) {
				map[node].left = left - 1;
			}
			if(!isExist(right)) {
				map[node].right = right - 1;
			}
		}
	}
	private static boolean isExist(int number) {
		return number == -1;
	}

	

}
