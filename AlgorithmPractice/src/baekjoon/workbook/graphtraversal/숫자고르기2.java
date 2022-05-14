package baekjoon.workbook.graphtraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 숫자고르기2 {
	private static boolean[] visit;
	private static Set<Integer> set;
	private static String solution(int[] map, int n) {
		visit = new boolean[n];
		set = new HashSet<>();
		for(int i=0;i<n;++i) {
			visit[i] = true;
			dfs(map, i, i);
			visit[i] = false;
		}
		
		return getResult();
	}
	
	

	private static void dfs(int[] map, int now, int target) {
		if(!visit[map[now]]) {
			visit[map[now]] = true;
			dfs(map, map[now], target);
			visit[map[now]] = false;
		}
		if(isCycle(map[now], target)) {
			set.add(map[now]);
		}
	}

	private static boolean isCycle(int diff, int target) {
		return diff == target;
	}
	
	private static String getResult() {
		StringBuilder answer = new StringBuilder();
		List<Integer> list = new ArrayList<>(set);
		Collections.sort(list);
		answer.append(list.size() + "\n");
		for(int num : list) {
			answer.append((num + 1) + "\n");	
		}
		return answer.toString();
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[] map = new int[n];
		for(int i=0;i<n;++i) {
			map[i] = Integer.parseInt(reader.readLine()) - 1;
		}
		System.out.println(solution(map, n));
	}

	
	

}
