package progammers.level3;


public class ¸Ö¸®¶Ù±â {
	public static long[] dp = new long[2001];
	public static long solution(int n) {
        long answer = 0;
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3;i<=n;++i) {
        	dp[i] = (dp[i-2] + dp[i-1])%1234567;
        }
        answer = dp[n];
        return answer;
    }
	
	public static void main(String[] args) {
		//n	result
		//4	5
		//3	3
		System.out.println(solution(4));
		System.out.println(solution(3));
	}

}
