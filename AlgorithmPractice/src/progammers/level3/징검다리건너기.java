package progammers.level3;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class 징검다리건너기 {
	public static int solution(int[] stones, int k) {
		
        int answer = 0;
        /*
        Map<Integer,Integer> map = new HashMap<>();
        int start = 0;
        int end = k;
        for(int i=0;i<end;++i) {
        	map.put(stones[i], map.getOrDefault(stones[i], 0)+1);
        }
        answer = Math.min(answer,Collections.max(map.keySet()));
        while(end < stones.length) {
        	if(map.get(stones[start]) == 1) {
        		map.remove(stones[start]);
        	}else {
        		map.put(stones[start], map.get(stones[start])-1);
        	}
        	
        	map.put(stones[end], map.getOrDefault(map, map.getOrDefault(stones[end], 0)+1));
        	answer = Math.min(answer,Collections.max(map.keySet()));
        	end++;
        	start++;
        }
        */
        int start = 0;
        int end = 200000000;
        while(start<end) {
        	int mid = (start + end) / 2;
        	if(canMove(stones,k,mid)) {
        		start = mid + 1;
        		answer = Math.max(answer, mid + 1);
        	}else {
        		end = mid - 1;
        	}
        }
        return answer;
    }
	private static boolean canMove(int[] stones, int k, int mid) {
		int count = 0;
		for(int stone : stones) {
			if(stone - mid < 0) {
				count++;
			}else {
				count = 0;
			}
			if(k == count) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1,2, 4, 5, 3, 2, 1, 4, 2, 5, 1,2, 4, 5, 3, 2, 1, 4, 2, 5, 1,2, 4, 5, 3, 2, 1, 4, 2, 5, 1,2, 4, 5, 3, 2, 1, 4, 2, 5, 1,2, 4, 5, 3, 2, 1, 4, 2, 5, 1,2, 4, 5, 3, 2, 1, 4, 2, 5, 1,2, 4, 5, 3, 2, 1, 4, 2, 5, 1,2, 4, 5, 3, 2, 1, 4, 2, 5, 1,2, 4, 5, 3, 2, 1, 4, 2, 5, 1,2, 4, 5, 3, 2, 1, 4, 2, 5, 1,2, 4, 5, 3, 2, 1, 4, 2, 5, 1,2, 4, 5, 3, 2, 1, 4, 2, 5, 1,2, 4, 5, 3, 2, 1, 4, 2, 5, 1,2, 4, 5, 3, 2, 1, 4, 2, 5, 1,2, 4, 5, 3, 2, 1, 4, 2, 5, 1,2, 4, 5, 3, 2, 1, 4, 2, 5, 1,2, 4, 5, 3, 2, 1, 4, 2, 5, 1,2, 4, 5, 3, 2, 1, 4, 2, 5, 1,2, 4, 5, 3, 2, 1, 4, 2, 5, 1,2, 4, 5, 3, 2, 1, 4, 2, 5, 1,2, 4, 5, 3, 2, 1, 4, 2, 5, 1,2, 4, 5, 3, 2, 1, 4, 2, 5, 1,2, 4, 5, 3, 2, 1, 4, 2, 5, 1,2, 4, 5, 3, 2, 1, 4, 2, 5, 1,2, 4, 5, 3, 2, 1, 4, 2, 5, 1,2, 4, 5, 3, 2, 1, 4, 2, 5, 1,2, 4, 5, 3, 2, 1, 4, 2, 5, 1,2, 4, 5, 3, 2, 1, 4, 2, 5, 1,2, 4, 5, 3, 2, 1, 4, 2, 5, 1,2, 4, 5, 3, 2, 1, 4, 2, 5, 1,2, 4, 5, 3, 2, 1, 4, 2, 5, 1,2, 4, 5, 3, 2, 1, 4, 2, 5, 1,2, 4, 5, 3, 2, 1, 4, 2, 5, 1,2, 4, 5, 3, 2, 1, 4, 2, 5, 1,2, 4, 5, 3, 2, 1, 4, 2, 5, 1,2, 4, 5, 3, 2, 1, 4, 2, 5, 1,2, 4, 5, 3, 2, 1, 4, 2, 5, 1,2, 4, 5, 3, 2, 1, 4, 2, 5, 1,2, 4, 5, 3, 2, 1, 4, 2, 5, 1,2, 4, 5, 3, 2, 1, 4, 2, 5, 1,2, 4, 5, 3, 2, 1, 4, 2, 5, 1,2, 4, 5, 3, 2, 1, 4, 2, 5, 1,2, 4, 5, 3, 2, 1, 4, 2, 5, 1,2, 4, 5, 3, 2, 1, 4, 2, 5, 1,2, 4, 5, 3, 2, 1, 4, 2, 5, 1,2, 4, 5, 3, 2, 1, 4, 2, 5, 1,2, 4, 5, 3, 2, 1, 4, 2, 5, 1,2, 4, 5, 3, 2, 1, 4, 2, 5, 1,2, 4, 5, 3, 2, 1, 4, 2, 5, 1,2, 4, 5, 3, 2, 1, 4, 2, 5, 1,2, 4, 5, 3, 2, 1, 4, 2, 5, 1,2, 4, 5, 3, 2, 1, 4, 2, 5, 1,2, 4, 5, 3, 2, 1, 4, 2, 5, 1,2, 4, 5, 3, 2, 1, 4, 2, 5, 1,2, 4, 5, 3, 2, 1, 4, 2, 5, 1,2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
		System.out.println(solution(stones,500));
	}

}
