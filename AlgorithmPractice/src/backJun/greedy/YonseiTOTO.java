package backJun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class YonseiTOTO {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] str = reader.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		int[][] arr = new int[n][];
		int[] larr = new int[n];
		for(int i =0;i<n;++i) {
			str = reader.readLine().split(" ");
			int p = Integer.parseInt(str[0]);
			int l = Integer.parseInt(str[1]);
			larr[i] = l;
			arr[i] = new int[p];
			str = reader.readLine().split(" ");
			for(int j=0;j<p;++j) {
				arr[i][j] = Integer.parseInt(str[j]);
			}
		}
		System.out.println(solution(arr,larr,n,m));
	}

	private static int solution(int[][] arr, int[] larr, int n, int m) {
		int answer = 0;
		ArrayList<Integer> list = new ArrayList<>();
		for(int i =0;i<arr.length;++i) {
			if(arr[i].length < larr[i]) {
				answer++;
				m-=1;
				if(m <= 0)
					return answer;
				continue;
			}
			int[] reverseOrder = Arrays.stream(arr[i]).boxed().sorted((o1,o2)->o2-o1).mapToInt(Integer::intValue).toArray();
			int leastM = reverseOrder[larr[i]-1];
			list.add(leastM);
		}
		Collections.sort(list);
		for(int i : list) {
			if(m-i >= 0) {
				m-=i;
				answer++;
			}else {
				break;
			}
		}
		return answer;
	}

}
