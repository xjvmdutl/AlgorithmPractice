package codeUp100;

import java.util.Scanner;

public class 월입력받아계절출력하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String str = switch (n) {
		case 12,1,2: {
			
			yield "winter";
		}
		case 3,4,5: {
			yield "spring";
		}
		case 6, 7, 8: {
			
			yield "summer";
		}
		case 9, 10, 11: {
			
			yield "fall";
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + n);
		};
		System.out.println(str);
	}
}
