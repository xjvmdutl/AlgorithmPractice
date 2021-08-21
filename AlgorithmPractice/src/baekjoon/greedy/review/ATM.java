package baekjoon.greedy.review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ATM {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[] p = new int[n];
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		for(int i = 0 ;i<n;++i)
			p[i] = Integer.parseInt(tokens.nextToken());
		System.out.println(solution(n,p));
	}

	private static int solution(int n, int[] p) {
		int answer = 0;
		Arrays.sort(p);//작은 순으로 정렬 -> 기다리는 시간이 적은 순서대로 정렬해야 최소한으로 기다리는 시간이 나온다
		int sum = 0;
		for(int i=0;i<n;++i) {
			sum += p[i];//기다리는 시간
			answer += sum;//총 기다리는 시간에 각각 기다린 시간을 더한다.
		}
		return answer;
	}

}
