package baekjoon.workbook.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.StringTokenizer;
public class 트리순회 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		
		char[][] map = new char[n][3];
		for(int i= 0;i<n;++i) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			for(int j=0;j<3;++j) {
				map[i][j] = tokens.nextToken().charAt(0);
			}
		}
		System.out.println(solution(map, n));
	}

	private static String solution(char[][] datas, int n) {
		StringBuilder preSearch = new StringBuilder();
		StringBuilder centerSearch = new StringBuilder();
		StringBuilder postSearch = new StringBuilder();
		char[][] map = new char[n][2];
		for(int i=0;i<n;++i) {
			int index = datas[i][0] - 'A';
			map[index][0] = datas[i][1];
			map[index][1] = datas[i][2];
		}
		preSearch(map, 0, n, preSearch);
		centerSearch(map, 0, n, centerSearch);
		postSearch(map, 0, n, postSearch);
		
		
		StringBuilder sb = new StringBuilder();
		sb.append(preSearch.toString() + "\n");
		sb.append(centerSearch.toString() + "\n");
		sb.append(postSearch.toString() + "\n");
		return sb.toString();
	}

	private static void postSearch(char[][] map, int index, int n, StringBuilder postSearch) {
		if(map[index][0] != '.') {
			int next = map[index][0] - 'A';
			postSearch(map, next, n, postSearch);
		}
		if(map[index][1] != '.') {
			int next = map[index][1] - 'A';
			postSearch(map, next, n, postSearch);
		}
		char c = (char) (index + 'A');
		postSearch.append(c);
	}

	private static void centerSearch(char[][] map, int index, int n, StringBuilder centerSearch) {
		if(map[index][0] != '.') {
			int next = map[index][0] - 'A';
			centerSearch(map, next, n, centerSearch);
		}
		char c = (char) (index + 'A');
		centerSearch.append(c);
		if(map[index][1] != '.') {
			int next = map[index][1] - 'A';
			centerSearch(map, next, n, centerSearch);
		}
	}

	private static void preSearch(char[][] map, int index, int n, StringBuilder preSearch) {
		char c = (char) (index + 'A');
		preSearch.append(c);
		if(map[index][0] != '.') {
			int next = map[index][0] - 'A';
			preSearch(map, next, n, preSearch);
		}
		if(map[index][1] != '.') {
			int next = map[index][1] - 'A';
			preSearch(map, next, n, preSearch);
		}
	}

}
