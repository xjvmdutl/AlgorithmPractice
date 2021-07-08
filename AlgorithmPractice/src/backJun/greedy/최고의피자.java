package backJun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 최고의피자 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		String[] strs = reader.readLine().split(" ");
		int a = Integer.parseInt(strs[0]);
		int b = Integer.parseInt(strs[1]);
		int c = Integer.parseInt(reader.readLine());
		int[] arr= new int[n];
		for(int i=0;i<n;++i) {
			arr[i] = Integer.parseInt(reader.readLine());
		}
		System.out.println(solution(arr,a,b,c,n));
	}

	private static long solution(int[] arr, int a, int b, int c, int n) {
		int answer = a;
		int[] reverse = Arrays.stream(arr).boxed().sorted((o1,o2)->o2-o1).mapToInt(Integer::intValue).toArray();
		long sumCalory = c;
		long result = c/a;
		for(int i=0;i<reverse.length;++i) {
			answer += b;
			sumCalory += reverse[i];
			long tmp = sumCalory/answer;
			result = Math.max(result,tmp);
		}
		return result;
	}

}
