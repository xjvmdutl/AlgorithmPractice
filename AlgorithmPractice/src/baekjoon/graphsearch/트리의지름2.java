package baekjoon.graphsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
class Node03{
	int x;
	int w; 
	public Node03(int x,int w) {
		this.x = x;
		this.w = w;
	}
}
public class 트리의지름2 {
	public static boolean[] visit;
	public static int answer;
	public static int max,maxIdx;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		List<Node03>[] list = new ArrayList[n];
		for(int i=0;i<n;++i)
			list[i] = new ArrayList<>();
		for(int i=0;i<n;++i) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			int s = Integer.parseInt(tokens.nextToken())-1;
			while(true) {
				int e = Integer.parseInt(tokens.nextToken())-1;
				if(e == -2) {
					break;
				}
				int w = Integer.parseInt(tokens.nextToken());
				list[s].add(new Node03(e,w));
				list[e].add(new Node03(s,w));
			}
		}
		System.out.println(solution(list,n));
	}

	private static int solution(List<Node03>[] list, int n) {
		visit = new boolean[n];
		max = 0;
		maxIdx = 0;
		visit[0] = true;
		dfs(list,0,0);
		
		visit = new boolean[n];
		visit[maxIdx] = true;
		dfs(list,maxIdx,0);
		return max;
	}

	private static void dfs(List<Node03>[] list, int idx,int weight) {
		if(max < weight) {
            max = weight;
            maxIdx = idx;
        }
		for(Node03 node : list[idx]) {
			if(!visit[node.x]) {
				visit[node.x] = true;
				dfs(list,node.x,weight+node.w);
			}
		}
	}

}
