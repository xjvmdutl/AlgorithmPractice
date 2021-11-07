package baekjoon.problems.algorithmPratice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N번째큰수 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		while(t-- > 0) {
			int[] arr = new int[10];
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			for(int i=0;i<10;++i)
				arr[i] = Integer.parseInt(tokens.nextToken());
			System.out.println(solution(arr));
		}
	}

	private static int solution(int[] arr) {
		return Arrays.stream(arr).boxed().sorted((o1,o2)->o2-o1).mapToInt(Integer::intValue).toArray()[2];
	}

}
