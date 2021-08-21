package baekjoon.greedy.review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ������� {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		System.out.println(solution(n));
	}

	private static int solution(int n) {
		int answer = -1;//answer�� ���� ��ä�� ������ -1
		int fiveCount = n/5;//5�� ����(���� ���� 5�� �����϶�) 
		for(int i=fiveCount;i>=0;--i) {//���� ���� 5�� �������� 0������
			int r = n - (5*i);//5�� ������ŭ ���ش�
			if((r % 3) == 0) {//���� 3���� ���������� �������� 0�϶�, 5�� ������ ���� ��� ���� �����Ƿ� �ٷ� ������������ �ּ�
				return i + (r / 3);
			}
		}
		return answer;//���� ��� -1 ����
	}

}
