package progammers.golevelkit.stackqueue;

import java.util.LinkedList;
import java.util.Queue;
class Truck{
	int weight;
    int move;

    public Truck(int weight) {
        this.weight = weight;
        this.move = 1;
    }

    public void moving() {
        move++;
    }
}
public class 다리를지나는트럭 {
	public static int solution(int bridge_length, int weight, int[] truck_weights) {
		Queue<Truck> waitQ = new LinkedList<>();
        Queue<Truck> moveQ = new LinkedList<>();

        for (int t : truck_weights) {
            waitQ.offer(new Truck(t));
        }
        int answer = 0;
        int curWeight = 0;
        while (!waitQ.isEmpty() || !moveQ.isEmpty()) {
        	answer++;
        	if (moveQ.isEmpty()) {
                Truck t = waitQ.poll();
                curWeight += t.weight;
                moveQ.offer(t);
                continue;
            }
        	for (Truck t : moveQ) {
                t.moving();
            }
        	if (moveQ.peek().move > bridge_length) {
                Truck t = moveQ.poll();
                curWeight -= t.weight;
            }
        	if (!waitQ.isEmpty() && curWeight + waitQ.peek().weight <= weight) {
                Truck t = waitQ.poll();
                curWeight += t.weight;
                moveQ.offer(t);
            }
        }
       
        return answer;
    }
	public static void main(String[] args) {
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
