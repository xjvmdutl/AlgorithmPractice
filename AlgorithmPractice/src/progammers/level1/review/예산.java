package progammers.level1.review;

import java.util.Arrays;

public class ¿¹»ê {
	public static int solution(int[] d, int budget) {
        int answer = 0;
        int sum = 0;
        Arrays.sort(d);
        for(int i=0;i<d.length;++i) {
        	if(sum + d[i] <= budget) {
        		sum += d[i];
        		answer++;
        		continue;
        	}
        	break;
        }
        
        return answer;
    }
	public static void main(String[] args) {
		//d	budget	result
		//[1,3,2,5,4]	9	3
		//[2,2,3,3]	10	4
		int[] d1 = {1,3,2,5,4};
		int budget1 = 9;
		System.out.println(solution(d1,budget1));
		int[] d2 = {2,2,3,3};
		int budget2 = 10;
		System.out.println(solution(d2,budget2));
	}

}
