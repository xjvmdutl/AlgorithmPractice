package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 단어정렬 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		String[] arr = new String[n];
		for(int i=0;i<n;++i) {
			arr[i] = reader.readLine();
		}
		System.out.println(solution(arr, n));
	}

	private static String solution(String[] arr, int n) {
		Set<String> set = new HashSet<>();
		for(int i=0;i<n;++i) {
			set.add(arr[i]);
		}
		List<String> list= new ArrayList<>(set);
		Collections.sort(list, (o1, o2)->{
			if(o1.length() == o2.length()) {
				return o1.compareTo(o2);
			}
			return o1.length() - o2.length();
		});
		StringBuilder sb = new StringBuilder();
		for(String s : list) {
			sb.append(s + "\n");
		}
		return sb.toString();
	}

}
