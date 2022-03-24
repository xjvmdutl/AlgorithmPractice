package baekjoon.workbook.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.StringTokenizer;

public class 배열합치기 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		int[] a = new int[n];
		tokens = new StringTokenizer(reader.readLine());
		for(int i=0;i<n;++i) {
			a[i] = Integer.parseInt(tokens.nextToken());
		}
		int[] b = new int[m];
		tokens = new StringTokenizer(reader.readLine());
		for(int i=0;i<m;++i) {
			b[i] = Integer.parseInt(tokens.nextToken());
		}
		System.out.println(solution(a, b, n, m));
	}

	private static String solution(int[] a, int[] b, int n, int m) {
		StringBuilder sb = new StringBuilder();
		Arrays.sort(a);
		Arrays.sort(b);
		int aStartPoint = 0;
		int bStartPoint = 0;
		while(aStartPoint < a.length || bStartPoint < b.length) {
			if(aStartPoint >= a.length) {
				for(int i=bStartPoint;i<b.length;++i) {
					sb.append(b[i] + " ");
				}
				break;
			}
			if(bStartPoint >= b.length) {
				for(int i=aStartPoint;i<a.length;++i) {
					sb.append(a[i] + " ");
				}
				break;
			}
			if(a[aStartPoint] < b[bStartPoint]) {
				sb.append(a[aStartPoint++] + " ");
				
			}else {
				sb.append(b[bStartPoint++] + " ");
			}
			
		}
		return sb.toString();
	}

}
