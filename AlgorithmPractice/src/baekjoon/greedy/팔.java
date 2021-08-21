package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ÆÈ {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		long l = Long.parseLong(strs[0]);
		long r = Long.parseLong(strs[1]);
		System.out.println(solution(l,r));
		
	}

	private static int solution(long l, long r) {
		int answer = 0;
        if(r - l < 0)
            return -1;
		long tmp = r-l;
		int count = 0;
		while(tmp > 0) {
			count++;
			tmp/=10;
		}
		while(l > 0) {
			if(count >0) {
				count--;
				l/=10;
				continue;
			}
			if(l%10 == 8) {
				answer++;
			}
			l/=10;
		}
		
		return answer;
	}

}
