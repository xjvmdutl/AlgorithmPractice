package baekjoon.greedy.review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 캠핑 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int count = 0;
		while(true) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			int l = Integer.parseInt(tokens.nextToken());
			int p = Integer.parseInt(tokens.nextToken());
			int v = Integer.parseInt(tokens.nextToken());
			if(l == 0 && p == 0 && v == 0)
				break;
			System.out.println("Case " + ++count + ": " + solution(l,p,v));
		}
	}

	private static int solution(int l, int p, int v) {
		int answer = 0;
		answer += (v/p) * l;//총휴가일수중 캠핑을 갈수있는 횟수 * 사용할수 있는 기간
		v%=p;//남은 기간은 v
		if(v > l) {//남은기간 > 캠핑갈수 있는 기간
			answer += l;//캠핑갈수있는 기간을 더해준다.
		}else {
			answer += v;//남은기간을 더해준다
		}
		return answer;
	}

}
