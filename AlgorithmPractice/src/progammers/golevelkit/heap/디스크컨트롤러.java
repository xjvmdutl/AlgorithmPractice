package progammers.golevelkit.heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

class Disk{
	int startTime;
	int playTime;
	public Disk(int startTime,int playTime) {
		this.playTime = playTime;
		this.startTime = startTime;
	}
}
public class 디스크컨트롤러 {
	public static int solution(int[][] jobs) {
        int answer = 0;
        Queue<Disk> que = new PriorityQueue<>((o1,o2)->{
        	return o1.playTime - o2.playTime;
        });
        Arrays.sort(jobs,(o1,o2)->{
        	return o1[0]-o2[0];
        });
        int cnt = 0;
        int time = 0;
        int jobIdx = 0;
        while(cnt < jobs.length) {
        	while(jobIdx < jobs.length && jobs[jobIdx][0] <= time) {
        		que.offer(new Disk(jobs[jobIdx][0],jobs[jobIdx][1]));
        		jobIdx++;
        	}
        	if(que.isEmpty()) {
        		time = jobs[jobIdx][0];
        	}else{
        		Disk disk = que.poll();
        		answer += disk.playTime + time - disk.startTime;
        		time += disk.playTime;
        		cnt++;
        	}
        }
        return (int) Math.floor(answer/jobs.length);
    }
	public static void main(String[] args) {
		//jobs	return
		//[[0, 3], [1, 9], [2, 6]]	9
		int[][] jobs = {{0, 3}, {4, 9}, {5, 6}};
		System.out.println(solution(jobs));
	}

}
