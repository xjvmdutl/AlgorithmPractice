package progammers.level2;

import java.util.ArrayList;
import java.util.HashMap;
//import java.util.LinkedList;
//import java.util.Queue;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class 오픈채팅방 {
//	static class People{
//		String print;
//		String userId;
//		String nickName;
//	}	
//	public static String[] solution(String[] record) {
//        
//        Queue<People> que = new LinkedList<>(); 
//        for(String data : record) {
//        	String[] tmp = data.split(" ");
//        	if(tmp[0].equals("Enter")) {
//        		change(que,tmp[1],tmp[2]);
//        		People p = new People();
//        		p.userId= tmp[1];
//        		p.print= tmp[2]+"님이 들어왔습니다.";
//        		p.nickName= tmp[2];
//        		que.offer(p);
//        	}else if(tmp[0].equals("Leave")) {
//        		String tmp2 = "";
//        		for(People p : que) {
//        			if(p.userId.equals(tmp[1])) {
//        				tmp2 = p.nickName; 
//        			}
//        		}
//        		People p = new People();
//        		p.userId= tmp[1];
//        		p.print= tmp2+"님이 나갔습니다.";
//        		p.nickName= tmp2;
//        		que.offer(p);
//        	}else if(tmp[0].equals("Change")) {
//        		change(que,tmp[1],tmp[2]);
//        	}
//        		
//        }
//        String[] answer = new String[que.size()];
//        int count = 0;
//        while(!que.isEmpty()) {
//        	answer[count++] = que.poll().print;
//        }
//        return answer;
//    }
//	public static void change(Queue<People> que,String tmp1,String tmp2) {
//		for(People p : que) {
//			if(p.userId.equals(tmp1)) {
//				p.print = p.print.replace(p.nickName, tmp2);
//				p.nickName = tmp1; 
//			}
//		}
//	}
	
	public static String[] solution(String[] record) {
        Map<String,String> nickMap = new HashMap<>();
        List<String> chatLog = new ArrayList<>();
        for(String log : record){
        	StringTokenizer st = new StringTokenizer(log);
        	String command = st.nextToken();
        	String userId = st.nextToken();
        	String nickName = "";
        	if(!command.equals("Leave")){
        		nickName = st.nextToken();
            }
        	switch(command){
	            case "Enter":
	                nickMap.put(userId, nickName);
	                chatLog.add(userId + "님이 들어왔습니다.");
	                break;
	            case "Leave":
	                chatLog.add(userId + "님이 나갔습니다.");
	                break;
	            case "Change":
	                nickMap.put(userId, nickName);
	                break;
	        }
        }
        String[] answer = new String[chatLog.size()];
        int logIdx = 0;
        for(String str : chatLog) {
        	int endOfId = str.indexOf("님");
        	String userId = str.substring(0, endOfId);
            answer[logIdx++] = str.replace(userId, nickMap.get(userId));
        }
        return answer;
    }
	
	public static void main(String[] args) {
		//record	result
		//["Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"]	["Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."]
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		String[] result = solution(record);
		for(String s : result)
			System.out.println(s);
		
	}

}
