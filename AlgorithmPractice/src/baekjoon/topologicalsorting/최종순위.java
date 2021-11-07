package baekjoon.topologicalsorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 최종순위 {
	public static int[] inDegree;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		while(t-- > 0) {
			int n = Integer.parseInt(reader.readLine());
			inDegree = new int[n];
			int[] arr = new int[n];
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			List<List<Integer>> list = new ArrayList<>();
			for(int i=0;i<n;++i) {
				arr[i] = Integer.parseInt(tokens.nextToken()) - 1;
				list.add(new ArrayList<>());
			}
			for(int i=0;i<n;++i) {
				int from = arr[i];
				for(int j=i+1;j<n;++j) {
					list.get(from).add(arr[j]);
					inDegree[arr[j]]++;
				}
			}
			int m = Integer.parseInt(reader.readLine());
			for(int i=0;i<m;++i) {
				tokens = new StringTokenizer(reader.readLine());
				int start = Integer.parseInt(tokens.nextToken())-1;
				int end = Integer.parseInt(tokens.nextToken())-1;
				if(list.get(start).contains(end)) {
					list.get(start).remove((Integer)end);
					list.get(end).add(start);
					inDegree[start]++;
					inDegree[end]--;
				}else {
					list.get(end).remove((Integer)start);
					list.get(start).add(end);
					inDegree[end]++;
					inDegree[start]--;
				}
			}
			System.out.println(solution(list,arr,n));
		}
	}

	private static String solution(List<List<Integer>> list, int[] arr, int n) {
		StringBuilder sb = new StringBuilder();
		Queue<Integer> que = new LinkedList<>();
		int cnt = 0;
		for(int i=0;i<n;++i) {
			if(inDegree[i] == 0) {
				cnt++;
				que.offer(i);
			}
		}
		if(cnt>1) {
			return "?";
		}
		for(int i=0;i<n;i++) {
			if(que.isEmpty()) {
				return "IMPOSSIBLE";
			}
			int now = que.poll();
			sb.append((now+1) + " ");
			for(int next : list.get(now)) {
				inDegree[next]--;
				if(inDegree[next]==0) 
					que.offer(next);
			}
		}
		return sb.toString();
	}
}
