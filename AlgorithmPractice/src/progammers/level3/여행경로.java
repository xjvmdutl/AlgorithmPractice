package progammers.level3;

import java.util.Arrays;

public class 여행경로 {
	public static boolean[] visit;
	public static boolean finish;
	public static String[] solution(String[][] tickets) {
		
		finish = false;
		visit = new boolean[tickets.length];
		String[] datas = new String[tickets.length];
		Arrays.sort(tickets,(o1,o2)->{
			return o1[1].compareTo(o2[1]);
		});
		dfs("ICN",0,tickets.length,datas,tickets);
		String[] answer = new String[datas.length+1];
		answer[0] = "ICN";
		for(int i=0;i<datas.length;++i) {
			answer[i+1] = datas[i];
		}
		return answer;
	}
	private static void dfs(String now, int count, int length, String[] datas, String[][] tickets) {
		if(count == length) {
			finish = true;
			return;
		}
		for(int i=0;i<tickets.length;++i) {
			if(!visit[i] && now.equals(tickets[i][0]) && !finish) {
				visit[i] = true;
				datas[count] = tickets[i][1];
				dfs(tickets[i][1],count+1,length,datas,tickets);
				visit[i] = false;
			}
		}
	}
	public static void main(String[] args) {
		//tickets	return
		//[["ICN", "JFK"], ["HND", "IAD"], ["JFK", "HND"]]	["ICN", "JFK", "HND", "IAD"]
		//[["ICN", "SFO"], ["ICN", "ATL"], ["SFO", "ATL"], ["ATL", "ICN"], ["ATL","SFO"]]	["ICN", "ATL", "ICN", "SFO", "ATL", "SFO"]
		String[][] tickets1 = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
		System.out.println(solution(tickets1));
		String[][] tickets2 = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
		System.out.println(solution(tickets2));
	}

}
