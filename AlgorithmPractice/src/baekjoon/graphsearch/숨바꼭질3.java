package baekjoon.graphsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class Subin{
	int x;
	int count;
	public Subin(int x,int count) {
		this.count = count;
		this.x = x;
	}
}
public class ¼û¹Ù²ÀÁú3 {
	public static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int k = Integer.parseInt(tokens.nextToken());
		System.out.println(solution(n,k));
	}

	private static int solution(int n, int k) {
		visit = new boolean[100001];
		int answer = bfs(n,k);
		return answer;
	}

	private static int bfs(int n, int k) {
		Queue<Subin> que = new LinkedList<>();
		que.offer(new Subin(n, 0));
		visit[n] = true;
		while(!que.isEmpty()) {
			Subin s = que.poll();
			if(s.x == k) {
				return s.count;
			}
			for(int i=0;i<3;++i) {
				int count = s.count;
				int x = s.x;
				if(i == 0) {
					x *= 2;
				}else if(i == 1) {
					x -= 1;
					count++;
				}else if(i == 2) {
					x += 1;
					count++;
				}
				if(0 <= x && x <= 100000 && !visit[x]) {
					visit[x] = true;
					que.offer(new Subin(x, count));
				}
			}
		}
		return -1;
	}

}
