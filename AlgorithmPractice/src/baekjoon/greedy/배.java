package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class น่ {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		String[] strs = reader.readLine().split(" ");
		int[] Narr = new int[n];
		for(int i=0;i<n;++i)
			Narr[i] = Integer.parseInt(strs[i]);
		int m = Integer.parseInt(reader.readLine());
		int[] Marr = new int[m];
		strs = reader.readLine().split(" ");
		for(int i=0;i<m;++i)
			Marr[i] = Integer.parseInt(strs[i]);
		System.out.println(solution(n,m,Narr,Marr));
	}

	private static int solution(int n, int m, int[] narr, int[] marr) {
		int answer = 0;
		int[] order = Arrays.stream(narr).boxed().sorted((o1,o2)->o2-o1).mapToInt(Integer::intValue).toArray();
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<marr.length;++i) {
			list.add(marr[i]);
			if(order[0] < marr[i])
				return -1;
		}
		Collections.sort(list,Collections.reverseOrder());
		while(!list.isEmpty()) {
			int idx = 0;
            for(int i = 0; i < order.length;) {
                if(idx == list.size()) break;
                else if(order[i] >= list.get(idx)) {
                    list.remove(idx);
                    i++;
                }
                else idx++;
            }
            answer++; 
		}
		return answer;
	}

}
