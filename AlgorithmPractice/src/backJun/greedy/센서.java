package backJun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class ¼¾¼­ {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int k = Integer.parseInt(reader.readLine());
		int[] arr = new int[n];
		String[] strs = reader.readLine().split(" ");
		for(int i=0;i<n;++i) {
			arr[i] = Integer.parseInt(strs[i]);
		}
		System.out.println(solution(n,k,arr));
	}

	private static int solution(int n, int k, int[] arr) {
		int answer = 0;
		if(k>= n) return 0;
		
		Arrays.sort(arr);
		int[] lengths = new int[n-1];
		for(int i=1;i<n;++i) {
			lengths[i-1] = arr[i]-arr[i-1];
		}
		Arrays.sort(lengths);
		for(int i=0;i<n-k;++i) {
			answer += lengths[i];
		}
		return answer;
	}

}
