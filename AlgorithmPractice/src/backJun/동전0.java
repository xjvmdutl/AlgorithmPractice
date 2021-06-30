package backJun;

import java.util.Scanner;

public class µ¿Àü0 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		int N = Integer.parseInt(line.split(" ")[0]);
		int K = Integer.parseInt(line.split(" ")[1]);
		int[] collect = new int[N];
		for(int i=0;i<N;++i) {
			collect[i] = sc.nextInt();
		}
		System.out.println(solution(K,collect));
		
	}

	private static int solution(int k, int[] collect) {
		int cnt =0;
		for(int i = collect.length-1;i>=0;--i) {
			if(k > collect[i]) {
				cnt += k/collect[i];
				k %= collect[i];
				if(k == 0)
					break;
			}
		}
		return cnt;
	}

}
