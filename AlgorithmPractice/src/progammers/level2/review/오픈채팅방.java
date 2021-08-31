package progammers.level2.review;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class ����ä�ù� {
	public static String[] solution(String[] record) {
        
        Map<String, String> map = new HashMap<>();
        Queue<String> que = new LinkedList<>();
        for(String str : record) {
        	StringTokenizer tokens = new StringTokenizer(str);
        	String status = tokens.nextToken();
        	String id = tokens.nextToken();
        	
        	if(status.equals("Enter")) {
        		String name = tokens.nextToken();
        		//����
        		if(map.containsKey(id)) {
        			map.put(id, name);
        		}else {
        			map.put(id, name);
        		}
        		que.offer(id+"���� ���Խ��ϴ�.");
        	}else if(status.equals("Leave")){
        		que.offer(id+"���� �������ϴ�.");
        	}else if(status.equals("Change")) {
        		String name = tokens.nextToken();
        		map.put(id, name);
        	}
        }
        String[] answer = new String[que.size()];
        int idx = 0;
        while(!que.isEmpty()) {
        	String str = que.poll();
        	int index = str.indexOf("��");
        	String id = str.substring(0,index);
        	String name = map.get(id);
        	answer[idx++] = str.replace(id, name);
        }
        return answer;
    }
	public static void main(String[] args) {
		//record	result
		//["Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"]	["Prodo���� ���Խ��ϴ�.", "Ryan���� ���Խ��ϴ�.", "Prodo���� �������ϴ�.", "Prodo���� ���Խ��ϴ�."]
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		System.out.println(solution(record));
	}

}
