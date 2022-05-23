package baekjoon.workbook.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 한윤정이이탈리아에가서아이스크림을사먹는데 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		List<Integer>[] map = getList(n);
		for(int i=0; i<m; ++i) {
			tokens = new StringTokenizer(reader.readLine());
			int n1 = Integer.parseInt(tokens.nextToken()) - 1;
			int n2 = Integer.parseInt(tokens.nextToken()) - 1;
			
			map[n1].add(n2);
			map[n2].add(n1);
		}
		System.out.println(solution(map, n));
	}


	private static List<Integer>[] getList(int n) {
		List<Integer>[] list = new ArrayList[n];
		for(int i=0;i<n;++i)
			list[i] = new ArrayList<Integer>();
		return list;
	}
	
	private static int solution(List<Integer>[] map, int n) {
		int answer = 0;
		for(int i=0; i < n; ++i) {
			for(int j=i+1; j < n; ++j) {
				for(int k=j+1; k < n; ++k) {
					if(map[i].contains(j) || map[j].contains(i)) {
						continue;
					}else if(map[j].contains(k) || map[k].contains(j)) {
						continue;
					}else if(map[i].contains(k) || map[k].contains(i)){
						continue;
					}
					answer++;
				}	
			}	
		}
		return answer;
	}

}
