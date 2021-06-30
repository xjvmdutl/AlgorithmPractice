package progammers.level2;

import java.util.HashMap;
import java.util.Map;

public class ���ڿ����� {
	public static int solution(String s) {
		int min = s.length();

	      for (int i = 1; i <= s.length(); i++) {
	        int compLeng = compression(s, i).length();
	        min = Math.min(min, compLeng);
	      }

	      return min;
	}
	private static String compression(String str, int i) {	
		int count = 1;
		String compression = "";
		String pattern = "";
		for (int j = 0; j <= str.length() + i; j += i) {
			String nowStr;

	        // �� ���ڿ��� ���� ���� ���ڿ�
	        if (j >= str.length()) { // ���� ���ڿ��� ���� ��
	          nowStr = "";
	        } else if (str.length() < j + i) { // ������ ���� ���ڿ��� ��
	          nowStr = str.substring(j);
	        } else {
	          nowStr = str.substring(j, j + i); // �� ��
	        }
	        // 1. �� ���ڿ��̶� �Ȱ����� ���Ѵ�. (�� ó���̸� �� X)
	        if (j != 0) {
	          if (nowStr.equals(pattern)) { // �Ȱ�����
	            count++;
	          } else if (count >= 2) { // �ٸ��� count�� 2ȸ �̻��̸� ���� ����
	            compression += count + pattern;
	            count = 1;
	          } else { // ���� �Ұ����ϸ� �׳� �״�� ���ڿ� �̾���̱�
	            compression += pattern;
	          }
	        }
	        // 2. i ���̸�ŭ ���ڿ��� �ڸ���.
	        pattern = nowStr;
		}
		return compression;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//s	result
		//"aabbaccc"	7
		//"ababcdcdababcdcd"	9
		//"abcabcdede"	8
		//"abcabcabcabcdededededede"	14
		//"xababcdcdababcdcd"	17
		String s1 = "aabbaccc";
		System.out.println(solution(s1));
		String s2 = "ababcdcdababcdcd";
		System.out.println(solution(s2));
		String s3 = "abcabcdede";
		System.out.println(solution(s3));
		String s4 = "abcabcabcabcdededededede";
		System.out.println(solution(s4));
		String s5 = "xababcdcdababcdcd";
		System.out.println(solution(s5));
		
	}

}
