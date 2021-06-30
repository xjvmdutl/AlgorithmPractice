package codeUp100;

import java.util.Scanner;

public class 주사위를2개던지면 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		for(int i=0;i<n;++i) {
			for(int j=0;j<m;++j) {
				System.out.println( (i+1) +" " + (j+1));
			}
		}
	}

}
