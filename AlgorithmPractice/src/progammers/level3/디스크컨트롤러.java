package progammers.level3;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
class Disk{
	int startTime;
	int processTime;
	public Disk(int startTime,int processTime) {
		this.processTime = processTime;
		this.startTime = startTime;
	}
}
public class 디스크컨트롤러 {
    public static int solution(int[][] jobs) {
    	int answer = 0;
    	Arrays.sort(jobs,(o1,o2)->{
    		if(o1[0] == o2[0])
    			return o1[1] - o2[1];
    		return o1[0] - o2[0];
    	});
    	Queue<Disk> pq = new PriorityQueue<>((o1,o2)->{
    		return o1.processTime - o2.processTime;
    	});
    	int startIdx = 0;
    	int count = 0;
    	int now = 0;
    	while(count < jobs.length) {
    		while(startIdx < jobs.length && jobs[startIdx][0] <= now) {
    			pq.offer(new Disk(jobs[startIdx][0], jobs[startIdx][1]));
    			startIdx++; 
    		}
    		if(pq.isEmpty()) {
    			now = jobs[startIdx][0];
    		}else {
    			Disk d = pq.poll();
    			now += d.processTime;
    			answer += now - d.startTime;
    			count++;
    		}	
    	}
    	return answer/jobs.length;
    }
	public static void main(String[] args) {
		int[][] play = {{0, 3},{1, 9},{2, 6}};
		System.out.println(solution(play));
	}

}
