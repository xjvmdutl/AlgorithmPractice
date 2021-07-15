package backJun.stepBystep.oneArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class OXÄûÁî {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		for(int i=0;i<t;++i) {
			System.out.println(solution(reader.readLine()));
		}
		
	}

	private static int solution(String s) {
		Stack<Character> stack = new Stack<>();
		int answer = 0;
		for(char c : s.toCharArray()) {
			if(c == 'O') {
				stack.push(c);
				answer+=stack.size();
			}else
				stack.clear();
		}
		return answer;
	}

}
