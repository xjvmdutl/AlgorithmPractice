package baekjoon.problems.algorithmPratice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class °¡¸£Ä§ {
	public static Set<Character> set;
	public static boolean[] visit;
	public static List<Character> selectList;
	public static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int k = Integer.parseInt(tokens.nextToken());
		String[] strs = new String[n];
		for(int i=0;i<n;++i) {
			strs[i] = reader.readLine();
		}
		System.out.println(solution(strs,k));
	}

	private static int solution(String[] strs, int k) {
		answer = 0;
		if(k < 5)
			return answer;
		List<Set<Character>> list = new ArrayList<>();
		set = new HashSet<Character>();
		for(int i=0;i<strs.length;++i) {
			Set<Character> tmpSet = new HashSet<>();
			char[] str = strs[i].toCharArray();
			for(char c : str) {
				tmpSet.add(c);
				set.add(c);
			}
			tmpSet.remove('a');
			tmpSet.remove('n');
			tmpSet.remove('t');
			tmpSet.remove('i');
			tmpSet.remove('c');
			list.add(tmpSet);
		}
		set.remove('a');
		set.remove('n');
		set.remove('t');
		set.remove('i');
		set.remove('c');
		k-=5;
		if(k > set.size())
			return strs.length;
		List<Character> setList = new ArrayList<>(set);
		visit = new boolean[setList.size()];
		selectList = new ArrayList<>();
		dfs(setList,0,0,k,list);
		return answer;
	}

	private static void dfs(List<Character> setList, int cnt, int index, int length, List<Set<Character>> list) {
		if(cnt == length) {
			int sum = 0;
			for(Set<Character> s:list) {
				if(selectList.containsAll(s)) {
					sum++;
				}
			}
			answer = Math.max(answer, sum);
			return;
		}
		for(int i=index;i<setList.size();++i) {
			if(!visit[i]) {
				visit[i] = true;
				selectList.add(setList.get(i));
				dfs(setList, cnt+1, i, length, list);
				selectList.remove(selectList.size()-1);
				visit[i] = false;
			}
		}
	}


}
