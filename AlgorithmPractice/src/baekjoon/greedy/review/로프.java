package baekjoon.greedy.review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ���� {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[] arr = new int[n];
		for(int i=0;i<n;++i)
			arr[i] = Integer.parseInt(reader.readLine());
		System.out.println(solution(arr,n));
	}

	private static int solution(int[] arr, int n) {
		int answer = 0;
		int[] reverse = Arrays.stream(arr).boxed().sorted((o1,o2)->o2-o1).mapToInt(Integer::intValue).toArray();
		//���ſ� ������ ���� 
		/*
		 * ����
		 * 3
		 * 10
		 * 20
		 * 50
		 * 
		 * */
		// 50 20 10 ���� ������ �ǰ�, �ش� ���� ���������� ������ �Ҽ� �ִ°��� �ش� index+1 ���� ���õ� ���� ���Ѱ��̴�.
		// �̰�� 50 *1 , 20 * 2, 10 *3  => 3���� ��찡 ���ü� �ִµ� ����ó�� �ϴ°� ���� 50�ϳ��� ó���ϴ°��� �� ũ��.
		for(int i=0;i<reverse.length;++i) {
			int count = i+1;
			answer = Math.max(answer, count*reverse[i]);
		}
		
		
		return answer;
	}

}
