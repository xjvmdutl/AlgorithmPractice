package progammers.level2;

import java.util.HashMap;
import java.util.Map;

class Point {
	int x;
	int y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class 방문길이 {
	
	public static int solution(String dirs) {
		int x=0 ,y=0;
        Map<Point, Character> map = new HashMap<>();
        Point p = null;
        for(int i=0;i<dirs.length();++i) {
        	char c = dirs.charAt(i);
        	if(c == 'U') {
        		if(y < 5) {
        			p = new Point(x,++y);	
        		}else {
        			continue;
        		}
        	}else if(c == 'D') {
        		if(y > -5) {
        			p = new Point(x,--y);	
        		}else {
        			continue;
        		}
        	}else if(c == 'L') {
        		if(x > -5) {
        			p = new Point(--x,y);	
        		}else {
        			continue;
        		}
        		
        	}else if(c == 'R') {
        		if(x < 5) {
        			p = new Point(++x,y);	
        		}else {
        			continue;
        		}
        		
        	}
        	boolean visited = false;
        	for(Point ptr : map.keySet()) {
        		if(ptr.x == p.x && ptr.y == p.y && map.get(ptr) == c) {
        			visited=true;
        			break;
        		}
        		if(c == 'U') {
        			if(ptr.x == p.x && (ptr.y+1) == p.y && map.get(ptr) == 'D') {
            			visited=true;
            			break;
            		}
            	}else if(c == 'D') {
            		if(ptr.x == p.x && (ptr.y-1) == p.y && map.get(ptr) == 'U') {
            			visited=true;
            			break;
            		}
            	}else if(c == 'L') {
            		if((ptr.x-1) == p.x && ptr.y == p.y && map.get(ptr) == 'R') {
            			visited=true;
            			break;
            		}
            	}else if(c == 'R') {
            		if((ptr.x+1) == p.x && ptr.y == p.y && map.get(ptr) == 'L') {
            			visited=true;
            			break;
            		}
            	}
        	}
        	if(!visited) {
        	    map.put(p, c);	
        	}
        	
        }
        return map.size();
    }
	
	public static void main(String[] args) {
		//dirs	answer
		//"ULURRDLLU"	7
		//"LULLLLLLU"	7
		String dirs1 = "ULURRDLLU";
		String dirs2 = "LULLLLLLU";
		String dirs3 = "UDUDUDUDUD";
		System.out.println(solution(dirs1));
		System.out.println(solution(dirs2));
		System.out.println(solution(dirs3));
	}

}
