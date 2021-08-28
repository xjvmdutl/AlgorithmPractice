package AutoEverPratice;

import java.util.Arrays;

public class t3 {
	public static boolean flag;
	 public static boolean[] solution(int[][] p, int[][] q) {
        boolean[] answer = new boolean[p.length];
        for(int i=0;i<p.length;++i) {
        	int xLength = p[i].length;
        	int yLength = q[i].length;
        	flag = false;
        	Arrays.sort(q[i]);
        	dfs(p[i],q[i],0,xLength-yLength);
        	answer[i] = flag;
        }
        return answer;
    }
	private static void dfs(int[] p, int[] q, int index, int count) {
		if(index == count) {
			Arrays.sort(p);
			for(int i=0;i<p.length;++i) {
				if(p[i] != q[i])
					return;
			}
			flag = true;
			return;
		}
		
		for(int i=0;i<p.length-1;++i) {
			for(int j=i+1;j<p.length;++j) {
				int[] tmp = new int[p.length-1];
				tmp[i] = p[i] + p[j];
				int idx = 0;
				for(int k=0;k<p.length;++k) {
					if(j == k) {
						continue;
					}
					if(tmp[idx] == 0) {
						tmp[idx++] = p[k];
					}else {
						idx++;
					}
				}
				dfs(tmp, q, index+1, count);
			}
			
		}
	}
	public static void main(String[] args) {
		int[][] p = {{5,3,2,2,1}};
		int[][] q = {{7,2,4}};
		System.out.println(solution(p,q));
		
	}

}
