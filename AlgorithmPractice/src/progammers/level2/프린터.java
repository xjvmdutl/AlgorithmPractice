package progammers.level2;


import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
class Print{
	int location;
	int prioritie;
	public Print(int location,int prioritie) {
		this.location = location;
		this.prioritie = prioritie;
	}
}
public class «¡∏∞≈Õ {
	public static int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Print> queue = new LinkedList<>();
        for(int i=0;i<priorities.length;++i) {
        	Print p = new Print(i,priorities[i]);
        	queue.offer(p);
        }
        while(!queue.isEmpty()) {
        	boolean flag = false;
        	int com = queue.peek().prioritie;
        	for(Print p : queue) {
        		if(com < p.prioritie ) {
        			flag = true;
        			break;
        		}
        	}
        	if(flag) {
        		queue.offer(queue.poll());
        	}else {
        		Print p = queue.poll();
            	answer++;	
            	if(p.location == location)
            		return answer;
        	}
        }
        
        
        return answer;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//priorities	location	return
		//[2, 1, 3, 2]	2	1
		//[1, 1, 9, 1, 1, 1]	0	5
		int[] priorities1 = {2, 1, 3, 2};
		int location1 = 2;
		
		System.out.println(solution(priorities1, location1));
		
		int[] priorities2 = {1, 1, 9, 1, 1, 1};
		int location2 = 0;
		System.out.println(solution(priorities2, location2));
	}

}
