package progammers.level3;

public class Á¤¼ö»ï°¢Çü {
	public static int solution(int[][] triangle) {
        int answer = 0;
        int[][] dp = new int[triangle.length][];
        dp[0] = new int[1];
        dp[0][0] = triangle[0][0];
        for(int i=1;i<triangle.length;++i) {
        	dp[i] = new int[triangle[i].length];
        	dp[i][0] = dp[i-1][0] + triangle[i][0];
        	for(int j=1;j<triangle[i].length-1;++j) {
        		dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
        	}
        	dp[i][triangle[i].length-1] = triangle[i][triangle[i].length-1] + dp[i-1][triangle[i-1].length-1];
        }
        for(int i=0;i<triangle[triangle.length-1].length;++i) {
        	answer = Math.max(answer, dp[dp.length-1][i]);
        }
        return answer;
    }
	public static void main(String[] args) {
		int[][] map = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
		System.out.println(solution(map));
	}

}
