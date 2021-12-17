package progammers.level3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Node{
	int x;
	int y;
	int data;
	Node left;
	Node right;
	
	public Node(int x,int y,int data) {
		this.data = data;
		this.x = x;
		this.y = y;
	}
}
public class 길찾기게임 {
	public static int index;
	public static int[][] solution(int[][] nodeinfo) {
        int[][] answer = new int[2][nodeinfo.length];
        List<Node> list = new ArrayList<>();
        for(int i=0;i<nodeinfo.length;++i) {
        	list.add(new Node(nodeinfo[i][0], nodeinfo[i][1], i+1));
        }
        Collections.sort(list,(o1,o2)->{
        	return o2.y - o1.y;
        });
        Node root = list.get(0);
        for(int i=1;i<list.size();++i) {
        	Node node = list.get(i);
        	connectionNode(root,node);
        }
        index = 0;
        preOrder(answer, root);
        root = list.get(0);
        index = 0;
        postOrder(answer,root);
        return answer;
    }
	private static void postOrder(int[][] answer, Node now) {
		if(now == null)
			return;
		
		postOrder(answer, now.left);
		postOrder(answer, now.right);
		answer[1][index++] = now.data;
	}
	private static void connectionNode(Node parent, Node child) {
		if(child.x < parent.x) {
			if(parent.left != null) {
				connectionNode(parent.left,child);
			}else {
				parent.left = child;
			}
		}else {
			if(parent.right != null) {
				connectionNode(parent.right,child);
			}else {
				parent.right = child;
			}
		}
	}
	private static void preOrder(int[][] answer,Node now) {
		if(now == null)
			return;
		answer[0][index++] = now.data;
		preOrder(answer, now.left);
		preOrder(answer, now.right);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] nodeinfo = {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};
		System.out.println(solution(nodeinfo));
	}

}
