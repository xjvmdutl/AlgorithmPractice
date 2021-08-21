package progammers.weekly;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node{
	int x;
	int y;
	public Node(int x,int y) {
		this.x = x;
		this.y = y;
	}
}

public class 퍼즐조각채우기 {
	public static boolean[][] visit;
	public static int N,answer;
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,1,-1};
	public static List<int[][]> list = new ArrayList<>();
	public static int solution(int[][] game_board, int[][] table) {
        answer = 0;
        N = game_board.length;
        visit = new boolean[N][N];
        for(int i=0;i<N;++i) {
        	for(int j=0;j<N;++j) {
        		if(game_board[i][j] == 0 && !visit[i][j]) {
        			bfs(game_board,j,i);
        		}
        	}
        }
        visit = new boolean[N][N];
        for(int i=0;i<N;++i) {
        	for(int j=0;j<N;++j) {
        		if(table[i][j] == 1 && !visit[i][j]) {
        			find(table,j,i);
        		}
        	}
        }
        return answer;
    }
	private static void find(int[][] table, int x, int y) {
		Queue<Node> que = new LinkedList<>();
		List<Node> block = new ArrayList<>();
		visit[y][x] = true;
		que.offer(new Node(x,y));
		block.add(new Node(x,y));
		int minX = x;
		int maxX = x;
		int minY = y;
		int maxY = y;
		while(!que.isEmpty()) {
			Node n = que.poll();
			for(int i=0;i<4;++i) {
				int nx = dx[i] + n.x;
				int ny = dy[i] + n.y;
				if(isRange(table,nx,ny)) {
					if(!visit[ny][nx] && table[ny][nx] == 1) {
						minX = Math.min(minX, nx);
						maxX = Math.max(maxX, nx);
						minY = Math.min(minY, ny);
						maxY = Math.max(maxY, ny);
						visit[ny][nx] = true;
						que.offer(new Node(nx,ny));
						block.add(new Node(nx,ny));
					}
				}
			}
		}
		int[][] arr = new int[maxY - minY + 1][maxX - minX + 1];
		for(Node n: block) {
			arr[n.y - minY][n.x - minX] = 1;
		}
		//블록완성
		for(int idx=0;idx<4;++idx) {
			int n = arr.length;
			int m = arr[0].length;
			boolean flag = false;
			for(int l = 0;l<list.size();++l) {
				int[][] blocks = list.get(l);	
				if(blocks.length == n && blocks[0].length == m) {
					if(isOK(blocks,arr)) {
						flag = true;
						answer += isCount(arr);
					}
				}
				if(flag) {
					list.remove(l);
					break;
				}
			}
			if(flag) {
				break;
			}
			//블록 돌리기
			int[][] rotation = new int[m][n];
			for(int i=0;i<m;++i) {
				for(int j=0;j<n;++j) {
					rotation[i][j] = arr[j][m - 1 - i];
				}	
			}
			arr = rotation;
		}
		
	}
	private static int isCount(int[][] arr) {
		int count = 0;
		for(int i=0;i<arr.length;++i) {
			for(int j=0;j<arr[i].length;++j) {
				if(arr[i][j] == 1)
					count++;
			}
		}
		return count;
	}
	private static boolean isOK(int[][] blocks, int[][] arr) {
		for(int i=0;i<arr.length;++i) {
			for(int j=0;j<arr[i].length;++j) {
				if(arr[i][j] != blocks[i][j])
					return false;
			}
		}
		
		return true;
	}
	private static void bfs(int[][] game_board, int x, int y) {
		Queue<Node> que = new LinkedList<>();
		List<Node> block = new ArrayList<>();
		visit[y][x] = true;
		que.offer(new Node(x,y));
		block.add(new Node(x,y));
		int minX = x;
		int maxX = x;
		int minY = y;
		int maxY = y;
		while(!que.isEmpty()) {
			Node n = que.poll();
			for(int i=0;i<4;++i) {
				int nx = dx[i] + n.x;
				int ny = dy[i] + n.y;
				if(isRange(game_board,nx,ny)) {
					if(!visit[ny][nx] && game_board[ny][nx] == 0) {
						minX = Math.min(minX, nx);
						maxX = Math.max(maxX, nx);
						minY = Math.min(minY, ny);
						maxY = Math.max(maxY, ny);
						visit[ny][nx] = true;
						que.offer(new Node(nx,ny));
						block.add(new Node(nx,ny));
					}
				}
			}
		}
		int[][] arr = new int[maxY - minY + 1][maxX - minX + 1];
		for(Node n: block) {
			arr[n.y - minY][n.x - minX] = 1;
		}
		list.add(arr);
	}
	private static boolean isRange(int[][] arr, int nx, int ny) {
		if(nx < 0 || nx >= N || ny < 0 || ny >= N) 
			return false;
		
		return true;
	}
	public static void main(String[] args) {
		int[][] game_board = {{1,1,0,0,1,0},{0,0,1,0,1,0},{0,1,1,0,0,1},{1,1,0,1,1,1},{1,0,0,0,1,0},{0,1,1,1,0,0}};
		int[][] table = {{1,0,0,1,1,0},{1,0,1,0,1,0},{0,1,1,0,1,1},{0,0,1,0,0,0},{1,1,0,1,1,0},{0,1,0,0,0,0}};
		System.out.println(solution(game_board, table));
	}

}
