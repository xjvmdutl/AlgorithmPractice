package progammers.level2;

import java.util.ArrayList;
import java.util.List;

public class n2배열자르기 {
	public static int[] solution(int n, long left, long right) {
        List<Integer> list = new ArrayList<>();
        long startRow = left / n;
        long startCol = left % n;
        long endRow = right / n;
        long endCol = right % n;
        for(long i=startRow;i<=endRow;++i) {
        	for(long j=startCol;j<n;++j) {
        		
        		if(i < j) {
        			list.add((int)(j+1));
        		}else {
        			list.add((int) (i+1));
        		}
        		if(i == endRow) {
        			if(j == endCol)
        				break;
        		}
        	}
        	startCol = 0;
        }
        int[] answer = new int[list.size()];
        for(int i=0;i<list.size();++i) {
        	answer[i] = list.get(i);
        }
        return answer;
    }
	public static void main(String[] args) {
		int n1 = 3;
		long left1 = 2;
		long right1 = 5;
		System.out.println(solution(n1,left1,right1));
		int n2 = 4;
		long left2 = 7;
		long right2 = 14;
		System.out.println(solution(n2,left2,right2));
	}

}
