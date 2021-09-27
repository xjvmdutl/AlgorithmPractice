package baekjoon.SieveofEratosthenes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 소수찾기 {
	public static boolean[] value;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[] arr = new int[n];
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		for(int i=0;i<arr.length;++i) {
			arr[i] = Integer.parseInt(tokens.nextToken());
		}
		System.out.println(solution(arr,n));
		
	}

	private static int solution(int[] arr, int n) {
		int answer = 0;
		int max = Arrays.stream(arr).max().getAsInt();
		value = new boolean[max+1];
		value[1] = true;
		for(int i=2;i<value.length;++i) {
			if(value[i])
				continue;
			for(int j=i+i;j<value.length;j+=i)
				value[j] = true;
		}
		for(int i=0;i<arr.length;++i) {
			if(!value[arr[i]])
				answer++;
		}
		return answer;
	}

}
