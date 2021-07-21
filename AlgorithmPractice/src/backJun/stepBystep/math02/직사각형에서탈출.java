package backJun.stepBystep.math02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 직사각형에서탈출 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		int[] arr = new int[4];
		for(int i=0;i<strs.length;++i)
			arr[i] = Integer.parseInt(strs[i]);
		System.out.println(solution(arr));
	}

	private static int solution(int[] arr) {
		int x = arr[0];
		int y = arr[1];
		int w = arr[2];
		int h = arr[3];
		int xl = Math.min(x, w-x);
		int yl = Math.min(y, h-y);
		
		return Math.min(xl, yl);
	}

}
