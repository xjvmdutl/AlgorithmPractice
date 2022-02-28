package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;
class Problem implements Comparable<Problem>{
	int number;
	int level;
	public Problem(int number, int level) {
		this.level = level;
		this.number = number;
	}
	@Override
	public int compareTo(Problem o) {
		if(this.level == o.level) {
			return this.number - o.number;
		}
		return this.level - o.level;
	}
}
public class 문제추천시스템Version1 {
	private static final String ADD = "add";
	private static final String RECOMMEND = "recommend";
	private static final String SOLVED = "solved";
	public static TreeSet<Problem> set;
	public static Map<Integer, Integer> map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		set = new TreeSet<>();
		map = new HashMap<>();
		for(int i=0;i<n;++i) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			int number = Integer.parseInt(tokens.nextToken());
			int level = Integer.parseInt(tokens.nextToken());
			set.add(new Problem(number, level));
			map.put(number, level);
		}
		int m = Integer.parseInt(reader.readLine());
		for(int j=0;j<m;++j) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			String oper = tokens.nextToken();
			solution(oper, tokens);
		}
		
	}

	private static void solution(String oper, StringTokenizer tokens) {
		if(oper.equals(RECOMMEND)) {
			int num = Integer.parseInt(tokens.nextToken());
			if(num == 1) {
				System.out.println(set.last().number);
			}else if(num == -1){
				System.out.println(set.first().number);
			}
		}else if(oper.equals(ADD)) {
			int num = Integer.parseInt(tokens.nextToken());
			int level = Integer.parseInt(tokens.nextToken());
			set.add(new Problem(num, level));
			map.put(num, level);
		}else if(oper.equals(SOLVED)) {
			int num = Integer.parseInt(tokens.nextToken());
			Problem p = new Problem(num, map.get(num));
			set.remove(p);
			map.remove(num);
		}
	}

}
