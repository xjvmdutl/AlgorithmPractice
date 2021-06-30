package progammers.level2;

import java.util.PriorityQueue;

public class ´õ¸Ê°Ô {
	public static int solution(int[] scoville, int K) {
		int answer = 0;
        PriorityQueue<Integer> heap = new PriorityQueue();

        for (int aScoville : scoville) {
            heap.offer(aScoville);
        }
        while(heap.peek() <= K) {
        	if(heap.size() == 1)
        		return -1;
        	int a = heap.poll();
        	int b = heap.poll();
        	int c = a + (b*2);
        	heap.offer(c);
        	answer++;
        }
        return answer;
    }
	
	public static void main(String[] args) {
//		scoville	K	return
//		[1, 2, 3, 9, 10, 12]	7	2
		int[] scoville = {1, 3, 2, 9, 10, 12};
		int K = 7;
		int result = solution(scoville, K);
		System.out.println(result);
	}

}
