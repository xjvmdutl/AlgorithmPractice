package backJun.stepBystep.oneArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ЦђБе {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[] arr = new int[n];
		String[] strs = reader.readLine().split(" ");
		for(int i=0;i<n;++i)
			arr[i] = Integer.parseInt(strs[i]);
		System.out.println(solution(arr,n));
	}

	private static double solution(int[] arr, int n) {
		double answer = 0;
		int max = Arrays.stream(arr).max().getAsInt();
		for(int i=0;i<arr.length;++i) {
			answer += (double)arr[i]/max*100;
		}
		return answer/n;
	}
}
