package backJun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 게임을만든동준이 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[] arr= new int[n];
		for(int i=0;i<n;++i) {
			arr[i] = Integer.parseInt(reader.readLine());
		}
		System.out.println(solution(arr,n));
	}

	private static int solution(int[] arr, int n) {
		int score = 0;
		for(int i=1;i<n;++i) {
			if(arr[i-1] >= arr[i]) {
				for(int j=i;j>0;--j) {
					while(arr[j-1]>=arr[j]) {
						score++;
						arr[j-1]--;
					}
				}
			}
		}
		
		return score;
	}

}
