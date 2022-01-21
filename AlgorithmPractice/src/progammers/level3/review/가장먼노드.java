package progammers.level3.review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class 가장먼노드 {
	public static int[] dis;
	public static int solution(int n, int[][] edge) {
        int answer = 0;
        dis = new int[n];
        List<Integer>[] map = new ArrayList[n];
        for(int i=0;i<n;++i) {
        	map[i] = new ArrayList<>();
        	dis[i] = Integer.MAX_VALUE;
        }
        for(int i=0;i<edge.length;++i) {
        	int start = edge[i][0] - 1;
        	int end = edge[i][1] - 1;
        	map[start].add(end);
        	map[end].add(start);
        }
        dlikstra(map,n);
        int max = Arrays.stream(dis).max().getAsInt();
        for(int i=1;i<n;++i) {
        	if(max == dis[i])
        		answer++;
        }
        return answer;
    }
	private static void dlikstra(List<Integer>[] map, int n) {
		Queue<Integer> que = new PriorityQueue<>();
		dis[0] = 0;
		que.offer(0);
		while(!que.isEmpty()) {
			int now = que.poll();
			for(int next : map[now]) {
				if(dis[next] > dis[now] + 1) {
					dis[next] = dis[now] + 1;
					que.offer(next);
				}
			}
		}
	}
	public static void main(String[] args) {
		//n	vertex	return
		//6	[[3, 6], [4, 3], [3, 2], [1, 3], [1, 2], [2, 4], [5, 2]]	3
		int[][] vertext = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
		System.out.println(solution(6,vertext));
	}

}
