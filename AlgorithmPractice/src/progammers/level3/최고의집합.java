package progammers.level3;

import java.util.Arrays;

public class 최고의집합 {
	public static int[] solution(int n, int s) {
        if(n > s) {
        	return new int[] {-1};
        }
        int[] answer = new int[n];
        for(int i=0;i<n;++i) {
        	answer[i] = s/n;
        }
        for(int i=0;i<s%n;++i) {
        	answer[i]++;
        }
        Arrays.sort(answer);
        
        return answer;
    }
	public static void main(String[] args) {
		//n	s	result
		//2	9	[4, 5]
		//2	1	[-1]
		//2	8	[4, 4]
		System.out.println(solution(2,9));
		System.out.println(solution(2,1));
		System.out.println(solution(2,8));
	}
}
