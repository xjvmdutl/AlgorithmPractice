package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
class Model{
	int data;
	Model left;
	Model right;
}
public class ÁßÃ¸ÁýÇÕ¸ðµ¨ {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		List<Integer>[] map = new ArrayList[n];
		for(int i=0;i<map.length;++i)
			map[i] = new ArrayList<>();
		for(int i=0;i<n;++i) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			int now = Integer.parseInt(tokens.nextToken()) - 1;
			int number;
			while((number = Integer.parseInt(tokens.nextToken())) != -1) {
				map[now].add(number);
			}
		}
		int root = Integer.parseInt(reader.readLine()) - 1;
		System.out.println(solution(map, n, root));
	}

	private static String solution(List<Integer>[] map, int n, int root) {
		//Model[] models = new Model[n];
		//makeTree(map, models, root);
		
		
		return null;
	}

	private static void makeTree(List<Integer>[] map, Model[] models, int now) {
		List<Integer> list = map[now];
		
	}

}
