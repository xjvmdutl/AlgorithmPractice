package baekjoon.problems.algorithmPratice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 소수찾기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[] arr = new int[n];
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		for(int i=0;i<n;++i)
			arr[i] = Integer.parseInt(tokens.nextToken());
		System.out.println(solution(arr));
	}

	private static int solution(int[] arr) {
		int answer = 0;
		int max = Arrays.stream(arr).max().getAsInt();
		boolean[] sosu = new boolean[max+1];
		sosu[0] = true;
		sosu[1] = true;
		for(int i=2;i<=max;++i) {
			for(int j=i*i;j<=max;j+=i)
				sosu[j]=true;
		}
		for(int number : arr)
			if(!sosu[number])
				answer++;
		return answer;
	}

}
