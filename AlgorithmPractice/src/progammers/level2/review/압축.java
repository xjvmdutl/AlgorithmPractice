package progammers.level2.review;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class æ–√‡ {
	public static Map<String,Integer> map;
	public static int[] solution(String msg) {
		map = new HashMap<>();
        init();
        int n = map.get("Z");
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<msg.length();++i) {
        	int index = i;
        	boolean flag = true;
        	while(index < msg.length()) {
        		index++;
        		String str = msg.substring(i,index);
        		if(!map.containsKey(str)) {
        			map.put(str, ++n);
        			str = msg.substring(i,index-1);
        			list.add(map.get(str));
        			i=index-2;
        			break;
        		}else if(index == msg.length()) {
        			list.add(map.get(str));
        			flag = false;
        		}
        	}
        	if(!flag) {
        		break;
        	}
        }
        int[] answer = new int[list.size()];
        for(int i=0;i<list.size();++i) {
        	answer[i] = list.get(i);
        }
        return answer;
    }
	private static void init() {
		int count = 1;
		for(int i='A';i<='Z';++i) {
			map.put(String.valueOf(Character.toChars(i)), count++);
		}
	}
	public static void main(String[] args) {
		//msg	answer
		//KAKAO	[11, 1, 27, 15]
		//TOBEORNOTTOBEORTOBEORNOT	[20, 15, 2, 5, 15, 18, 14, 15, 20, 27, 29, 31, 36, 30, 32, 34]
		//ABABABABABABABAB	[1, 2, 27, 29, 28, 31, 30]
		System.out.println(solution("KAKAO"));
		System.out.println(solution("TOBEORNOTTOBEORTOBEORNOT"));
		System.out.println(solution("ABABABABABABABAB"));
	}

}
