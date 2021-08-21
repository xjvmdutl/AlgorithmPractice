package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 사과담기게임 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] str= reader.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		int cnt = Integer.parseInt(reader.readLine());
		int[] arr = new int[cnt];
		for(int i=0;i<cnt;++i) {
			arr[i] = Integer.parseInt(reader.readLine());
		}
		System.out.println(solution(n,m,cnt,arr));
	}

	private static int solution(int n, int m, int cnt, int[] arr) {
		int answer = 0;
		int leftIndex = 0;
		int rightIndex = m-1;
		for(int i =0;i<arr.length;++i) {
			if(arr[i]-1 > rightIndex) {
				while(rightIndex<arr[i]-1) {
					leftIndex++;
					rightIndex++;
					answer++;
				}
			}else if(leftIndex > arr[i]-1){
				while(leftIndex>arr[i]-1) {
					leftIndex--;
					rightIndex--;
					answer++;
				}
			}
		}
		return answer;
	}

}
