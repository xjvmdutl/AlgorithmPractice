package baekjoon.workbook.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 단절점과단절선 {
	public static boolean[] visit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		List<Integer>[] map = new ArrayList[n];
		for(int i=0;i<n;++i) {
			map[i] = new ArrayList<>();
		}
		int[][] arr = new int[n][2];
		for(int i=0;i<n-1;++i) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			int start = Integer.parseInt(tokens.nextToken()) - 1;
			int end = Integer.parseInt(tokens.nextToken()) - 1;
			map[start].add(end);
			map[end].add(start);
			arr[i][0] =start;
			arr[i][1] =end;
		}
		int q = Integer.parseInt(reader.readLine());
		for(int i=0;i<q;++i) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			int t = Integer.parseInt(tokens.nextToken());
			int k = Integer.parseInt(tokens.nextToken());
			if(t == 1) {
				System.out.println(solution1(map, arr,n, k));
			}else if(t == 2){
				System.out.println("yes");
			}
		}
	}

	private static String solution1(List<Integer>[] map, int[][] arr,int n, int k) {
		if(map[k-1].size() >= 2) {
			return "yes";
		}
		return "no";
	}

}
