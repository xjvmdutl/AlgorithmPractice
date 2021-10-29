package baekjoon.problems.codingtestfailsumary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 배열복원하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int h = Integer.parseInt(tokens.nextToken());
		int w = Integer.parseInt(tokens.nextToken());
		int x = Integer.parseInt(tokens.nextToken());
		int y = Integer.parseInt(tokens.nextToken());
		int[][] arr = new int[h+x][w+y];
		for(int i=0;i<h+x;++i) {
			tokens = new StringTokenizer(reader.readLine());
			for(int j=0;j<w+y;++j) {
				arr[i][j] = Integer.parseInt(tokens.nextToken());
			}	
		}
		System.out.println(solution(arr,h,w,x,y));
	}

	private static String solution(int[][] arr, int h, int w, int x, int y) {
		
		int[][] a = new int[h][w];
		for(int i=0;i<h;++i) {
			if(i >= x) {
				for(int j=0;j<y;++j) {
					a[i][j] = arr[i][j];
				}
				for(int j=y;j<w;++j) {
					a[i][j] = arr[i][j] - a[i-x][j-y];
				}
			}else {
				for(int j=0;j<w;++j) {
					a[i][j] = arr[i][j];
				}
			}
		}
		return print(a,h,w);
		
	}

	private static String print(int[][] a, int h, int w) {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<h;++i) {
			for(int j=0;j<w;++j) {
				sb.append(a[i][j] + " ");
			}	
			sb.append("\n");
		}
		return sb.toString();
	}

}
