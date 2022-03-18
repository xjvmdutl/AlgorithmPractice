package test.gabia;

public class test7 {
	public static void main(String[] args) {
		int[] gold1 = {1,100,101,102,1,5};
		//System.out.println(solution(gold1));
		int[] gold2 = {1,2,3,1,1,1,2};
		//System.out.println(solution(gold2));
		int[] gold3 = {2,5,1,3,4};
		System.out.println(solution(gold3));
		int[] gold4 = {7,2,5,6,1,4,2,8};
		System.out.println(solution(gold4));
	}

	private static int solution(int[] gold_price) {
		int[][] dp = new int[2][gold_price.length];
		dp[0][0] = -gold_price[0]; //구매
		dp[0][1] = 0; //판매
		for(int i=1;i<gold_price.length;++i) {
			dp[i][1] = Math.max(dp[i][0], i); 
			
		}
		return 0;
	}


}
