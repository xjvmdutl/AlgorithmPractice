package progammers.level1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class 신고결과받기 {
	public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, HashSet<String>> set = new HashMap<>();
        Map<String, HashSet<String>> map = new HashMap<>();
        for(int i=0;i<report.length;++i) {
        	StringTokenizer tokens = new StringTokenizer(report[i]);
        	String id = tokens.nextToken();
        	String rep = tokens.nextToken();
    		if(!set.containsKey(id)) {
    			set.put(id, new HashSet<>());
    		}
    		set.get(id).add(rep);
    		if(!map.containsKey(rep)) {
    			map.put(rep, new HashSet<>());
    		}
    		map.get(rep).add(id);
        }
        for(int i=0;i<id_list.length;++i) {
        	if(!set.containsKey(id_list[i])) {
        		answer[i] = 0;
        	}else {
        		int count = 0;
        		Set<String> reports = set.get(id_list[i]);
        		for(String id : reports) {
        			if(map.get(id).size() >= k) {
        				count++;
        			}
        		}
        		answer[i] = count;
        	}
        }
        return answer;
    }
	public static void main(String[] args) {
		//유저 ID	유저가 신고한 ID	설명
		//id_list	report	k	result
		//["muzi", "frodo", "apeach", "neo"]	["muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"]	2	[2,1,1,0]
		//["con", "ryan"]	["ryan con", "ryan con", "ryan con", "ryan con"]	3	[0,0]
		String[] id_list1 = {"muzi", "frodo", "apeach", "neo"};
		String[] report1 = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
		System.out.println(solution(id_list1, report1, 2));
		String[] id_list2 = {"con", "ryan"};
		String[] report2 = {"ryan con", "ryan con", "ryan con", "ryan con"};
		System.out.println(solution(id_list2, report2, 3));
	}

}
