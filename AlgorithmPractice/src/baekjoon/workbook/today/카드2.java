package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeSet;

public class Ä«µå2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n =Integer.parseInt(reader.readLine());
		System.out.println(solution(n));
	}

	private static int solution(int n) {
		int answer = 0;
		Queue<Integer> que = new LinkedList<>();
		for(int i=0;i<n;++i) {
			que.offer(i+1);
		}
		while(que.size() != 1) {
			que.poll();
			int now = que.poll();
			que.offer(now);
		}
		for(int number : que)
			answer = number;
		return answer;
	}

}
