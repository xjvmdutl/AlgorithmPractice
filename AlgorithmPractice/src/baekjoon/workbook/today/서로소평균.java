package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ¼­·Î¼ÒÆò±Õ {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[] arr = new int[n];
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		for(int i=0;i<n;++i) {
			arr[i] = Integer.parseInt(tokens.nextToken());
		}
		int x = Integer.parseInt(reader.readLine());
		System.out.println(solution(arr, n, x));
	}

	private static double solution(int[] arr, int n, int x) {
		double sum = 0;
		double count = 0;
		for(int i=0;i<n;++i) {
			int gcd= GCD(Math.max(arr[i], x), Math.min(arr[i], x));
			if(gcd == 1) {
				count++;
				sum += arr[i];
			}
		}
		return sum/count;
	}

	private static int GCD(int x, int y) {
		if(y == 0)
			return x;
		return GCD(y, x%y);
	}

}
