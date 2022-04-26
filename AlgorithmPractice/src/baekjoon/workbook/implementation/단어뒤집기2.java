package baekjoon.workbook.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 단어뒤집기2 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String s = reader.readLine();
		System.out.println(solution(s));
	}

	private static String solution(String s) {
		StringBuilder answer = new StringBuilder();
		StringBuilder content = new StringBuilder();
		for(int i=0;i<s.length();++i) {
			if(isOpenTag(s.charAt(i))) {
				if(!isEmpty(content)) {
					answer.append(content.reverse());
					content = new StringBuilder();
				}
				int closeIndex = findClosTag(s, i);
				answer.append(s.substring(i, closeIndex + 1));
				i = closeIndex;
			}else if(isJumpTag(s.charAt(i)) || isLastIndex(i, s.length()-1)) {
				if(isLastIndex(i, s.length()-1)) {
					content.append(s.charAt(i));
					answer.append(content.reverse());
				}else {
					answer.append(content.reverse() + " ");
				}
				content = new StringBuilder();
			}else if(Character.isAlphabetic(s.charAt(i)) || Character.isDigit(s.charAt(i))) {
				content.append(s.charAt(i));
			}
		}
		
		return answer.toString();
	}

	
	

	private static boolean isEmpty(StringBuilder content) {
		return content.length() == 0;
	}

	private static boolean isLastIndex(int index, int last) {
		return index == last;
	}

	private static int findClosTag(String s, int index) {
		for(int i=index;i<s.length();++i) {
			if(isCloseTage(s.charAt(i))) {
				return i;
			}
		}
		throw new IllegalArgumentException();
	}

	private static boolean isOpenTag(char c) {
		return c == '<';
	}
	
	private static boolean isCloseTage(char c) {
		return c == '>';
	}
	
	private static boolean isJumpTag(char c) {
		return c == ' ';
	}

}
