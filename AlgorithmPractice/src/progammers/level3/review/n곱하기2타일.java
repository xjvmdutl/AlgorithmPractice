package progammers.level3.review;

public class n곱하기2타일 {
	private static final int MAX = 1000000007;
	public static int solution(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3;i<=n;++i) {
        	dp[i] = ( dp[i-1] + dp[i-2] ) % MAX;
        }
        return dp[n];
    }
	public static void main(String[] args) {
		System.out.println(solution(4));
	}
}
