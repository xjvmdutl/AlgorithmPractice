package baekjoon.graphsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class Pipe{
	int x;
	int y;
	int n;
	int m;
	int count;
	public Pipe(int x,int y,int n,int m,int count) {
		this.x = x;
		this.y = y;
		this.n = n;
		this.m = m;
		this.count = count;
	}
}
public class 파이프옮기기1 {
	public static int answer;
	public static int[] nx = {1,0,1};
	public static int[] ny = {0,1,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[][] arr = new int[n][n];
		for(int i=0;i<n;++i) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			for(int j=0;j<n;++j) {
				arr[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		
		System.out.println(solution(arr,n));
	
	}

	private static int solution(int[][] arr, int n) {
		answer = 0;
		bfs(arr,n);
		return answer;
	}

	private static void bfs(int[][] arr, int n) {
		Queue<Pipe> que = new LinkedList<>();
		que.offer(new Pipe(1,0,1,2,1));
		while(!que.isEmpty()) {
			Pipe p = que.poll();
			if(p.x == n-1 && p.y == n-1) {
				answer++;
			}
			if(p.n == 1 && p.m == 2) {//가로2 세로1
				for(int i=0;i<3;++i) {
					if(i==1) 
						continue;
					int dx = nx[i] + p.x;
					int dy = ny[i] + p.y;
					if(isRange(arr,dx,dy)) {//가로 하나 더
						if(i == 0 && arr[dy][dx] != 1) {
							que.offer(new Pipe(p.x+1, p.y ,1 , 2, p.count+1));
						}else if(i==2 && arr[dy][dx] != 1 && arr[dy][dx-1] != 1 && arr[dy-1][dx] != 1) {
							que.offer(new Pipe(p.x+1, p.y+1 ,2 , 2, p.count+1));
						}
					}
				}
			}else if(p.n == 2 && p.m == 1) {//가로1 세로2
				for(int i=0;i<3;++i) {
					if(i==0) 
						continue;
					int dx = nx[i] + p.x;
					int dy = ny[i] + p.y;
					if(isRange(arr,dx,dy)) {//가로 하나 더
						if(i == 1 && arr[dy][dx] != 1) {
							que.offer(new Pipe(p.x, p.y+1 ,2 , 1, p.count+1));
						}else if(i==2 && arr[dy][dx] != 1 && arr[dy][dx-1] != 1 && arr[dy-1][dx] != 1) {
							que.offer(new Pipe(p.x+1, p.y+1 ,2 , 2, p.count+1));
						}
					}
				}
			}else if(p.n == 2 && p.m == 2) {//가로2 세로2
				for(int i=0;i<3;++i) {
					int dx = nx[i] + p.x;
					int dy = ny[i] + p.y;
					if(isRange(arr,dx,dy)) {//가로 하나 더
						if(i == 0 && arr[dy][dx] != 1) {
							que.offer(new Pipe(p.x+1, p.y ,1 , 2, p.count+1));
						}else if(i == 1 && arr[dy][dx] != 1) {
							que.offer(new Pipe(p.x, p.y+1 ,2 , 1, p.count+1));
						}else if(i==2 && arr[dy][dx] != 1 && arr[dy][dx-1] != 1 && arr[dy-1][dx] != 1) {
							que.offer(new Pipe(p.x+1, p.y+1 ,2 , 2, p.count+1));
						}
					}
				}
			}
		}
	}

	private static boolean isRange(int[][] arr, int x, int y) {
		if(0 > x || x >= arr[0].length || 0 > y || y >= arr.length ) {
			return false;
		}
		return true;
	}
}
