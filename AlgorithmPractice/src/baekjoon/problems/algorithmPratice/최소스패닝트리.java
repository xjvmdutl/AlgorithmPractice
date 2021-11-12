package baekjoon.problems.algorithmPratice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
class Spaning{
	int start;
	int end;
	int weight;
	public Spaning(int start,int end,int weight) {
		this.start = start;
		this.end = end;
		this.weight = weight;
	}
}
public class 최소스패닝트리 {
	public static int[] parents;
	public static void main(String[] args) throws IOException {
		BufferedReader reader =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int v = Integer.parseInt(tokens.nextToken());
		int e = Integer.parseInt(tokens.nextToken());
		List<Spaning> list = new ArrayList<>();
		for(int i=0;i<e;++i) {
			tokens = new StringTokenizer(reader.readLine());
			int start = Integer.parseInt(tokens.nextToken())-1;
			int end = Integer.parseInt(tokens.nextToken())-1;
			int weight = Integer.parseInt(tokens.nextToken());
			list.add(new Spaning(start, end, weight));
		}
		System.out.println(solution(list,v,e));
	}

	private static int solution(List<Spaning> list, int v, int e) {
		int answer = 0;
		Collections.sort(list,(o1,o2)->{
			return o1.weight - o2.weight;
		});
		parents = new int[v];
		for(int i=0;i<v;++i)
			parents[i] = i;
		for(int i=0;i<list.size();++i) {
			int parent = findNode(list.get(i).start);
			int child = findNode(list.get(i).end);
			if(parent == child)
				continue;
			parents[child] = parent;
			answer += list.get(i).weight;
		}
		return answer;
	}

	private static int findNode(int node) {
		if(node == parents[node])
			return node;
		return parents[node] = findNode(parents[node]);
	}

}
