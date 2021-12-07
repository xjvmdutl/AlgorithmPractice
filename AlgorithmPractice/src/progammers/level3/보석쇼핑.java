package progammers.level3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ∫∏ºÆºÓ«Œ {
	public static int[] solution(String[] gems) {
        int[] answer = new int[2];
        Set<String> set = new HashSet<>();
        for(String gem : gems)
        	set.add(gem);
        int left = 0;
        int right = 0;
        int dis = Integer.MAX_VALUE;
        Map<String,Integer> map = new HashMap<>();
        while(true) {
        	if(map.size() == set.size()) {
        		map.put(gems[left], map.get(gems[left])-1);
        		if(map.get(gems[left]) == 0)
        			map.remove(gems[left]);
        		left++;
        	}else if(right == gems.length) {
        		break;
        	}else {
        		map.put(gems[right], map.getOrDefault(gems[right],0)+1);
        		right++;
        	}
        	if(map.size() == set.size()) {
        		if(right - left < dis) {
        			dis = right - left;
        			answer[0] = left+1;
        			answer[1] = right;
        		}
        	}
        }
        return answer;
    }
	public static void main(String[] args) {
		String[] gems1 = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
		System.out.println(solution(gems1));
		String[] gems2 = {"AA", "AB", "AC", "AA", "AC"};
		System.out.println(solution(gems2));
		String[] gems3 = {"XYZ", "XYZ", "XYZ"};
		System.out.println(solution(gems3));
		String[] gems4 = {"ZZZ", "YYY", "NNNN", "YYY", "BBB"};
		System.out.println(solution(gems4));
		
	}

}
