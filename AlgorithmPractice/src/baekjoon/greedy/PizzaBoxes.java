package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
class point{
	int x;
	int y;
	public point(int x,int y) {
		this.x = x;
		this.y = y;
	}
	@Override
	public boolean equals(Object obj) {
		point p = (point)obj;
		if(p.x == this.x && p.y == this.y)
			return true;
		else
			return false;
	}
	
}
public class PizzaBoxes {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		int n = Integer.parseInt(strs[0]);
		int m = Integer.parseInt(strs[1]);
		long[][] arr = new long[n][m];
		for(int i=0;i<n;++i) {
			strs = reader.readLine().split(" ");
			for(int j=0;j<m;++j) {
				arr[i][j] = Long.parseLong(strs[j]);
			}
		}
		System.out.println(solution(arr,n,m));
		
	}

	private static long solution(long[][] arr, int n, int m) {
		long answer = 0;
		ArrayList<point> list=  new ArrayList<>();
		for(int i=0;i<arr.length;++i) {
			long max = 0;
			point p = new point(i,0);
			for(int j=0;j<arr[i].length;++j) {
				answer += arr[i][j];
				if(max < arr[i][j]) {
					max = arr[i][j];
					p = new point(i,j);
				}
			}
			list.add(p);
		}
		for(int i=0;i<arr[0].length;++i) {
			long max = 0;
			point p = new point(0,i);
			for(int j=0;j<arr.length;++j) {
				if(max < arr[j][i]) {
					max = arr[j][i];
					p = new point(j,i);
				}
			}
			if(list.contains(p)) {
				continue;
			}
			list.add(p);
		}
		
		for(point p : list) {
			answer -= arr[p.x][p.y];
		}
		return answer;
	}

}
