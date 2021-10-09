package baekjoon.graphsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;



class Point03{
	int x;
	int y;
	public Point03(int x,int y) {
		this.x = x;
		this.y = y;
	}
}
public class 맥주마시면서걸어가기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		while(t-- > 0) {
			List<Point03> list = new ArrayList<>();
			int n = Integer.parseInt(reader.readLine());
			for(int i=0;i<n+2;++i) {
				StringTokenizer tokens = new StringTokenizer(reader.readLine());
				int x = Integer.parseInt(tokens.nextToken());
				int y = Integer.parseInt(tokens.nextToken());
				list.add(new Point03(x, y));
			}
			System.out.println(solution(list,n));
		}
	}

	private static String solution(List<Point03> list, int n) {
		boolean[][] d = new boolean[n+2][n+2];
		for(int i=0;i<n+2;++i) {
			for(int j=i+1;j<n+2;++j) {
				if(Manhattan(list.get(i),list.get(j)) <= 1000 ) {
					d[i][j] = true;
					d[j][i] = true;
				}
			}
		}
		for(int k=0;k<n+2;++k) {
			for(int i=0;i<n+2;++i) {
				for(int j=0;j<n+2;++j) {
					if(d[i][k] && d[k][j]) {
						d[i][j] = true;
					}
				}
			}
		}
		
		return d[0][n+1] ? "happy" : "sad";
	}
	private static int Manhattan(Point03 point1, Point03 point2) {
		return Math.abs(point1.x - point2.x) + Math.abs(point1.y - point2.y);
	}

}
