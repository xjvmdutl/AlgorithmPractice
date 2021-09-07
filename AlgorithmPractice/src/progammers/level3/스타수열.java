package progammers.level3;

import java.util.Arrays;


public class 스타수열 {
	public static int[] dp;
	public static int solution(int[] a) {
        int answer = 0;
        int max= Arrays.stream(a).max().getAsInt();
        dp = new int[max+1];
        if(a.length <= 1) {
        	return answer;
        }
        for(int i=0;i<a.length;++i) {
        	int num = a[i];
        	dp[num]++;
        }
        for(int i=0;i<dp.length;++i) {
        	if(dp[i] *  2 <= answer)
        		continue;
        	int star = 0;
        	for(int j=0;j<a.length-1;++j) {
        		if((a[j] == i || a[j+1] == i) && (a[j] != a[j+1])) {
        			j++;
        			star+=2;
        		}
        	}
        	answer = Math.max(star, answer);
        }
        
        return answer;
    }
	public static void main(String[] args) {
		//a	result
		//[0]	0
		//[5,2,3,3,5,3]	4
		//[0,3,3,0,7,2,0,2,2,0]	8
		int[] a1 = {0};
		int[] a2 = {5,2,3,3,5,3};
		int[] a3 = {0,3,3,0,7,2,0,2,2,0};
		System.out.println(solution(a1));
		System.out.println(solution(a2));
		System.out.println(solution(a3));
	}

}
