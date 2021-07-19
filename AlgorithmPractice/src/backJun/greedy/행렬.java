package backJun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class За·Д {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] str = reader.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		int[][] arr1 = new int[n][m];
		int[][] arr2 = new int[n][m];
		for(int i=0;i<n;++i) {
			str = reader.readLine().split("");
			for(int j=0;j<str.length;++j) {
				arr1[i][j] = Integer.parseInt(str[j]);
			}
		}
		for(int i=0;i<n;++i) {
			str = reader.readLine().split("");
			for(int j=0;j<str.length;++j) {
				arr2[i][j] = Integer.parseInt(str[j]);
			}
		}
		System.out.println(solution(arr1,arr2));
	}

	private static int solution(int[][] arr1, int[][] arr2) {
		int answer = 0;
	    if (arr1.length < 3 || arr1[0].length < 3) {
	        return isSameMatrix(arr1, arr2) ? answer : -1;
	    }
	    for (int i = 0; i < arr1.length - 2; i++) {
	        for (int j = 0; j < arr1[0].length - 2; j++) {
	            if (arr1[i][j] != arr2[i][j]) {
	            	answer += togglePartialMatrix(arr1, i, j);
	            }
	        }
	    }
	    return isSameMatrix(arr1, arr2) ? answer : -1;
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

	private static boolean isSameMatrix(int[][] arr1, int[][] arr2) {
		for(int i=0;i<arr1.length;++i) {
			for(int j=0;j<arr1[i].length;++j) {
				if(arr1[i][j] != arr2[i][j])
					return false;
			}
		}
		return true;
	}

}
