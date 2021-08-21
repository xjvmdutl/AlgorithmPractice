package baekjoon.stepbystep.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class »ó¼ö {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine()," ");
		String n1 = tokens.nextToken();
		String n2 = tokens.nextToken();
		System.out.println(solution(n1,n2));
	}

	private static int solution(String n1, String n2) {
		StringBuilder sb1 = new StringBuilder(n1);
		int reverseN1 = Integer.parseInt(sb1.reverse().toString());
		StringBuilder sb2 = new StringBuilder(n2);
		int reverseN2 = Integer.parseInt(sb2.reverse().toString());
		
		return reverseN1 > reverseN2 ? reverseN1 : reverseN2;
	}

}
