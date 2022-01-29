package progammers.level3.review;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ∫∏ºÆºÓ«Œ {
	public static int[] solution(String[] gems) {
		int[] answer = new int[2];
	
		int length = Integer.MAX_VALUE;
		Set<String> set = new HashSet<>();
		Map<String, Integer> map = new HashMap<>();
		for(String gem : gems) {
			set.add(gem);
		}
		int start = 0;
		int end = 0;
		map.put(gems[0], 1);

		while(end < gems.length) {
			if(set.size() == map.size()) {
				int l = end - start;
				if(l < length) {
					answer[0] = start + 1;
					answer[1] = end + 1;
					length = l;
				}
			}
			if(set.size() == map.size()) {
				int count = map.get(gems[start]) - 1;
				if(count == 0) {
					map.remove(gems[start]);
				}else {
					map.put(gems[start], count);
					
				}
				start++;
			}else {
				end++;
				if(end < gems.length) {
					map.put(gems[end], map.getOrDefault(gems[end], 0) + 1);
				}
			}
			
		}
        return answer;
    }
	public static void main(String[] args) {
		//gems																	result
		//["DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"]	[3, 7]
		//["AA", "AB", "AC", "AA", "AC"]	[1, 3]
		//["XYZ", "XYZ", "XYZ"]	[1, 1]
		//["ZZZ", "YYY", "NNNN", "YYY", "BBB"]	[1, 5]
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
