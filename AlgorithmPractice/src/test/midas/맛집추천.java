package test.midas;

import java.util.HashSet;
import java.util.Set;

class Point{
	int startx;
	int starty;
	int endx;
	int endy;
	public Point(int startx, int starty, int endx, int endy) {
		this.startx = startx;
		this.starty = starty;
		this.endx = endx;
		this.endy = endy;
	}
}
public class 맛집추천 {
	public static int answer;
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	public static boolean[][] visit;
	public static int solution(int N, int[][] L) {
        answer = 21;
        
        Point[] points = new Point[L.length];
        int maxX= 0;
        int maxY= 0;
        for(int i=0;i<L.length;++i) {
        	points[i] = new Point(L[i][0], L[i][3], L[i][2], L[i][1]);
        	maxX = Math.max(maxX, L[i][2]);
        	maxX = Math.max(maxY, L[i][1]);
        }
        dfs(points, 0, N);
        
        return answer;
    }
	
	private static void dfs(Point[] points,int count , int n) {
		if(count > 20 && answer <= count) {
			return;
		}
		if(isOkay(points, n)) {
			answer = Math.min(answer, count);
			return;
		}
		for(int i=0;i<points.length;++i) {
			Point p = points[i];
			for(int j=0;j<4;++j) {
				int startNx = p.startx + dx[i];
				int endNx = p.endx + dx[i];
				int startNy = p.starty + dy[i];
				int endNy = p.endy + dy[i];
				if(isRange(startNx, startNy,n) && isRange(endNx, endNy,n)) {
					points[i] = new Point(startNx, startNy, endNx, endNy);
					dfs(points, count+1, n);
					points[i] = p;
				}
			}
		}
	}

	

	private static boolean isRange(int x, int y, int n) {
		return 0 <= x && x <= 32767 && 0 <= y && y <= 32767;
	}

	private static boolean isOkay(Point[] points, int n) {
		for(int i=0;i<points.length;++i) {
			Point p = points[i];
        	//겹치는 부분 찾기
        	for(int j=0;j<points.length;++j) {
        		if(i != j) {
	        		Point compare = points[j];
	        		if(p.startx <= compare.startx && compare.startx <= p.endx
	        				&& p.starty <= compare.starty && compare.starty <= p.endy) {
	        			return false;
	        		}else if(p.startx <= compare.endx && compare.endx <= p.endx
	        				&& p.starty <= compare.starty && compare.starty <= p.endy) {
	        			return false;
	        		}else if(p.startx <= compare.startx && compare.startx <= p.endx
	        				&& p.starty <= compare.endy && compare.endy <= p.endy) {
	        			return false;
	        		}else if(p.startx <= compare.endx && compare.endx <= p.endx
	        				&& p.starty <= compare.endy && compare.endy <= p.endy) {
	        			return false;
	        		}
        		}
        	}
        }
		return true;
	}

	public static void main(String[] args) {
		//N	L	return
		//3	[[5,7,6,6],[3,9,5,4],[8,2,7,6]]	1
		int[][] L = {{5,7,6,6},{3,9,5,4},{8,2,7,6}};
		solution(3, L);
	}

}
