package baekjoon.problems.codingtestfailsumary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 괄호추가하기3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		char[] arr = reader.readLine().toCharArray();
		System.out.println(solution(n,arr));
	}

	private static int solution(int n, char[] arr) {
		int answer = 0;
		int[][] max = new int[n][n];
		int[][] min = new int[n][n];
		for(int i=0;i<n;++i) {
			Arrays.fill(max[i], Integer.MIN_VALUE);
			Arrays.fill(min[i], Integer.MAX_VALUE);
		}
		for(int i=0;i<n;++i) {
			if(Character.isDigit(arr[i])) {
				max[i][i] = arr[i] - '0';
				min[i][i] = arr[i] - '0';
			}
		}
		for(int j = 2; j < n; j+=2) {
            for(int i = 0; i < n - j; i+=2) {
                for(int k = 2; k <= j; k+=2) {
                    int[] num = new int[4];
                    int op = i + k - 1;
                    num[0] = calc(max[i][i + k - 2], max[i + k][i + j], arr[op]);
                    num[1] = calc(max[i][i + k - 2], min[i + k][i + j], arr[op]);
                    num[2] = calc(min[i][i + k - 2], max[i + k][i + j], arr[op]);
                    num[3] = calc(min[i][i + k - 2], min[i + k][i + j], arr[op]);
                    Arrays.sort(num);
                    max[i][i + j] = Math.max(max[i][i + j], num[3]);
                    min[i][i + j] = Math.min(min[i][i + j], num[0]);
                }
            }
        }
		return max[0][n - 1];
	}

	private static int calc(int a, int b, char op) {
		if(op == '+') return a + b;
        else if(op == '-') return a - b;
        else return a * b;
	}

}
