package backJun.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class ทฮวม {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;++i)
			arr[i] = sc.nextInt();
		System.out.println(solution(arr,n));
		
			
	}

	private static int solution(int[] arr, int n) {
		Arrays.sort(arr);
		int max = 0;
		for(int i=arr.length-1;i>=0;--i) {
			max = Math.max(max, (arr.length - i)*arr[i]);
		}
		
		
		return max;
	}

}
