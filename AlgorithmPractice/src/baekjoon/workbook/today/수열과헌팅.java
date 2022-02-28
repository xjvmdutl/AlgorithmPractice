package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class ¼ö¿­°úÇåÆÃ {
	public static List<Integer> left;
	public static List<Integer> right;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		left = new ArrayList<>();
		right = new ArrayList<>();;
		int n = Integer.parseInt(reader.readLine());
		int[] minArray = new int[n];
		int[] maxArray = new int[n];
		for(int i=0;i<n;++i) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			int number = Integer.parseInt(tokens.nextToken());
			int r = Integer.parseInt(tokens.nextToken());
			minArray[i] = number - r;
			maxArray[i] = number + r;
			left.add(minArray[i]);
			right.add(maxArray[i]);
		}
		System.out.println(solution(maxArray, minArray, n));
	}

	private static String solution(int[] maxArray, int[] minArray, int n) {
		StringBuilder sb = new StringBuilder();
		Collections.sort(left);
		Collections.sort(right);
		for(int i=0;i<n;++i) {
			int start = lowerBound(minArray[i], n);
			int end = upperBound(maxArray[i], n);
			sb.append((start+1) + " ");
			sb.append(end + " \n");
		}
		return sb.toString();	
	}
	private static int lowerBound(int number, int n) {
		int start = 0;
		int end = n;
		while(start < end) {
			int mid = (start + end) / 2;
			if(number <= right.get(mid)) {
				end = mid;
			}else {
				start = mid + 1;
			}
		}
		return end;
	}
	
	private static int upperBound(int number, int n) {
		int start = 0;
		int end = n;
		while(start < end) {
			int mid = (start + end) / 2;
			if(left.get(mid) <= number) {
				start = mid + 1;
			}else {
				end = mid;
			}
		}
		return end;
	}

	

}
