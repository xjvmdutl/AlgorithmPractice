package baekjoon.problems.samsungSwTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 연산자끼워넣기 {
	public static long max;
	public static long min;
	public static List<Integer> list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[] arr = new int[n];
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		for(int i=0;i<n;++i) {
			arr[i] = Integer.parseInt(tokens.nextToken());
		}
		int[] operator = new int[4];
		tokens = new StringTokenizer(reader.readLine());
		for(int i=0;i<4;++i) {
			operator[i] = Integer.parseInt(tokens.nextToken());
		}
		System.out.println(solution(arr,n,operator));
	}

	private static String solution(int[] arr, int n, int[] operator) {
		max = Long.MIN_VALUE;
		min = Long.MAX_VALUE;
		list = new ArrayList<>();
		int count = 0;
		for(int i=0;i<4;++i) {
			count+=operator[i];
		}
		dfs(arr,n,operator,0,count);
		StringBuilder sb = new StringBuilder();
		sb.append(max + "\n");
		sb.append(min);
		return sb.toString();
	}

	private static void dfs(int[] arr, int n, int[] operator,int idx,int length) {
		if(idx == length) {
			long sum = arr[0];
			for(int i=0;i<list.size();++i) {
				int index = list.get(i);
				if(index == 0) {
					sum += arr[i+1];
				}else if(index == 1) {
					sum -= arr[i+1];
				}else if(index==2) {
					sum *= arr[i+1];
				}else {
					sum /= arr[i+1];
				}
			}
			max = Math.max(max, sum);
			min = Math.min(min, sum);
			return;
		}
		
		for(int i=0;i<4;++i) {
			if(operator[i] != 0) {
				operator[i]--;
				list.add(i);
				dfs(arr, n, operator,idx+1,length);
				list.remove(idx);
				operator[i]++;
			}
		}
		
		
		
	}

}
