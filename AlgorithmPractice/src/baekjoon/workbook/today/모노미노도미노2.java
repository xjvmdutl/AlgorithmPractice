package baekjoon.workbook.today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 모노미노도미노2 {
	public static int score;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[][] arr = new int[n][3];
		for(int i=0;i<n;++i) {
			StringTokenizer tokens = new StringTokenizer(reader.readLine());
			arr[i][0] = Integer.parseInt(tokens.nextToken());
			arr[i][1] = Integer.parseInt(tokens.nextToken());
			arr[i][2] = Integer.parseInt(tokens.nextToken());
		}
		System.out.println(solution(arr, n));
	}

	private static String solution(int[][] arr, int n) {
		StringBuilder sb = new StringBuilder();
		score = 0;
		boolean[][] blue = new boolean[4][6];
		boolean[][] green = new boolean[6][4];
		for(int i=0;i<n;++i) {
			int t = arr[i][0];
			int x = arr[i][1];
			int y = arr[i][2];
			fillBlue(blue,x,t);
			fillGreen(green,y,t);
			breakenBlue(blue);
			breakenGreen(green);
		}
		int cnt = count(blue, green);
		sb.append(score + "\n");
		sb.append(cnt );
		return sb.toString();
	}

	private static int count(boolean[][] blue, boolean[][] green) {
		int count = 0;
		for(int i=0;i<blue.length;++i) {
			for(int j=0;j<blue[i].length;++j) {
				if(blue[i][j])
					count++;
			}	
		}
		for(int i=0;i<green.length;++i) {
			for(int j=0;j<green[i].length;++j) {
				if(green[i][j])
					count++;
			}	
		}
		
		return count;
	}

	private static void breakenGreen(boolean[][] green) {
		List<Integer> list = new ArrayList<>();
		for(int i=5; i>=2;--i) {
			boolean tf1 = green[i][0];
			boolean tf2 = green[i][1];
			boolean tf3 = green[i][2];
			boolean tf4 = green[i][3];
			if(tf1 && tf2 && tf3 && tf4) {
				list.add(i);
			}
		}
		if(list.size() > 0) {
			moveGreen(green, list);
		}
		list.clear();
		for(int i=1;i>=0;--i) {
			boolean tf1 = green[i][0];
			boolean tf2 = green[i][1];
			boolean tf3 = green[i][2];
			boolean tf4 = green[i][3];
			if(tf1 || tf2 || tf3 || tf4) {
				list.add(i);
			}
		}
		if(list.size() > 0) {
			for(int i=0;i<list.size();++i) {
				moveLastTwoGreen(green);
			}
		}
		
	}

	private static void moveLastTwoGreen(boolean[][] green) {
		for(int i=5;i>0;--i) {
			green[i][0] = green[i-1][0];
			green[i][1] = green[i-1][1];
			green[i][2] = green[i-1][2];
			green[i][3] = green[i-1][3];
		}
		green[0][0] = false;
		green[0][1] = false;
		green[0][2] = false;
		green[0][3] = false;
	}

	private static void moveGreen(boolean[][] green, List<Integer> list) {
		Collections.sort(list, (o1,o2)->o1-o2);
		for(int index : list) {
			for(int i=index;i>0;--i) {
				green[i][0] = green[i-1][0];
				green[i][1] = green[i-1][1];
				green[i][2] = green[i-1][2];
				green[i][3] = green[i-1][3];
			}
			green[0][0] = false;
			green[0][1] = false;
			green[0][2] = false;
			green[0][3] = false;
			score++;
		}
	}

	private static void breakenBlue(boolean[][] blue) {
		List<Integer> list = new ArrayList<>();
		for(int i=5; i>=2;--i) {
			boolean tf1 = blue[0][i];
			boolean tf2 = blue[1][i];
			boolean tf3 = blue[2][i];
			boolean tf4 = blue[3][i];
			if(tf1 && tf2 && tf3 && tf4) {
				list.add(i);
			}
		}
		if(list.size() > 0) {
			moveBlue(blue, list);
		}
		list.clear();
		for(int i=1;i>=0;--i) {
			boolean tf1 = blue[0][i];
			boolean tf2 = blue[1][i];
			boolean tf3 = blue[2][i];
			boolean tf4 = blue[3][i];
			if(tf1 || tf2 || tf3 || tf4) {
				list.add(i);
			}
		}
		if(list.size() > 0) {
			for(int i=0;i<list.size();++i) {
				moveLastTwoBlue(blue);
			}
		}
		
	}
	private static void moveLastTwoBlue(boolean[][] blue) {
		for(int i=5;i>0;--i) {
			blue[0][i] = blue[0][i-1];
			blue[1][i] = blue[1][i-1];
			blue[2][i] = blue[2][i-1];
			blue[3][i] = blue[3][i-1];
		}
		blue[0][0] = false;
		blue[1][0] = false;
		blue[2][0] = false;
		blue[3][0] = false;
	}

	private static void moveBlue(boolean[][] blue, List<Integer> list) {
		Collections.sort(list, (o1,o2)->o1-o2);
		for(int index : list) {
			for(int i=index;i>0;--i) {
				blue[0][i] = blue[0][i-1];
				blue[1][i] = blue[1][i-1];
				blue[2][i] = blue[2][i-1];
				blue[3][i] = blue[3][i-1];
			}
			blue[0][0] = false;
			blue[1][0] = false;
			blue[2][0] = false;
			blue[3][0] = false;
			score++;
		}
	}

	private static void fillGreen(boolean[][] green, int y, int t) {
		if(t == 1) {
			oneMoveGreen(green, y);
		}else if(t == 2) {
			twoMoveGreen(green, y, y+1);
		}else if(t == 3) {
			twoMoveGreen(green, y);
		}
	}

	

	private static void fillBlue(boolean[][] blue, int x, int t) {
		if(t == 1) {
			oneMoveBlue(blue, x);
		}else if(t == 2) {
			twoMoveBlue(blue, x);
		}else if(t == 3) {
			twoMoveBlue(blue, x, x+1);
		}
	}

	

	


	private static void oneMoveGreen(boolean[][] green, int y) {
		int max = 0;
		for(int i=0;i<=5;++i) {
			if(!green[i][y]) {
				max = i;
			}else {
				break;
			}
		}
		green[max][y] = true;
	}

	private static void twoMoveGreen(boolean[][] green, int y1, int y2) {
		int max = 0;
		for(int i=0;i<=5;++i) {
			if(!green[i][y1] && !green[i][y2]) {
				max = i;
			}else {
				break;
			}
		}
		green[max][y1] = true;
		green[max][y2] = true;

	}

	private static void twoMoveGreen(boolean[][] green, int y) {
		int max = 0;
		for(int i=0;i<=5;++i) {
			if(!green[i][y]) {
				max = i;
			}else {
				break;
			}
		}
		green[max][y] = true;
		green[max-1][y] = true;
	}
	
	private static void oneMoveBlue(boolean[][] blue, int x) {
		int max = 0;
		for(int i=0;i<=5;++i) {
			if(!blue[x][i]) {
				max = i;
			}else {
				break;
			}
		}
		blue[x][max] = true;
	}
	
	private static void twoMoveBlue(boolean[][] blue, int x) {
		int max = 0;
		for(int i=0;i<=5;++i) {
			if(!blue[x][i]) {
				max = i;
			}else {
				break;
			}
		}
		blue[x][max] = true;
		blue[x][max-1] = true;
	}
	
	private static void twoMoveBlue(boolean[][] blue, int x1, int x2) {
		int max = 0;
		for(int i=0;i<=5;++i) {
			if(!blue[x1][i] && !blue[x2][i]) {
				max = i;
			}else {
				break;
			}
		}
		blue[x1][max] = true;
		blue[x2][max] = true;
	}

}
