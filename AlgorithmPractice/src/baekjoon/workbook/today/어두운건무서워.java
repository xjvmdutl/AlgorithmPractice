package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
class Picture{
	int r1;
	int c1;
	int r2;
	int c2;
	public Picture(int r1,int c1, int r2, int c2) {
		this.r1 = r1;
		this.c1 = c1;
		this.r2 = r2;
		this.c2 = c2;
	}
}
public class 어두운건무서워 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int r = Integer.parseInt(tokens.nextToken());
		int c = Integer.parseInt(tokens.nextToken());
		int q = Integer.parseInt(tokens.nextToken());
		int[][] map = new int[r][c];
		for(int i=0;i<r;++i) {
			tokens = new StringTokenizer(reader.readLine());
			for(int j=0;j<c;++j) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		Picture[] pictures = new Picture[q];
		for(int i=0;i<q;++i) {
			tokens = new StringTokenizer(reader.readLine());
			int r1 = Integer.parseInt(tokens.nextToken()) - 1;
			int c1 = Integer.parseInt(tokens.nextToken()) - 1;
			int r2 = Integer.parseInt(tokens.nextToken()) - 1;
			int c2 = Integer.parseInt(tokens.nextToken()) - 1;
			pictures[i] = new Picture(r1, c1, r2, c2);
		}
		System.out.println(solution(map,pictures,r,c,q));
	}

	private static String solution(int[][] map, Picture[] pictures, int r, int c, int q) {
		StringBuilder sb = new StringBuilder();
		int[][] sums = new int[r][c];
		for(int i=0;i<r;++i) {
			int sum = 0;
			for(int j=0;j<c;++j) {
				sum += map[i][j];
				sums[i][j] = sum;
			}
		}
		for(Picture p : pictures) {
			int sum = 0;
			for(int i=p.r1;i<=p.r2;++i) {
				sum += sums[i][p.c2] - sums[i][p.c1] + map[i][p.c1];
			}
			sb.append(sum / (((p.r2 - p.r1)+1) * ((p.c2 - p.c1)+1)) + "\n");
		}
		
		return sb.toString();
	}

}
