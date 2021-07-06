package backJun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문서검색 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String str = reader.readLine();
		String findStr = reader.readLine();
		System.out.println(solution(str,findStr));
	}

	private static int solution(String str, String findStr) {
		int answer = 0;
		int idx = 0;
		while(idx <= str.length() - findStr.length()) {
			StringBuilder sb = new StringBuilder();
			sb.append(str.substring(idx,findStr.length()+idx));
			if(sb.toString().equals(findStr)) {
				answer++;
				idx+=findStr.length();
				continue;
			}
			idx++;
		}
		
		return answer;
	}

}
