package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 소가정보섬에올라온이유 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int q = Integer.parseInt(tokens.nextToken());
		int[] arr1 = new int[n];
		tokens = new StringTokenizer(reader.readLine());
		for(int i=0;i<n;++i) {
			arr1[i] =  Integer.parseInt(tokens.nextToken());
		}
		int[] arr2 = new int[q];
		tokens = new StringTokenizer(reader.readLine());
		for(int i=0;i<q;++i) {
			arr2[i] =  Integer.parseInt(tokens.nextToken());
		}
		System.out.println(solution(arr1,arr2,n,q));
	}

	private static String solution(int[] arr1, int[] arr2, int n, int q) {
		StringBuilder sb = new StringBuilder();
		List<Integer> list = new ArrayList<>();
		long sum = 0;
		for(int i=0;i<arr1.length;++i) {
			int number = arr1[i];
			for(int j=1;j<=3;++j) {
				number *= arr1[(i+j)%arr1.length];
			}
			list.add(number);
			sum += number;
		}
		for(int i=0;i<arr2.length;++i) {
			for(int j=-3;j<=0;++j) {
				int index = arr2[i]+j-1 < 0 ? arr2[i]+j-1 + arr1.length : arr2[i]+j-1;
				list.set(index, list.get(index)*-1);
				sum += 2 * list.get(index);
			}
			sb.append(sum + "\n");
		}
		return sb.toString();
	}

}
