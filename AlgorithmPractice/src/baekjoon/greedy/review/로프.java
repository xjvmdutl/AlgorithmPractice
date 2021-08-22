package baekjoon.greedy.review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 로프 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[] arr = new int[n];
		for(int i=0;i<n;++i)
			arr[i] = Integer.parseInt(reader.readLine());
		System.out.println(solution(arr,n));
	}

	private static int solution(int[] arr, int n) {
		int answer = 0;
		int[] reverse = Arrays.stream(arr).boxed().sorted((o1,o2)->o2-o1).mapToInt(Integer::intValue).toArray();
		//무거운 순으로 정렬 
		/*
		 * 예제
		 * 3
		 * 10
		 * 20
		 * 50
		 * 
		 * */
		// 50 20 10 으로 정렬이 되고, 해당 값을 병렬적으로 적용을 할수 있는것은 해당 index+1 값에 선택된 값을 곱한것이다.
		// 이경우 50 *1 , 20 * 2, 10 *3  => 3가지 경우가 나올수 있는데 병렬처리 하는것 보다 50하나가 처리하는것이 더 크다.
		for(int i=0;i<reverse.length;++i) {
			int count = i+1;
			answer = Math.max(answer, count*reverse[i]);
		}
		
		
		return answer;
	}

}
