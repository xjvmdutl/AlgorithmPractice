package progammers.level2.review;

import java.util.LinkedList;
import java.util.Queue;
class Kakao{
	int x;
	int y;
	public Kakao(int x,int y) {
		this.x =x;
		this.y =y;
	}
}
public class «¡∑ª¡Ó4∫Ì∑œ {
	public static boolean[][] remove;
	public static boolean[][] visit;
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,1,-1};
	public static int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] arr = new char[m][n];
        for(int i=0;i<m;++i) {
        	arr[i] = board[i].toCharArray();
        }
        
        while(true) {
        	boolean flag = false;
        	visit = new boolean[m][n];
        	remove = new boolean[m][n];
        	for(int i=0;i<m-1;++i) {
        		for(int j=0;j<n-1;++j) {
        			if(arr[i][j] != 'X' && !visit[i][j]) {
	        			char c1 = arr[i][j];
	        			char c2 = arr[i][j+1];
	        			char c3 = arr[i+1][j];
	        			char c4 = arr[i+1][j+1];
	        			if(c1 == c2 && c1 ==c3 && c1 == c4) {
	        				flag = true;
	        				bfs(arr,j,i,m,n);
	        			}
        			}
        		}
        	}
        	if(!flag)
        		break;
        	for(int i=0;i<m;++i) {
        		for(int j=0;j<n;++j) {
        			if(remove[i][j]) {
        				answer++;
        				arr[i][j] = 'X';
        			}
        		}
        	}
        	for(int i=0;i<n;++i) {
        		Queue<Character> que = new LinkedList<>();
        		for(int j = m-1;j>=0;--j) {
        			if(arr[j][i] == 'X') {
        				continue;
        			}
        			que.offer(arr[j][i]);
        		}
        		for(int j = m-1;j>=0;--j) {
        			if(!que.isEmpty()) {
        				arr[j][i] = que.poll();
        			}else {
        				arr[j][i] = 'X';
        			}
        		}
        	}
        }
        return answer;
    }
	private static void bfs(char[][] arr, int x, int y, int m, int n) {
		Queue<Kakao> que = new LinkedList<>();
		char c = arr[y][x];
		que.offer(new Kakao(x, y));
		visit[y][x] = true;
		remove[y][x] =true;
		remove[y][x+1] = true;
		remove[y+1][x+1] = true;
		remove[y+1][x] = true;
		while(!que.isEmpty()) {
			Kakao k = que.poll();
			for(int i=0;i<4;++i) {
				int nx = dx[i] + k.x;
				int ny = dy[i] + k.y;
				if(0 <= ny && ny < m && 0 <= nx && nx < n) {
					if(!visit[ny][nx] && arr[ny][nx] == c) {
						if(0 <= ny+1 && ny+1 < m && 0 <= nx+1 && nx+1 <n) {
							char c1 = arr[ny][nx+1];
		        			char c2 = arr[ny+1][nx];
		        			char c3 = arr[ny+1][nx+1];
		        			if(c1 == c && c2 == c && c3 ==c) {
		        				remove[ny][nx] =true;
		        				remove[ny][nx+1] = true;
		        				remove[ny+1][nx+1] = true;
		        				remove[ny+1][nx] = true;
		        			}
						}
						visit[ny][nx] =true;
						que.offer(new Kakao(nx, ny));
					}
					
					
				}
			}
		}
	}
	public static void main(String[] args) {
		//m	n	board	answer
		//4	5	["CCBDE", "AAADE", "AAABF", "CCBBF"]	14
		//6	6	["TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"]	15
		
		
		int m1 = 4;
		int n1 = 5;
		String[] board1 = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
		System.out.println(solution(m1,n1,board1));
		int m2 = 6;
		int n2 = 6;
		String[] board2 = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
		System.out.println(solution(m2,n2,board2));
		int m3 =4;
		int n3 =5;
		String[] board3 = {"AAAAA","AUUUA","AUUAA","AAAAA"};
		System.out.println(solution(m3,n3,board3));
		
		
	}

}
