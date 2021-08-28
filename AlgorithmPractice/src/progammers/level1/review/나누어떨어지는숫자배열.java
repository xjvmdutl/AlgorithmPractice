package progammers.level1.review;

import java.util.PriorityQueue;
import java.util.Queue;

public class 나누어떨어지는숫자배열 {
	public static int[] solution(int[] arr, int divisor) {
		Queue<Integer> que =new PriorityQueue<Integer>();
		for(int i=0;i<arr.length;++i) {
        	if(arr[i] % divisor == 0) {
        		que.offer(arr[i]);
        	}
        }
		int[] answer = null;
		int idx = 0;
		if(que.isEmpty()) {
			answer = new int[1];
			answer[idx] = -1;
		}else {
			answer = new int[que.size()];
			while(!que.isEmpty()) {
				answer[idx++] = que.poll();
			}
		}
        return answer;
    }
	public static void main(String[] args) {
		//arr	divisor	return
		//[5, 9, 7, 10]	5	[5, 10]
		//[2, 36, 1, 3]	1	[1, 2, 3, 36]
		//[3,2,6]	10	[-1]
		int[] d1 = {5,9,7,10}; 
		int[] d2 = {2, 36, 1, 3}; 
		int[] d3 = {3,2,6}; 
		int[] r1 = solution(d1,5);
		int[] r2= solution(d2,1);
		int[] r3 = solution(d3,10);
	}

}
