package baekjoon.problems.algorithmPratice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


public class ¿ùµåÄÅ {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = new String[4]; 
		for(int i=0;i<4;++i) {
			str[i] =reader.readLine();
		}
				
				
		System.out.println(solution(str));
	}

	private static String solution(String[] strs) {
		StringBuilder sb = new StringBuilder();
		Map<Integer,Integer> map1 = new HashMap<>();
		Map<Integer,Integer> map2 = new HashMap<>();
		Map<Integer,Integer> map3 = new HashMap<>();
		Map<Integer,Integer> map4 = new HashMap<>();
		init(map1,map2,map3,map4);
		OUTER:for(String str : strs) {
			StringTokenizer tokens = new StringTokenizer(str);
			boolean[] isOkay = new boolean[4];
			for(int i=0;i<6;++i) {
				int s = Integer.parseInt(tokens.nextToken())*100;
				int m = Integer.parseInt(tokens.nextToken())*10;
				int f = Integer.parseInt(tokens.nextToken());
				int result = s+m+f;
				if(map1.get(i) != result) {
					isOkay[0] = true;
				}
				if(map2.get(i) != result) {
					isOkay[1] = true;
				}
				if(map3.get(i) != result) {
					isOkay[2] = true;
				}
				if(map4.get(i) != result) {
					isOkay[3] = true;
				}
			}
			for(int i=0;i<4;++i) {
				if (!isOkay[i]) {
					if(i == 0 || i == 1) {
						sb.append(1 + " ");
					}else {
						sb.append(0 + " ");
					}
					continue OUTER;
				}
			}
			sb.append(0 + " ");
		}
		return sb.toString();
	}

	private static void init(Map<Integer, Integer> map1, Map<Integer, Integer> map2, Map<Integer, Integer> map3,
			Map<Integer, Integer> map4) {
		map1.put(0, 500);
		map1.put(1, 302);
		map1.put(2, 203);
		map1.put(3, 5);
		map1.put(4, 401);
		map1.put(5, 104);
		
		map2.put(0, 410);
		map2.put(1, 302);
		map2.put(2, 410);
		map2.put(3, 113);
		map2.put(4, 5);
		map2.put(5, 113);
		
		map3.put(0, 500);
		map3.put(1, 401);
		map3.put(2, 221);
		map3.put(3, 203);
		map3.put(4, 104);
		map3.put(5, 5);
		
		map4.put(0, 500);
		map4.put(1, 311);
		map4.put(2, 211);
		map4.put(3, 203);
		map4.put(4, 5);
		map4.put(5, 104);
		
		
	}

}
