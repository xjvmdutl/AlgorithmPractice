package baekjoon.workbook.shortestpath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 명제증명 {
	private static final int ROW =  52;
	private static final int HALF =  26;
	private static final int INF = 150000;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[][] map = init();
		for(int i=0;i<n;++i) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			char c1 = tokens.nextToken().charAt(0);
			tokens.nextToken();
			char c2 = tokens.nextToken().charAt(0);
			int startIndex;
			int endIndex;
			if(Character.isLowerCase(c1)) {
				startIndex = c1 - 'a' + HALF;
			}else {
				startIndex = c1 - 'A';
			}
			if(Character.isLowerCase(c2)) {
				endIndex = c2 - 'a' + HALF;
			}else {
				endIndex = c2 - 'A';
			}
			map[startIndex][endIndex] = 1;
		}
		System.out.println(solution(map, n));
	}
	
	
	private static int[][] init() {
		int[][] map = new int[ROW][ROW];
		for(int i=0;i<ROW;++i) {
			for(int j=0;j<ROW;++j) {
				if(i == j) {
					map[i][j] = 0;
				}else {
					map[i][j] = INF;
				}
			}	
		}
		return map;
	}
	
	private static String solution(int[][] map, int n) {
		List<Character> result = floydWashal(map, n);
		return getResult(result);
	}

	private static List<Character> floydWashal(int[][] map, int n) {
		for(int k=0;k<ROW;++k) {
			for(int i=0;i<ROW;++i) {
				for(int j=0;j<ROW;++j) {
					map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
				}	
			}
		}
		return getResultList(map);
	}
	
	private static List<Character> getResultList(int[][] map) {
		List<Character> list = new ArrayList<>();
		for(int i=0;i<ROW;++i) {
			for(int j=0;j<ROW;++j) {
				if(map[i][j] != 0 && map[i][j] < INF && i != j) {
					char c1;
					char c2;
					if(i < HALF) {
						c1 = (char) ('A' + i);
					}else {
						c1 = (char) ('a' + i - HALF);
					}
					if(j < HALF) {
						c2 = (char) ('A' + j);
					}else {
						c2 = (char) ('a' + j - HALF);
					}
					list.add(c1);
					list.add(c2);
				}
			}	
		}
		return list;
	}


	private static String getResult(List<Character> result) {
		StringBuilder answer = new StringBuilder();
		answer.append(result.size() / 2 + "\n");
		for(int i=0;i<result.size();i += 2) {
			answer.append(result.get(i) + " => " + result.get(i+1) + "\n");
		}
		return answer.toString();
	}

}
