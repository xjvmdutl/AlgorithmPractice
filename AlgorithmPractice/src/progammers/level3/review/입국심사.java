package progammers.level3.review;

import java.math.BigInteger;

public class 입국심사 {
    public static long solution(int n, int[] times) {
    	long answer = Long.MAX_VALUE;
    	BigInteger start = BigInteger.ZERO;
    	BigInteger end = new BigInteger("1000000000").multiply(new BigInteger("1000000000"));
    	while(start.compareTo(end) <= 0) {
    		BigInteger mid = start.add(end).divide(BigInteger.TWO);
    		long sum = 0;
    		for(int i=0;i<times.length;++i) {
    			sum += mid.divide(new BigInteger(String.valueOf(times[i]))).longValue();
    		}
    		if(sum >= n) {
    			answer = Math.min(answer, mid.longValue());
    			end = new BigInteger(String.valueOf(mid.longValue() - 1));
    		}else {
    			start = new BigInteger(String.valueOf(mid.longValue() + 1));
    		}
    	}
    	return answer;
    }
	public static void main(String[] args) {
		/**
		 * n	times	return
		 * 6	[7, 10]	28
		 */
		int[] times = {7, 10};
		System.out.println(solution(6, times));
	}

}
