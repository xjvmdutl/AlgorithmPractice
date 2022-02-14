package baekjoon.workbook.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연산자끼워넣기 {
	public static int[] per = new int[4];
	public static long max;
	public static long min;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int[] arr = new int[n];
		for(int i=0;i<n;++i) {
			arr[i] = Integer.parseInt(tokens.nextToken());
		}
		tokens = new StringTokenizer(reader.readLine());
		for(int i=0;i<4;++i)
			per[i] = Integer.parseInt(tokens.nextToken());
		System.out.println(solution(arr, n));
	}
	private static String solution(int[] arr, int n) {
		max = Long.MIN_VALUE;
		min = Long.MAX_VALUE;
		int[] operator = new int[n-1]; 
		permulation(arr, operator, 0, n-1);
		StringBuilder sb = new StringBuilder();
		sb.append(max + "\n");
		sb.append(min + "\n");
		return sb.toString();
	}
	private static void permulation(int[] arr, int[] operator, int count, int length) {
		if(count == length) {
			long now = arr[0];
			for(int i=0;i<operator.length;++i) {
				now = operation(now, arr[i+1], operator[i]);
			}
			max = Math.max(now, max);
			min = Math.min(now, min);
			return;
		}
		for(int i=0;i<4;++i) {
			if(per[i] > 0) {
				operator[count] = i;
				per[i]--;
				permulation(arr, operator, count+1, length);
				per[i]++;
			}
		}
	}
	private static long operation(long now, int next, int oper) {
		long returnNum = 0;
		switch (oper) {
			case 0: {
				returnNum = now + next;
				break;
			}
			case 1: {
				returnNum = now - next;
				break;
			}
			case 2: {
				returnNum = now * next;
				break;
			}
			case 3: {
				boolean flag = false;
				if(now < 0) {
					flag = true;
					now *= -1;
				}
				returnNum = now / next;
				if(flag) {
					returnNum *= -1;
				}
				break;
			}
		}
		return returnNum;
	}

}
