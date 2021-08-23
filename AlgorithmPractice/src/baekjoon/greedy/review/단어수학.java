package baekjoon.greedy.review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class �ܾ���� {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		String[] str = new String[n];
		for(int i=0;i<n;++i)
			str[i] = reader.readLine();
		System.out.println(solution(str,n));
	}

	private static int solution(String[] str, int n) {
		int answer = 0;
		int[] dir = new int['Z' - 'A' +1];//��������� �� �������� �迭
		for(int i=0;i<str.length;++i) {
			int l = 1;
			for(int j=str[i].length()-1;j>=0;--j) {
				char c = str[i].charAt(j);//���� ���� �ܾ�
				dir[c - 'A'] += l;//�ش� �ܾ��� �ڸ��� * 1 �� ���Ѵ�.
				l*=10;
			}
		}
		int[] reverse = Arrays.stream(dir).boxed().sorted((o1,o2)->o2-o1).mapToInt(Integer::intValue).toArray();
		//������������ ����
		int idx = 9;
		for(int i=0;i<reverse.length;++i) {
			if(reverse[i] == 0)
				break;
			answer += reverse[i] * idx;
			//9���� ���� �����ؼ� �����ش�.
			idx--;
		}
		return answer;
	}

}
