package baekjoon.workbook.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class 배열돌리기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		while(t-- > 0) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			int n = Integer.parseInt(tokens.nextToken());
			int d = Integer.parseInt(tokens.nextToken());
			int[][] map = new int[n][n];
			for(int i=0;i<n;++i) {
				tokens = new StringTokenizer(reader.readLine());
				for(int j=0;j<n;++j) {
					map[i][j] = Integer.parseInt(tokens.nextToken());
				}	
			}
			System.out.print(solution(map, n, d));
		}
	}

	private static String solution(int[][] map, int n, int d) {
		int count = Math.abs(d) / 45;
		for(int i=0;i<count;++i) {
			if(d > 0) {
				//시게방향
				map = rotation(map, n);
			}else {
				map = reverseRotation(map, n);
			}
		}
		return print(map);
	}



	private static int[][] rotation(int[][] map, int n) {
		int[][] result = new int[n][n];
		for(int i=0;i<n;++i) {
			for(int j=0;j<n;++j) {
				result[i][j] = map[i][j];
			}	
		}
		rotationRow(map, result, n);
		rotationDownDiagonal(map, result, n);
		rotaionCol(map, result ,n);
		rotaionUpDiagonal(map, result ,n);
		return result;
	}
	

	private static void rotationRow(int[][] map, int[][] result, int n) {
		for(int i=0;i<n;++i) {
			result[i][i] = map[n/2][i];
		}
	}
	
	private static void rotationDownDiagonal(int[][] map, int[][] result, int n) {
		for(int i=0;i<n;++i) {
			result[i][n/2] = map[i][i];
		}
	}
	
	private static void rotaionCol(int[][] map, int[][] result, int n) {
		for(int i=0;i<n;++i) {
			result[i][n-i-1] = map[i][n/2];
		}
	}
	
	private static void rotaionUpDiagonal(int[][] map, int[][] result, int n) {
		for(int i=0;i<n;++i) {
			result[n/2][n-i-1] = map[i][n-i-1];
		}
	}
	
	
	private static int[][] reverseRotation(int[][] map, int n) {
		int[][] result = new int[n][n];
		for(int i=0;i<n;++i) {
			for(int j=0;j<n;++j) {
				result[i][j] = map[i][j];
			}	
		}
		reverseRotationRow(map, result, n);
		reverseRotationDownDiagonal(map, result, n);
		reverseRotaionCol(map, result ,n);
		reverseRotaionUpDiagonal(map, result ,n);
		return result;
	}
	


	private static void reverseRotationRow(int[][] map, int[][] result, int n) {
		for(int i=0;i<n;++i) {
			
			result[n-i-1][i] = map[n/2][i];
		}
	}
	
	private static void reverseRotationDownDiagonal(int[][] map, int[][] result, int n) {
		for(int i=0;i<n;++i) {
			result[n/2][i] = map[i][i];
		}
	}
	
	private static void reverseRotaionCol(int[][] map, int[][] result, int n) {
		for(int i=0;i<n;++i) {
			result[i][i] = map[i][n/2];
		}
	}
	
	private static void reverseRotaionUpDiagonal(int[][] map, int[][] result, int n) {
		for(int i=0;i<n;++i) {
			result[i][n/2] = map[i][n-i-1];
		}
	}
	
	private static String print(int[][] map) {
		StringBuilder answer = new StringBuilder();
		for(int i=0;i<map.length;++i) {
			for(int j=0;j<map[i].length;++j) {
				answer.append(map[i][j] + " ");
			}
			answer.append("\n");
		}
		return answer.toString();
	}

}
