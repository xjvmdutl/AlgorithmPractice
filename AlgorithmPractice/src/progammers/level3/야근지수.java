package progammers.level3;

import java.util.PriorityQueue;

public class 야근지수 {
	 public static long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> que = new PriorityQueue<>((o1,o2)->o2-o1);
        for(int i=0;i<works.length;++i) {
        	que.offer(works[i]);
        }
        while(n-- > 0) {
        	int data = que.poll();
        	if(data == 0) {
        		return 0;
        	}
        	que.offer(--data);
        }
        int length = que.size();
        for(int i=0;i<length;++i) {
        	answer += Math.pow(que.poll(),2);
        }
        return answer;
    }
	public static void main(String[] args) {
		//works	n	result
		//[4, 3, 3]	4	12
		//[2, 1, 2]	1	6
		//[1,1]	3	0
		int[] works1 = {4,3,3};
		System.out.println(solution(4,works1));
		int[] works2 = {2,1,2};
		System.out.println(solution(1,works2));
		int[] works3 = {1,1};
		System.out.println(solution(0,works3));
	}

}
