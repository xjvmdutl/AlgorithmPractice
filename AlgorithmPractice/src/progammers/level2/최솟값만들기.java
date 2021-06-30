package progammers.level2;

import java.util.Arrays;
import java.util.Collections;

public class 최솟값만들기 {
	public static int solution(int []A, int []B)
    {
        int answer = 0;
        Integer[] b = Arrays.stream(B).boxed().toArray(Integer[]::new);
        Arrays.sort(A);
        
        Arrays.sort(b,Collections.reverseOrder());
        for(int i=0;i<A.length;i++) {
        	//차례대로 곱한후 누적 저장한다.
        		answer=answer+(A[i]*b[i]);
        	
        }
        return answer;
    } 
	
	public static void main(String[] args) {
//		A	B	answer
//		[1, 4, 2]	[5, 4, 4]	29
//		[1,2]	[3,4]	10
		int[] A1 = {1,4,2};
		int[] A2 = {1,2};
		int[] B1 = {5,4,4};
		int[] B2 = {3,4};
		System.out.println(solution(A1, B1));
		System.out.println(solution(A2, B2));
	}

}
