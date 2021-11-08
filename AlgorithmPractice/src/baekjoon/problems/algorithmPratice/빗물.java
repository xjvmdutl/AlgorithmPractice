package baekjoon.problems.algorithmPratice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ºø¹° {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int h = Integer.parseInt(tokens.nextToken());
		int w = Integer.parseInt(tokens.nextToken());
		int[] arr = new int[w];
		tokens = new StringTokenizer(reader.readLine());
		for(int i=0;i<w;++i) {
			arr[i] = Integer.parseInt(tokens.nextToken());
		}
		System.out.println(solution(arr,h,w));
	}

	private static int solution(int[] arr, int h, int w) {
		int answer = 0;
		for(int i=1;i<w-1;++i) {
			int current = arr[i];
			int maxLeft = 0;
			int maxRight = 0;
			for(int j=i+1;j<w;++j) {
				if(current < arr[j]) {
					maxRight = Math.max(maxRight, arr[j]);
				}
			}
			for(int j=i-1;j>=0;--j) {
				if(current < arr[j]) {
					maxLeft = Math.max(maxLeft, arr[j]);
				}
			}
			if(Math.min(maxLeft, maxRight) > current) {
				answer += Math.min(maxLeft, maxRight) - current;
			}
		}
		return answer;
	}

}
