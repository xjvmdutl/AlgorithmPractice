package baekjoon.problems.algorithmPratice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
class Emoticon implements Comparable<Emoticon>{
	int browser;
	int clipboard;
	int time;
	public Emoticon(int browser,int clipboard,int time) {
		this.browser = browser;
		this.clipboard = clipboard;
		this.time = time;
	}
	@Override
	public int compareTo(Emoticon o) {
		return this.time - o.time;
	}
}
public class 이모티콘 {
	public static int time;
	public static boolean[][] visit = new boolean[1001][1001];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int s = Integer.parseInt(reader.readLine());
		System.out.println(solution(s));
	}

	private static int solution(int s) {
		time = 0;
		bfs(1,s);
		return time;
	}

	private static void bfs(int start, int s) {
		Queue<Emoticon> que = new PriorityQueue<>();
		que.offer(new Emoticon(1, 0, 0));
		while(!que.isEmpty()) {
			Emoticon e = que.poll();
			if(e.browser == s) {
				time = e.time;
				return;
			}
			for(int i=0;i<3;++i) {
				int nextClipboard = e.clipboard;
				int nextBrowser = e.browser;
				if(i == 0) {
					nextClipboard = e.browser;
				}else if(i == 1) {
					if(e.clipboard == 0)
						continue;
					nextBrowser += e.clipboard;
				}else {
					nextBrowser -= 1;
				}
				if(0 <= nextBrowser && nextBrowser <= 1000) {
					if(!visit[nextBrowser][nextClipboard]) {
						visit[nextBrowser][nextClipboard] = true;
						que.offer(new Emoticon(nextBrowser, nextClipboard, e.time+1));
					}
				}
			}
		}
	}

}
