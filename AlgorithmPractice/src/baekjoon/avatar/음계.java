package baekjoon.avatar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class À½°è {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[8];
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		for(int i=0;i<8;++i) {
			arr[i] = Integer.parseInt(tokens.nextToken());
		}
		System.out.println(solution(arr));
	}

	private static String solution(int[] arr) {
		StringBuilder sb = new StringBuilder();
		boolean flag = true;
		for(int i=1;i<=8;++i) {
			if(arr[i-1] != 9-i) {
				flag = false;
				break;
			}
		}
		if(flag) {
			sb.append("descending");
			return sb.toString();
		}
		for(int i=1;i<=8;++i) {
			if(arr[i-1] != i) {
				sb = new StringBuilder("mixed");
				return sb.toString();
			}
		}
		
		sb = new StringBuilder("ascending");
		return sb.toString();
	}

}
