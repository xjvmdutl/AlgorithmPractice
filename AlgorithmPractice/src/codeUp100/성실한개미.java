package codeUp100;

import java.util.Scanner;

public class 성실한개미 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[10][10];
		for(int i=0;i<arr.length;++i)
			for(int j=0;j<arr[i].length;++j)
				arr[i][j]= sc.nextInt();
		int i = 1;
		int j = 1;
		arr[i][j] = 9;
		while(true) {
	
			if((arr[i][j+1] == 1 &&  arr[i+1][j] == 1))
				break;
			if(arr[i][j+1] == 1) {
				int n = arr[i+1][j];
				arr[++i][j] = 9;
				if(n == 2)
					break;
			}else {
				int n = arr[i][j+1];
				arr[i][++j] =9;
				if(n == 2)
					break;
				
			}
			
		}
		for(int k =0;k<arr.length;++k) {
			for(int l=0;l<arr[k].length;++l)
				System.out.print(arr[k][l] + " ");
			System.out.println();
		}
	}

}
