package progammers.level1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;




public class ¿¹»ê {
	public static int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        while(budget>0){
            if(budget-d[answer] < 0) {
            	break;
            }
            budget-=d[answer++];
        }
        return answer;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
