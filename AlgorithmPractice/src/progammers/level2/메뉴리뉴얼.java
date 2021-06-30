package progammers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class 메뉴리뉴얼 {
	public static Map<String,Integer> map;	
	public static String[] solution(String[] orders, int[] course) {
	       
		List<String> list = new ArrayList<>();
        for(int i=0;i<orders.length;++i){
            char[] chracters = orders[i].toCharArray();
            Arrays.sort(chracters);
            orders[i]=String.valueOf(chracters);
        }
        for(int i=0;i<course.length;++i){
            int max = Integer.MIN_VALUE;   
            map  = new HashMap<>();
            for(int j=0;j<orders.length;++j){
                StringBuilder sb = new StringBuilder();
                if(course[i]<=orders[j].length())
                    combine(orders[j],sb,0,0,course[i]);
            }
            for(String s : map.keySet()){
                max = Math.max(max,map.get(s));
            }
            for(String s : map.keySet()){
                if(max >=2 && map.get(s) == max)
                    list.add(s);
            }
        }
        Collections.sort(list);
        String[] answer = new String[list.size()];
        for(int i=0;i<list.size();++i){
            answer[i] = list.get(i);
        }
        return answer;
	 }
	private static void combine(String order, StringBuilder sb, int idx, int cnt, int n) {
		if(cnt == n) {
			map.put(sb.toString(),map.getOrDefault(sb.toString(),0)+1);
		}
		// 16. idx부터 시작함으로써 조합을 구할 수 있다.
        for(int i = idx ; i<order.length();i++){
        	sb.append(order.charAt(i));
        	combine(order,sb,i+1,cnt+1,n);
            sb.delete(cnt,cnt+1);

        }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//orders	course	result
		//["ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"]	[2,3,4]	["AC", "ACDE", "BCFG", "CDE"]
		//["ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"]	[2,3,5]	["ACD", "AD", "ADE", "CD", "XYZ"]
		//["XYZ", "XWY", "WXA"]	[2,3,4]	["WX", "XY"]
		String[] orders1 = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
		int[] course1 = {2,3,4};
		String[] result1 = solution(orders1,course1);
		for(String s : result1)
			System.out.print(s+ " ");
		System.out.println();
		
		String[] orders2 = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"}; 
		int[] course2 = {2,3,5};
		String[] result2 = solution(orders2,course2);
		for(String s : result2)
			System.out.print(s+ " ");
		System.out.println();
		
		String[] orders3 = {"XYZ", "XWY", "WXA"};
		int[] course3 = {2,3,4};
		String[] result3 = solution(orders3,course3);
		for(String s : result3)
			System.out.print(s+ " ");
		System.out.println();
		
	}

}
