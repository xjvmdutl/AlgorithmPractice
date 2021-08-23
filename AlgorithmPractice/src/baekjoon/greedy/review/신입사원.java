package baekjoon.greedy.review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 신입사원 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		for(int i=0;i<t;++i) {
			int n = Integer.parseInt(reader.readLine());
			int[] arr = new int[n];
			for(int j=0;j<n;++j) {
				StringTokenizer tokens = new StringTokenizer(reader.readLine());
				arr[Integer.parseInt(tokens.nextToken())-1] = Integer.parseInt(tokens.nextToken())-1;
				//첫번째 시험 등수를 Index로 하여 2번째 시험 등수값을 넣어준다
			}
			System.out.println(solution(arr));
		}
	}

	private static int solution(int[] arr) {
		int answer = 1;
		int score = arr[0];//arr[0]번째는 첫번째 시험에서 1등을 했기때문에 무조건 합격이다.
		for(int i=1;i<arr.length;++i) {
			//for문을 진행할 떄 첫번쨰 시험은 무조건 졋기 때문에 두번째 시험은 이겨야된다.
			if(score > arr[i]) {
				score = arr[i];//두번째 시험통과한 가장 작은값을 score에 담는다
				answer++;//시험에 통과했기 때문에 하나씩 증가
			}
		}
		
		
		return answer;
	}

}
