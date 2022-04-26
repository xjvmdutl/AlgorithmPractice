package baekjoon.workbook.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class ZOAC3 {
	
	private static Set<Character> collection;
	
	static class Point{
		int x;
		int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static class Pad{
		Point sl;
		Point sr;
		public Pad(Point sl, Point sr) {
			this.sl = sl; 
			this.sr = sr; 
		}
		public void updateSr(Point newPoint) {
			sr = newPoint;
		}
		public void updateSl(Point newPoint) {
			sl = newPoint;
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		char sl = tokens.nextToken().charAt(0);
		char sr = tokens.nextToken().charAt(0);
		String str = reader.readLine();
		System.out.println(solution(str, sl, sr));
	}

	private static int solution(String str, char sl, char sr) {
		int answer = 0;
		collection = getCollection();
		char[][] map = getPad();
		Point leftPoint = find(map, sl);
		Point rightPoint = find(map, sr);
		Pad pad = new Pad(leftPoint, rightPoint);
		for(char c : str.toCharArray()) {
			answer += addDistance(map, pad, c);
		}
		
		return answer;
	}
	
	private static Set<Character> getCollection() {
		Set<Character> set = new HashSet<Character>();
		set.add('y');
		set.add('u');
		set.add('i');
		set.add('o');
		set.add('p');
		set.add('h');
		set.add('j');
		set.add('k');
		set.add('l');
		set.add('b');
		set.add('n');
		set.add('m');
		return set;
	}

	private static char[][] getPad() {
		char[][] pad = {
			{'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'},
			{'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'},
			{'z', 'x', 'c', 'v', 'b', 'n', 'm'}
		};		
		return pad;
	}
	
	private static Point find(char[][] map, char find) {
		for(int i=0;i<map.length;++i) {
			for(int j=0;j<map[i].length;++j) {
				if(find == map[i][j]) {
					return new Point(j, i);
				}
			}	
		}
		throw new IllegalArgumentException("Not Found Point " + find);
	}
	
	private static int addDistance(char[][] map, Pad pad, char c) {
		int distance = 0;
		Point newPoint = find(map, c);
		if(isCollection(c)) {
			distance = getDistance(pad.sr, newPoint);
			pad.updateSr(newPoint);
		}else {
			distance =  getDistance(pad.sl, newPoint);
			pad.updateSl(newPoint);
		}
		return distance + 1;
	}
	

	private static int getDistance(Point prePoint, Point newPoint) {
		int xDis = Math.abs(prePoint.x - newPoint.x);
		int yDis = Math.abs(prePoint.y - newPoint.y);
		return xDis + yDis;
	}

	private static boolean isCollection(char c) {
		return collection.contains(c);
	}

	

}
