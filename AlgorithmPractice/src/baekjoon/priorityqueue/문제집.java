package baekjoon.priorityqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
class Solve{
	int number;
	int priority;
	public Solve(int number,int priority) {
		this.number = number;
		this.priority = priority;
	}
}
public class 문제집 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		int link[] = new int[n];
		List<Integer>[] list = new ArrayList[n];
		for(int i=0;i<n;++i) {
			list[i] = new ArrayList<>();
		}
		for(int i=0;i<m;++i) {
			tokens = new StringTokenizer(reader.readLine());
			int a = Integer.parseInt(tokens.nextToken())-1;
			int b = Integer.parseInt(tokens.nextToken())-1;
			list[a].add(b);
			link[b]++;
		}
		System.out.println(solution(list,n,link));
	}

	private static String solution(List<Integer>[] list, int n, int[] link) {
		//위상정렬
		Queue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < n; i++)
            if(link[i] == 0)
                pq.offer(i);
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            int now = pq.poll();
            sb.append((now+1) + " ");
            for(int next: list[now]) {
            	link[next]--;
            	if(link[next] == 0)
                    pq.offer(next);
            }
        }
		return sb.toString();
	}
}
