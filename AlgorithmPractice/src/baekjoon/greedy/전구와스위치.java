package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 전구와스위치 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		char[] arr1 = reader.readLine().toCharArray();
		char[] arr2 = new char[n];
		char[] result = reader.readLine().toCharArray();
		for(int i=0;i<n;++i) {
			arr2[i] = arr1[i];
		}
		int n1 = solution(arr1,result,false);
		int n2 = solution(arr2,result,true);
		if(n1 == -1 && n2 == -1) 
			System.out.println(-1);
		else if(n1 != -1 && n2 != -1)
			System.out.println(Math.min(n1, n2));
		else 
			System.out.println(n1 == -1 ? n2 : n1);
	}

	private static int solution(char[] arr, char[] result, boolean flag) {
		int answer = 0;
		//첫번째 전구 키기
		if(flag) {
			arr[0] = arr[0] == '0' ? '1' : '0';
			arr[1] = arr[1] == '0' ? '1' : '0';
			answer++;
		}
		for(int i=1;i<arr.length;++i) {
			if(arr[i-1] != result[i-1]) {
				arr[i-1] = arr[i-1] == '0' ? '1' : '0';
				arr[i] = arr[i] == '0' ? '1' : '0';
				answer++;
				if( i != arr.length-1)
					arr[i+1] = arr[i+1] == '0' ? '1' : '0';
			}
		}
		if(arr[arr.length-1] != result[result.length-1])
			answer = -1;
		return answer;
	}
}
