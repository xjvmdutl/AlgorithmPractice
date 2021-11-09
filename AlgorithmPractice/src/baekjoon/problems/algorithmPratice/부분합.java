package baekjoon.problems.algorithmPratice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class ºÎºÐÇÕ {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int s = Integer.parseInt(tokens.nextToken());
		int[] arr = new int[n];
		tokens = new StringTokenizer(reader.readLine());
		for(int i=0;i<n;++i)
			arr[i] = Integer.parseInt(tokens.nextToken());
		System.out.println(solution(arr,n,s));
	}

	private static long solution(int[] arr, int n, int s) {
		int answer = 100001;
		int sum = 0;
        int firstPointer = 0;
        int secondPointer = 0;
		while(true) {
			if(sum >= s) {
				sum -= arr[firstPointer++];
				answer = Math.min(answer, (secondPointer-firstPointer)+1);
			}else if(secondPointer == n)
				break;
			else 
				sum += arr[secondPointer++];
		}
		return answer == 100001 ? 0 : answer;
	}

}
