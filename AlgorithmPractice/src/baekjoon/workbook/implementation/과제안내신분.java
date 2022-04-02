package baekjoon.workbook.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class 과제안내신분 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Set<Integer> set = new HashSet<>();
		for(int i=0;i<28;++i) {
			set.add(Integer.parseInt(reader.readLine()));
		}
		System.out.println(solution(set));
	}

	private static String solution(Set<Integer> set) {
		StringBuilder answer = new StringBuilder();
		for(int i=0;i<30;++i) {
			if(!set.contains((i+1))){
				answer.append((i + 1 )+ "\n");
			}
		}
		return answer.toString();
	}

}
