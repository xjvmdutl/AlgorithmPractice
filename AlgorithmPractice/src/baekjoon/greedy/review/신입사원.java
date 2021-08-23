package baekjoon.greedy.review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ���Ի�� {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		for(int i=0;i<t;++i) {
			int n = Integer.parseInt(reader.readLine());
			int[] arr = new int[n];
			for(int j=0;j<n;++j) {
				StringTokenizer tokens = new StringTokenizer(reader.readLine());
				arr[Integer.parseInt(tokens.nextToken())-1] = Integer.parseInt(tokens.nextToken())-1;
				//ù��° ���� ����� Index�� �Ͽ� 2��° ���� ������� �־��ش�
			}
			System.out.println(solution(arr));
		}
	}

	private static int solution(int[] arr) {
		int answer = 1;
		int score = arr[0];//arr[0]��°�� ù��° ���迡�� 1���� �߱⶧���� ������ �հ��̴�.
		for(int i=1;i<arr.length;++i) {
			//for���� ������ �� ù���� ������ ������ ���� ������ �ι�° ������ �̰ܾߵȴ�.
			if(score > arr[i]) {
				score = arr[i];//�ι�° ��������� ���� �������� score�� ��´�
				answer++;//���迡 ����߱� ������ �ϳ��� ����
			}
		}
		
		
		return answer;
	}

}
