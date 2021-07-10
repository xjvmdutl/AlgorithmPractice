package backJun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ZOAC2 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String str = reader.readLine();
		System.out.println(solution(str));
	}


	private static int solution(String str) {
		int answer = 0;
		char current = 'A';
		for(int i=0;i<str.length();++i) {
			
			char c = str.charAt(i);
			//¿À¸¥ÂÊ
			int right = c - current;
			int left = current - c;
			
			if(right <=0)
				right += 26;
			else if(left<=0)
				left +=26;
			
			
			current = c;
			answer += Math.min(right, left);
		}
		return answer;
	}

}
