package progammers.level3;

import java.util.Arrays;

public class °Å½º¸§µ· {
	public static int[][] dp;
	public static final int MOD = 1000000007;
	public static void main(String[] args) {
		//n	money	result
		//5	[1,2,5]	4
		
		int[] money = {1,2,5};
		System.out.println(solution(5,money));
	}
	public static int solution(int n, int[] money) {
        
        Arrays.sort(money);
        dp = new int[money.length+1][n+1];
        dp[0][0] = 1;
        for(int i=1;i<=money.length;++i) {
        	for(int j=0;j<dp[i].length;++j) {
        		if(j < money[i - 1]) {
        			dp[i][j] = dp[i-1][j] % MOD;
        		}else if(j == money[i-1]) {
        			dp[i][j] = (dp[i-1][j] + 1) % MOD;
        		}else {
        			dp[i][j] = (dp[i-1][j] + dp[i][j-money[i-1]])%MOD;
        		}
        		
        	}
        }
        return dp[money.length][n];
    }
}
