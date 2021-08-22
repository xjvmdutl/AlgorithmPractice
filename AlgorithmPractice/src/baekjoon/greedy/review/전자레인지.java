package baekjoon.greedy.review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 전자레인지 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		System.out.println(solution(t));
	}

	private static String solution(int t) {
		StringBuilder sb = new StringBuilder();
		int a = 300;//5분
		int b = 60;//1분
		int c = 10;//10초
		sb.append(t/a + " ");//5분으로 나눈값
		t %= a;
		sb.append(t/b + " ");//1분으로 나눈값
		t %= b;
		sb.append(t/c);//10초로 나눈값
		t %= c;
		if(t > 0) {//만약 값이 남아 있다면 3개의 버튼으로 조합이 안된다.
			//-1값을 리턴
			sb= new StringBuilder("-1");
		}
		return sb.toString();
	}

}
