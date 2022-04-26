package baekjoon.workbook.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class º°Âï±â19 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		System.out.println(solution(n));
	}

	private static String solution(int n) {
		StringBuilder answer = new StringBuilder();
		int row = (4*(n-1)) + 1;
		int col = (4*(n-1)) + 1;
		char[][] map = new char[row][col];

		fill(map, n, row, col);
		print(map, answer, row, col);
		return answer.toString();
	}

	private static void print(char[][] map, StringBuilder answer, int row, int col) {
		for(int i=0;i<row;++i) {
			for(int j=0;j<col;++j) {
				if(map[i][j] == '\0') {
					answer.append(' ');
				}else {
					answer.append(map[i][j]);
				}
			}	
			answer.append("\n");
		}
	}
	
	private static void fill(char[][] map, int n, int row, int col) {
		for(int i=0;i<=row/2;++i) {
			if(i % 2 == 0) {
				int startRow = i;
				int endRow = row - i - 1;
				int startCol = i;
				int endCol = col - i - 1;
				fillRow(map, startRow, startCol, endCol);
				fillCol(map, startCol, startRow, endRow);
				fillRow(map,endRow,startCol, endCol);
				fillCol(map, endCol, startRow, endRow);
			}
		}
	}

	private static void fillCol(char[][] map, int col, int startRow, int endRow) {
		for(int i=startRow;i<=endRow;++i) {
			map[i][col] = '*';
		}
	}

	private static void fillRow(char[][] map, int row, int startCol, int endCol) {
		Arrays.fill(map[row],startCol,endCol + 1, '*');
	}




	

}
