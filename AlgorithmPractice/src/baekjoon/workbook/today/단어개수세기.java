package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 단어개수세기 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(solution(reader.readLine()));
	}

	private static int solution(String str) {
		int answer = 0;
		StringTokenizer token = new StringTokenizer(str);
		while(token.hasMoreTokens()) {
			StringTokenizer nextToken = new StringTokenizer(token.nextToken(), "-");
			while(nextToken.hasMoreTokens()) {
				answer++;
				String next = nextToken.nextToken();
				next = next
						.replaceAll("c\'", "0")
						.replaceAll("j\'", "1")
						.replaceAll("n\'", "2")
						.replaceAll("m\'", "3")
						.replaceAll("t\'", "4")
						.replaceAll("s\'", "5")
						.replaceAll("l\'", "6")
						.replaceAll("d\'", "7")
						.replaceAll("qu\'", "8");
				if(Character.isDigit(next.charAt(0))) {
					char c = next.charAt(1);
					if(c == 'a' || c =='e' || c == 'i' || c == 'o' || c== 'u' || c=='h')
						answer++;
				}
			}
		}
		return answer;
	}

}
