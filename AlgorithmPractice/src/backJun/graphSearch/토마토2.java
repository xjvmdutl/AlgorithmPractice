package backJun.graphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
class Tomato2 {
	int x;
	int y;
	int z;
	public Tomato2(int x,int y,int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
}
public class ≈‰∏∂≈‰2 {
	public static boolean[][][] visited;
	
	public static int[] dx = {-1,1,0,0,0,0};
	public static int[] dy = {0,0,1,-1,0,0};
	public static int[] dz = {0,0,0,0,1,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		int m = Integer.parseInt(strs[0]);
		int n = Integer.parseInt(strs[1]);
		int h = Integer.parseInt(strs[2]);
		int[][][] arr = new int[h][n][m];
		for(int i=0;i<h;++i) {
			for(int j=0;j<n;++j) {
				strs = reader.readLine().split(" ");
				for(int k=0;k<m;++k) {
					arr[i][j][k] = Integer.parseInt(strs[k]);
				}	
			}
		}
		System.out.println(solution(arr,m,n,h));
	}

	private static int solution(int[][][] arr, int m, int n, int h) {
		int answer = 0;
		visited = new boolean[h][n][m];
		Queue<Tomato2> que = new LinkedList<>();
		for(int i=0;i<h;++i) {
			for(int j=0;j<n;++j) {
				for(int k=0;k<m;++k) {
					if(arr[i][j][k] == 1)
						que.offer(new Tomato2(k, j, i));
				}	
			}
		}
		while(!que.isEmpty()) {
			Tomato2 t= que.poll();
			for(int i=0;i<6;++i) {
				int x = dx[i] + t.x;
				int y = dy[i] + t.y;
				int z = dz[i] + t.z;
				if(0 <= x && x < m
				&& 0 <= y && y < n
				&& 0 <= z && z < h) {
					if(!visited[z][y][x] && arr[z][y][x] == 0) {
						int data = arr[t.z][t.y][t.x];
						arr[z][y][x] = data + 1;
						que.offer(new Tomato2(x, y, z));
					}
				}
			}
		}
		for(int i=0;i<h;++i) {
			for(int j=0;j<n;++j) {
				for(int k=0;k<m;++k) {
					if(arr[i][j][k] == 0)
						return -1;
					answer = Math.max(answer, arr[i][j][k]);
				}	
			}
		}
		
		return answer - 1;
	}

}
