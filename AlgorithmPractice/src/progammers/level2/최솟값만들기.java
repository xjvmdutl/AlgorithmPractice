package progammers.level2;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class ?ּڰ??????? {
	public static int solution(int []A, int []B)
    {
        int answer = 0;
        PriorityQueue<Integer> que1 = new PriorityQueue<>();
        PriorityQueue<Integer> que2 = new PriorityQueue<>((o1,o2)->o2-o1);
        for(int i=0;i<A.length;i++) {
        	que1.offer(A[i]);
        	que2.offer(B[i]);
        }
        for(int i=0;i<A.length;++i) {
        	answer += que1.poll() * que2.poll();
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
