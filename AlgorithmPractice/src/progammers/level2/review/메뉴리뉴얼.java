package progammers.level2.review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class 메뉴리뉴얼 {
	public static HashMap<String,Integer> map; 
	public static boolean[] visit;
	public static String max;
	public static int maxCount;
	public static String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        List<String> list = new ArrayList<>();
        for(int i=0;i<orders.length;++i) {
        	char[] order = orders[i].toCharArray();
        	Arrays.sort(order);
        	orders[i] = String.valueOf(order);
        }
        for(int i=0;i<course.length;++i) {
        	map = new HashMap<>();
        	maxCount = 0;
        	int cos = course[i];
        	for(int j=0;j<orders.length;++j) {
        		visit = new boolean[orders[j].length()];
        		char[] arr = new char[cos];
        		if(course[i]<=orders[j].length())
        			dfs(orders[j],0,cos,arr,0);
        		
            }
        	if(maxCount >=2) {
	        	for(String str: map.keySet()) {
	        		if(map.get(str) == maxCount) {
	        			list.add(str);
	        		}
	        	}
        	}
        }
        Collections.sort(list);
        answer = new String[list.size()];
        for(int i=0;i<list.size();++i) {
        	answer[i] = list.get(i);
        }
        return answer;
    }
	private static void dfs(String str, int index, int cos, char[] arr,int cnt) {
		if(cnt == cos) {
			Arrays.sort(arr);
			StringBuilder sb = new StringBuilder();
			for(char c : arr) {
				sb.append(c);
			}
			map.put(sb.toString(),map.getOrDefault(sb.toString(), 0)+1);
			if(maxCount < map.get(sb.toString())) {
				maxCount = map.get(sb.toString());
				max = sb.toString();
			}
			return;
		}
		for(int i=index;i<str.length();++i) {
			arr[cnt] = str.charAt(i);
			dfs(str, i+1, cos, arr,cnt+1);
		}
	}
	public static void main(String[] args) {
		//orders	course	result
		//["ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"]	[2,3,4]	["AC", "ACDE", "BCFG", "CDE"]
		//["ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"]	[2,3,5]	["ACD", "AD", "ADE", "CD", "XYZ"]
		//["XYZ", "XWY", "WXA"]	[2,3,4]	["WX", "XY"]
		String[] orders1 = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
		int[] course1 = {2,3,4};
		System.out.println(solution(orders1,course1));
		String[] orders2 = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
		int[] course2 = {2,3,5};
		System.out.println(solution(orders2,course2));
		String[] orders3 = {"XYZ", "XWY", "WXA"};
		int[] course3 = {2,3,4};
		System.out.println(solution(orders3,course3));
	}

}
