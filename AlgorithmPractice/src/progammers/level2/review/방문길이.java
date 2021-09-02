package progammers.level2.review;

import java.util.HashSet;
import java.util.Set;

class visit{
	int x;
	int y;
	char l;
	public visit(int x,int y,char l) {
		this.x = x;
		this.y = y;
		this.l = l;
	}
	@Override
	public boolean equals(Object o) {
		if(o instanceof visit) {
			visit obj = (visit)o;
			if(this.x == obj.x && this.y == obj.y && this.l == obj.l) {
				return true;
			}else {
				return false;
			}
		}
		return super.equals(o);
	}
	@Override
	public int hashCode() {
		return this.x * 100 + this.y * 10;
	}
	
}
public class 방문길이 {
	public static Set<visit> set;
	public static int solution(String dirs) {
        int answer = 0;
        int x = 0;
        int y = 0;
        set = new HashSet<>();
        for(int i=0;i<dirs.length();++i) {
        	char c = dirs.charAt(i);
        	if(c == 'U') {
        		int nx = x;
        		int ny = y+1;
        		if(-5 <= nx && nx <= 5 && -5 <= ny && ny <= 5) {
        			set.add(new visit(x, y, 'U'));
        			set.add(new visit(nx, ny, 'D'));
        			x = nx;
        			y = ny;
        		}
        	}else if(c == 'D') {
        		int nx = x;
        		int ny = y-1;
        		if(-5 <= nx && nx <= 5 && -5 <= ny && ny <= 5) {
        			set.add(new visit(x, y, 'D'));
        			set.add(new visit(nx, ny, 'U'));
        			x = nx;
        			y = ny;
        		}
        	}else if(c == 'R') {
        		int nx = x+1;
        		int ny = y;
        		if(-5 <= nx && nx <= 5 && -5 <= ny && ny <= 5) {
        			set.add(new visit(x, y, 'R'));
        			set.add(new visit(nx, ny, 'L'));
        			x = nx;
        			y = ny;
        		}
        	}else if(c == 'L') {
        		int nx = x-1;
        		int ny = y;
        		if(-5 <= nx && nx <= 5 && -5 <= ny && ny <= 5) {
        			set.add(new visit(x, y, 'L'));
        			set.add(new visit(nx, ny, 'R'));
        			x = nx;
        			y = ny;
        		}
        	}
        }
        System.out.println(set.size()/2);
        return answer;
    }
	public static void main(String[] args) {
		//dirs	answer
		//"ULURRDLLU"	7
		//"LULLLLLLU"	7
		System.out.println(solution("ULURRDLLU"));
		System.out.println(solution("LULLLLLLU"));
	}

}
