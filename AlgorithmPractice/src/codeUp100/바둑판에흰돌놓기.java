package codeUp100;

import java.util.Scanner;
public class �ٵ��ǿ��򵹳��� {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[19][19];
		for(int i=0;i<n;++i) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			arr[x-1][y-1] = 1;
		}
		for(int i = 0;i<arr.length;++i) {
			for(int j=0;j<arr[i].length;++j)
				System.out.print(arr[i][j] + " ");
			System.out.println();
		}
	}

	

}
