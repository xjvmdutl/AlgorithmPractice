package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
class Freshman {
	int time;
	String name;
	public Freshman(int time, String name){
		this.name = name;
		this.time = time;
	}
}
public class ½ÎÀÌ¹ö°³°­ÃÑÈ¸ {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		String s = tokens.nextToken();
		String e = tokens.nextToken();
		String q = tokens.nextToken();
		
		List<Freshman> chatList = new ArrayList<>();

		String str;
		while((str = reader.readLine()) != null) {
			if(str.equals(""))
				break;
			tokens = new StringTokenizer(str);
			String[] times = tokens.nextToken().split(":");
			int time = Integer.parseInt(times[0])*60 + Integer.parseInt(times[1]);
			chatList.add(new Freshman(time, tokens.nextToken()));
		}
		System.out.println(solution(chatList, s, e, q));
	}

	private static int solution(List<Freshman> chatList, String s, String e, String q) {
		int answer = 0;
		String[] startTimes = s.split(":");
		int startTime = Integer.parseInt(startTimes[0])*60 + Integer.parseInt(startTimes[1]);
		String[] endTimes = e.split(":");
		int endTime = Integer.parseInt(endTimes[0])*60 + Integer.parseInt(endTimes[1]);
		String[] qTimes = q.split(":");
		int qTime = Integer.parseInt(qTimes[0])*60 + Integer.parseInt(qTimes[1]);
		Set<String> set = new HashSet<>();
		for(int i=0;i<chatList.size();++i) {
			Freshman f = chatList.get(i);
			if(f.time <= startTime) {
				set.add(f.name);
			}else if(endTime <= f.time 
					&& f.time <= qTime 
					&& set.contains(f.name)) {
				set.remove(f.name);
				answer++;
			}
		}
		return answer;
	}

}
