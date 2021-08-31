package progammers.level2.review;

import java.util.Arrays;
import java.util.PriorityQueue;

public class ���ʰ� {
	 public static int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> que = new PriorityQueue<>();
        for(int i=0;i<scoville.length;++i)
        	que.offer(scoville[i]);
        
        while(que.size() >= 2) {
        	answer++;
        	int n1 = que.poll();
        	int n2 = que.poll();
        	que.offer(n1+(n2*2));
        	if(que.peek() >= K) {
        		return answer;
        	}
        }
        return -1;
    }
	public static void main(String[] args) {
		//scoville	K	return
		//[1, 2, 3, 9, 10, 12]	7	2
		int[] scoville = {1, 1, 1, 1, 1, 1};
		int k = 100;
		System.out.println(solution(scoville,k));
	}

}
