package progammers.level2.review;

import java.util.PriorityQueue;

public class 최솟값만들기 {
	public static int solution(int []A, int []B){
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
		//A	B	answer
		//[1, 4, 2]	[5, 4, 4]	29
		//[1,2]	[3,4]	10
		int[] a1 = {1,4,2};
		int[] b1 = {5,4,4};
		System.out.println(solution(a1,b1));
		int[] a2 = {1,2};
		int[] b2 = {3,4};
		System.out.println(solution(a2,b2));
	}
}
