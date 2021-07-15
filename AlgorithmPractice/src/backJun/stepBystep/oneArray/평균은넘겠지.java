package backJun.stepBystep.oneArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 평균은넘겠지 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int c = Integer.parseInt(reader.readLine());
		for(int i=0;i<c;++i) {
			String[] strs = reader.readLine().split(" ");
			int n = Integer.parseInt(strs[0]);
			int[] arr = new int[n];
			for(int j=0;j<n;++j) {
				arr[j] = Integer.parseInt(strs[j+1]);
			}
			System.out.println(solution(arr,n) + "%");
		}
	}

	private static String solution(int[] arr, int n) {
		double answer = 0;
		int sum = Arrays.stream(arr).sum();
		long cnt = Arrays.stream(arr).filter(o -> o > (double)sum/n).count();
		
		return String.format("%.3f", (double)cnt/n*100);
	}

}
