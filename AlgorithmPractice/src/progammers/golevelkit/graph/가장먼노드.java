package progammers.golevelkit.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 가장먼노드 {
	public static int[] distance;
	public static boolean[] visit;
	public static int solution(int n, int[][] edge) {
        int answer = 0;
        distance = new int[n];
        visit = new boolean[n];
        Arrays.fill(distance, 0);
        List<Integer>[] list = new ArrayList[n];
        for(int i=0;i<n;++i)
        	list[i] = new ArrayList<>();

        for(int i=0;i<edge.length;++i) {
        	int start = edge[i][0]-1;
        	int end = edge[i][1]-1;
        	list[start].add(end);
        	list[end].add(start);
        }
        dijkstra(list,n);
        int maxValue = Arrays.stream(distance).max().getAsInt();
        for(int i=0;i<distance.length;++i) {
        	if(maxValue == distance[i])
        		answer++;
        }
        return answer;
    }
	private static void dijkstra(List<Integer>[] list, int n) {
		Queue<Integer> que = new LinkedList<>();
		que.offer(0);
		visit[0] = true;
		while(!que.isEmpty()) {
			int start = que.poll();
			for(int end : list[start]) {
				if(!visit[end]) {
					distance[end]=distance[start]+1;
					que.offer(end);
					visit[end] = true;
				}
			}
		}
	}
	public static void main(String[] args) {
		//n	vertex	return
		//6	[[3, 6], [4, 3], [3, 2], [1, 3], [1, 2], [2, 4], [5, 2]]	3
		int n = 6;
		int[][] vertex = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
		System.out.println(solution(n,vertex));
	}

}
