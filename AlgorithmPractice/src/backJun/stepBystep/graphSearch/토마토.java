package backJun.stepBystep.graphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
class Tomato{
	int x;
	int y;
	public Tomato(int x,int y) {
		this.x = x;
		this.y = y;
	}
}
public class ≈‰∏∂≈‰ {
	
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,1,-1};
	public static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		int m = Integer.parseInt(strs[0]);
		int n = Integer.parseInt(strs[1]);
		int[][] arr = new int[n][m];
		for(int i=0;i<n;++i) {
			strs = reader.readLine().split(" ");
			for(int j=0;j<m;++j) {
				arr[i][j] = Integer.parseInt(strs[j]);
			}
		}
		System.out.println(solution(arr,n,m));
	}

	private static int solution(int[][] arr, int n, int m) {
		
		visited = new boolean[n][m];
		Queue<Tomato> queue = new LinkedList<>();
		for(int i=0;i<arr.length;++i) {
			for(int j=0;j<arr[i].length;++j) {
				if(arr[i][j] == 1)
					queue.offer(new Tomato(j, i));
			}
		}
		while(!queue.isEmpty()) {
			Tomato t = queue.poll();
	
			for(int i=0;i<4;++i) {
				int x = t.x + dx[i];
				int y = t.y + dy[i];
				if(0 <= x && x < m && 0 <= y && y < n) {
					if(arr[y][x] == 0) {
						queue.add(new Tomato(x, y));
						arr[y][x] = arr[t.y][t.x]+1;
					}
				}
			}
		}
		int answer = Integer.MIN_VALUE;
		for(int i=0;i<arr.length;++i) {
			for(int j=0;j<arr[i].length;++j) {
				if(arr[i][j] == 0)
					return -1;
				else
					answer = Math.max(answer, arr[i][j]);
			}
		}
		if(answer == 1)
			return 0;
		
		return answer-1;
	}

}
