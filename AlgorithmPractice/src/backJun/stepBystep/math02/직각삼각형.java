package backJun.stepBystep.math02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Á÷°¢»ï°¢Çü {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String[] str = reader.readLine().split(" ");
			int[] arr = new int[3];
			for(int i=0;i<3;++i) {
				arr[i] = Integer.parseInt(str[i]);
			}
			if(arr[0] == 0 && arr[1] == 0 && arr[2] == 0)
				break;
			System.out.println(solution(arr));
		}
		
		
	}

	private static String solution(int[] arr) {
		Arrays.sort(arr);
		int a = arr[0];
		int b = arr[1];
		int c = arr[2];
		if( c*c == (a*a) + (b*b))
			return "right";
		else
			return "wrong";
	}

}
