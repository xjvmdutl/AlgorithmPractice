package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 폴리오미노 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String str = reader.readLine();
		System.out.println(solution(str));
	}

	private static String solution(String str) {
		StringBuilder sb= new StringBuilder();
		List<Character> list = new ArrayList<>();
		for(int i =0 ;i<str.length();++i) {
			char c = str.charAt(i);
			if(c == '.') {
				if(!list.isEmpty()) {
					int idx = list.size()/4;
					for(int j=0;j<idx;++j) {
						sb.append("AAAA");
					}
					idx = list.size()%4/2;
					for(int j=0;j<idx;++j) {
						sb.append("BB");
					}
					if(list.size()%4%2 != 0)
						return "-1";
				}
				sb.append(c);
				list = new ArrayList<>();
			}else {
				list.add(c);
			}
		}
		if(!list.isEmpty()) {
			int idx = list.size()/4;
			for(int j=0;j<idx;++j) {
				sb.append("AAAA");
			}
			idx = list.size()%4/2;
			for(int j=0;j<idx;++j) {
				sb.append("BB");
			}
			if(list.size()%4%2 != 0)
				return "-1";
		}
		
		
		return sb.toString();
	}

}
