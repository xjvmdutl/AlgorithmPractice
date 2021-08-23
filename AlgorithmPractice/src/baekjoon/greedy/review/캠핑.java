package baekjoon.greedy.review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ķ�� {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int count = 0;
		while(true) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			int l = Integer.parseInt(tokens.nextToken());
			int p = Integer.parseInt(tokens.nextToken());
			int v = Integer.parseInt(tokens.nextToken());
			if(l == 0 && p == 0 && v == 0)
				break;
			System.out.println("Case " + ++count + ": " + solution(l,p,v));
		}
	}

	private static int solution(int l, int p, int v) {
		int answer = 0;
		answer += (v/p) * l;//���ް��ϼ��� ķ���� �����ִ� Ƚ�� * ����Ҽ� �ִ� �Ⱓ
		v%=p;//���� �Ⱓ�� v
		if(v > l) {//�����Ⱓ > ķ�ΰ��� �ִ� �Ⱓ
			answer += l;//ķ�ΰ����ִ� �Ⱓ�� �����ش�.
		}else {
			answer += v;//�����Ⱓ�� �����ش�
		}
		return answer;
	}

}
