package codeUp100;

import java.util.Scanner;

public class ºû¼¯¾î»ö¸¸µé±â {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		int n3 = sc.nextInt();
		int count =0;
		for(int i=0;i<n1;++i) {
			for(int j=0;j<n2;++j) {
				for(int k=0;k<n3;++k) {
					System.out.println(i + " " + j+ " "+k);
					count++;
				}
			}
		}
		System.out.println(count);
	}

}
