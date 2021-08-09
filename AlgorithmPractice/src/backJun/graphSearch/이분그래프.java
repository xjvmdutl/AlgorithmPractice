package backJun.graphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 이분그래프 {
	public static int[] colors;
	public static boolean isBinary;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(reader.readLine());
		for(int i=0;i<k;++i) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			int v = Integer.parseInt(tokens.nextToken());
			int e = Integer.parseInt(tokens.nextToken());
			List<ArrayList<Integer>> list = new ArrayList<>();
			for(int j=0;j<v;++j) {
				list.add(new ArrayList<Integer>());
			}
			for(int j=0;j<e;++j) {
				tokens = new StringTokenizer(reader.readLine());
				int n1 = Integer.parseInt(tokens.nextToken())-1;
				int n2 = Integer.parseInt(tokens.nextToken())-1;
				list.get(n1).add(n2);
				list.get(n2).add(n1);
			}
			System.out.println(solution(list,v,e));
		}
	}

	private static String solution(List<ArrayList<Integer>> list, int v, int e) {
		String answer = "YES";
		final int RED = 1;
		isBinary = true;
		colors = new int[v];
		for(int i=0;i<v;++i) {
			if(!isBinary) {
				answer = "NO";
				break;
			}
			if(colors[i] == 0) {
				colors[i] = RED;
				dfs(list,i);
			}
		}
		return answer;
	}

	private static void dfs(List<ArrayList<Integer>> list, int idx) {
		for(int i=0;i<list.get(idx).size();++i) {
			int node = list.get(idx).get(i);
			if(colors[node] == 0) {
				colors[node] = colors[idx] * -1;
				dfs(list, node);
			}else if(colors[node] + colors[idx] != 0) {//인접노드 색이 다르다
				isBinary = false;
				return;
			}
			
		}
	}

	
}
