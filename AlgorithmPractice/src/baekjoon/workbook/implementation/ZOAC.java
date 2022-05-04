package baekjoon.workbook.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ZOAC {
	static class Grammer{
		private char c;
		private int index;
		public Grammer(int index, char c) {
			this.c = c;
			this.index = index;
		}
	}
	private static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String str = reader.readLine();
		System.out.println(solution(str));
	}

	private static String solution(String str) {
		StringBuilder answer = new StringBuilder();
		visit = new boolean[str.length()];
		permutation(str, answer, 0, str.length()-1);
		return answer.toString();
	}

	private static void permutation(String str, StringBuilder answer, int start, int end) {
		if(start > end) {
			return;
		}
		Grammer grammer = findGrammer(str, start, end);
		visit[grammer.index] = true;
		String result = getStr(str);
		answer.append(result.toString() + "\n");
		permutation(str, answer, grammer.index + 1, end);
		permutation(str, answer, start, grammer.index - 1);
	}

	private static String getStr(String str) {
		StringBuilder answer = new StringBuilder();
		for(int i=0;i<str.length();++i) {
			if(visit[i]) {
				answer.append(str.charAt(i));
			}
		}
		return answer.toString();
	}

	private static Grammer findGrammer(String str, int start, int end) {
		char startC = str.charAt(start);
		int index = start;
		for(int i=start+1;i<=end;++i) {
			char c = str.charAt(i);
			if(Character.compare(startC, c) > 0) {
				startC = c;
				index = i;
			}
		}
		return new Grammer(index, startC);
	}

}
