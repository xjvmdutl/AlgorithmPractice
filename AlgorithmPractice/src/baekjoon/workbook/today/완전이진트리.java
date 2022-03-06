package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class VeryTree{
	int left;
	int right;
	public VeryTree(int left, int right) {
		this.left = left;
		this.right = right;
	}
}
public class 완전이진트리 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(reader.readLine());
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int[] arr = new int[(int) Math.pow(2, k) - 1];
		for(int i=0;i<arr.length;++i) {
			arr[i] = Integer.parseInt(tokens.nextToken());
		}
		System.out.println(solution(arr, k));
			
	}

	private static String solution(int[] arr, int k) {
		StringBuilder sb = new StringBuilder();
		Queue<VeryTree> que = new LinkedList<>();
		que.offer(new VeryTree(0, arr.length-1));
		while(!que.isEmpty()) {
			int QSize = que.size();
			for(int i=0;i<QSize;++i) {
				VeryTree v = que.poll();
				int mid = (v.left + v.right) / 2;
				sb.append(arr[mid] + " ");
				if(v.left != v.right) {
					que.offer(new VeryTree(v.left, mid-1));
					que.offer(new VeryTree(mid+1, v.right));
				}
			}
			sb.append("\n");
		}
		
		
		return sb.toString();
	}

}
