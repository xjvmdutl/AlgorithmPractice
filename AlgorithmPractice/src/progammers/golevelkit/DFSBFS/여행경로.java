package progammers.golevelkit.DFSBFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 여행경로 {
	public static List<String> list;
	public static boolean[] visit;
	public static boolean first;
	public static String[] solution(String[][] tickets) {
        
        
        Arrays.sort(tickets,(o1,o2)->{
        	if(o1[0].equals(o2[0]))
        		return o1[1].compareTo(o2[1]);
        	return o1[0].compareTo(o2[0]);
        });
        list = new ArrayList<>();
        first = true;
        list.add("ICN");
        
        for(int i=0;i<tickets.length;++i) {
        	if(tickets[i][0].equals("ICN")) {
        		visit = new boolean[tickets.length];
        		String[] arr = new String[tickets.length];
                dfs(tickets,i,0,tickets.length,arr);
        	}
        }
        
        
        String[] answer = new String[list.size()];
        
        for(int i=0;i<list.size();++i) {
        	answer[i] = list.get(i);
        }
        return answer;
    }
	private static void dfs(String[][] tickets, int index, int now, int length,String[] arr) {
		visit[index] = true;
		String target = tickets[index][1];
		arr[now] = target;
		if(now == length-1) {
			if(first) {
				for(int i=0;i<visit.length;++i) {
					if(!visit[i])
						return;
				}
				
				for(int i=0;i<arr.length;++i) {
					list.add(arr[i]);
				}
				first = false;
			}
			return;
		}
		for(int i=0;i<tickets.length;++i) {
			if(!visit[i] && tickets[i][0].equals(target)) {
				
				dfs(tickets, i,now+1,length,arr);
			}
		}
		visit[index] = false;
	}
	public static void main(String[] args) {
		//tickets	return
		//[["ICN", "JFK"], ["HND", "IAD"], ["JFK", "HND"]]	["ICN", "JFK", "HND", "IAD"]
		//[["ICN", "SFO"], ["ICN", "ATL"], ["SFO", "ATL"], ["ATL", "ICN"], ["ATL","SFO"]]	["ICN", "ATL", "ICN", "SFO", "ATL", "SFO"]
		String[][] tickets1 = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
		System.out.println(solution(tickets1));
		String[][] tickets2 = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
		System.out.println(solution(tickets2));
		
		//T 1 : [["ICN", "B"], ["B", "ICN"], ["ICN", "A"], ["A", "D"], ["D", "A"]]
		//ans : ["ICN", "B", "ICN", "A", "D", "A"]
		String[][] tickets3 = {{"ICN", "B"}, {"B", "ICN"}, {"ICN", "A"}, {"A", "D"}, {"D", "A"}};
		System.out.println(solution(tickets3));
		
		//T 2: [["ICN", "AAA"], ["ICN", "AAA"], ["ICN", "AAA"], ["AAA", "ICN"], ["AAA", "ICN"]]
		//ans : ["ICN", "AAA", "ICN", "AAA", "ICN", "AAA"]
		String[][] tickets4 = {{"ICN", "AAA"}, {"ICN", "AAA"}, {"ICN", "AAA"}, {"AAA", "ICN"}, {"AAA", "ICN"}};
		System.out.println(solution(tickets4));
		
		//T 3 : [["ICN", "COO"], ["ICN", "BOO"], ["COO", "ICN"], ["BOO", "DOO"]]
		//ans : ["ICN", "COO", "ICN", "BOO", "DOO"]
		String[][] tickets5 = {{"ICN", "COO"}, {"ICN", "BOO"}, {"COO", "ICN"}, {"BOO", "DOO"}};
		System.out.println(solution(tickets5));
		
		//T 4: [["ICN", "SFO"], ["SFO", "ICN"], ["ICN", "SFO"], ["SFO", "QRE"]]
		//ans : ["ICN", "SFO", "ICN", "SFO", "QRE"]
		String[][] tickets6 = {{"ICN", "SFO"}, {"SFO", "ICN"}, {"ICN", "SFO"}, {"SFO", "QRE"}};
		System.out.println(solution(tickets6));
	
		//T 5 : [["ICN", "BOO"], ["ICN", "COO"], ["COO", "DOO"], ["DOO", "COO"], ["BOO", "DOO"], ["DOO", "BOO"], ["BOO", "ICN"], ["COO", "BOO"]]
		//ans : ["ICN", "BOO", "DOO", "BOO", "ICN", "COO", "DOO", "COO", "BOO"]
		String[][] tickets7 = {{"ICN", "BOO"}, {"ICN", "COO"}, {"COO", "DOO"}, {"DOO", "COO"}, {"BOO", "DOO"}, {"DOO", "BOO"}, {"BOO", "ICN"}, {"COO", "BOO"}};
		System.out.println(solution(tickets7));
	}

}
