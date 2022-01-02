package progammers.level3;
class Card{
	int x;
	int y;
	public Card(int x,int y) {
		this.x = x;
		this.y = y;
	}
}
public class 카드짝맞추기 {
	public static int answer = 0;
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	public static int solution(int[][] board, int r, int c) {
        answer = 0;
        
        while(true) {
        	int count = 0;
        	for(int i=0;i<4;++i) {
        		for(int j=0;j<4;++j) {
            		if(board[i][j] == 0)
            			count++;
            	}	
        	}
        	if(count == 16)
        		break;
        	bfs(board,r,c);
        }
        return answer;
    }
	private static void bfs(int[][] board, int r, int c) {
		if(board[r][c] == 0) {
			findNode(board,r,c);
		}
	}
	private static void findNode(int[][] board, int r, int c) {
		for(int i=0;i<4;++i) {
			int nx =  r;
			int ny =  c;
			for(int j=0;j<4;++j) {
				nx =  nx + dx[i];
				ny =  ny + dy[i];
				if(!isRange(nx,ny) || board[ny][nx] != 0) {
					break;
				}
			}
			nx -= dx[i];
			ny -= dy[i];
			
		}
	}
	private static boolean isRange(int nx, int ny) {
		return 0 <= nx && nx < 4 && 0 <= ny && ny < 4;
	}
	public static void main(String[] args) {
		//board	r	c	result
		//[[1,0,0,3],[2,0,0,0],[0,0,0,2],[3,0,1,0]]	1	0	14
		//[[3,0,0,2],[0,0,1,0],[0,1,0,0],[2,0,0,3]]	0	1	16
		int[][] board1 = {{1,0,0,3},{2,0,0,0},{0,0,0,2},{3,0,1,0}};
		System.out.println(solution(board1,1,0));
	}

}
