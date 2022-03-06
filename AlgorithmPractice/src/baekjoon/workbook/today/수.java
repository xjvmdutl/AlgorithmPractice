package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ¼ö {
	public static int answer;
	public static List<Integer> list;
	public static boolean[] visit;
	public static boolean[] check1;
	public static boolean[] check2;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int k = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		System.out.println(solution(k, m));
	}

	private static int solution(int k, int m) {
		answer = 0;
		visit = new boolean[10];
		int max = (int) Math.pow(10, k);
		check1 = new boolean[max];
		check2 = new boolean[max];
		boolean[] sosu = new boolean[max];
		sosu[0] = true;
		sosu[1] = true;
		for(int i=2;i<max;++i) {
			for(int j=i+i;j<max;j+=i) {
				sosu[j] = true;
			}
		}
		list = new ArrayList<>();
		for(int i=2;i<max;++i) {
			if(!sosu[i]) {
				list.add(i);
			}
		}
		for(int i=0;i<list.size();++i) {
			for(int j=i+1;j<list.size();++j) {
				if(list.get(i) + list.get(j) < max) {
					check1[list.get(i) + list.get(j)] = true;
				}
			}	
		}
		for(int i=0;i<list.size();++i) {
			for(int j=i;j<list.size();++j) {
				if((long)list.get(i) * list.get(j) < max) {
					check2[list.get(i) * list.get(j)] = true;
				}
			}	
		}
		
		
		for(int i=1;i<10;++i) {
			int num = i;
			visit[i] = true;
			permulate(num, 0, k-1, m);
			visit[i] = false;
		}
		return answer;
	}

	private static void permulate(int num, int count, int length, int m) {
		if(count == length) {
			int now = num;
			while(now % m == 0) {
				now /= m;
			}
			if(check2[now] && check1[num]) {
				answer++;
			}
			return;
		}
		for(int i=0;i<=9;++i) {
			if(!visit[i]) {
				visit[i] = true;
				num *= 10;
				num += i;
				permulate(num, count+1, length, m);
				num /= 10;
				visit[i] = false;
			}
		}
			
		
	}

}
