package baekjoon.workbook.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 동전게임 {

	private static final int MAX = 512;
	private static final int END = 511;
	private static final int START = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		while(t-- > 0) {
			char[][] map = new char[3][3];
			for(int i=0;i<3;++i) {
				StringTokenizer tokens = new StringTokenizer(reader.readLine());
				for(int j=0;j<3;++j) {
					map[i][j] = tokens.nextToken().charAt(0);
				}
			}
			System.out.println(solution(map));
		}
	}
	private static int solution(char[][] map) {
		int start = 0;
		for(int i=0;i<3;++i) {
			for(int j=0;j<3;++j) {
				start *= 2;
				if(map[i][j] == 'H') {
					start++;
				}
			}	
		}
		int answer = bfs(start);
		return answer;
	}
	private static int bfs(int start) {
		Queue<Integer> que = new LinkedList<>();
		boolean[] visit = new boolean[MAX];
		visit[start] = true;
		int count = 0;
		que.offer(start);
		while(!que.isEmpty()) {
			int size = que.size();
			while(size-- > 0) {
				int now = que.poll();
				if(isGoal(now)) {
					return count;
				}
				int[] next = findNext(now);
				for(int i=0; i<8;++i) {
					if(!visit[next[i]]) {
						visit[next[i]] = true;
						que.offer(next[i]);
					}
				}
			}
			count++;
		}
		return -1;
	}
	
	private static boolean isGoal(int now) {
		return now == END || now == START;
	}
	private static int[] findNext(int now) {
		int[] next = new int[8];
		next[0] = change(now, 0, 1, 2);
		next[1] = change(now, 3, 4, 5);
		next[2] = change(now, 6, 7, 8);
		next[3] = change(now, 0, 3, 6);
		next[4] = change(now, 1, 4, 7);
		next[5] = change(now, 2, 5, 8);
		next[6] = change(now, 0, 4, 8);
		next[7] = change(now, 2, 4, 6);
		return next;
	}
	private static int change(int now, int i, int j, int k) {
		now = now ^ (1 << i);
		now = now ^ (1 << j);
		now = now ^ (1 << k);
		return now;
	}

}
