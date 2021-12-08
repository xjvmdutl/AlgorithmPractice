package AutoEverPratice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
class Round{
	int x;
	int y;
	public Round(int x,int y) {
		this.x = x;
		this.y = y;
	}
}
public class tes {
	public static boolean[][] visit;
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,1,-1};
	public static List<Integer> list;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[][] arr= new int[n][n];
		for(int i=0;i<n;++i) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			for(int j=0;j<n;++j) {
				arr[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		System.out.println(solution(arr,n));
	}

	private static String solution(int[][] arr, int n) {
		StringBuilder sb = new StringBuilder();
		int count = 0;
		list = new ArrayList<>();
		visit = new boolean[n][n];
		for(int i=0;i<n;++i) {
			for(int j=0;j<n;++j) {
				if(!visit[i][j] && arr[i][j] == 1) {
					bfs(arr,n,j,i);
					count++;
				}
			}
		}
		sb.append(count + "\n");
		Collections.sort(list);
		for(int number : list) {
			sb.append(number + " ");
		}
		return sb.toString();
	}

	private static void bfs(int[][] arr, int n, int x, int y) {
		Queue<Round> que= new LinkedList<>();
		que.offer(new Round(x,y));
		visit[y][x] = true;
		int count = 1;
		while(!que.isEmpty()) {
			Round r = que.poll();
			for(int i=0;i<4;++i) {
				int nx = r.x + dx[i];
				int ny = r.y + dy[i];
				if(0 <= nx && nx < n && 0 <= ny && ny < n) {
					if(!visit[ny][nx] && arr[ny][nx] == 1) {
						visit[ny][nx] = true;
						count++;
						que.offer(new Round(nx, ny));
					}
				}
			}
		}
		list.add(count);
	}

}
