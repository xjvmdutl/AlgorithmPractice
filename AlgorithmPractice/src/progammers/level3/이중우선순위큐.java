package progammers.level3;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 이중우선순위큐 {
    public int[] solution(String[] operations) {
    	int[] answer = new int[2];
    	Queue<Integer> max = new PriorityQueue<>((o1,o2)->o2-o1);
    	Queue<Integer> min = new PriorityQueue<>((o1,o2)->o1-o2);
    	for(String oper : operations) {
    		StringTokenizer tokens = new StringTokenizer(oper);
    		String op = tokens.nextToken();
    		int number = Integer.parseInt(tokens.nextToken());
    		if(op.equals("I")) {
    			min.offer(number);
    			max.offer(number);
    		}else if(op.equals("D")) {
    			if(max.isEmpty() || min.isEmpty())
    				continue;
    			if(number > 0) {
    				int m = max.poll();
    				min.remove(m);
    			}else {
    				int m = min.poll();
    				max.remove(m);
    			}
    		}
    	}
    	if(!min.isEmpty() && !max.isEmpty()) {
    		answer[0] = max.poll();
    		answer[1] = min.poll();
    	}
    	return answer;
    }
	public static void main(String[] args) {
		
	}
}
