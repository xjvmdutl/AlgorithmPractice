package codeUp100;

import java.util.Scanner;

public class ¼³ÅÁ°úÀÚ»Ì±â {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();
		int w = sc.nextInt();
		int[][] arr= new int[h][w];
		int n = sc.nextInt();
		for(int i=0;i<n;++i) {
			int l = sc.nextInt();
			int d = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();
			if(d==0) {
				for(int j=y-1;j<y-1+l;++j) {
					arr[x-1][j] = 1;
				}
			}else {
				for(int j=x-1;j<x-1+l;++j) {
					arr[j][y-1] = 1;
				}
			}
			
		}
		for(int i=0;i<arr.length;++i) {
			for(int j=0;j<arr[i].length;++j) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

}
