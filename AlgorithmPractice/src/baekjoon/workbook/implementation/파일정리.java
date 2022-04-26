package baekjoon.workbook.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class 파일정리 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		String[] files = new String[n];
		for(int i=0;i<n;++i) {
			files[i] = reader.readLine();
		}
		System.out.println(solution(files, n));
	}

	private static String solution(String[] files, int n) {
		Map<String, Integer> map = new HashMap<>();
		for(String file : files) {
			String extension = getExtension(file);
			map.put(extension, map.getOrDefault(extension, 0) + 1);
		}
		List<Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());
		Collections.sort(entries, (o1, o2) -> {
			return o1.getKey().compareTo(o2.getKey());
		});
		return print(entries);
	}

	private static String print(List<Entry<String, Integer>> entries) {
		StringBuilder answer = new StringBuilder();
		for(Entry<String, Integer> entry : entries) {
			answer.append(entry.getKey() + " " + entry.getValue() + "\n");
		}
		return answer.toString();
	}

	private static String getExtension(String file) {
		int index = file.indexOf('.');
		return file.substring(index + 1);
	}

}
