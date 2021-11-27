package progammers.level3;

import java.util.LinkedList;
import java.util.Queue;

public class 네트워크 {
	public static boolean[] visit;
	public static int solution(int n, int[][] computers) {
		visit = new boolean[n];
		int answer = 0;
		for(int i=0;i<n;++i) {
			if(!visit[i]) {
				answer++;
				bfs(computers,n,i);
			}
		}
		return answer;
	}
	private static void bfs(int[][] computers, int n,int start) {
		Queue<Integer> que = new LinkedList<>();
		visit[start] = true;
		que.offer(start);
		while(!que.isEmpty()) {
			int now = que.poll();
			for(int i=0;i<n;++i) {
				if(computers[now][i] == 1 && !visit[i]) {
					visit[i] = true;
					que.offer(i);
				}
			}
		}
	}
	public static void main(String[] args) {
		//3	[[1, 1, 0], [1, 1, 0], [0, 0, 1]]
		//3	[[1, 1, 0], [1, 1, 1], [0, 1, 1]]
		int[][] arr1 = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
		int[][] arr2 = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
		System.out.println(solution(3,arr1));
		System.out.println(solution(3,arr2));
	}

}
