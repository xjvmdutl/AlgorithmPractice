package progammers.level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class 숫자게임 {
	public static int solution(int[] A, int[] B) {
	   int answer = 0;
	   Queue<Integer> que = new PriorityQueue<>((o1,o2)->o2-o1);
	   List<Integer> list = new ArrayList<>();
	   Arrays.sort(B);
	   for(int i=0;i<B.length;++i) {
		   que.offer(A[i]);
		   list.add(B[i]);
	   }
	   for(int i=0;i<A.length;++i) {
		   int n1 = que.poll();
		   if(list.get(list.size()-1) > n1) {
			   answer++;
			   list.remove(list.size()-1);
		   }else {
			   list.remove(0);
		   }
	   }
	   return answer;
	}
	public static void main(String[] args) {
		//A			B			result
		//[5,1,3,7]	[2,2,6,8]	3
		//[2,2,2,2]	[1,1,1,1]	0
		int[] a1 = {5,1,3,7};
		int[] b1 = {2,2,6,8};
		System.out.println(solution(a1,b1));
		int[] a2 = {2,2,2,2};
		int[] b2 = {1,1,1,1};
		System.out.println(solution(a2,b2));
	}
}
