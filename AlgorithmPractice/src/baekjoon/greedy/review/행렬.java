package baekjoon.greedy.review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class За·Д {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		int[][] arr1 = new int[n][m];
		for(int i=0;i<n;++i) {
			String str = reader.readLine();
			for(int j=0;j<m;++j) {
				arr1[i][j] = str.charAt(j)-'0';
			}
		}
		int[][] arr2 = new int[n][m];
		for(int i=0;i<n;++i) {
			String str = reader.readLine();
			for(int j=0;j<m;++j) {
				arr2[i][j] = str.charAt(j)-'0';
			}
		}
		System.out.println(solution(arr1,arr2,n,m));
	}

	private static int solution(int[][] arr1, int[][] arr2, int n, int m) {
		int answer = 0;
		if(n < 3 || m < 3) {
			if(!isSame(arr1,arr2)) {
				return isSame(arr1, arr2) ? answer : -1;
			}
		}
		for(int i=0;i<n-2;++i) {
			for(int j=0;j<m-2;++j) {
				if(arr1[i][j] != arr2[i][j]) {
					answer += togglePartialMatrix(arr1, i, j);
				}
			}	
		}
		return isSame(arr1, arr2) ? answer : -1;
	}
	private static int togglePartialMatrix(int[][] arr1, int row, int col) {
		for (int i = row; i < row + 3; i++) {
	        for (int j = col; j < col + 3; j++) {
	            if(arr1[i][j] == 1) 
	            	arr1[i][j] = 0;
	            else
	            	arr1[i][j] = 1;
	        }
	    }
		return 1;
		
	}
	private static boolean isSame(int[][] arr1, int[][] arr2) {
		for(int i=0;i<arr1.length;++i) {
			for(int j=0;j<arr1[i].length;++j) {
				if(arr1[i][j] != arr2[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

	

}
