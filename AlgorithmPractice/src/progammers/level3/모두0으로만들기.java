package progammers.level3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 모두0으로만들기 {
	public static long[] arr;
	public static long answer;
	public static long solution(int[] a, int[][] edges) {
        answer = 0;
        arr = new long[a.length];
        long sum = 0;
        List<Integer>[] map = new ArrayList[a.length];
        int[] degree = new int[a.length];
        for(int i=0;i<a.length;++i) {
        	map[i] = new ArrayList<>();
        	sum += a[i];
        	arr[i] = a[i];
        }
        if(sum != 0) {
        	return -1;
        }
        for(int i=0;i<edges.length;++i) {
        	map[edges[i][0]].add(edges[i][1]);
        	map[edges[i][1]].add(edges[i][0]);
        	degree[edges[i][0]]++;
        	degree[edges[i][1]]++;
        }
        topology(map,degree);
        return answer;
    }
	
	private static void topology(List<Integer>[] map, int[] degree) {
		boolean[] visit = new boolean[map.length];
		Queue<Integer> que = new LinkedList<>();
        for(int i = 0; i < degree.length; i++) {
            if(degree[i] == 1) 
            	que.offer(i);
        } 
        while(!que.isEmpty()) {
        	int now = que.poll();
        	visit[now] = true;
        	for(int next : map[now]) {
        		if(!visit[next]) {
        			degree[next]--;
        			arr[next] += arr[now];
        			answer += Math.abs(arr[now]);
        			arr[now] = 0;
        			if(degree[next] == 1)
        				que.offer(next);
        		}
        	}
        }
        
		
		
	}

	public static void main(String[] args) {
		//a	edges	result
		//[-5,0,2,1,2]	[[0,1],[3,4],[2,3],[0,3]]	9
		//[0,1,0]	[[0,1],[1,2]]	-1
		int[] a1 = {-5,0,2,1,2};
		int[][] edges1 = {{0,1},{3,4},{2,3},{0,3}};
		System.out.println(solution(a1,edges1));
		int[] a2 = {0,1,0};
		int[][] edges2 = {{0,1},{1,2}};
		System.out.println(solution(a2,edges2));
	}
}
