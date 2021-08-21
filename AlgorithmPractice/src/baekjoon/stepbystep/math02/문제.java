package baekjoon.stepbystep.math02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ¹®Á¦ {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int m = Integer.parseInt(reader.readLine());
		System.out.println(solution(n,m));
	}

	private static String solution(int n, int m) {
		StringBuilder sb = new StringBuilder();
		int min = 0;
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=n;i<=m;++i) {
			for(int j=2;j<=i;++j) {
				if(j == i)
					list.add(i);
				if(i % j == 0)
					break;
			}
		}
		if(list.isEmpty())
			return "-1";
		
		min = list.get(0);
		int sum =0;
		for(int data : list)
			sum+=data;
		sb.append(sum + "\n");
		sb.append(min);
		
		return sb.toString();
	}

}
