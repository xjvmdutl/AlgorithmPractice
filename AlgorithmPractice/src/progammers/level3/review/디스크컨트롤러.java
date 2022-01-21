package progammers.level3.review;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class 디스크컨트롤러 {
	static class Disk{
		int startTime;
		int processTime;
		public Disk(int startTime, int processTime) {
			this.startTime = startTime;
			this.processTime = processTime;
		}
		
	}
	public static int solution(int[][] jobs) {
        int answer = 0;
        Arrays.sort(jobs,(o1,o2)->{
        	if(o1[0] == o2[0])
        		return o1[1] - o2[1];
        	return o1[0] - o2[0];
        });
        Queue<Disk> pq = new PriorityQueue<>((o1,o2)->o1.processTime - o2.processTime);
        int start = 0;
        int startIdx = 0;
        int time = 0;
        while(start < jobs.length) {
        	while(startIdx < jobs.length && jobs[startIdx][0] <= time) {
        		pq.offer(new Disk(jobs[startIdx][0], jobs[startIdx][1]));
        		startIdx++;
        	}
        	if(pq.isEmpty()) {
        		time = jobs[startIdx][0];
        	}else {
        		Disk disk = pq.poll();
        		time += disk.processTime;
        		answer += time - disk.startTime;
        		start++;
        	}
        }
        return answer / jobs.length;
    }
	public static void main(String[] args) {
//		[[0, 3], [1, 9], [2, 6]]	9
		int[][] jobs = {{0,3}, {1,9}, {2,6}};
		System.out.println(solution(jobs));
	}
}
