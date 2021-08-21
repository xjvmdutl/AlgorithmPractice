package baekjoon.greedy.review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ����0 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int N = Integer.parseInt(tokens.nextToken());
		int K = Integer.parseInt(tokens.nextToken());
		int[] collect = new int[N];
		for(int i=0;i<N;++i) {
			collect[i] = Integer.parseInt(reader.readLine());
		}
		System.out.println(solution(K,collect));
	}

	private static int solution(int k, int[] collect) {
		int[] reverseSort = Arrays.stream(collect).boxed().sorted((o1,o2)->o2-o1).mapToInt(Integer::intValue).toArray();
		//��ѵ����� ����
		int answer = 0;
		for(int money : reverseSort) {
			answer += k/money;//��ѵ����� �������� answer�� ���ѵ�
			k %= money;//������ ������ k�� �����Ѵ�.
		}
		return answer;
	}

}
