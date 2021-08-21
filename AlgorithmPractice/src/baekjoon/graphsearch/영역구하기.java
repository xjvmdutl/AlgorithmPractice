package baekjoon.graphsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
class node{
	int x;
	int y;
	public node(int x,int y) {
		this.x = x;
		this.y = y;
	}
}
public class 영역구하기 {
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,1,-1};
	public static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int m = Integer.parseInt(tokens.nextToken());
		int n = Integer.parseInt(tokens.nextToken());
		int k = Integer.parseInt(tokens.nextToken());
		int[][] arr = new int[m][n];
		for(int i=0;i<k;++i) {
			tokens = new StringTokenizer(reader.readLine());
			int x1 = Integer.parseInt(tokens.nextToken());
			int y1 = Integer.parseInt(tokens.nextToken());
			y1 = arr.length - 1 - y1;
			int x2 = Integer.parseInt(tokens.nextToken())-1;
			int y2 = Integer.parseInt(tokens.nextToken())-1;
			y2 = arr.length - 1 - y2;
			for(int j = y2;j<=y1;++j) {
				for(int l = x1;l<=x2;++l) {
					arr[j][l] = 1;
				}	
			}
		}
		System.out.println(solution(arr,m,n));
	}

	private static String solution(int[][] arr, int m, int n) {
		StringBuilder sb = new StringBuilder();
		List<Integer> list = new ArrayList<>();
		visited = new boolean[m][n];
		for(int i=0;i<arr.length;++i) {
			for(int j=0;j<arr[i].length;++j) {
				if(!visited[i][j] && arr[i][j] == 0) {
					visited[i][j] = true;
					int cnt = bfs(arr,j,i);
					list.add(cnt);
				}
			}
		}
		Collections.sort(list);
		sb.append(list.size() + "\n");
		for(int data : list)
			sb.append(data + " ");
		
		return sb.delete(sb.length()-1, sb.length()).toString();
	}

	private static int bfs(int[][] arr, int x, int y) {
		int cnt = 1;
		Queue<node> que = new LinkedList<>();
		que.offer(new node(x,y));
		while(!que.isEmpty()) {
			node n = que.poll();
			for(int i=0;i<4;++i) {
				int nx = n.x + dx[i];
				int ny = n.y + dy[i];
				if(0 <= nx && nx < arr[0].length
						&& 0 <= ny && ny < arr.length) {
					if(!visited[ny][nx] && arr[ny][nx] == 0) {
						visited[ny][nx] = true;
						cnt++;
						que.offer(new node(nx, ny));
					}
				}
			}
		}
		return cnt;
	}

}
