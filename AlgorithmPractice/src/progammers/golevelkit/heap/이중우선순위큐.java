package progammers.golevelkit.heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class 이중우선순위큐 {
	public static int[] solution(String[] operations) {
        int[] answer = new int[2];
        Queue<Integer> min = new PriorityQueue<>((o1,o2)->{
        	return o1 - o2;
        });
        Queue<Integer> max = new PriorityQueue<>((o1,o2)->{
        	return o2 - o1;
        });
        for(int i=0;i<operations.length;++i) {
        	String[] oper = operations[i].split(" ");
        	int num = Integer.parseInt(oper[1]);
        	if(oper[0].equals("I")) {
        		min.offer(num);
        		max.offer(num);
        	}else if(oper[0].equals("D")) {
        		if(max.isEmpty()) {
        			continue;
        		}
        		if(num > 0) {
        			int number = max.poll();
        			min.remove(number);
        		}else {
        			int number = min.poll();
        			max.remove(number);
        		}
        	}
        }
        if(max.isEmpty() && min.isEmpty()) {
        	answer[0] = 0;
        	answer[1] = 0;
		}else {
			answer[0] = max.poll();
        	answer[1] = min.poll();
		}
        return answer;
    }
	public static void main(String[] args) {
		//operations	return
		//["I 16","D 1"]	[0,0]
		//["I 7","I 5","I -5","D -1"]	[7,5]
		String[] operations1 = {"I 16","D 1"};
		System.out.println(solution(operations1));
		String[] operations2 = {"I 7","I 5","I -5","D -1"};
		System.out.println(solution(operations2));
	}

}
