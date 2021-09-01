package progammers.level2.review;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
class Truck{
	int weight;
	int time;
	public Truck(int weight,int time){
		this.time = time;
		this.weight = weight;
	}
}
public class 다리를지나는트럭 {
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        List<Truck> bridge = new ArrayList<>();
        Queue<Truck> wait = new LinkedList<>();
        for(int i=0;i<truck_weights.length;++i) {
        	wait.offer(new Truck(truck_weights[i], bridge_length));
        }
        int w = 0;
        
        while(!wait.isEmpty()) {
        	answer++;
        	
        	if(weight >= w +  wait.peek().weight) {
        		Truck t = wait.poll();
        		w += t.weight;
        		bridge.add(t);
        	}
        	for(int i=0;i<bridge.size();++i) {
        		Truck t = bridge.get(i);
        		t.time--;
        		if(t.time <= 0) {
        			w -= t.weight;
        			bridge.remove(i);
        			i--;
        		}
        	}
        }
        Truck t = bridge.get(bridge.size()-1);
        answer+= t.time+1;
        return answer;
    }
	public static void main(String[] args) {
		//bridge_length	weight	truck_weights	return
		//2				10	[7,4,5,6]	8
		//100			100	[10]	101
		//100			100	[10,10,10,10,10,10,10,10,10,10]	110
		int bridge_length1 = 2;
		int weight1 = 10;
		int[] truck_weights1 = {7,4,5,6};
		System.out.println(solution(bridge_length1,weight1,truck_weights1));
		int bridge_length2 = 100;
		int weight2 = 100;
		int[] truck_weights2 = {10};
		System.out.println(solution(bridge_length2,weight2,truck_weights2));
		int bridge_length3 = 100;
		int weight3 = 100;
		int[] truck_weights3 = {10,10,10,10,10,10,10,10,10,10};
		
		System.out.println(solution(bridge_length3,weight3,truck_weights3));
		

	}

}
