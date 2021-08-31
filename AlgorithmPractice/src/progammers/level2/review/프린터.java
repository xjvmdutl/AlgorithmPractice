package progammers.level2.review;

import java.util.LinkedList;
import java.util.Queue;
class Print{
	int v;
	int index;
	public Print(int v,int index) {
		this.index = index;
		this.v = v;
	}
}
public class «¡∏∞≈Õ {
	public static int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Print> que = new LinkedList<>();
        for(int i=0;i<priorities.length;++i) {
        	que.offer(new Print(priorities[i], i+1));
        }
        while(!que.isEmpty()) {
        	Print p = que.poll();
        	boolean flag = false;
        	for(Print print : que) {
        		if(p.v < print.v) {
        			que.offer(p);
        			flag = true;
        			break;
        		}
        	}
        	if(!flag) {
        		answer++;
        		if(p.index == location+1) {
        			return answer;
        		}
        	}
        }
        
        return answer;
    }
	public static void main(String[] args) {
		//priorities	location	return
		//[2, 1, 3, 2]	2	1
		//[1, 1, 9, 1, 1, 1]	0	5
		int[] priorities1 = {2, 1, 3, 2};
		System.out.println(solution(priorities1,2));
		int[] priorities2 = {1, 1, 9, 1, 1, 1};
		System.out.println(solution(priorities2,0));
	}

}
