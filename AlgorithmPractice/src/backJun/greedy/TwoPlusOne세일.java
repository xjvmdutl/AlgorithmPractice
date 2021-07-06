package backJun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TwoPlusOneºº¿œ {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[] arr = new int[n];
		for(int i=0;i<n;++i)
			arr[i] = Integer.parseInt(reader.readLine());
		System.out.println(solution(n,arr));
		
	}

	private static int solution(int n, int[] arr) {
		int answer = 0;
		int[] reverseSort = Arrays.stream(arr).boxed().sorted((o1,o2)->o2-o1).mapToInt(Integer::intValue).toArray();
		for(int i=0;i<n/3;++i) {
			answer += reverseSort[i*3];
			answer += reverseSort[i*3 + 1];
		}
		for(int i=n/3*3;i<n;++i) {
			answer+=reverseSort[i];
		}
		
		return answer;
	}
	
}
