package baekjoon.graphsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 이진검색트리 {
	public static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String str = null;
		List<Integer> list = new ArrayList<>();
		while((str = reader.readLine()) != null) {
			if(str.equals(""))
				break;
			list.add(Integer.parseInt(str));
		}
		System.out.println(solution(list));
	}

	private static String solution(List<Integer> list) {
		sb = new StringBuilder();
		postOrder(0,list.size()-1,list);
		
		return sb.toString();
	}

	private static void postOrder(int start, int end, List<Integer> list) {
		if(start > end)
			return;
		int mid = start + 1;
		while(mid <= end && list.get(mid) < list.get(start)) {
			mid++;
		}
		postOrder(start+1, mid-1, list);
		postOrder(mid, end, list);
		sb.append(list.get(start) + "\n");
		
	}

}
