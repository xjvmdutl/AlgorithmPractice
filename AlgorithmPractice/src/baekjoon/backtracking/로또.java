package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ·Î¶Ç {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			int k = Integer.parseInt(tokens.nextToken());
			if(k == 0) {
				break;
			}
			int[] arr = new int[k];
			for(int i=0;i<k;++i) {
				arr[i] = Integer.parseInt(tokens.nextToken());
			}
			System.out.println(solution(arr,k));
		}
	}

	private static String solution(int[] arr, int k) {
		StringBuilder sb = new StringBuilder();
		Arrays.sort(arr);
		int[] per = new int[6];
		permulate(arr,0,0,per,sb);
		return sb.toString();
	}

	private static void permulate(int[] arr, int count,int index, int[] per, StringBuilder sb) {
		if(count == 6) {
			for(int number : per) {
				sb.append(number+ " ");
			}
			sb.append("\n");
			return;
		}
		for(int i=index;i<arr.length;++i) {
			per[count] = arr[i];
			permulate(arr, count+1, i+1, per, sb);
		}
	}

}
