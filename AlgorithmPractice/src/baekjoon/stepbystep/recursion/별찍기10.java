package baekjoon.stepbystep.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class �����10 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		System.out.println(solution(n));
	}

	private static String solution(int n) {
		char[][] arr = new char[n][n];//N*N �迭 ����
		recuit(0,0,n,arr);//����Լ�(���� i��ġ,���� j��ġ,ũ��,�迭(����))
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
		//�ش� �κ��� ���� X����  X+SIZE���� �ϳ��� ���ϸ鼭 ��� ���̴�.
		for(int i=x;i<x+size;++i) {//����X ���� X+SIZE���� �ݺ��Ѵ� 
			//( EX ) ó�� 27�ϰ�� 0 ~ 27 -> 0 ~ 27/3
			//						   -> 27/3 ~ 27/3+27/3
			//						   -> 27/3+27/3 ~ 27/3+27/3+27/3
			for(int j=y;j<y+size;++j) {
				//���⼭ �߰��� �ִ� �κ� 9���� ������ �߰��� ���� ä���ߵǱ⿡ if�� ����
				if( (y + (size/3) <= j) && (j < y + (size/3) + (size/3))
					&& (x + (size/3) <= i) && (i < x + (size/3) + (size/3))) {
					arr[i][j] = ' ';
				}else {
					arr[i][j] = '*';	
				}
			}
		}
		// ���̻� �ɰ� �� ���� ����� ��
		if (size == 3) {
			return;
		}
		//���� ���� : ����Լ��� ȣ���ؾ� �Ǵ� ������ 
		//	x,y 			: 	x ,y + size/3 				: x ,y + 2*(size/3)
		//	x+size/3,y 		: 	x + size/3,y + size/3(ȣ��x)	: x + size/3,y + 2*(size/3)
		//	x+2*(size/3),y	: 	x + 2*(size/3),y + size/3 	: x + 2*(size/3),y + 2*(size/3)
		//�̶� i��  += size/3 (���⼭ x) , j�� += size/3 (���⼭ y )���ϴ°��̴�.
		for (int i = x; i < x + size; i += size/3) {//�ѿ����� ���Ͽ� 3 * 3 ���� ���� i ~ i+size
													//						   j ~ j+size
													// 						��ġ�� 3���� �Ұ��̴�
			//�Ű������� ��������� ȣ���Ѵ�.
			//( EX ) ó�� 27�ϰ�� 0 -> 0				-> ....
			//					  -> 27/3			-> 27/3
			//										-> 27/3/3
			//										-> 27/3/3+27/3/3
			//				      -> 27/3+27/3		-> ...
			for (int j = y; j < y + size; j += size/3) {
			//Y�� ���� ����
				if(i == x + size/3 && j == y + size/3) {//�߰����ϰ��
					//9���� ���� �����߿� �߰��� ������� ��� �Լ��� ȣ���� �ʿ䰡 ����.
					continue;
				}
				recuit(i, j, size/3, arr);
			}
		}
	}

}
