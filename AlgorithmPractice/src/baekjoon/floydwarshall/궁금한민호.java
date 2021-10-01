package baekjoon.floydwarshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ±√±›«—πŒ»£ {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[][] arr = new int[n][n];
		for(int i=0;i<n;++i) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			for(int j=0;j<n;++j) {
				arr[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		System.out.println(solution(arr,n));
	}

	private static int solution(int[][] arr, int n) {
		final int INF = 20 * 10000 +1;
		int[][] d = new int[n][n];
		for(int i=0;i<n;++i) {
			for(int j=0;j<n;++j) {
				d[i][j] = arr[i][j];
			}
		}	
		for(int k=0;k<n;++k) {
			for(int i=0;i<n;++i) {
				for(int j=0;j<n;++j) {
					if (i == j || i == k || k == j) {
                        continue;
                    }
					if (arr[i][j] > arr[i][k] + arr[k][j]) {
                        return -1;
                    }else if (arr[i][j] == arr[i][k] + arr[k][j]) {
                        d[i][j] = INF;
                    }
				}
			}	
		}
		int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (d[i][j] != INF && i != j) {
                	answer += d[i][j];
                }
            }
        }
		
		return answer/2;
	}

}
