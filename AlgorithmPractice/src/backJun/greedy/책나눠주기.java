package backJun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Ã¥³ª´²ÁÖ±â {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		for(int i=0;i<t;++i) {
			String[] strs = reader.readLine().split(" ");
			int n = Integer.parseInt(strs[0]);
			int m = Integer.parseInt(strs[1]);
			int[][] arr = new int[m][2];
			for(int j=0;j<m;++j) {
				strs = reader.readLine().split(" ");
				int a = Integer.parseInt(strs[0]);
				int b = Integer.parseInt(strs[1]);
				arr[j][0] = a;
				arr[j][1] = b;
			}
			System.out.println(solution(arr,n,m));
		}
	}

	private static int solution(int[][] arr, int n, int m) {
		int answer = 0;
 		Arrays.sort(arr,(o1,o2)->{
			if(o1[1] == o2[1])
				return o1[0] - o2[0];
			return o1[1] - o2[1];
		});
 		boolean[] visit = new boolean[n];
		for(int i=0;i<arr.length;++i) {
			int a = arr[i][0] - 1;
			int b = arr[i][1] - 1;
			for(int j=a;j<=b;++j) {
				if(!visit[j]) {
					visit[j] = true;
					answer++;
					break;
				}
			}
			
		}
		return answer;
	}

}
