package progammers.weekly;

import java.util.HashSet;

class Point{
	int x;
	int y;
	public Point(int x,int y) {
		this.x = x;
		this.y = y;
	}
	 @Override
    public boolean equals(Object a) {
        Point obj = (Point) a;
        return (obj.x == this.x && obj.y == this.y);
    }

    @Override
    public int hashCode() {
        return x+y;
    }
}
public class 교점에별만들기 {
	public static String[] solution(int[][] line) {
        
        HashSet<Point> set = new HashSet<>();
        int maxX = -1001;
        int maxY = -1001;
        int minX = 1001;
        int minY = 1001;
        for(int i=0;i<line.length;++i) {
        	for(int j=i+1;j<line.length;++j) {
        		long a = line[i][0];
        		long b = line[i][1];
        		long e = line[i][2];
        		long c = line[j][0];
        		long d = line[j][1];
        		long f = line[j][2];
        		
        		double variable1 = (double)(b*f-e*d)/(a*d - b*c);
        		double variable2 = (double)(e*c-a*f)/(a*d - b*c);
        		if ((variable1 == Math.floor(variable1)) && !Double.isInfinite(variable1)
        				&&(variable2 == Math.floor(variable2)) && !Double.isInfinite(variable2)) {
        			int x= (int) variable1;
        			int y= (int) variable2;
        			maxX = Math.max(maxX, x);
            		minX = Math.min(minX, x);
            		maxY = Math.max(maxY, y);
            		minY = Math.min(minY, y);
            		set.add(new Point(x, y));
        		}
        	}
        }
      
        String[] answer = new String[maxY-minY+1];
        int idx = 0;
        for(int i=maxY;i>=minY;--i) {
        	StringBuilder sb = new StringBuilder();
        	for(int j=minX;j<=maxX;++j) {
        		Point p = new Point(j,i);
        		if(set.contains(p))
        			sb.append("*");
        		else
        			sb.append(".");
            }	
        	answer[idx++] = sb.toString();
        }
        return answer;
    }
	public static void main(String[] args) {
		//line	result
		//[[2, -1, 4], [-2, -1, 4], [0, -1, 1], [5, -8, -12], [5, 8, 12]]	["....*....", ".........", ".........", "*.......*", ".........", ".........", ".........", ".........", "*.......*"]
		//[[0, 1, -1], [1, 0, -1], [1, 0, 1]]	["*.*"]
		//[[1, -1, 0], [2, -1, 0]]	["*"]
		//[[1, -1, 0], [2, -1, 0], [4, -1, 0]]	["*"]
		int[][] line1 = {{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}};
		System.out.println(solution(line1));
		int[][] line2 = {{0, 1, -1}, {1, 0, -1}, {1, 0, 1}};
		System.out.println(solution(line2));
		int[][] line3 = {{1, -1, 0}, {2, -1, 0}};
		System.out.println(solution(line3));
		int[][] line4 = {{100000, 100000, 100000}, {100000, 100000, 100000}, {4, -1, 0}};
		System.out.println(solution(line4));
		
	}

}
