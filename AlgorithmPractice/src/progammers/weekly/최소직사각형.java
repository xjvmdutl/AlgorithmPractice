package progammers.weekly;

import java.util.PriorityQueue;
import java.util.Queue;

public class 최소직사각형 {
	public static int solution(int[][] sizes) {

        Queue<Integer> pq1 = new PriorityQueue<>((o1,o2)->o2-o1);
        Queue<Integer> pq2 = new PriorityQueue<>((o1,o2)->o2-o1);
        for(int i=0;i<sizes.length;++i) {
        	if(sizes[i][0] > sizes[i][1]) {
        		pq1.offer(sizes[i][0]);
        		pq2.offer(sizes[i][1]);
        	}else {
        		pq1.offer(sizes[i][1]);
        		pq2.offer(sizes[i][0]);
        	}
        }
        int m1 = pq1.poll();
        int m2 = pq2.poll();
        return m1 * m2;
    }
	public static void main(String[] args) {
		//sizes	result
		//[[60, 50], [30, 70], [60, 30], [80, 40]]	4000
		//[[10, 7], [12, 3], [8, 15], [14, 7], [5, 15]]	120
		//[[14, 4], [19, 6], [6, 16], [18, 7], [7, 11]]	133
		int[][] sizes1 = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
		System.out.println(solution(sizes1));
		int[][] sizes2 = {{10, 7},{12, 3},{8, 15}, {14, 7}, {5, 15}};
		System.out.println(solution(sizes2));
		int[][] sizes3 = {{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}};
		System.out.println(solution(sizes3));
	}

}
