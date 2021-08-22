package baekjoon.greedy.review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class �Ҿ������ȣ {
	//���� Ǯ���� ��� Stack
	//���ڸ� ��� �迭�� �־�е� + ���� �ϰ�� ������ Stack�� �ִ� �����͸� �����ڿ� ���� �����͸� ���ϱ�, -������ ��� ���ÿ� �߰��Ѵ�.
	//�׵� stack�� ���鼭 ����
	//���� Ǭ ��� ���ڿ� Ǯ��
	//-�� �������� ���ڿ��� ������ -> �ΰ��� ��츦 ����ؾߵȴ� 1. �ʱ� ���� ������ 2. �ʱ� ��� ������
	//1�� -> example) -50+20-10 => split ['','50+20',10] �� ���´� 
	// 				  �ش� �����͸� '+' �� �������� �� �и��Ѵ�.['' ('50','20'),('10')]
	//				  ���� ����ִ� �������� ���(ù���� �����ʹ� ������ ����ִ�) �׳� �Ѿ��, ���� 1�� �̻��� �����Ͱ� ���ð��(ex)50,20
	//				  ������ ��� ���ѵ�(+������ ����)  ���� sum���� ��������� ���ش�.(-������ ����)
	//				  -(50+20)-(10) ���� ������ �Ͱ� ����
	//2�� -> example) 55+20-60+50+20-20+10-5 => split ['55+20','60+50+20','20+10',5]
	//	  �ش� �����͸� '+' �� �������� �� �и��Ѵ�.[('55','20'), ('60','50','20'),('20','10'),('5')]
	//				  ���� 1�� �̻��� �����Ͱ� ���ð��(ex) '55','20'
	//				  ������ ��� ���ѵ�(+������ ����)  ���� sum���� ��������� ���ش�.(-������ ����)
	//				  ��,���⼭ 1���� �������� Index0���� �����ʹ� ('55','20') �ʱⰪ���� ���� sum���� �����־�� �ȴ�.
	//				  75 - 130 - 30 - 5 = 90
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String str = reader.readLine();
		System.out.println(solution(str));
	}

	private static int solution(String str) {
		int answer = 0;
		String[] strs=str.split("-");
		if(str.charAt(0) == '-') {
			for(int i=0;i<strs.length;++i) {
				String s = strs[i];
				StringTokenizer tokens = new StringTokenizer(s,"+");
				int result = 0;
				while(tokens.hasMoreTokens()) {
					result += Integer.parseInt(tokens.nextToken());
				}
				answer -= result;
			}
		}else {
			for(int i=0;i<strs.length;++i) {
				String s = strs[i];
				StringTokenizer tokens = new StringTokenizer(s,"+");
				int result = 0;
				while(tokens.hasMoreTokens()) {
					result += Integer.parseInt(tokens.nextToken());
				}
				if(i==0) {
					answer += result;
					continue;
				}
				answer -= result;
			}
		}
		
	
		return answer;
	}

}
