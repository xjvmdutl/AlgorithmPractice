package progammers.level2.review;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class 오픈채팅방 {
	public static String[] solution(String[] record) {
        
        Map<String, String> map = new HashMap<>();
        Queue<String> que = new LinkedList<>();
        for(String str : record) {
        	StringTokenizer tokens = new StringTokenizer(str);
        	String status = tokens.nextToken();
        	String id = tokens.nextToken();
        	
        	if(status.equals("Enter")) {
        		String name = tokens.nextToken();
        		//입장
        		if(map.containsKey(id)) {
        			map.put(id, name);
        		}else {
        			map.put(id, name);
        		}
        		que.offer(id+"님이 들어왔습니다.");
        	}else if(status.equals("Leave")){
        		que.offer(id+"님이 나갔습니다.");
        	}else if(status.equals("Change")) {
        		String name = tokens.nextToken();
        		map.put(id, name);
        	}
        }
        String[] answer = new String[que.size()];
        int idx = 0;
        while(!que.isEmpty()) {
        	String str = que.poll();
        	int index = str.indexOf("님");
        	String id = str.substring(0,index);
        	String name = map.get(id);
        	answer[idx++] = str.replace(id, name);
        }
        return answer;
    }
	public static void main(String[] args) {
		//record	result
		//["Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"]	["Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."]
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		System.out.println(solution(record));
	}

}
