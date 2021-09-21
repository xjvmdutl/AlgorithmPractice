package baekjoon.greedy.review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 뒤집기 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String str = reader.readLine();
		System.out.println(solution(str));
	}

	private static int solution(String str) {
		int answer = 0;
		//010111 반례
		int now = str.charAt(0);
		for(int i=1;i<str.length();++i) {
			char c = str.charAt(i);
			if(now != c) {//시작 값이랑 다를경우
				for(int j = i;j<str.length();++j) {//다른지점까지 이동
					if(c != str.charAt(j)) {//다른지점
						i= j-1;
						break;
					}else if(j == str.length()-1){//다른지점이 없다면
						i= j;
					}
				}
				answer++;
			}
		}
		
		
		return answer;
	}

}
