package progammers.golevelkit;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 기능개발 {
	public static int[] solution(int[] progresses, int[] speeds) {
        
        Queue<Integer> que = new LinkedList<>();
        for(int i=0;i<progresses.length;++i) {
        	int gage = 100 - progresses[i];
        	int day = 0;
        	if(gage % speeds[i] != 0) {
        		day++;
        	}
        	day += gage/speeds[i];
        	que.offer(day);
        }
        int count = 1;
        int now = que.poll();
        List<Integer> list = new ArrayList<>();
        while(!que.isEmpty()) {
        	if(now < que.peek()) {
        		now=que.poll();
        		list.add(count);
        		count=0;
        	}else {
        		que.poll();
        	}
        	count++;
        }
        list.add(count);
        int[] answer = new int[list.size()];
        for(int i=0;i<list.size();++i) {
        	answer[i] = list.get(i);
        }
        return answer;
    }
	public static void main(String[] args) {
		//progresses	speeds	return
		//[93, 30, 55]	[1, 30, 5]	[2, 1]
		//[95, 90, 99, 99, 80, 99]	[1, 1, 1, 1, 1, 1]	[1, 3, 2]
		int[] progresses1 = {93, 30, 65};
		int[] speeds1 = {1, 30, 5};
		System.out.println(solution(progresses1,speeds1));
		int[] progresses2 = {95, 90, 99, 99, 80, 99};
		int[] speeds2 = {1, 1, 1, 1, 1, 1};
		System.out.println(solution(progresses2,speeds2));
	}

}
