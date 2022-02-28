package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;
class Blizard{
	int number;
	int count;
	public Blizard(int number) {
		this.number = number;
		this.count = 1;
	}
	public boolean isSame(int same) {
		return number == same;
	}
	public void upCount() {
		count++;
	}
	public void downCount() {
		count--;
	}
	public boolean isOver() {
		return count >= 4;
	}
	public boolean isZero() {
		return count <= 0;
	}
}
class Shark{
	int x;
	int y;
	public Shark(int x,int y) {
		this.x = x;
		this.y =y;
	}
}
public class 마법사상어와블리자드 {
	public static Map<Integer, Integer> hashMap;
	public static Stack<Blizard> stack;
	public static Stack<Blizard> reverseStack;
	public static int count;
	public static int[] dx = {0,0,-1,1};
	public static int[] dy = {-1,1,0,0};
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int m = Integer.parseInt(tokens.nextToken());
		int[][] map = new int[n][n];
		for(int i=0;i<n;++i) {
			tokens = new StringTokenizer(reader.readLine());
			for(int j=0;j<n;++j) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
			}	
		}
		int[][] arr = new int[m][2];
		for(int i=0;i<m;++i) {
			tokens = new StringTokenizer(reader.readLine());
			arr[i][0] = Integer.parseInt(tokens.nextToken())-1;
			arr[i][1] = Integer.parseInt(tokens.nextToken());
		}
		System.out.println(solution(map, arr, n, m));
	}

	private static int solution(int[][] map, int[][] arr, int n, int m) {
		hashMap = new HashMap<>();
		for(int i=0;i<m;++i) {
			fireBallBreak(map, arr[i][0], arr[i][1], n);
			removeBall(map, n);
			map = new int[n][n];
			reverseStack = new Stack<Blizard>();
			reverse();
			insertBall(map, n);
		}
		int answer = counting();
		return answer;
	}

	private static int counting() {
		int n1 = hashMap.containsKey(1) ? hashMap.get(1) : 0;
		int n2 = hashMap.containsKey(2) ? hashMap.get(2) * 2 : 0;
		int n3 = hashMap.containsKey(3) ? hashMap.get(3) * 3 : 0;
		return n1 + n2 + n3;
	}

	private static void reverse() {
		while(!stack.isEmpty()) {
			reverseStack.push(stack.pop());
		}
	}

	private static void insertBall(int[][] map, int n) {
		int x = (n/2);
		int y = (n/2);
		count = 0;
		List<Shark> list = new ArrayList<>();
		OUTER:for(int i=0;i<n;++i) {
			if(i%2 == 0) {
				for(int j=0;j<=i;++j) {
					x--;
					if(x < 0) {
						break OUTER;
					}
					list.add(new Shark(x, y));
					if(isConvert(map, n, list) ) {
						count++;
						insert(map, list);
						list.clear();
					}
				}
				for(int j=0;j<=i;++j) {
					y++;
					list.add(new Shark(x, y));
					if(isConvert(map, n, list)) {
						count++;
						insert(map, list);
						list.clear();
					}
				}
			}else {
				for(int j=0;j<=i;++j) {
					x++;
					list.add(new Shark(x, y));
					if(isConvert(map, n, list)) {
						count++;
						insert(map, list);
						list.clear();
					}
				}
				for(int j=0;j<=i;++j) {
					y--;
					list.add(new Shark(x, y));
					if(isConvert(map, n, list)) {
						count++;
						insert(map, list);
						list.clear();
					}
				}
			}
		}
	}

	

	private static boolean isConvert(int[][] map, int n, List<Shark> list) {
		return list.size() >= 2 && count <= ((n*n) /2);
	}

	private static void insert(int[][] map, List<Shark> list) {
		if(reverseStack.isEmpty()) {
			return;
		}
		Blizard b = reverseStack.pop();
		map[list.get(0).y][list.get(0).x] = b.count;
		map[list.get(1).y][list.get(1).x] = b.number;
	}
	
	private static void removeBall(int[][] map, int n) {
		stack = new Stack<>();
		int x = n/2;
		int y = n/2;
		OUTER:for(int i=0;i<n;++i) {
			if(i%2 == 0) {
				for(int j=0;j<=i;++j) {
					x--;
					if(x < 0) {
						break OUTER;
					}
					if(!isOkay(n)) {
						break OUTER;
					}
					check(map[y][x]);
				}
				for(int j=0;j<=i;++j) {
					y++;
					if(!isOkay(n)) {
						break OUTER;
					}
					check(map[y][x]);
				}
			}else {
				for(int j=0;j<=i;++j) {
					x++;
					if(!isOkay(n)) {
						break OUTER;
					}
					check(map[y][x]);
				}
				for(int j=0;j<=i;++j) {
					if(!isOkay(n)) {
						break OUTER;
					}
					y--;
					check(map[y][x]);
				}
			}
		}
		checkFinally();
	}


	private static boolean isOkay(int n) {
		return stack.size()  * 2 <= n * n;
	}

	private static void checkFinally() {
		if(stack.isEmpty()) {
			return;
		}else if(stack.peek().isOver()) {
			Blizard b = stack.pop();
			hashMap.put(b.number, hashMap.getOrDefault(b.number, 0)+ b.count);
		}
	}

	private static void check(int number) {
		if(number == 0)
			return;
		if(stack.isEmpty()) {
			stack.push(new Blizard(number));
			return;
		}
		if(stack.peek().isSame(number)) {
			stack.peek().upCount();
		}else {
			if(stack.peek().isOver()) {
				Blizard b = stack.pop();
				hashMap.put(b.number, hashMap.getOrDefault(b.number, 0)+ b.count);
			}
			if(stack.isEmpty()) {
				stack.push(new Blizard(number));
			}else {
				if(!stack.peek().isSame(number)) {
					stack.push(new Blizard(number));
				}else {
					stack.peek().upCount();
				}
			}
		}
	}

	private static void fireBallBreak(int[][] map, int dir, int length, int n) {
		int x = (n/2);
		int y = (n/2);
		for(int i=1;i<=length;++i) {
			int nx = x + (dx[dir]*i);
			int ny = y + (dy[dir]*i);
			map[ny][nx] = 0;
		}
	}

}
