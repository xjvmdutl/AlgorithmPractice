package backJun.stepBystep.math02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 소수찾기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		String[] str = reader.readLine().split(" ");
		int[] arr = new int[n];
		for(int i=0;i<n;++i) {
			arr[i] = Integer.parseInt(str[i]);
		}
		System.out.println(solution(arr));
	}

	private static int solution(int[] arr) {
		int answer = 0;
		for(int i=0;i<arr.length;++i) {
			int data = arr[i];
			if(data == 1)
				continue;
			for(int j=2;j<=data;++j) {
				if(j == data) {
					answer+=1;
					break;
				}
				if(data % j == 0) {
					break;
				}
			}
		}
		return answer;
	}

}
