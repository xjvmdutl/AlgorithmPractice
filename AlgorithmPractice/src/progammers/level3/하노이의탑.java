package progammers.level3;

import java.util.ArrayList;
import java.util.List;
class Hanoi{
	int x;
	int y;
	public Hanoi(int x,int y){
		this.x = x;
		this.y = y;
	}
}
public class 하노이의탑 {
	public static List<Hanoi> list;
	public static int count = 0;
	public static int[][] solution(int n) {
        
        list = new ArrayList<>();
        hanoi(n,1,3);
        int[][] answer = new int[list.size()][2];
        for(int i=0;i<list.size();++i) {
        	answer[i][0] = list.get(i).x;
        	answer[i][1] = list.get(i).y;
        }
        return answer;
    }
	private static void hanoi(int n, int x, int y) {
		if(n > 1) {
			hanoi(n-1, x, 6-x-y);//중간기둥 이동
		}
		list.add(new Hanoi(x,y));
		if(n>1) {
			hanoi(n-1, 6-x-y, y);
		}   
	}
	public static void main(String[] args) {
		System.out.println(solution(5));
	}
}
