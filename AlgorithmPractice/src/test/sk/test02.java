package test.sk;
class Point{
	int x;
	int y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class test02 {
	public static int count;
	public static int[][] solution(int n, boolean clockwise) {
        int[][] answer = new int[n][n];
        first(answer, clockwise, n);
        second(answer, clockwise, n);
        third(answer, clockwise, n);
        fourth(answer, clockwise, n);
        if(n % 2 == 1) {
        	answer[n/2][n/2] = ++count;
        }
        return answer;
    }
	private static void fourth(int[][] answer, boolean clockwise, int n) {
		// TODO Auto-generated method stub
		count = 1;
		int startX = n-1;
		int startY = n-1;
		answer[startY][startX] = count;
		Point p = new Point(startX, startY);
		if(clockwise) {
			int r = n-1;
			for(int i=0;i<n/2;++i) {
				if(i%4 == 0) {
					left(answer, p, n-r);
					r--;
				}else if(i%4 == 1) {
					top(answer, p, n-r);
					r--;
				}else if(i%4 == 2) {
					rigth(answer, p, r--);
				}else if(i%4 == 3) {
					bottom(answer, p, r--);
				}
			}
		}else {
			int r = n-1;
			for(int i=0;i<n/2;++i) {
				if(i%4 == 0) {
					top(answer, p, n-r);
					r--;
				}else if(i%4 == 1) {
					left(answer, p, n-r);
					r--;
				}else if(i%4 == 2) {
					bottom(answer, p, r--);
				}else if(i%4 == 3) {
					rigth(answer, p, r--);
				}
			}
		}
	}
	private static void third(int[][] answer, boolean clockwise, int n) {
		count = 1;
		int startX = 0;
		int startY = n-1;
		answer[startY][startX] = count;
		Point p = new Point(startX, startY);
		if(clockwise) {
			int r = n-1;
			for(int i=0;i<n/2;++i) {
				if(i%4 == 0) {
					top(answer, p, n-r);
					r--;
				}else if(i%4 == 1) {
					rigth(answer, p, r--);
				}else if(i%4 == 2) {
					bottom(answer, p, r--);
				}else if(i%4 == 3) {
					left(answer, p, n-r);
					r--;
				}
			}
		}else {
			int r = n-1;
			for(int i=0;i<n/2;++i) {
				if(i%4 == 0) {
					rigth(answer, p, r--);
				}else if(i%4 == 1) {
					top(answer, p, n-r);
					r--;
				}else if(i%4 == 2) {
					left(answer, p, n-r);
					r--;
				}else if(i%4 == 3) {
					bottom(answer, p, r--);
				}
			}
		}
	}
	private static void second(int[][] answer, boolean clockwise, int n) {
		count = 1;
		int startX = n-1;
		int startY = 0;
		answer[startY][startX] = count;
		Point p = new Point(startX, startY);
		if(clockwise) {
			int r = n-1;
			for(int i=0;i<n/2;++i) {
				if(i%4 == 0) {
					bottom(answer, p, r--);
				}else if(i%4 == 1) {
					left(answer, p, n-r);
					r--;
				}else if(i%4 == 2) {
					top(answer, p, n-r);
					r--;
				}else if(i%4 == 3) {
					rigth(answer, p, r--);
				}
			}
		}else {
			int r = n-1;
			for(int i=0;i<n/2;++i) {
				if(i%4 == 0) {
					left(answer, p, n-r);
					r--;
				}else if(i%4 == 1) {
					bottom(answer, p, r--);
				}else if(i%4 == 2) {
					rigth(answer, p, r--);
				}else if(i%4 == 3) {
					top(answer, p, n-r);
					r--;
				}
			}
		}
	}
	private static void first(int[][] answer, boolean clockwise, int n) {
		count = 1;
		int startX = 0;
		int startY = 0;
		answer[startY][startX] = count;
		Point p = new Point(startX, startY);
		if(clockwise) {
			int r = n-1;
			for(int i=0;i<n/2;++i) {
				if(i%4 == 0) {
					rigth(answer, p, r--);
				}else if(i%4 == 1) {
					bottom(answer, p, r--);
				}else if(i%4 == 2) {
					left(answer, p, n - r);
					r--;
				}else if(i%4 == 3) {
					top(answer, p, n - r);
					r--;
				}
			}
		}else {
			int r = n-1;
			for(int i=0;i<n/2;++i) {
				if(i%4 == 0) {
					bottom(answer, p, r--);
				}else if(i%4 == 1) {
					rigth(answer, p, r--);
				}else if(i%4 == 2) {
					top(answer, p, n - r);
					r--;
				}else if(i%4 == 3) {
					left(answer, p, n - r);
					r--;
				}
			}
		}
	}
	
	private static void top(int[][] answer, Point p, int n) {
		for(int i=p.y;i>n;--i) {
			p.y--;
			count++;
			answer[p.y][p.x] = count;
		}
	}
	private static void left(int[][] answer, Point p, int n) {
		for(int i=p.x;i>n;--i) {
			p.x--;
			count++;
			answer[p.y][p.x] = count;
		}
	}
	private static void bottom(int[][] answer, Point p, int n) {
		for(int i=p.y+1;i<n;++i) {
			p.y++;
			count++;
			answer[p.y][p.x] = count;
		}
	}
	private static void rigth(int[][] answer, Point p, int n) {
		for(int i=p.x+1;i<n;++i) {
			p.x++;
			count++;
			answer[p.y][p.x] = count;
		}
	}
	public static void main(String[] args) {
		System.out.println(solution(6,false));
	}

}
