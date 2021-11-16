package progammers.golevelkit;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class 단속카메라 {

	public static void main(String[] args) {
		//routes	return
		//[[-20,15], [-14,-5], [-18,-13], [-5,-3]]	2
		int[][] routes = {{-20,15}, {-14,-5}, {-18,-13}, {-5,-3}};
		System.out.println(solution(routes));
	}

	private static int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes,(o1,o2)->{
        	if(o1[0] == o2[0])
        		return o1[1] - o2[1];
        	return o1[0] - o2[0];
        });
        Queue<Integer> pq = new PriorityQueue<>((o1,o2)->o2-o1);
        pq.offer(routes[0][1]);
        for(int i=1;i<routes.length;++i) {
        	int start = routes[i][0];
        	int end = routes[i][1];
        	if(!pq.isEmpty() && pq.peek() < start) {
        		pq.offer(end);	
        	}else if(!pq.isEmpty() && pq.peek() > end){
        		pq.poll();
        		pq.offer(end);
        	}else {
        		continue;
        	}
        	
        }
        return pq.size();
    }

}
