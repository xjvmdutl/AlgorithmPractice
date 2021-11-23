package progammers.level3;

import java.util.Arrays;

public class 입국심사 {
	public static long solution(int n, int[] times) {
       long answer = Long.MAX_VALUE;
       long start = 0;
       long end = (long)1000000000 * (long)Arrays.stream(times).max().getAsInt();
       Arrays.sort(times);
       while(start <= end) {
    	   long mid = (start + end)/2;
    	   long sum = 0;
    	   for(int i=0;i<times.length;++i) {
    		   sum += mid/times[i];
    	   }
    	   if(sum >= n) {
    		   end = mid - 1;
    		   answer = Math.min(mid, answer);
    	   }else {
    		   start = mid + 1;
    	   }
       }
       return answer;
	}
	public static void main(String[] args) {
		int[] times = {7,10};
		System.out.println(solution(6,times));
	}

}
