package backJun.graphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ¼¶ÀÇ°³¼ö {
	public static boolean[][] visited;
	public static int[] dx = {-1,0,1,
							  -1,1,
							  -1,0,1};
	public static int[] dy = {-1,-1,-1,
							  0,0,
							  1,1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			int w = Integer.parseInt(tokens.nextToken());
			int h = Integer.parseInt(tokens.nextToken());
			if(w == 0 && h ==0)
				break;
			int[][] arr = new int[h][w];
			for(int i=0;i<h;++i) {
				tokens = new StringTokenizer(reader.readLine());
				for(int j=0;j<w;++j) {
					arr[i][j] = Integer.parseInt(tokens.nextToken());
				}
			}
			System.out.println(solution(arr,w,h));
		}
	}

	private static int solution(int[][] arr, int w, int h) {
		int answer = 0;
		visited = new boolean[h][w];
		for(int i=0;i<h;++i) {
			for(int j=0;j<w;++j) {
				if(!visited[i][j] && arr[i][j] == 1) {
					answer++;
					visited[i][j] = true;
					dfs(arr,j,i);
				}
			}
		}
		return answer;
	}

	private static void dfs(int[][] arr, int x, int y) {
		for(int i=0;i<8;++i) {
			int idx = dx[i] + x;
			int jdy = dy[i] + y;
			if(0 <= idx && idx < arr[0].length && 0 <= jdy && jdy < arr.length) {
				if(!visited[jdy][idx] && arr[jdy][idx] == 1) {
					visited[jdy][idx] = true;
					dfs(arr, idx, jdy);
				}
			}
		}
	}

}
