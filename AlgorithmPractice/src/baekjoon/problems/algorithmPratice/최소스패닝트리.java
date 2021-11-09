package baekjoon.problems.algorithmPratice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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

	public static void main(String[] args) throws IOException {
		BufferedReader reader =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int v = Integer.parseInt(tokens.nextToken());
		int e = Integer.parseInt(tokens.nextToken());
		List<Spaning> list = new ArrayList<>();
		for(int i=0;i<e;++i) {
			tokens = new StringTokenizer(reader.readLine());
			int start = Integer.parseInt(tokens.nextToken());
			int end = Integer.parseInt(tokens.nextToken());
			int weight = Integer.parseInt(tokens.nextToken());
			list.add(new Spaning(start, end, weight));
		}
	}

}
