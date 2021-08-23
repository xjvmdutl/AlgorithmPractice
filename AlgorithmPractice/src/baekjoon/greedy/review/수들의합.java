package baekjoon.greedy.review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 수들의합 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		long s = Long.parseLong(reader.readLine());
		System.out.println(solution(s));
	}

	private static int solution(long s) {
		long sum = 0;
		int idx = 1;
		for(idx=1;sum < s;++idx) {//1부터 시작하여 합들이 최대가 되는 값을 구한다.
			sum += idx;
		}
		idx--;//for문으로 인하여 idx값이 하나 증가했기 때문에 감소시킨다
		if(sum == s) {//만약 딱 떨어지는 숫자일 경우 (1,3,6,10,.... 일경우 )
			return idx; // 값을 리턴한다.
		}else {
			return idx - 1;//전 숫자까지의 갯수가 최대갯수이다.
		}
	}

}
