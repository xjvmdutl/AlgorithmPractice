package baekjoon.problems.algorithmPratice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ½Ã±×³Î {
	public static boolean[] visit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		String s = reader.readLine();
		System.out.println(solution(n,s));
	}

	private static String solution(int n, String s) {
		StringBuilder sb = new StringBuilder();
		
		char[][] map = new char[5][n/5];
		for(int i=0;i<n;++i) {
			int col = i%(n/5);
			int row = i/(n/5);
			map[row][col] = s.charAt(i);
		}
		visit = new boolean[map[0].length];
		for(int j=0;j<map[0].length;++j) {
			if(map[0][j] == '#' && !visit[j]) {
				sb.append( find(map,j));
			}
		}
		return sb.toString();
	}

	private static int find(char[][] map, int index) {
		int lastIndex = index;
		for(int i=index;i<=map[0].length;++i) {
			if(i == map[0].length ) {
				lastIndex=i-1;
				break;
			}else if(map[0][i] == '.' && map[1][i] == '.' && map[2][i] == '.' && map[3][i] == '.' && map[4][i] == '.' ) {
				lastIndex=i-1;
				break;
			}
			visit[i] = true;
		}
		int middle = (lastIndex + index)/2;
		int number = findNumber(map,index,middle,lastIndex);
		return number;
	}

	private static int findNumber(char[][] map, int first, int middle, int last) {
		char f2 = map[1][first];
		char f3 = map[2][first];
		char f4 = map[3][first];
		char f5 = map[4][first];
		
		char m3 = map[2][middle];
		char l2 = map[1][last];
		if(first == last) {
			return 1;
		}
		if(f2=='.' && f3=='.' && f4=='.' && f5=='.') {
			return 7;
		}else if(f2=='.' && f4=='.' ) {
			return 3;
		}else if(f2 == '.') {
			return 2;
		}else if(f4 == '.' && f5 == '.') {
			return 4;
		}else {
			if(m3 == '.') {
				return 0;
			}else if(f4 == '.' && l2=='.') {
				return 5;
			}else if(l2 == '.') {
				return 6;
			}else if(f4 == '.') {
				return 9;
			}else {
				return 8;
			}
		}
		
		
		
	}
	/*
	###.#.###.###.#.#.###.###.###.###.###
	#.#.#...#...#.#.#.#...#.....#.#.#.#.#
	#.#.#.###.###.###.###.###...#.###.###
	#.#.#.#.....#...#...#.#.#...#.#.#...#
	###.#.###.###...#.###.###...#.###.###
	*/


}
