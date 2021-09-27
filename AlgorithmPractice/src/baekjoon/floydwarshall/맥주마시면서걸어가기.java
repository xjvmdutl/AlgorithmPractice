package baekjoon.floydwarshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
class Point{
	int x;
	int y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class 맥주마시면서걸어가기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		while(t-- > 0) {
			List<Point> list = new ArrayList<>();
			int n = Integer.parseInt(reader.readLine());
			for(int i=0;i<n+2;++i) {
				StringTokenizer tokens = new StringTokenizer(reader.readLine());
				int x = Integer.parseInt(tokens.nextToken());
				int y = Integer.parseInt(tokens.nextToken());
				list.add(new Point(x, y));
			}
			System.out.println(solution(list,n));
		}
	}

	private static String solution(List<Point> list, int n) {
		boolean[][] arr = new boolean[n+2][n+2];
		for (int i = 0; i < n + 2; i++) {
             for (int j = i + 1; j < n + 2; j++) {
                 if (Manhattan(list.get(i), list.get(j)) <= 1000) {
                     arr[i][j] = arr[j][i] = true;
                 }
             }
        }
		for(int k=0;k<n+2;++k) {
			for(int i=0;i<n+2;++i) {
				for(int j=0;j<n+2;++j) {
					if(arr[i][k] && arr[k][j]) 
						arr[i][j] = true;
				}
			}
		}
		
		
		return arr[0][n+1] ? "happy" : "sad";
	}

	private static int Manhattan(Point point1, Point point2) {
		return Math.abs(point1.x - point2.x) + Math.abs(point1.y - point2.y);
	}

}
