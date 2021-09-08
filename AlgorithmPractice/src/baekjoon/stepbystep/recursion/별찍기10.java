package baekjoon.stepbystep.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 별찍기10 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		System.out.println(solution(n));
	}

	private static String solution(int n) {
		char[][] arr = new char[n][n];//N*N 배열 선언
		recuit(0,0,n,arr);//재귀함수(시작 i위치,시작 j위치,크기,배열(고정))
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<arr.length;++i) {
			for(int j=0;j<arr.length;++j) {
				sb.append(arr[i][j]);
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	private static void recuit(int x,int y,int size, char[][] arr) {
		//해당 부분은 시작 X부터  X+SIZE까지 하나씩 더하면서 찍는 것이다.
		for(int i=x;i<x+size;++i) {//시작X 부터 X+SIZE까지 반복한다 
			//( EX ) 처음 27일경우 0 ~ 27 -> 0 ~ 27/3
			//						   -> 27/3 ~ 27/3+27/3
			//						   -> 27/3+27/3 ~ 27/3+27/3+27/3
			for(int j=y;j<y+size;++j) {
				//여기서 중간에 있는 부분 9개의 영역중 중간은 빈값을 채워야되기에 if로 구분
				if( (y + (size/3) <= j) && (j < y + (size/3) + (size/3))
					&& (x + (size/3) <= i) && (i < x + (size/3) + (size/3))) {
					arr[i][j] = ' ';
				}else {
					arr[i][j] = '*';	
				}
			}
		}
		// 더이상 쪼갤 수 없는 블록일 때
		if (size == 3) {
			return;
		}
		//주의 할점 : 재귀함수를 호출해야 되는 영역은 
		//	x,y 			: 	x ,y + size/3 				: x ,y + 2*(size/3)
		//	x+size/3,y 		: 	x + size/3,y + size/3(호출x)	: x + size/3,y + 2*(size/3)
		//	x+2*(size/3),y	: 	x + 2*(size/3),y + size/3 	: x + 2*(size/3),y + 2*(size/3)
		//이라서 i를  += size/3 (여기서 x) , j를 += size/3 (여기서 y )를하는것이다.
		for (int i = x; i < x + size; i += size/3) {//한영역에 대하여 3 * 3 으로 분할 i ~ i+size
													//						   j ~ j+size
													// 						위치를 3분할 할것이다
			//매개변수를 재귀적으로 호출한다.
			//( EX ) 처음 27일경우 0 -> 0				-> ....
			//					  -> 27/3			-> 27/3
			//										-> 27/3/3
			//										-> 27/3/3+27/3/3
			//				      -> 27/3+27/3		-> ...
			for (int j = y; j < y + size; j += size/3) {
			//Y도 위와 동일
				if(i == x + size/3 && j == y + size/3) {//중간값일경우
					//9개의 분할 영역중에 중간에 있을경우 재귀 함수를 호출할 필요가 없다.
					continue;
				}
				recuit(i, j, size/3, arr);
			}
		}
	}

}
