package baekjoon.greedy.review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ȸ�ǽǹ��� {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[][] arr = new int[n][2];
		for(int i=0;i<n;++i) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			arr[i][0] = Integer.parseInt(tokens.nextToken());
			arr[i][1] = Integer.parseInt(tokens.nextToken());
		}
		System.out.println(solution(arr,n));
	}

	private static int solution(int[][] arr, int n) {
		
		Arrays.sort(arr,(o1,o2)->{
			if(o1[1] == o2[1]) {
				return o1[0] - o2[0];//return o2[0] - o1[0]; //�̰� �ƴϴ� 
				//�ݷ�
				/*
					6
					1 4
					2 3
					2 4
					3 4
					4 4
					4 5
				*/
				//��밪 : 2 3 , 3 4 , 4 4 , 4 5 = 4
				//����� : 2 3 , 4 4 , 4 5 = 3
				//���� ȸ�� ����ð��� ������� ���۽ð��� ������������ �����ؾߵȴ�.
			}
			return o1[1] - o2[1]; //���� ����Ǵ� ȸ�ǽð��� �������� �������� ����
		});
		int time = 0;
		int answer = 0;
		for(int i=0;i<arr.length;++i) {
			if(time <= arr[i][0]) {// ���� �ð� ���� ȸ�� ���۽ð����� �������
				answer++;//���� �߰�
				time = arr[i][1];//�ð� ����
			}
		}
		return answer;
	}

}
