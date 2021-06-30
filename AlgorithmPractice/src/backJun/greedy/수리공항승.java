package backJun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ¼ö¸®°øÇ×½Â {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] str = reader.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int l = Integer.parseInt(str[1]);
		str= reader.readLine().split(" ");
		double[] arr = new double[n];
		for(int i=0;i<n;++i) {
			arr[i] = Integer.parseInt(str[i]);
		}
		System.out.println(solution(arr,n,l));
	}

	private static int solution(double[] arr, int n, int l) {
		Arrays.sort(arr);
		int cnt = 1;
		double limit = (arr[0] - 0.5+l);
		for(int i=1; i<n; i++) {
			if(limit < (arr[i]+0.5)) {
				limit = (arr[i]-0.5+l);
				cnt++;
			}
		}
		
		return cnt;
	}

}
