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
		Arrays.sort(p);//���� ������ ���� -> ��ٸ��� �ð��� ���� ������� �����ؾ� �ּ������� ��ٸ��� �ð��� ���´�
		int sum = 0;
		for(int i=0;i<n;++i) {
			sum += p[i];//��ٸ��� �ð�
			answer += sum;//�� ��ٸ��� �ð��� ���� ��ٸ� �ð��� ���Ѵ�.
		}
		return answer;
	}

}
