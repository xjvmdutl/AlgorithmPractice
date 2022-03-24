package baekjoon.workbook.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 이진검색트리2 {
	static class Node{
		int number;
		Node left;
		Node right;
		public Node(int number) {
			this.number = number;
		}
		public void insert(int num) {
			if(num < this.number) {
				if(this.left == null) {
					this.left = new Node(num);
				}else {
					this.left.insert(num);
				}
			}else {
				if(this.right == null) {
					this.right = new Node(num);
				}else {
					this.right.insert(num);
				}
			}
		}
	}
	public static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String str;
		Node root = new Node(Integer.parseInt(reader.readLine()));
		while((str = reader.readLine()) != null) {
			if(str == "") {
				break;
			}
			root.insert(Integer.parseInt(str));
		}
		System.out.println(solution(root));
	}
	private static String solution(Node root) {
		StringBuilder sb = new StringBuilder();
		postOrder(root, sb);
		return sb.toString();
	}
	private static void postOrder(Node root, StringBuilder sb) {
		if(root.left != null) {
			postOrder(root.left, sb);
		}
		if(root.right != null) {
			postOrder(root.right, sb);
		}
		sb.append(root.number + "\n");
	}


}
