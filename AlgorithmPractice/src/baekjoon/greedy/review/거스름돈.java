package baekjoon.greedy.review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 거스름돈 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int money = Integer.parseInt(reader.readLine());
		System.out.println(solution(1000-money));//거스름돈 
	}

	private static int solution(int money) {
		int answer = 0;
		int m1 = 500;//초기 500엔 시작 
		//500 -> 50 -> 5 변경
		int m2 = 100; // 초기 100엔
		//100 -> 10 -> 1 변경
		for(int i=0;i<6;++i) {
			if(i%2==0) { 
				//500 , 50, 5엔으로 나누었을떄 (짝수번쨰만 실행)
				answer += money/m1;//m1값으로 나눈값을 더한다(만약 값이 더 작다면 0이 더해져서 상관 없다)
				money %= m1;//money값을 해당 m1으로 나눈 나머지 값으로 만들어 준다.
				m1/=10;//m1 값을 10으로 나눈다 = 500 -> 50 -> 5 
			}else {
				//100 , 10, 1 엔으로 나누었을떄(홀수번째만 실행)
				answer += money/m2;
				money %= m2;
				m2/=10;//m2값을 10으로 나눈다 = 100 -> 10 -> 1 
			}
		}
		
		
		return answer;
	}

}
