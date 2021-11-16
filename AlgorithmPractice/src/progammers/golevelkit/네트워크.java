package progammers.golevelkit;

import java.util.LinkedList;
import java.util.Queue;

public class 네트워크 {
	public static boolean[] visit; 
	
	public static int solution(int n, int[][] computers) {
        int answer = 0;
        visit = new boolean[n];
        for(int i=0;i<n;++i) {
        	if(!visit[i]) {
        		answer++;
        		bfs(computers,i,n);
        	}
        }
        return answer;
    }
	private static void bfs(int[][] computers, int index, int n) {
		Queue<Integer> que = new LinkedList<>();
		visit[index] = true;
		que.offer(index);
		while(!que.isEmpty()) {
			int now = que.poll();
			for(int i=0;i<computers[now].length;++i) {
				if(!visit[i] && computers[now][i] > 0) {
					visit[i] = true;
					que.offer(i);
				}
			}
		}
	}
	public static void main(String[] args) {
		//n	computers	return
		//3	[[1, 1, 0], [1, 1, 0], [0, 0, 1]]	2
		//3	[[1, 1, 0], [1, 1, 1], [0, 1, 1]]	1
		int n1 = 3;
		int[][] computers1 = {{1, 1, 0},{1, 1, 0},{0, 0, 1}};
		System.out.println(solution(n1,computers1));
		int n2 = 3;
		int[][] computers2 = {{1, 1, 0},{1, 1, 1},{0, 1, 1}};
		System.out.println(solution(n2,computers2));
	}

}
