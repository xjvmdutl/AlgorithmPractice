package baekjoon.stepbystep.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 단어의개수 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String str = reader.readLine();
		System.out.println(solution(str));
	}

	private static int solution(String str) {
		if("".equals(str))
			return 0;
		str = str.trim();
		StringTokenizer tokens = new StringTokenizer(str," ");
		return tokens.countTokens();
	}
	

}
