package baekjoon.workbook.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 달팽이 {
	public static int x, y, number;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int find = Integer.parseInt(reader.readLine());
		System.out.println(solution(n, find));
	
	}

	private static String solution(int n, int find) {
		StringBuilder answer = new StringBuilder();
		int[][] map = new int[n][n];
		fillMap(map, n);
		mapToStringBuilder(map, n, answer);
		findData(map, find, answer);
		return answer.toString();
	}
	
	private static void fillMap(int[][] map, int n) {
		number = 1;
		x = n/2;
		y = n/2;
		int cnt = 1;
		map[y][x] = number++; //초기화
		int play = n/2;
		while(play-- > 0) {
			//up
			upFill(map, cnt);
			//right
			rightFill(map, cnt);
			
			cnt++;
			//under
			upderFill(map, cnt);
			//left
			leftFill(map, cnt);
			cnt++;
		}
		upFill(map, cnt - 1);
	}


	private static void leftFill(int[][] map, int cnt) {
		for(int i=0;i<cnt;++i) {
			map[y][--x] = number++;   
		}
		
	}

	private static void upderFill(int[][] map, int cnt) {
		for(int i=0;i<cnt;++i) {
			map[++y][x] = number++;   
		}
	}

	private static void rightFill(int[][] map, int cnt) {
		for(int i=0;i<cnt;++i) {
			map[y][++x] = number++;   
		}
	}

	private static void upFill(int[][] map, int cnt) {
		for(int i=0;i<cnt;++i) {
			map[--y][x] = number++;   
		}
	}

	private static void findData(int[][] map, int find, StringBuilder answer) {
		for(int i=0;i<map.length;++i) {
			for(int j=0;j<map[i].length;++j) {
				if(map[i][j] == find) {
					answer.append((i+1) + " " + (j+1));
					return;
				}
			}	
		}
	}
	private static void mapToStringBuilder(int[][] map, int n, StringBuilder answer) {
		for(int i=0;i<n;++i) {
			for(int j=0;j<n;++j) {
				answer.append(map[i][j] + " ");
			}	
			answer.append("\n");
		}
	}

	

	
}
