package baekjoon.greedy.review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class �������� {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		long s = Long.parseLong(reader.readLine());
		System.out.println(solution(s));
	}

	private static int solution(long s) {
		long sum = 0;
		int idx = 1;
		for(idx=1;sum < s;++idx) {//1���� �����Ͽ� �յ��� �ִ밡 �Ǵ� ���� ���Ѵ�.
			sum += idx;
		}
		idx--;//for������ ���Ͽ� idx���� �ϳ� �����߱� ������ ���ҽ�Ų��
		if(sum == s) {//���� �� �������� ������ ��� (1,3,6,10,.... �ϰ�� )
			return idx; // ���� �����Ѵ�.
		}else {
			return idx - 1;//�� ���ڱ����� ������ �ִ밹���̴�.
		}
	}

}
