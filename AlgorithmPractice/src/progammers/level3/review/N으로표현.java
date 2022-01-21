package progammers.level3.review;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class N으로표현 {
	public static int answer;
	public static Set<Integer>[] dp;
    public static int solution(int N, int number) {
    	if(N == number)
    		return 1;
    	dp = new HashSet[9];
    	String num = String.valueOf(N);
    	for(int i=0;i<=8;++i) {
    		dp[i] = new HashSet<>();
    		if(i == 1)
    			dp[1].add(Integer.parseInt(num));
    		if(i < 2)
    			continue;
			num += String.valueOf(N);
			dp[i].add(Integer.parseInt(num));
			for(int j=1;j<i;++j) {
				calc(j,i);
				if(dp[i].contains(number)) {
					return i;
				}
			}
    	}
        return -1;
    }
	private static void calc(int count, int last) {
		Iterator<Integer> iterA = dp[count].iterator();
		Iterator<Integer> iterB = dp[last - count].iterator();
		
		while(iterA.hasNext()) {
			int numberA = iterA.next();
			while(iterB.hasNext()) {
				int numberB = iterB.next();
				dp[last].add(numberA + numberB);
				dp[last].add(numberA - numberB);
				dp[last].add(numberA * numberB);
				if(numberB != 0)
					dp[last].add(numberA / numberB);
			}
			iterB = dp[last - count].iterator();
		}
	}
	
	public static void main(String[] args) {
		/*
		 * N number return 
		 * 5 12 	4 
		 * 2 11 	3
		 */
		System.out.println(solution(5,12));
		System.out.println(solution(2,11));
	}

}
