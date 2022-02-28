package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class πŒ±’¿Ã¿«∫Òπ–π¯»£ {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		String[] strs = new String[n];
		for(int i=0;i<n;++i) {
			strs[i] = reader.readLine();
		}
		System.out.println(solution(strs, n));
	}

	private static String solution(String[] strs, int n) {	
		Set<String> set = new HashSet<>();
		for(int i=0;i<n;++i) {
			StringBuilder sb = new StringBuilder(strs[i]);
			set.add(sb.reverse().toString());
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;++i) {
			if(set.contains(strs[i])) {
				sb.append(strs[i].length() + " "  + strs[i].charAt(strs[i].length()/2));
				return sb.toString();
			}
		}
		
		return sb.toString();
	}

}
