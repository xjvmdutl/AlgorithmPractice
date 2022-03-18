package baekjoon.workbook.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
class Node{
	int number;
	Node left;
	Node right;
	public Node(int number) {
		this.number = number;
	}
	public void insert(int number) {
		if(number < this.number) {
			if(this.left == null) {
				this.left = new Node(number);
			}else {
				this.left.insert(number);
			}
		}else {
			if(this.right == null) {
				this.right = new Node(number);
			}else {
				this.right.insert(number);
			}
		}
	}
}
public class 이진검색트리 {
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
		sb = new StringBuilder();
		postOrder(root);
		return sb.toString();
	}
	private static void postOrder(Node root) {
		if(root.left != null) {
			postOrder(root.left);
		}
		if(root.right != null) {
			postOrder(root.right);
		}
		sb.append(root.number + "\n");
	}


}
