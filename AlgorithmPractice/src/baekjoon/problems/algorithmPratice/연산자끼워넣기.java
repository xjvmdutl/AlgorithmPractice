package baekjoon.problems.algorithmPratice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연산자끼워넣기 {
	public static int[] operations;
	public static long min;
	public static long max;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[] arr = new int[n];
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		for(int i=0;i<n;++i)
			arr[i] = Integer.parseInt(tokens.nextToken());
		int[] oper = new int[4];
		tokens = new StringTokenizer(reader.readLine());
		for(int i=0;i<4;++i)
			oper[i] = Integer.parseInt(tokens.nextToken());
		System.out.println(solution(arr,oper,n));
	}

	private static String solution(int[] arr, int[] oper,int n) {
		StringBuilder sb = new StringBuilder();
		operations = new int[n-1];
		max = Long.MIN_VALUE;
		min = Long.MAX_VALUE;
		dfs(arr,oper,n,0,n-1);
		sb.append(max + "\n");
		sb.append(min);
		return sb.toString();
	}

	private static void dfs(int[] arr, int[] oper, int n,int index, int length) {
		if(index == length) {
			long value = arr[0];
			for(int i=1;i<n;++i) {
				value = opered(value,arr[i],operations[i-1]); 
			}
			max = Math.max(value, max);
			min = Math.min(value, min);
			return;
		}
		for(int i=0;i<4;++i) {
			if(oper[i] > 0) {
				operations[index] = i;
				oper[i]--;
				dfs(arr, oper, n, index+1, length);
				oper[i]++;
			}
		}
	}

	private static long opered(long value1, long value2, int index) {
		long returnValue = 0;
		if(index == 0) {
			returnValue = value1 + value2;
		}else if(index == 1) {
			returnValue = value1 - value2;
		}else if(index == 2) {
			returnValue = value1 * value2;
		}else if(index == 3) {
			returnValue = value1 / value2;
		}
		return returnValue;
	}

}
