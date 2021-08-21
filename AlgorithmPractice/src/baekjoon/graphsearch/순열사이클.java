package baekjoon.graphsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 순열사이클 {
	public static boolean[] visit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		for(int i=0;i<t;++i) {
			int n = Integer.parseInt(reader.readLine());
			List<ArrayList<Integer>> list = new ArrayList<>();
			for(int j=0;j<n;++j) {
				list.add(new ArrayList<>());
			}
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			for(int j=0;j<n;++j) {
				int end = Integer.parseInt(tokens.nextToken());
				list.get(j).add(end-1);
			}
			System.out.println(solution(list,n));
		}
	}

	private static int solution(List<ArrayList<Integer>> list, int n) {
		int answer = 0;
		visit = new boolean[n];
		for(int i=0;i<n;++i) {
			if(!visit[i]) {
				answer++;
				bfs(list,n,i);
			}
		}
		return answer;
	}

	private static void bfs(List<ArrayList<Integer>> list, int n, int idx) {
		Queue<Integer> que = new LinkedList<>();
		que.offer(idx);
		visit[idx] = true;
		while(!que.isEmpty()) {
			int index = que.poll();
			for(int i=0;i<list.get(index).size();++i) {
				int next = list.get(index).get(i);
				if(!visit[next]) {
					visit[next] = true;
					que.offer(next);
				}
			}
		}
	}

}
