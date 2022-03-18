package test.ahnlab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test01 {
	public static int solution(String[] s) {
		int answer = 0;
		Arrays.sort(s, (o1, o2) -> o2.length() - o1.length()); // ����� ��� Ž��
		for (String str : s) {
			List<Character> numList = new ArrayList<>();// ����
			List<Character> chList = new ArrayList<>();// ����
			List<Character> scList = new ArrayList<>();// Ư������
			for (char c : str.toCharArray()) {
				if (Character.isDigit(c)) {
					numList.add(Character.toLowerCase(c));
				} else if (Character.isAlphabetic(c)) {
					chList.add(c);
				} else if (c == '!' || c == '@' || c == '#' || c == '$' || c == '%' || c == '^' || c == '&'
						|| c == '*') {
					scList.add(c);
				} else
					throw new IllegalArgumentException("");
			}
			if (pelinford(numList, chList, scList)) {
				answer = str.length();
				break;
			}
		}
		return answer;
	}

	private static boolean pelinford(List<Character> numList, List<Character> chList, List<Character> scList) {
		// ���� üũ
		for (int i = 0; i < numList.size() / 2; i++) {
			if (numList.get(i) != numList.get(numList.size() - 1 - i)) {
				return false;
			}
		}
		// ���� üũ
		for (int i = 0; i < chList.size() / 2; i++) {
			if (chList.get(i) != chList.get(chList.size() - 1 - i)) {
				return false;
			}
		}
		// Ư������ üũ
		for (int i = 0; i < scList.size() / 2; i++) {
			if (scList.get(i) != scList.get(scList.size() - 1 - i)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String[] strs = {"!!7"};
		System.out.println(solution(strs));
	}

}
