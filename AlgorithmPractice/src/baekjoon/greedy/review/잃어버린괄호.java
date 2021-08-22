package baekjoon.greedy.review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 잃어버린괄호 {
	//이전 풀었던 방식 Stack
	//숫자를 모두 배열에 넣어둔뒤 + 연산 일경우 이전에 Stack에 있는 데이터를 꺼낸뒤에 현재 데이터를 더하구, -연산일 경우 스택에 추가한다.
	//그뒤 stack을 돌면서 연산
	//지금 푼 방식 문자열 풀이
	//-를 기준으로 문자열을 나눈다 -> 두가지 경우를 고려해야된다 1. 초기 음수 데이터 2. 초기 양수 데이터
	//1번 -> example) -50+20-10 => split ['','50+20',10] 이 나온다 
	// 				  해당 데이터를 '+' 를 기준으로 또 분리한다.['' ('50','20'),('10')]
	//				  만약 비어있는 데이터일 경우(첫번쨰 데이터는 무조건 비어있다) 그냥 넘어가구, 만약 1개 이상을 데이터가 나올경우(ex)50,20
	//				  값들의 모두 더한뒤(+연산을 진행)  최종 sum값을 결과값에서 뺴준다.(-연산을 진행)
	//				  -(50+20)-(10) 으로 연산한 것과 같다
	//2번 -> example) 55+20-60+50+20-20+10-5 => split ['55+20','60+50+20','20+10',5]
	//	  해당 데이터를 '+' 를 기준으로 또 분리한다.[('55','20'), ('60','50','20'),('20','10'),('5')]
	//				  만약 1개 이상을 데이터가 나올경우(ex) '55','20'
	//				  값들의 모두 더한뒤(+연산을 진행)  최종 sum값을 결과값에서 뺴준다.(-연산을 진행)
	//				  단,여기서 1번과 차이점은 Index0번을 데이터는 ('55','20') 초기값으로 최종 sum값에 더해주어야 된다.
	//				  75 - 130 - 30 - 5 = 90
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String str = reader.readLine();
		System.out.println(solution(str));
	}

	private static int solution(String str) {
		int answer = 0;
		String[] strs=str.split("-");
		if(str.charAt(0) == '-') {
			for(int i=0;i<strs.length;++i) {
				String s = strs[i];
				StringTokenizer tokens = new StringTokenizer(s,"+");
				int result = 0;
				while(tokens.hasMoreTokens()) {
					result += Integer.parseInt(tokens.nextToken());
				}
				answer -= result;
			}
		}else {
			for(int i=0;i<strs.length;++i) {
				String s = strs[i];
				StringTokenizer tokens = new StringTokenizer(s,"+");
				int result = 0;
				while(tokens.hasMoreTokens()) {
					result += Integer.parseInt(tokens.nextToken());
				}
				if(i==0) {
					answer += result;
					continue;
				}
				answer -= result;
			}
		}
		
	
		return answer;
	}

}
