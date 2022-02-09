package progammers.level3;

public class ÆÄ±«µÇÁö¾ÊÀº°Ç¹° {
	public static int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int[][] querys = new int[board.length + 1][board[0].length + 1];
        for(int[] s : skill) {
    		int value = s[5];
        	if(s[0] == 1) {
        		querys[s[1]][s[2]] -= value;
        		querys[s[1]][s[4] + 1] += value;
        		querys[s[3] + 1][s[2]] += value;
        		querys[s[3] + 1][s[4] + 1] -= value;
        	}else {
        		querys[s[1]][s[2]] += value;
        		querys[s[1]][s[4] + 1] -= value;
        		querys[s[3] + 1][s[2]] -= value;
        		querys[s[3] + 1][s[4] + 1] += value;
        	}
        }
        
        //Èð±â
        for(int i=0;i<querys.length;++i) {
        	for(int j=1;j<querys[0].length;++j) {
            	querys[i][j] += querys[i][j-1];
            }	
        }
        for(int j=0;j<querys[0].length;++j) {
        	for(int i=1;i<querys.length;++i) {
            	querys[i][j] += querys[i - 1][j];
            }	
        }
        for(int i=0;i<board.length;++i) {
        	for(int j=0;j<board[0].length;++j) {
            	if(querys[i][j] + board[i][j] > 0)
            		answer++;
            }	
        }
        return answer;
    }
	public static void main(String[] args) {
		//board												skill														result
		//[[5,5,5,5,5],[5,5,5,5,5],[5,5,5,5,5],[5,5,5,5,5]]	[[1,0,0,3,4,4],[1,2,0,2,3,2],[2,1,0,3,1,2],[1,0,1,3,3,1]]	10
		//[[1,2,3],[4,5,6],[7,8,9]]							[[1,1,1,2,2,4],[1,0,0,1,1,2],[2,2,0,2,0,100]]				6
		int[][] board1 = {{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5}};
		int[][] skill1 = {{1,0,0,3,4,4}, {1,2,0,2,3,2}, {2,1,0,3,1,2}, {1,0,1,3,3,1}};
		System.out.println(solution(board1,skill1));
		
		int[][] board2 = {{1,2,3},{4,5,6},{7,8,9}};
		int[][] skill2 = {{1,1,1,2,2,4}, {1,0,0,1,1,2}, {2,2,0,2,0,100}};
		System.out.println(solution(board2,skill2));
	}

}
