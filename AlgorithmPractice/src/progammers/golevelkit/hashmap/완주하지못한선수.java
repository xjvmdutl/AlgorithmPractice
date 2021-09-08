package progammers.golevelkit.hashmap;

import java.util.HashMap;
import java.util.Map;

public class 완주하지못한선수 {
	public static String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        for(int i=0;i<participant.length;++i) {
        	map.put(participant[i], map.getOrDefault(participant[i],0 )+1);
        }
        for(int i=0;i<completion.length;++i) {
        	map.put(completion[i],map.get(completion[i]) - 1);
        	if(map.get(completion[i]) == 0) {
        		map.remove(completion[i]);
        	}
        }
        for(String s : map.keySet())
        	answer = s;
        return answer;
    }
	public static void main(String[] args) {
		//participant	completion	return
		//["leo", "kiki", "eden"]	["eden", "kiki"]	"leo"
		//["marina", "josipa", "nikola", "vinko", "filipa"]	["josipa", "filipa", "marina", "nikola"]	"vinko"
		//["mislav", "stanko", "mislav", "ana"]	["stanko", "ana", "mislav"]	"mislav"
		String[] participant1 = {"leo", "kiki", "eden"};
		String[] completion1 = {"eden", "kiki"};
		System.out.println(solution(participant1,completion1));
		String[] participant2 = {"marina", "josipa", "nikola", "vinko", "filipa"};
		String[] completion2 = {"josipa", "filipa", "marina", "nikola"};
		System.out.println(solution(participant2,completion2));
		String[] participant3 = {"mislav", "stanko", "mislav", "ana"};
		String[] completion3 = {"stanko", "ana", "mislav"};
		System.out.println(solution(participant3,completion3));
	}

}
