package baekjoon.workbook.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ºí·Î±× {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int x = Integer.parseInt(tokens.nextToken());
		int[] arr = new int[n];
		tokens = new StringTokenizer(reader.readLine());
		for(int i=0;i<n;++i) {
			arr[i] = Integer.parseInt(tokens.nextToken());
		}
		System.out.println(solution(arr, n, x));
	}

	private static String solution(int[] arr, int n, int x) {
		int max = 0;
		int count = 1;
		for(int i=0;i<x;++i) {
			max += arr[i];
		}
		int now = max;
		for(int i=x;i< n;++i) {
			now -= arr[i-x];
			now += arr[i];
			if(max < now) {
				max = now;
				count = 1;
			}else if(max == now) {
				count++;
			}
		}
		if(max == 0) {
			return "SAD";
		}
		StringBuilder sb = new StringBuilder();
		sb.append(max + "\n" + count);
		return sb.toString();
	}

}
