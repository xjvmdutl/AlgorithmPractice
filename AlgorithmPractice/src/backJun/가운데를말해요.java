package backJun;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class 가운데를말해요 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Queue<Integer> minHeap = new PriorityQueue<>();
		Queue<Integer> maxHeap = new PriorityQueue<>((o1,o2)->{
			return o2-o1;
		});
		for(int i=1;i<=n;++i) {
			int num = sc.nextInt();
			if(maxHeap.size() == minHeap.size()) {
				maxHeap.offer(num);
			}else{
				minHeap.offer(num);
			}
			if(!minHeap.isEmpty() && !maxHeap.isEmpty()) {
	            if(minHeap.peek() < maxHeap.peek()){
	                int tmp = minHeap.poll();
	                minHeap.offer(maxHeap.poll());
	                maxHeap.offer(tmp);
	            }
            }
			System.out.println(maxHeap.peek());
		}
		
	}

}
