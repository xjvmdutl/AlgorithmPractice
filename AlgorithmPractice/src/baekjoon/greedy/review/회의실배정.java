package baekjoon.greedy.review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 회의실배정 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[][] arr = new int[n][2];
		for(int i=0;i<n;++i) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			arr[i][0] = Integer.parseInt(tokens.nextToken());
			arr[i][1] = Integer.parseInt(tokens.nextToken());
		}
		System.out.println(solution(arr,n));
	}

	private static int solution(int[][] arr, int n) {
		
		Arrays.sort(arr,(o1,o2)->{
			if(o1[1] == o2[1]) {
				return o1[0] - o2[0];//return o2[0] - o1[0]; //이거 아니다 
				//반례
				/*
					6
					1 4
					2 3
					2 4
					3 4
					4 4
					4 5
				*/
				//기대값 : 2 3 , 3 4 , 4 4 , 4 5 = 4
				//결과값 : 2 3 , 4 4 , 4 5 = 3
				//따라서 회의 종료시간이 같을경우 시작시간을 오름차순으로 정렬해야된다.
			}
			return o1[1] - o2[1]; //먼저 종료되는 회의시간을 기준으로 오름차순 정렬
		});
		int time = 0;
		int answer = 0;
		for(int i=0;i<arr.length;++i) {
			if(time <= arr[i][0]) {// 현재 시간 보다 회의 시작시간보다 빠를경우
				answer++;//갯수 추가
				time = arr[i][1];//시간 변경
			}
		}
		return answer;
	}

}
