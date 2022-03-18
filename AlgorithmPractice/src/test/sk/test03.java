package test.sk;

public class test03 {
	public static final int INF = 10000019;
	public static int solution(int width, int height, int[][] diagonals) {
        int answer = 0;
        
        int[][][] dp = new int[width + 1][height + 1][2];
        boolean[][] map = new boolean[width + 1][height + 1];
        for(int i=0;i<diagonals.length;++i) {
        	int x = width - diagonals[i][0];
        	int y = diagonals[i][1];
        	map[x+1][y] = true;
        	map[x][y-1] = true;
        }
        dp[width][0][0] = 1;
        for(int i=0;i<=height;++i) {
        	if(map[width][i]) {
        		dp[width-1][i-1][1] += 1;
        	}
        	dp[width][i][0] = 1;
        }
        for(int i=width-1;i>=0;--i) {
        	if(map[i+1][1]) {
        		dp[i+1][1][1] = 1;
        	}
        	dp[i][0][1] += dp[i+1][0][1];
        	dp[i][0][0] += dp[i+1][0][0];
        }
        for(int i=width-1;i>=0;--i) {
        	for(int j=1;j<=height;++j) {
        		dp[i][j][0] += dp[i+1][j][0] + dp[i][j-1][0];
        		dp[i][j][0] %= INF;
        		dp[i][j][1] += dp[i+1][j][1] + dp[i][j-1][1];
        		dp[i][j][1] %= INF;
            	if(map[i][j] && i > 0 && map[i-1][j-1]) {
            		dp[i-1][j-1][1] += dp[i][j][0];
            		dp[i-1][j-1][1] %= INF;
            	}
            	if(map[i][j] && j < height && map[i+1][j+1]) {
            		dp[i+1][j+1][1] += dp[i][j][0];
            		dp[i+1][j+1][1] %= INF;
            	}
            }
        }
        
        
        return dp[0][height][1];
    }
	public static void main(String[] args) {
		/*
		 * width height diagonals result
		 *  2 2 [[1,1],[2,2]] 12 
		 *  51 37 [[17,19]] 3225685
		 */
		int[][] d = {{1,1}, {2,2}};
		System.out.println(solution(2,2,d));
		int[][] d2 = {{17,19}};
		System.out.println(solution(51,37,d2));
	}

}
