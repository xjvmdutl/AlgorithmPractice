package codeUp100;

import java.util.Scanner;

public class 십육진수구구단 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		String s = sc.next();
		
		for(int i=1;i<=15;++i) {
			System.out.printf("%X * %X = %X\n",Integer.parseInt(s,16),i,Integer.parseInt(s,16) * i);
		}
	}

}
