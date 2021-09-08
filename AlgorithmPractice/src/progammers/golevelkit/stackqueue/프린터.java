package progammers.golevelkit.stackqueue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
class Print{
	int idx;
	int priority;
	public Print(int idx , int priority) {
		this.idx = idx;
		this.priority = priority;
	}
}
public class «¡∏∞≈Õ {
	public static void main(String[] args) {
		//priorities	location	return
		//[2, 1, 3, 2]	2	1
		//[1, 1, 9, 1, 1, 1]	0	5
		int[] priorities1 = {2, 1, 3, 2};
		System.out.println(solution(priorities1,2));
		int[] priorities2 = {1, 1, 9, 1, 1, 1};
		System.out.println(solution(priorities2,0));
	}

	public static int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Print> que = new LinkedList<>();
        for(int i=0;i<priorities.length;++i) {
        	que.offer(new Print(i, priorities[i]));
        }
        Arrays.sort(priorities);
        int idx = 0;
        
        while(!que.isEmpty()) {
        	Print p = que.poll();
        	int max = priorities[priorities.length-idx-1];
        	if(max != p.priority) {
        		que.offer(p);
        		continue;
        	}
        	idx++;
        	if(p.idx == location) {
        		return idx;
        	}
        }
        return answer;
    }

}
