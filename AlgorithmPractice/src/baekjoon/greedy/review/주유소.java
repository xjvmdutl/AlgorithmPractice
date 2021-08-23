package baekjoon.greedy.review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ������ {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		long[] road = new long[n-1];
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		for(int i=0;i<road.length;++i) {
			road[i] = Long.parseLong(tokens.nextToken());
		}
		long[] price = new long[n];
		tokens = new StringTokenizer(reader.readLine());
		for(int i=0;i<n-1;++i) {
			price[i] = Long.parseLong(tokens.nextToken());
		}
		System.out.println(solution(road,price,n));
	}

	private static long solution(long[] road, long[] price, int n) {
		
		/*
		 * 4
		 * 2 3 1
		 * 5 2 4 1
		 * */
		
		long minPrice = price[0];//�ʱ� �� // ���� 5
		long sum = 0;//ó������ �Ȼ��
		for(int i=0;i<price.length-1;++i) {
			if(minPrice > price[i]) {//�� �Ѱ��� �⸧ �Ĵ°��� �ִٸ�
				minPrice = price[i];//�� �Ѱ��� �⸧�� ���
			}
			sum += road[i] * minPrice;//�Ѱ��� �⸧���� ���� ��� �����ش�
		}
		return sum;
	}

}
