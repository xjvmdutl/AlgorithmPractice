package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
public class °øÇ× {
	public static int[] gates;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int g = Integer.parseInt(reader.readLine());
		int p = Integer.parseInt(reader.readLine());
		int[] arr = new int[p];
		for(int i=0;i<p;++i) {
			arr[i] = Integer.parseInt(reader.readLine());
		}
		System.out.println(solution(g,p,arr));
	}

	private static int solution(int g, int p, int[] arr) {
		int answer = 0;
		gates = new int[g+1];
		for(int i=1;i<=g;++i) {
			gates[i] = i;
		}
		
		for(int i=0;i<arr.length;++i) {
			if(arr[i] > g) break;
			if(find(arr[i])==0) break;
			else answer++;
			union(arr[i]);
		}
		return answer;
	}

	public static int find(int x) {
		if(gates[x]==x) return x;
		else return gates[x] = find(gates[x]); 
	}
	
	public static void union(int x) {
		x = find(x);
		gates[x] = x-1;
	}
}
