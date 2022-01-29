package progammers.level3.review;

import java.util.PriorityQueue;
import java.util.Queue;

public class 이중우선순위큐 {
    public static int[] solution(String[] operations) {
        int[] answer = new int[2];
        Queue<Integer> minQueue = new PriorityQueue<>((o1,o2) -> o1-o2);
        Queue<Integer> maxQueue = new PriorityQueue<>((o1,o2) -> o2-o1);
        for(String oper : operations) {
        	String[] operation = oper.split(" ");
        	if(operation[0].equals("I")) {
        		maxQueue.offer(Integer.parseInt(operation[1]));
        		minQueue.offer(Integer.parseInt(operation[1]));
        	}else if(operation[0].equals("D")) {
        		int number = Integer.parseInt(operation[1]);
        		if(minQueue.isEmpty() || maxQueue.isEmpty())
        			continue;
        		if(number == 1) {
        			int now = maxQueue.poll();
        			minQueue.remove(now);
        		}else if(number == -1) {
        			int now = minQueue.poll();
        			maxQueue.remove(now);
        		}else {
            		throw new IllegalArgumentException();
        		}
        	}else {
        		throw new IllegalArgumentException();
        	}
        }
		if(minQueue.isEmpty() || maxQueue.isEmpty())
			return answer;
		answer[0] = maxQueue.poll();
		answer[1] = minQueue.poll();
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
