package baekjoon.avatar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ¼¼¼ö {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int a = Integer.parseInt(tokens.nextToken());
		int b = Integer.parseInt(tokens.nextToken());
		int c = Integer.parseInt(tokens.nextToken());
		System.out.println(solution(a,b,c));
	}

	private static int solution(int a, int b, int c) {
		if(a < b) {
			if(c <= a) {
				return a;
			}else if(b <= c) {
				return b;
			}else {
				return c;
			}
		}else if(b < c) {
			if(a >= c) {
				return c;
			}else {
				return a;
			}
		}else {
			return b;
		}
	}

}
