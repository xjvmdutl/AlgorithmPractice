package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 요세푸스문제 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int k = Integer.parseInt(tokens.nextToken());
		System.out.println(solution(n, k));
	}

	private static String solution(int n, int k) {
		StringBuilder sb = new StringBuilder();
		Queue<Integer> que = new LinkedList<>();
		for(int i=0;i<n;++i) {
			que.offer((i+1));
		}
		sb.append("<");
		while(!que.isEmpty()) {
			int r = (k-1) % que.size();
			for(int i=0;i<r;++i) {
				que.offer(que.poll());
			}
			sb.append(que.poll() + ", ");
		}
		sb.delete(sb.length()-2, sb.length());
		sb.append(">");
		return sb.toString();
	}

}
