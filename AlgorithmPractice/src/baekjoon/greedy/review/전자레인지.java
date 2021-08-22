package baekjoon.greedy.review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ���ڷ����� {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		System.out.println(solution(t));
	}

	private static String solution(int t) {
		StringBuilder sb = new StringBuilder();
		int a = 300;//5��
		int b = 60;//1��
		int c = 10;//10��
		sb.append(t/a + " ");//5������ ������
		t %= a;
		sb.append(t/b + " ");//1������ ������
		t %= b;
		sb.append(t/c);//10�ʷ� ������
		t %= c;
		if(t > 0) {//���� ���� ���� �ִٸ� 3���� ��ư���� ������ �ȵȴ�.
			//-1���� ����
			sb= new StringBuilder("-1");
		}
		return sb.toString();
	}

}
