package baekjoon.workbook.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class 트리인가 {
	public static boolean isTree;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int count = 1;
		while(true) {
			int edge = 0;
			Map<Integer, Integer> map = new HashMap<>();
			while(true) {
				int start = sc.nextInt();
				int end = sc.nextInt();
				if(start == -1 && end == -1) return;
                else if(start == 0 && end == 0) break;
				map.put(start, map.getOrDefault(start, 0));
				map.put(end, map.getOrDefault(end, 0) + 1);
				edge++;
			}
			System.out.println(solution(map, edge, count++));
		}
	}

	private static String solution(Map<Integer, Integer> map, int edge, int count) {
		isTree = true;
		int root = 0;
		StringBuilder sb = new StringBuilder();
		for(int key : map.keySet()) {
			if(map.get(key) == 0) {
				root++;
			}else if(map.get(key) > 1) {
				isTree = false;
				break;
			}
		}
		if(map.size() == 0) {
			sb.append("Case " + count + " is a tree.");
			return sb.toString();
		}else if(root == 1 && isTree && edge == map.size() - 1) {
			sb.append("Case " + count + " is a tree.");
			return sb.toString();
		}else {
			sb.append("Case " + count + " is not a tree.");
			return sb.toString();
		}
	}
}
