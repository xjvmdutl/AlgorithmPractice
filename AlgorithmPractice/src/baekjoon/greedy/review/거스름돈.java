package baekjoon.greedy.review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class �Ž����� {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int money = Integer.parseInt(reader.readLine());
		System.out.println(solution(1000-money));//�Ž����� 
	}

	private static int solution(int money) {
		int answer = 0;
		int m1 = 500;//�ʱ� 500�� ���� 
		//500 -> 50 -> 5 ����
		int m2 = 100; // �ʱ� 100��
		//100 -> 10 -> 1 ����
		for(int i=0;i<6;++i) {
			if(i%2==0) { 
				//500 , 50, 5������ ���������� (¦�������� ����)
				answer += money/m1;//m1������ �������� ���Ѵ�(���� ���� �� �۴ٸ� 0�� �������� ��� ����)
				money %= m1;//money���� �ش� m1���� ���� ������ ������ ����� �ش�.
				m1/=10;//m1 ���� 10���� ������ = 500 -> 50 -> 5 
			}else {
				//100 , 10, 1 ������ ����������(Ȧ����°�� ����)
				answer += money/m2;
				money %= m2;
				m2/=10;//m2���� 10���� ������ = 100 -> 10 -> 1 
			}
		}
		
		
		return answer;
	}

}
