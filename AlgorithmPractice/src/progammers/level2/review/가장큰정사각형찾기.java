package progammers.level2.review;

public class 가장큰정사각형찾기 {
	public static int solution(int [][]board){
		int answer = 0;
		if(board.length<=1 || board[0].length<=1)
            answer =1;
		for(int i =1;i<board.length;++i){
            for(int j=1;j<board[i].length;++j){
				if(board[i][j] >= 1 ) {
					int up = board[i-1][j];
                    int left = board[i][j-1];
                    int upleft = board[i-1][j-1];
                    int min = Math.min(Math.min(up,left), upleft);
                    board[i][j] = min+1;
                    answer = Math.max(answer,board[i][j]);
				}
			}
		}
		
        return answer*answer;
    }
	
	public static void main(String[] args) {
		//board	answer
		//[[0,1,1,1],[1,1,1,1],[1,1,1,1],[0,0,1,0]]	9
		//[[0,0,1,1],[1,1,1,1]]	4
		int[][] board1 = {{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}};
		System.out.println(solution(board1));
		int[][] board2 = {{0,0,1,1},{1,1,1,1}};
		System.out.println(solution(board2));
	}

}
