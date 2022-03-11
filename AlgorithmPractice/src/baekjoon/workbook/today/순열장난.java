package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 순열장난 {
	private static final int INF = 51;
	public static boolean[] visit;
	public static StringBuilder sb;
	public static List<Integer> per;
	public static boolean isFinish;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String str = reader.readLine(); 
		System.out.println(solution(str));
	}

	private static String solution(String str) {
		visit = new boolean[51];
		per = new ArrayList<>();
		isFinish = false;
		sb = new StringBuilder();
		permulate(str, 0, str.length(), 0);
		return sb.toString();
	}

	private static void permulate(String str, int index, int length, int count) {
		if(isFinish) {
			return;
		}
		if(index == length) {
			if(isOkay(count)) {
				isFinish = true;
				for(int num : per) {
					sb.append(num + " ");
				}
			}
			return;
		}
		
		char c = str.charAt(index); //나올수 있는 경우
		//바로 변환
		if(!visit[c- '0']) {
			visit[c-'0'] = true;
			per.add(count, c-'0');
			permulate(str, index+1, length, count+1);
			visit[c-'0'] = false;
			per.remove(count);
		}
		if(index+1 < length) {
			int next = Integer.parseInt(str.substring(index, index + 2));
			if(next < INF && !visit[next]) {
				visit[next] = true;
				per.add(next);
				permulate(str, index+2, length, count +1);
				visit[next] = false;
				per.remove(count);
			}
		}
	}

	private static boolean isOkay(int count) {
		for(int i=1;i<=count;++i) {
			if(!per.contains(i))
				return false;
		}
		return true;
	}
}
