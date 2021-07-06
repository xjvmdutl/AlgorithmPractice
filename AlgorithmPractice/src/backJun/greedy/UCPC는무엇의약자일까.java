package backJun.greedy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UCPC는무엇의약자일까 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String str = reader.readLine();
		System.out.println(solution(str));
	}

	private static String solution(String str) {
		StringBuilder sb= new StringBuilder("UCPC");
		int idx = 0;
		for(char c : str.toCharArray()) {
			if(idx<4 && c == sb.charAt(idx) ) {
				idx++;
				if(idx == 4)
					return "I love UCPC";
			}
		}
		return "I hate UCPC";
	}

}
