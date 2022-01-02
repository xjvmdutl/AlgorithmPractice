package progammers.level3;

import java.util.PriorityQueue;
import java.util.Queue;

public class 외벽점검 {
	public static boolean[] visit;
	public static int answer;
	public static int solution(int n, int[] weak, int[] dist) {
        answer = Integer.MAX_VALUE;
        int[][] weakCase = new int[weak.length][weak.length];
        visit = new boolean[dist.length];
        int[] per = new int[dist.length];
        Queue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<weak.length;++i) {
        	weakCase[0][i] = weak[i];
        	pq.offer(weak[i]);
        }
        makeWeakCase(weakCase,pq,weak.length,n);
        permulator(weakCase,dist,per,0,dist.length);
        
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
	private static void permulator(int[][] weakCase, int[] dist, int[] per, int count, int length) {
		if(count == length) {
			for(int[] weak : weakCase) {
				Check(per,weak);
			}
		}
		for(int i=0;i<dist.length;++i) {
			if(!visit[i]) {
				visit[i] = true;
				per[count] = dist[i];
				permulator(weakCase, dist, per, count+1, length);
				visit[i] = false;
			}
		}
	}
	private static void Check(int[] per, int[] weak) {
		int cur = 0;
		int next = 0;
        int dist_idx = 0;
		while(cur < weak.length && dist_idx < per.length) {
			next = cur + 1;
			while(next < weak.length &&
                    weak[cur] + per[dist_idx] >= weak[next]){
               next++;
            }
			cur = next;
            dist_idx++;
		}
		if(cur == weak.length && dist_idx < answer)
            answer = dist_idx;
		
	}
	private static void makeWeakCase(int[][] weakCase, Queue<Integer> pq, int length, int n) {
		for(int i=1;i<length;++i) {
			Queue<Integer> tmpQue = new PriorityQueue<>();
			pq.offer(pq.poll() + n);
			int index = 0;
			while(!pq.isEmpty()){
				int now = pq.poll();
				weakCase[i][index++] = now;
				tmpQue.offer(now);
			}
			pq = tmpQue;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//n	weak	dist	result
		//12	[1, 5, 6, 10]	[1, 2, 3, 4]	2
		//12	[1, 3, 4, 9, 10]	[3, 5, 7]	1
		int[] weak1 = {1,5,6,10};
		int[] dist1 = {1,2,3,4};
		System.out.println(solution(12,weak1,dist1));
	}
	
}
