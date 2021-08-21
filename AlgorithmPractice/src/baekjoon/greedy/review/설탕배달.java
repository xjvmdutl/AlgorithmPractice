package baekjoon.greedy.review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 설탕배달 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		System.out.println(solution(n));
	}

	private static int solution(int n) {
		int answer = -1;//answer에 값이 안채워 졋을때 -1
		int fiveCount = n/5;//5의 갯수(가장 많은 5의 갯수일때) 
		for(int i=fiveCount;i>=0;--i) {//가장 많은 5의 갯수부터 0개까지
			int r = n - (5*i);//5의 갯수만큼 빼준다
			if((r % 3) == 0) {//만약 3으로 나눳을때의 나머지가 0일때, 5의 갯수가 많을 경우 부터 했으므로 바로 리턴했을때가 최소
				return i + (r / 3);
			}
		}
		return answer;//없을 경우 -1 리턴
	}

}
