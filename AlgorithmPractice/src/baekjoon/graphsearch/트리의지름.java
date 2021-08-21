package baekjoon.graphsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
class Node02{
	int x;
	int w; 
	public Node02(int x,int w) {
		this.x = x;
		this.w = w;
	}
}
public class 트리의지름 {
	public static boolean[] visit;
	public static int max,maxIdx;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		List<Node02>[] list = new ArrayList[n];
		for(int i=0;i<n;++i)
			list[i] = new ArrayList<>();
		for(int i=0;i<n-1;++i) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			int s = Integer.parseInt(tokens.nextToken())-1;
			int e = Integer.parseInt(tokens.nextToken())-1;
			int w = Integer.parseInt(tokens.nextToken());
			list[s].add(new Node02(e,w));
			list[e].add(new Node02(s,w));
		}
		System.out.println(solution(list,n));
	}
	private static int solution(List<Node02>[] list,int n) {
		visit = new boolean[n];
		max = 0;
		maxIdx = 0;
		visit[0] = true;
		dfs(list,0,0);
		visit = new boolean[n];
		visit[maxIdx] = true;
		dfs(list,maxIdx,0);
		int answer = max;
		
		return answer;
	}
	private static void dfs(List<Node02>[] list, int i,int weight) {
		if(max < weight) {
            max = weight;
            maxIdx = i;
        }
		for(Node02 node : list[i]) {
			if(!visit[node.x]) {
				visit[node.x] = true;
				dfs(list,node.x,weight+node.w);
			}
		}
		
	}

}
