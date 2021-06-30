package codeUp100;

import java.util.Scanner;

public class 바둑알십자뒤집기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[19][19];
		for(int i = 0;i<arr.length;++i) {
			for(int j=0;j<arr[i].length;++j)
				arr[i][j] = sc.nextInt();
		}
		int n = sc.nextInt();
		
		for(int i=0;i<n;++i) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			for(int j =0;j<19;++j) {
				if(arr[x-1][j] == 0)
					arr[x-1][j] = 1;
				else arr[x-1][j] =0;
				if(arr[j][y-1] == 0)
					arr[j][y-1] = 1;
				else arr[j][y-1] =0;
			}
		}
		for(int i = 0;i<arr.length;++i) {
			for(int j=0;j<arr[i].length;++j)
				System.out.print(arr[i][j] + " ");
			System.out.println();
		}
	}

}
