package baekjoon.problems.algorithmPratice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
class Tuttle{
	int x;
	int y;
	public Tuttle(int x,int y) {
		this.x = x;
		this.y = y;
	}
}
public class °ÅºÏÀÌ {
	public static int[] dx = {0,0,-1,1};
	public static int[] dy = {-1,1,0,0};
	public static int[] changeDir = {1,0,3,2};
	public static int[] rotationRightDir = {3,2,0,1};
	public static int[] rotationLeftDir = {2,3,1,0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		while(t-->0) {
			String str = reader.readLine();
			System.out.println(solution(str));
		}
	}
	
	private static int solution(String str) {
		int answer = 0;
		int x = 250;
		int y = 250;
		int dir = 0;
		List<Tuttle> list = new ArrayList<>();
		list.add(new Tuttle(x, y));
		for(int i=0;i<str.length();++i) {
			char c = str.charAt(i);
			if(c == 'F') {
				int nx = x + dx[dir];
				int ny = y + dy[dir];
				list.add(new Tuttle(nx, ny));
				x = nx;
				y = ny;
			}else if(c == 'B') {
				int tmp = dir;
				dir = changeDir[dir];
				int nx = x + dx[dir];
				int ny = y + dy[dir];
				list.add(new Tuttle(nx, ny));
				x = nx;
				y = ny;
				dir = tmp;
			}else if(c == 'L') {
				dir = rotationLeftDir[dir];
			}else {
				dir = rotationRightDir[dir];
			}
		}
		int minX = 501;
		int minY = 501;
		int maxX = -1;
		int maxY = -1;
		for(Tuttle t: list) {
			minX = Math.min(t.x, minX);
			minY = Math.min(t.y, minY);
			maxX = Math.max(t.x, maxX);
			maxY = Math.max(t.y, maxY);
		}
		
		return (maxX-minX) * (maxY-minY);
	}

}
