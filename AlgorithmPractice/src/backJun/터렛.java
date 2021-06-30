package backJun;

import java.util.Scanner;
public class ≈Õ∑ø {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i = 0;i<t;++i) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int r1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			int r2 = sc.nextInt();
			System.out.println(solution(x1,y1,r1,x2,y2,r2));
			
		}
	}

	private static int solution(int x1, int y1, int r1, int x2, int y2, int r2) {
		double d = Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2) );
		if(d ==0 && r1==r2) {//π´«—»˜ ∞„ƒß
			return -1;
		}else if(d > Math.abs(r2-r1) && d < r1+r2) {
			return 2;
		}else if(Math.abs(r2-r1) == d || r2+r1==d) {
			return 1;
		}else if(r1 + r2 < d || Math.abs(r2-r1)>d || d==0) {
			return 0;
		}
		return 0;
	}
	

}
