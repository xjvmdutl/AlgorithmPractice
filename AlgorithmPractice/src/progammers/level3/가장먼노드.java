package progammers.level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 가장먼노드 {
	public static int[] dist;
	public static int solution(int n, int[][] edge) {
        int answer = 0;
        List<Integer>[] map = new ArrayList[n];
        for(int i=0;i<n;++i) {
        	map[i] = new ArrayList<>();
        }
        for(int i=0;i<edge.length;++i) {
        	int start = edge[i][0]-1;
        	int end = edge[i][1]-1;
        	map[start].add(end);//양방향 이라서
        	map[end].add(start);
        }
        dijkstra(map,n);
        int max = Arrays.stream(dist).max().getAsInt();
        for(int i=0;i<dist.length;++i) {
        	if(max == dist[i])
        		answer++;
        }
        return answer;
    }
	private static void dijkstra(List<Integer>[] map, int n) {
		Queue<Integer> que = new LinkedList<>();
		dist = new int[n];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[0] = 0;
		que.offer(0);
		while(!que.isEmpty()) {
			int now = que.poll();
			for(int next : map[now]) {
				if(dist[next] > dist[now] + 1) {
					dist[next] = dist[now] + 1;
					que.offer(next);
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//n	vertex	return
		//6	[[3, 6], [4, 3], [3, 2], [1, 3], [1, 2], [2, 4], [5, 2]]	3
		int n = 6;
		int[][] vertex = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
		System.out.println(solution(n,vertex));
	}

}
