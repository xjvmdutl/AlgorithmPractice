package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Æ®¸® {
	public static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String str;
		int count = 1;
		while((str = reader.readLine()) != null) {
			StringTokenizer tokens = new StringTokenizer(str);
			int n = Integer.parseInt(tokens.nextToken());
			int m = Integer.parseInt(tokens.nextToken());
			if(n == 0 && m == 0) {
				break;
			}
			List<Integer>[] map = new ArrayList[n];
			for(int i=0;i<n;++i)
				map[i] = new ArrayList<>();
			for(int i=0;i<m;++i) {
				tokens = new StringTokenizer(reader.readLine());
				int start = Integer.parseInt(tokens.nextToken()) - 1;
				int end = Integer.parseInt(tokens.nextToken()) - 1;
				map[start].add(end);
				map[end].add(start);
			}
			System.out.println(solution(map, n, m, count++));
		}
	}

	private static String solution(List<Integer>[] map, int n, int m, int count) {
		StringBuilder sb = new StringBuilder();
		visit = new boolean[n];
		int cnt = 0;
		for(int i=0;i<n;++i) {
			if(!visit[i]) {
				if(bfs(map, i, n)) {
					cnt++;	
				}
			}
		}
		
		if(cnt > 1) {
			sb.append("Case " + count + ": A forest of "+ cnt +" trees.");
		}else if(cnt == 1) {
			sb.append("Case " + count + ": There is one tree. ");
		}else {
			sb.append("Case " + count + ": No trees. ");
		}
		return sb.toString();
	}

	private static boolean bfs(List<Integer>[] map, int now, int n) {
		Queue<Integer> que = new LinkedList<>();
		que.offer(now);
		visit[now] = true;
		int node = 0;
		int edge = 0;
		while(!que.isEmpty()) {
			int cur = que.poll();
			node++;
			for(int next : map[cur]) {
				edge++;
				if(!visit[next]) {
					visit[next] = true;
					que.offer(next);
				}
			}
		}
		return (edge / 2) + 1 == node;
	}

}
