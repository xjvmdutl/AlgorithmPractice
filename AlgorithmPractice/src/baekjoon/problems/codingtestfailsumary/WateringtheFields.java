package baekjoon.problems.codingtestfailsumary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
class Pipe implements Comparable<Pipe>{
	int parent;
	int child;
	int weight;
	public Pipe(int parent,int child,int weight){
		this.parent = parent;
		this.child = child;
		this.weight = weight;
	}
	@Override
	public int compareTo(Pipe o) {
		return this.weight - o.weight;
	}
}
public class WateringtheFields {
	public static int[] parents;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int c = Integer.parseInt(tokens.nextToken());
		
		int[][] arr = new int[n][2];
		for(int i=0;i<n;++i) {
			tokens = new StringTokenizer(reader.readLine());
			arr[i][0] = Integer.parseInt(tokens.nextToken());
			arr[i][1] = Integer.parseInt(tokens.nextToken());
		}
		System.out.println(solution(arr,n,c));
		
		
	}

	private static int solution(int[][] arr, int n, int c) {
		List<Pipe> list = new ArrayList<>();
		int answer = 0;
		parents = new int[n];
		for(int i=0;i<n;++i) {
			parents[i] = i;
		}
		for(int i=0;i<n;++i) {
			for(int j=i+1;j<n;++j) {
				int dis = FindDistance(arr[i][0],arr[i][1],arr[j][0],arr[j][1]);
				if(c <= dis) {
					list.add(new Pipe(i,j,dis));
				}
			}
		}
		Collections.sort(list);
		
		for(int i=0;i<list.size();++i) {
			int parent = findNode(list.get(i).parent);
			int child = findNode(list.get(i).child);
			if(parent == child)
				continue;
			answer += list.get(i).weight;
			parents[child] = parent;
		}
		int now = parents[0];
		for(int i=1;i<n;++i) {
			if(now != parents[i]) {
				return -1;
			}
		}
		return answer;
	}

	private static int findNode(int node) {
		if(node == parents[node]) {
			return node;
		}
		return parents[node] = findNode(parents[node]);
	}

	private static int FindDistance(int x1, int y1, int x2, int y2) {
		return (int) (Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));
	}

}
