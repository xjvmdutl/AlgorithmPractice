package backJun.stepBystep.math01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 부녀회장이될테야 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		for(int i=0;i<t;++i) {
			int k = Integer.parseInt(reader.readLine());
			int n = Integer.parseInt(reader.readLine());
			System.out.println(solution(k,n));
		}
	}

	private static int solution(int k, int n) {
		int cnt = 0;
		int[][] arr = new int[k+1][n];
		for(int i=0;i<arr[0].length;++i)
			arr[0][i] = ++cnt;
		for(int i=1;i<arr.length;++i) {
			for(int j=0;j<arr[i].length;++j) {
				int sum = 0;
				for(int l = 0;l<=j;++l) {
					sum += arr[i-1][l];
				}
				arr[i][j] = sum;
			}
		}
		if( k == 0)
			return n;
		
		
		return arr[k][n-1];
	}

}
