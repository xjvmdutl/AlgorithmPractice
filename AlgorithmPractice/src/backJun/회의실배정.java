package backJun;

import java.util.Arrays;
import java.util.Scanner;

public class 회의실배정 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		int[][] arr = new int[n][2];
		
		for(int i =0;i<n;++i) {
			String str = sc.nextLine();
			int start = Integer.parseInt(str.split(" ")[0]);
			int end = Integer.parseInt(str.split(" ")[1]);
			arr[i][0] = start;
			arr[i][1] = end;
		}
		System.out.println(solution(arr,n));
	}

	private static int solution(int[][] arr, int n) {
		int time = 0;
		int count =0;
		Arrays.sort(arr,(o1,o2) -> {
			if(o1[1] == o2[1])
				return o1[0] - o2[0];
			else
				return o1[1] - o2[1];
		});
		for(int i = 0;i<arr.length;++i) {
			if(time <= arr[i][0]) {
				count++;
				time=arr[i][1];
			}
		}
		return count;
	}

	

}
