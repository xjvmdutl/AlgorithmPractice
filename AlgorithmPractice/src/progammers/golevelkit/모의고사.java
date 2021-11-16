package progammers.golevelkit;

import java.util.ArrayList;
import java.util.List;

public class 모의고사 {
	public static int[] solution(int[] answers) {
        
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] arr3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        for(int i=0;i<answers.length;++i) {
        	if(arr1[i%arr1.length] == answers[i]) {
        		count1++;
        	}
        	if(arr2[i%arr2.length] == answers[i]) {
        		count2++;
        	}
        	if(arr3[i%arr3.length] == answers[i]) {
        		count3++;
        	}
        }
        List<Integer> list = new ArrayList<>();
        int max = Math.max(count1, count2);
        max = Math.max(max,count3);
        if(count1 == max) {
        	list.add(1);
        }
        if(count2 == max) {
        	list.add(2);
        }
        if(count3 == max) {
        	list.add(3);
        }
        int[] answer = new int[list.size()];
        for(int i=0;i<list.size();++i) {
        	answer[i] = list.get(i);
        }
        return answer;
    }
	public static void main(String[] args) {
		int[] a1 = {1,2,3,4,5};
		int[] r1 = solution(a1);
		int[] a2 = {1,3,2,4,2};
		int[] r2 = solution(a2);
	}
}
