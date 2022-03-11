package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 비트우정지수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		while(t-- > 0) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			System.out.println(solution(tokens.nextToken(), tokens.nextToken()));
		}
	}

	private static int solution(String str1, String str2) {
		int zeroCount = 0;
		int oneCount = 0;
		for(int i=0;i<str1.length();++i) {
			if(str1.charAt(i) != str2.charAt(i)) {
				if(str1.charAt(i) == '0')
					zeroCount++;
				else
					oneCount++;
			}
		}
		return Math.max(zeroCount, oneCount);
	}

}
