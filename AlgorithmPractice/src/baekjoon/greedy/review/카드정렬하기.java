package baekjoon.greedy.review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class 카드정렬하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[] arr = new int[n];
		for(int i=0;i<n;++i) {
			arr[i] = Integer.parseInt(reader.readLine());
		}
		System.out.println(solution(arr,n));
	}

	private static int solution(int[] arr, int n) {
		int answer = 0;
		Queue<Integer> que = new PriorityQueue<>();//우선순위 큐 선언
		for(int i=0;i<arr.length;++i) {
			que.offer(arr[i]);//que에 모든 데이터를 넣어둔다
		}
		while(que.size() >= 2) {//que의 크기가 2이상일 경우 반복
			int n1 = que.poll();//que중 가장 작은 데이터
			int n2 = que.poll();//que중 2번째로 작은 데이터
			answer += n1 + n2;//두값을 더한뒤
			que.offer(n1+n2);//다시 que에 넣어 우선순위를 판별한다.
		}
		return answer;
	}

}
