package baekjoon.greedy.review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class ī�������ϱ� {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[] arr = new int[n];
		for(int i=0;i<n;++i) {
			arr[i] = Integer.parseInt(reader.readLine());
		}
		System.out.println(solution(arr,n));
	}

	private static int solution(int[] arr, int n) {
		int answer = 0;
		Queue<Integer> que = new PriorityQueue<>();//�켱���� ť ����
		for(int i=0;i<arr.length;++i) {
			que.offer(arr[i]);//que�� ��� �����͸� �־�д�
		}
		while(que.size() >= 2) {//que�� ũ�Ⱑ 2�̻��� ��� �ݺ�
			int n1 = que.poll();//que�� ���� ���� ������
			int n2 = que.poll();//que�� 2��°�� ���� ������
			answer += n1 + n2;//�ΰ��� ���ѵ�
			que.offer(n1+n2);//�ٽ� que�� �־� �켱������ �Ǻ��Ѵ�.
		}
		return answer;
	}

}
