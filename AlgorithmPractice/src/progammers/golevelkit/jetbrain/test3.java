package progammers.golevelkit.jetbrain;

import java.util.PriorityQueue;
import java.util.Queue;

class Truck{
	int gold;
	int silver;
	int weight;
	int time;
	int index;
	public Truck(int gold,int silver,int weight,int time,int index) {
		this.gold = gold;
		this.silver = silver;
		this.weight = weight;
		this.time = time;
		this.index = index;
	}
	
}
public class test3 {
	public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long answer = 0;
        int gold = 0;
        int silver = 0;
        while(gold < a || silver < b) {
        	boolean[] visit = new boolean[g.length];
        	Queue<Truck> que1 = new PriorityQueue<Truck>((o1,o2)->{
        		return o2.gold - o1.gold;
        	});
        	Queue<Truck> que2 = new PriorityQueue<Truck>((o1,o2)->{
        		return o2.silver - o1.silver;
        	});
        	Queue<Truck> que = new PriorityQueue<Truck>();
        	for(int i=0;i<g.length;++i) {
    			//que.offer(null)
    		}
        	if(gold < a) {
        		
        	}
        }
        return answer;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//a		b	g			s			w			t		result
		//10	10	[100]		[100]		[7]			[10]	50
		//90	500	[70,70,0]	[0,0,500]	[100,100,2]	[4,8,1]	499
	}

}
