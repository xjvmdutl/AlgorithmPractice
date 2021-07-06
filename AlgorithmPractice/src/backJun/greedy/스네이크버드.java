package backJun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 스네이크버드 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		int n = Integer.parseInt(strs[0]);
		int l = Integer.parseInt(strs[1]);
		strs = reader.readLine().split(" ");
		int[] arr= new int[n];
		for(int i=0;i<n;++i) {
			arr[i] = Integer.parseInt(strs[i]);
		}
		System.out.println(solution(n,l,arr));
	}

	private static int solution(int n, int l, int[] arr) {
		Arrays.sort(arr);
		for(int i=0;i<arr.length;++i) {
			if(arr[i] > l) {
				break;
			}
			l++;
		}
		return l;
	}

}
