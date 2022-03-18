package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ÀûÀÇÀû {
	public static int[] parents;
	public static int[] enermy;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		parents = new int[n + 1];
		enermy = new int[n + 1];
		for(int i=1;i<=n;++i) {
			parents[i] = i;
		}
		int answer = 1;
		for(int i=0;i<m;++i) {
			tokens = new StringTokenizer(reader.readLine());
			int a = Integer.parseInt(tokens.nextToken());
			int b = Integer.parseInt(tokens.nextToken());
			int findA = find(a);
			int findB = find(b);
			if(findA == findB) {
				answer = 0;
				break;
			}
			if(enermy[findA] == 0)
				enermy[findA] = findB;
			else
				union(enermy[findA], findB);
			
			if(enermy[findB] == 0)
				enermy[findB] = findA;
			else
				union(enermy[findB], findA);
		}
		System.out.println(answer);
	}

	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a == b)
			return;
		parents[b] = a;
	}

	private static int find(int node) {
		if(node == parents[node])
			return node;
		return parents[node] = find(parents[node]);
	}

	

}
