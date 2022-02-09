package progammers.level3;
class WF{
	boolean win;
	int count;
	public WF(int count, boolean win) {
		this.count = count;
		this.win = win;
	}
}
class People{
	int x;
	int y;
	public People(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class 사라지는발판 {
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	public static int solution(int[][] board, int[] aloc, int[] bloc) {
        People a = new People(aloc[1], aloc[0]);
        People b = new People(bloc[1], bloc[0]);
        WF wf = dfs(board, a, b, true, 0);
        return wf.count;
    }
	private static WF dfs(int[][] board, People a, People b, boolean turn, int move) {
		if((turn && board[a.y][a.x] == 0) || (!turn && board[b.y][b.x] == 0)) {
			return new WF(move, false);
		}
		int win = Integer.MAX_VALUE;
		int lose = 0;
		for(int i=0;i<4;++i) {
			//a 차례
			if(turn) {
				int nx = a.x + dx[i];
				int ny = a.y + dy[i];
				if(isRange(nx,ny,board.length, board[0].length)) {
					if(board[ny][nx] == 0) {
						continue;
					}
					board[a.y][a.x] = 0;
					WF wf = dfs(board, new People(nx, ny), b, !turn, move + 1);
					if(!wf.win) {
						win = Math.min(win, wf.count);
					}else {
						lose = Math.max(lose, wf.count);
					}
					board[a.y][a.x] = 1;
				}
			}else {
				int nx = b.x + dx[i];
				int ny = b.y + dy[i];
				if(isRange(nx,ny,board.length, board[0].length)) {
					if(board[ny][nx] == 0) {
						continue;
					}
					board[b.y][b.x] = 0;
					WF wf = dfs(board, a, new People(nx, ny), !turn, move + 1);
					if(!wf.win) {
						win = Math.min(win, wf.count);
					}else {
						lose = Math.max(lose, wf.count);
					}
					board[b.y][b.x] = 1;
				}
			}
		}
		if(win == Integer.MAX_VALUE && lose == 0) {
			return new WF(move, false);
		}else if(win != Integer.MAX_VALUE) {
			return new WF(win, true);
		}else {
			return new WF(lose, false);
		}
	}
	private static boolean isRange(int nx, int ny, int n, int m) {
		return 0 <= nx && nx < m && 0 <= ny && ny < n;
	}
	public static void main(String[] args) {
		//board	aloc	bloc	result
		//[[1, 1, 1], [1, 1, 1], [1, 1, 1]]	[1, 0]	[1, 2]	5
		//[[1, 1, 1], [1, 0, 1], [1, 1, 1]]	[1, 0]	[1, 2]	4
		//[[1, 1, 1, 1, 1]]	[0, 0]	[0, 4]	4
		//[[1]]	[0, 0]	[0, 0]	0
		int[][] board1 = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
		int[] aloc1 = {1, 0};
		int[] bloc1 = {1, 2};
		System.out.println(solution(board1, aloc1, bloc1));
		
		int[][] board2 = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
		int[] aloc2 = {1, 0};
		int[] bloc2 = {1, 2};
		System.out.println(solution(board2, aloc2, bloc2));
		
		int[][] board3 = {{1, 1, 1, 1, 1}};
		int[] aloc3 = {0, 0};
		int[] bloc3 = {0, 4};
		System.out.println(solution(board3, aloc3, bloc3));
		
		int[][] board4 = {{1}};
		int[] aloc4 = {0, 0};
		int[] bloc4 = {0, 0};
		System.out.println(solution(board4, aloc4, bloc4));
	}
}
