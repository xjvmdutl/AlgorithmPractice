package backJun;

import java.util.Scanner;

public class Æò¹üÇÑ¹è³¶ {
	public static int virtical;
	public static boolean[] visit;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int n = Integer.parseInt(str.split(" ")[0]);
		int k = Integer.parseInt(str.split(" ")[1]);
		int[][] arr = new int[n][2];
 		for(int i=0;i<n;++i) {
 			str = sc.nextLine();
 			arr[i][0] = Integer.parseInt(str.split(" ")[0]);
 			arr[i][1] = Integer.parseInt(str.split(" ")[1]);	
		
 		}
 		System.out.println(solution(arr,k));
	}

	private static int solution(int[][] arr,int k) {
		virtical = 0;
		visit = new boolean[arr.length];
		for(int i=0;i<arr.length;++i)
			permulate(arr,0,0,k,i);
		return virtical;
	}

	private static void permulate(int[][] arr,int v,int g,int k,int idx) {
		if(g == k) {
			virtical = Math.max(v, virtical);
			return;
		}else if(g>k){
			return;
		}
		for(int i=idx;i<arr.length;++i) {
			if(!visit[i]) {
				visit[i] = true;
				permulate(arr,v+arr[i][1],g+arr[i][0],k,idx+1);
				visit[i] = false;
			}
		}
	}
}
