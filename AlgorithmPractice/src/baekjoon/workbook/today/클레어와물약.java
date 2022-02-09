package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
class Liquid{
	int number;
	boolean possible;
	List<ArrayList<Integer>> indegree = new ArrayList<>();
	List<Integer> adj = new ArrayList<Integer>();
	List<Integer> counts = new ArrayList<Integer>();
	public Liquid(int number) {
		this.number = number;
	}
}
public class 클레어와물약 {
	public static int[] have;
	public static List<Integer> answer;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		Liquid[] map = new Liquid[n];
		for(int i=0;i<n;++i)
			map[i] = new Liquid(i);
		int m = Integer.parseInt(tokens.nextToken());
		
		for(int i=0;i<m;++i) {
			tokens = new StringTokenizer(reader.readLine());
			int k = Integer.parseInt(tokens.nextToken());
			ArrayList<Integer> indegree = new ArrayList<Integer>();
			for(int j=0;j<k;++j) {
				indegree.add(Integer.parseInt(tokens.nextToken()) - 1);
			}
			int r = Integer.parseInt(tokens.nextToken()) - 1;
			for(int j=0;j<k;++j) {
				map[indegree.get(j)].adj.add(r);
			}
			map[r].indegree.add(indegree);
			map[r].counts.add(indegree.size());
		}
		int l = Integer.parseInt(reader.readLine());
		have= new int[l];
		tokens = new StringTokenizer(reader.readLine());
		for(int i=0;i<l;++i) {
			int y = Integer.parseInt(tokens.nextToken()) - 1;
			map[y].possible = true;
			have[i] = y;
		}
		System.out.println(solution(map));
	}

	private static String solution(Liquid[] map) {
		StringBuilder sb = new StringBuilder();
		answer = new ArrayList<Integer>();
		topology(map);
		Collections.sort(answer);
		sb.append(answer.size() + "\n");
		for(int number : answer) {
			sb.append((number+1) + " ");
		}
		return sb.toString();
	}

	private static void topology(Liquid[] map) {
		Queue<Liquid> que = new LinkedList<>();
		for(int i=0;i<have.length;++i) {
			answer.add(have[i]);
			que.offer(map[have[i]]);
		}
		while(!que.isEmpty()) {
			Liquid liquid = que.poll();
			int num = liquid.number;
			List<Integer> adj = liquid.adj;
			for(int i=0;i<adj.size();++i) {
				int next = adj.get(i);
				if(map[next].possible) //이미 만든 물약
					continue;
				List<ArrayList<Integer>> indegree = map[next].indegree;
				for(int j=0;j<indegree.size();++j) {
					if(map[next].possible)
						break;
					for(int k=0;k<indegree.get(j).size();++k) {
						if(num == indegree.get(j).get(k)) {
							map[next].indegree.get(j).set(k, -1);
							map[next].counts.set(j, map[next].counts.get(j)-1);
							if(map[next].counts.get(j) == 0) {
								map[next].possible = true;
								break;
							}
						}
					}
				}
				if (map[next].possible) {
	                answer.add(next);
	                que.offer(map[next]);
	            }
			}
		}
	}

	private static String solution(List<ArrayList<Integer>> map, List<Integer> list, int[] y) {
		Set<Integer> set = new HashSet<>();
		for(int i=0;i<y.length;++i)
			set.add(y[i]);
		while(true) {
			boolean flag = false;
			int size = map.size();
			int index = 0;
			for(int i=0;i<size;++i) {
				if(set.containsAll(map.get(index))) {
					set.add(list.get(index));
					list.remove(index);
					map.remove(index);
					flag = true;
				}else {
					index++;
				}
			}
			if(!flag)
				break;
		}
		StringBuilder sb = new StringBuilder(set.size() + "\n");
		List<Integer> tmpList = new ArrayList<Integer>(set);
		Collections.sort(tmpList);
		for(int i=0;i<tmpList.size();++i) {
			sb.append(tmpList.get(i) + " ");
		}
		return sb.toString();
	}

}
