package baekjoon.workbook.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 줄어드는수 {
	public static long answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		System.out.println(solution(n));
	}

	private static long solution(int n) {
		if(n - 1 < 10)
			return n-1;
		answer = -1;
		bfs(n);
		return answer;
	}

	private static void bfs(int n) {
		Queue<String> que = new LinkedList<>();
		for(int i=1;i<10;++i) {
			que.offer(String.valueOf(i));
		}
		int count = 10;
		while(!que.isEmpty()) {
			
			String str = String.valueOf(que.poll());
			char c = str.charAt(str.length()-1);
			for(int i='0';i<c;++i) {
				count++;
				que.offer(new String(str + (char)i));
				if(count == n) {
					answer = Long.parseLong(str + (char)i);
					return;
				}
			}
		}
	}

}
