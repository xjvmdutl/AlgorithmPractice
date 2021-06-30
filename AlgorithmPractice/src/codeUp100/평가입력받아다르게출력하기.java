package codeUp100;

import java.util.Scanner;

public class 평가입력받아다르게출력하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char c = sc.next().charAt(0);
		String str = switch (c) {
		case 'A': {
			yield "best!!!";
		}
		case 'B': {
			yield "good!!";
		}
		case 'C': {
			yield "run!";
		}
		case 'D': {
			yield "slowly~";
		}
		default:
			yield "what?";
		};
		System.out.println(str);
	}

}
