package baekjoon.greedy.review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ������ {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String str = reader.readLine();
		System.out.println(solution(str));
	}

	private static int solution(String str) {
		int answer = 0;
		//010111 �ݷ�
		int now = str.charAt(0);
		for(int i=1;i<str.length();++i) {
			char c = str.charAt(i);
			if(now != c) {//���� ���̶� �ٸ����
				for(int j = i;j<str.length();++j) {//�ٸ��������� �̵�
					if(c != str.charAt(j)) {//�ٸ�����
						i= j-1;
						break;
					}else if(j == str.length()-1){//�ٸ������� ���ٸ�
						i= j;
					}
				}
				answer++;
			}
		}
		
		
		return answer;
	}

}
