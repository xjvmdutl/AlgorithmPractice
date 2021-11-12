package baekjoon.problems.algorithmPratice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LCDTest {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int s = Integer.parseInt(tokens.nextToken());
		String print = tokens.nextToken();
		System.out.println(solution(s,print));
	}

	private static String solution(int s, String print) {
		char[][] map = new char[(2*s)+3][(s+3)*print.length()];
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<map.length;++i) {
			for(int j=0;j<map[i].length;++j)
				map[i][j] = ' ';
		}
		for(int i=0;i<print.length();++i) {
			char c = print.charAt(i);
			PrintMap(map,i,c,s);
		}
		for(int i=0;i<map.length;++i) {
			sb.append(String.valueOf(map[i])+"\n");
		}
		return sb.toString();
		
	}

	private static void PrintMap(char[][] map, int index, char c, int s) {
		if(c == '1') {
			fill(map,index,s,3);
			fill(map,index,s,6);
			
		}else if(c == '2') {
			fill(map, index, s, 1);
			fill(map, index, s, 3);
			fill(map, index, s, 4);
			fill(map, index, s, 5);
			fill(map, index, s, 7);
		}else if(c == '3') {
			fill(map, index, s, 1);
			fill(map, index, s, 3);
			fill(map, index, s, 4);
			fill(map, index, s, 6);
			fill(map, index, s, 7);
		}else if(c == '4') {
			fill(map, index, s, 2);
			fill(map, index, s, 3);
			fill(map, index, s, 4);
			fill(map, index, s, 6);
		}else if(c == '5') {
			fill(map, index, s, 1);
			fill(map, index, s, 2);
			fill(map, index, s, 4);
			fill(map, index, s, 6);
			fill(map, index, s, 7);
		}else if(c == '6') {
			fill(map, index, s, 1);
			fill(map, index, s, 2);
			fill(map, index, s, 4);
			fill(map, index, s, 5);
			fill(map, index, s, 6);
			fill(map, index, s, 7);
		}else if(c == '7') {
			fill(map, index, s, 1);
			fill(map, index, s, 3);
			fill(map, index, s, 6);
		}else if(c == '8') {
			fill(map, index, s, 1);
			fill(map, index, s, 2);
			fill(map, index, s, 3);
			fill(map, index, s, 4);
			fill(map, index, s, 5);
			fill(map, index, s, 6);
			fill(map, index, s, 7);
		}else if(c == '9') {
			fill(map, index, s, 1);
			fill(map, index, s, 2);
			fill(map, index, s, 3);
			fill(map, index, s, 4);
			fill(map, index, s, 6);
			fill(map, index, s, 7);
		}else if(c == '0') {
			fill(map, index, s, 1);
			fill(map, index, s, 2);
			fill(map, index, s, 3);
			fill(map, index, s, 5);
			fill(map, index, s, 6);
			fill(map, index, s, 7);
		}
	}

	private static void fill(char[][] map, int index, int s, int number) {
		/*
		 *  	 -- (1)
		 * 		|(2)|(3)
		 *   	|	|
		 *   	 --(4)
		 *   	|(5)|(6)
		 *   	|	|
		 *   	 --(7)
		 */
		//if(1)
		if(number == 1) {
			for(int j=(s+3)*index+1;j<(s+3)*(index+1)-2;++j) {
				map[0][j] ='-';
			}
		}else if(number == 2) {
			for(int i=1;i<=s;++i) {
				map[i][(s+3)*index] ='|';
			}
		}else if(number == 3) {
			for(int i=1;i<=s;++i) {
				map[i][(s+3)*(index+1) - 2] ='|';
			}
		}else if(number == 4) {
			for(int j=(s+3)*index+1;j<(s+3)*(index+1)-2;++j) {
				map[s+1][j] ='-';
			}
		}else if(number == 5){
			for(int i=s+2;i<2*s+2;++i) {
				map[i][(s+3)*index] ='|';
			}
		}else if(number == 6) {
			for(int i=s+2;i<=2*s+1;++i) {
				map[i][(s+3)*(index+1) - 2] ='|';
			}
		}else if(number == 7) {
			for(int j=(s+3)*index+1;j<(s+3)*(index+1)-2;++j) {
				map[2*s+2][j] ='-';
			}
		}
	}
    
}
/*
      --   --        --   --   --   --   --   --  
   |    |    | |  | |    |       | |  | |  | |  | 
   |    |    | |  | |    |       | |  | |  | |  | 
      --   --   --   --   --        --   --       
   | |       |    |    | |  |    | |  |    | |  | 
   | |       |    |    | |  |    | |  |    | |  | 
      --   --        --   --        --   --   --  
*/