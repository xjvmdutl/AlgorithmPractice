package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 거꾸로구구단 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int k = Integer.parseInt(tokens.nextToken());
		System.out.println(solution(n,k));
	}

	private static int solution(int n, int k) {
		Queue<Integer> que = new PriorityQueue<>((o1,o2)->o2-o1);
		for(int i=1;i<=k;++i) {
			StringBuilder sb = new StringBuilder(String.valueOf(n * i));
			que.offer(Integer.parseInt(sb.reverse().toString()));
		}
		return que.poll();
	}

}
