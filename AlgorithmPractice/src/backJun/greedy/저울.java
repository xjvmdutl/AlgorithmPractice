package backJun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Àú¿ï {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[] arr = new int[n];
		String[] strs = reader.readLine().split(" ");
		for(int i=0;i<n;++i)
			arr[i] = Integer.parseInt(strs[i]);
		System.out.println(solution(n,arr));
	}

	private static int solution(int n, int[] arr) {
		Arrays.sort(arr);
		int min = 1;
		for(int i=0;i<arr.length;++i) {
			if(min < arr[i])
				break;
			min += arr[i];
			
		}
		
		return min;
	}

}
