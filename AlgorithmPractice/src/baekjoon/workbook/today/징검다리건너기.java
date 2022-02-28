package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
class Bridge implements Comparable<Bridge>{
	int now;
	boolean jump;
	int energy;
	public Bridge(int now, boolean jump, int energy) {
		this.now = now;
		this.jump = jump;
		this.energy = energy;
	}
	@Override
	public int compareTo(Bridge o) {
		return this.energy - o.energy;
	}
}
public class 징검다리건너기 {
	public static int answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[][] arr = new int[n][2];
		for(int i=1;i<n;++i) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			arr[i][0] = Integer.parseInt(tokens.nextToken());
			arr[i][1] = Integer.parseInt(tokens.nextToken());
		}
		int k = Integer.parseInt(reader.readLine());
		System.out.println(solution(arr, n, k));
	}

	private static int solution(int[][] arr, int n, int k) {
		answer = Integer.MAX_VALUE;
		bfs(arr, n, k);
		return answer;
	}

	private static void bfs(int[][] arr, int n, int k) {
		Queue<Bridge> pq = new PriorityQueue<>();
		pq.offer(new Bridge(1, false, 0));
		while(!pq.isEmpty()) {
			Bridge b = pq.poll();
			if(b.now == n) {
				answer = Math.min(b.energy, answer);
				continue;
			}
			if(b.now +  1 <= n) {
				pq.offer(new Bridge(b.now+1, b.jump, b.energy + arr[b.now][0]));//점프
			}
			if(b.now + 2 <= n) {
				pq.offer(new Bridge(b.now+2, b.jump, b.energy + arr[b.now][1])); //큰점프	
			}
			if(!b.jump && b.now +3 <= n) {
				pq.offer(new Bridge(b.now + 3, true, b.energy + k));
			}
		}
	}

}
