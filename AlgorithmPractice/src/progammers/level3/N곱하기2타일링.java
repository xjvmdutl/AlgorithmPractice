package progammers.level3;

public class N���ϱ�2Ÿ�ϸ� {
	public static int solution(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3;i<=n;++i) {
        	dp[i] = (dp[i-2] + dp[i-1])% 1000000007;	
        }
         
        return dp[n];
    }
	public static void main(String[] args) {
		System.out.println(solution(4));
	}

}
