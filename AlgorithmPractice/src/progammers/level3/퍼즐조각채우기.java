package progammers.level3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
class Piece{
	int x;
	int y;
	public Piece(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class 퍼즐조각채우기 {
	public static boolean[][] visit;
	public static List<int[][][]> list;
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	public static int answer;
	public static int solution(int[][] game_board, int[][] table) {
		answer = 0;
		visit= new boolean[table.length][table[0].length];
		list = new ArrayList<>();
		for(int i=0;i<table.length;++i) {
			for(int j=0;j<table[i].length;++j) {
				if(!visit[i][j] && table[i][j] == 1) {
					bfs(table,j,i,table.length,table[0].length);
				}
			}	
		}
		visit= new boolean[table.length][table[0].length];
		for(int i=0;i<game_board.length;++i) {
			for(int j=0;j<game_board[i].length;++j) {
				if(!visit[i][j] && game_board[i][j] == 0) {
					find(game_board,j,i,game_board.length,game_board[0].length);
				}
			}	
		}
		
		return answer;
	}
	private static void find(int[][] game_board, int x, int y, int n, int m) {
		List<Piece> pieces = new ArrayList<>();
		Queue<Piece> que = new LinkedList<>();
		que.offer(new Piece(x, y));
		visit[y][x] = true;
		
		int minX = Integer.MAX_VALUE;
		int maxX = Integer.MIN_VALUE;
		int minY = Integer.MAX_VALUE;
		int maxY = Integer.MIN_VALUE;
		while(!que.isEmpty()) {
			Piece p = que.poll();
			pieces.add(p);
			minX = Math.min(minX, p.x);
			maxX = Math.max(maxX, p.x);
			minY = Math.min(minY, p.y);
			maxY = Math.max(maxY, p.y);
			for(int i=0;i<4;++i) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if(isRange(nx,ny,n,m) && !visit[ny][nx] && game_board[ny][nx] == 0) {
					visit[ny][nx] = true;
					que.offer(new Piece(nx, ny));
				}
			}
		}
		int N = maxY - minY + 1;
		int M = maxX - minX + 1;
		int count = 0;
		int[][] data = new int[N][M];
		for(Piece p : pieces) {
			int nx = p.x - minX;
			int ny = p.y - minY;
			data[ny][nx] = 1;
			count++;
		}
		for(int i=0;i<list.size();++i) {
			int[][][] datas = list.get(i);
			OUTER:for(int[][] arr : datas) {
				if(arr.length != N || arr[0].length != M)
					continue OUTER;
				for(int j=0;j<N;++j) {
					for(int k=0;k<M;++k) {
						if(arr[j][k] != data[j][k]) {
							continue OUTER;
						}
					}
				}
				list.remove(i);
				answer += count;
				return;
			}
		}
	}
	private static void bfs(int[][] table, int x, int y, int n, int m) {
		Queue<Piece> que = new LinkedList<>();
		List<Piece> pieces = new ArrayList<>();
		que.offer(new Piece(x, y));
		visit[y][x] = true;
		int minX = Integer.MAX_VALUE;
		int maxX = Integer.MIN_VALUE;
		int minY = Integer.MAX_VALUE;
		int maxY = Integer.MIN_VALUE;
		while(!que.isEmpty()) {
			Piece p = que.poll();
			pieces.add(p);
			minX = Math.min(minX, p.x);
			maxX = Math.max(maxX, p.x);
			minY = Math.min(minY, p.y);
			maxY = Math.max(maxY, p.y);
			for(int i=0;i<4;++i) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if(isRange(nx,ny,n,m) && !visit[ny][nx] && table[ny][nx] == 1) {
					visit[ny][nx] = true;
					que.offer(new Piece(nx, ny));
				}
			}
		}
		int[][][] datas = new int[4][][];
		int N = maxY - minY + 1;
		int M = maxX - minX + 1;
		datas[0] = new int[N][M];
		for(Piece p : pieces) {
			int nx = p.x - minX;
			int ny = p.y - minY;
			datas[0][ny][nx] = 1;
		}
		for(int i=1;i<4;++i) {
			Rotation(i,datas,N,M);
		}
		list.add(datas);
	}
	private static void Rotation(int index, int[][][] datas,int N,int M) {
		if(index == 2) {
			datas[index] = new int[N][M];
			for(int i=0;i<M;++i){
	            for(int j=0;j<N;++j){
	            	datas[index][N - 1 - j][i] = datas[index-1][i][j];
	            }
	        }
		}else {
			datas[index] = new int[M][N];
			for(int i=0;i<N;++i){
	            for(int j=0;j<M;++j){
	            	datas[index][M - 1 - j][i] = datas[index-1][i][j];
	            }
	        }
		}
	}
	private static boolean isRange(int nx, int ny, int n, int m) {
		return 0 <= nx && nx < m && 0 <= ny && ny < n;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] ganme_board1 = {{1,1,0,0,1,0},{0,0,1,0,1,0},{0,1,1,0,0,1},{1,1,0,1,1,1},{1,0,0,0,1,0},{0,1,1,1,0,0}};
		int[][] table1 = {{1,0,0,1,1,0},{1,0,1,0,1,0},{0,1,1,0,1,1},{0,0,1,0,0,0},{1,1,0,1,1,0},{0,1,0,0,0,0}};
		System.out.println(solution(ganme_board1,table1));
	}

}
