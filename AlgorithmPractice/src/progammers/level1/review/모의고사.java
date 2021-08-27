package progammers.level1.review;

import java.util.ArrayList;
import java.util.List;

public class 모의고사 {
	public static int[] solution(int[] answers) {
        int[] first = { 1, 2, 3, 4, 5};
        int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int p1=0,p2=0,p3 = 0;
        for(int i=0;i<answers.length;++i) {
        	int i1 = i%first.length;
        	int i2 = i%second.length;
        	int i3 = i%third.length;
        	if(answers[i] == first[i1]) {
        		p1++;
        	}
        	if(answers[i] == second[i2]) {
        		p2++;
        	}
        	if(answers[i] == third[i3]) {
        		p3++;
        	}
        }
        List<Integer> list = new ArrayList<>();
        int max = Math.max(p1, p2);
        max = Math.max(max,p3);
        if(p1 == max) {
        	list.add(1);
        }
        if(p2 == max) {
        	list.add(2);
        }
        if(p3 == max) {
        	list.add(3);
        }
   
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
	public static void main(String[] args) {
		int[] a1 = {1,2,3,4,5};
		int[] r1 = solution(a1);
		int[] a2 = {1,3,2,4,2};
		int[] r2 = solution(a2);
	}

}
