package progammers.weekly;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class 입실퇴실 {
	public static int[] solution(int[] enter, int[] leave) {
		int N = enter.length;
		Set<Integer> room = new HashSet<>();
		Map<Integer, Integer> meetCnt = new HashMap<>(); 
		Queue<Integer> inList = new LinkedList<Integer>();
		Queue<Integer> outList = new LinkedList<Integer>();
		for(int i = 0; i < N; i++) { 
			inList.add(enter[i]);
			outList.add(leave[i]); 
			meetCnt.put(i+1, 0); 
		}

		while(!inList.isEmpty()) {
			int in = inList.poll(); // 이미 입실한 친구들은 새롭게 온 친구 1명을 만났다. 
			if(room.size() >= 1) { 
				room.forEach(
						humanNum -> {
							meetCnt.put(humanNum, meetCnt.get(humanNum) + 1);
						}
					);
			}
			meetCnt.put(in, room.size()); // 새로 입실한 친구는 방에 있는 사람 수 만큼 만났다.
			room.add(in); //System.out.println(room.toString() + " || " + in + "번 in"); 
			while(!outList.isEmpty() && room.contains(outList.peek())) {
				int out = outList.poll();
				room.remove(out); //System.out.println(room.toString() + " || " + out + "번 out"); 
		
			} 
		} 
		int[] answer = new int[N]; 
		for(int i = 0 ; i < N ; i++) { 
			answer[i] = meetCnt.get(i+1); 
		}
		return answer;
	}
	public static void main(String[] args) {
		//enter	leave	result
		//[1,3,2]	[1,2,3]	[0,1,1]
		//[1,4,2,3]	[2,1,3,4]	[2,2,1,3]
		//[3,2,1]	[2,1,3]	[1,1,2]
		//[3,2,1]	[1,3,2]	[2,2,2]
		//[1,4,2,3]	[2,1,4,3]	[2,2,0,2]
		int[] enter1 = {1,3,2};
		int[] leave1 = {1,2,3};
		System.out.println(solution(enter1,leave1));
		int[] enter2 = {1,4,2,3};
		int[] leave2 = {2,1,3,4};
		System.out.println(solution(enter2,leave2));
		int[] enter3 = {3,2,1};
		int[] leave3 = {2,1,3};
		System.out.println(solution(enter3,leave3));
		int[] enter4 = {3,2,1};
		int[] leave4 = {1,3,2};
		System.out.println(solution(enter4,leave4));
		int[] enter5 = {1,4,2,3};
		int[] leave5 = {2,1,4,3};
		System.out.println(solution(enter5,leave5));
	}

}
