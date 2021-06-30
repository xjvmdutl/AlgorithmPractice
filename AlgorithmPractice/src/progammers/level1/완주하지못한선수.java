package progammers.level1;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class 완주하지못한선수 {
	 public static String solution(String[] participant, String[] completion) {
		/*
		 String answer = "";
        Arrays.sort(participant);
        Arrays.sort(completion);
    	for(int i=0;i<participant.length;++i) {
    		System.out.println(participant.length);
    		if(i == participant.length-1) {
    			answer=participant[i];
    		}else if(!participant[i].equals(completion[i])) {
    			answer=participant[i];
    		}
    	}   
        return answer;
        */
		String answer = "";
		Map<String,Integer> map = new HashMap<>();
		for(int i =0;i<participant.length;++i) {
			int count =0;
			if(map.containsKey(participant[i])) {
				count=map.get(participant[i]);
			}
			map.put(participant[i],++count);
		}
		for(int i=0;i<completion.length;++i) {
			map.put(completion[i],map.get(completion[i])-1);
		}
		
		for(String key : map.keySet()) {
			if(map.get(key) == 1) {
				answer=key;
			}
		}
		
        return answer;
    }
	 
	 
	 
	 /*
	     public String solution(String[] participant, String[] completion) {
	        String answer = "";
	        HashMap<String, Integer> hm = new HashMap<>();
	        for (String player : participant) hm.put(player, hm.getOrDefault(player, 0) + 1);
	        for (String player : completion) hm.put(player, hm.get(player) - 1);
	
	        for (String key : hm.keySet()) {
	            if (hm.get(key) != 0){
	                answer = key;
	            }
	        }
	        return answer;
	    }
	 */
	 public static void main(String[] args) {
		String[] arr1 = {"marina", "josipa", "nikola", "vinko", "filipa"};
		String[] arr2 = {"josipa", "filipa", "marina", "nikola"};
		String s = solution(arr1,arr2);
	}
}
