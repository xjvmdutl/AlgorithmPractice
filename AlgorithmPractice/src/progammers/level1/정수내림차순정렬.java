package progammers.level1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 정수내림차순정렬 {
	 public static long solution(long n) {
        long answer = 0;
        List<Long> list = new ArrayList<>();
        while(n>0){
        	list.add(n%10);
            n/=10;
        }

        Collections.sort(list,Collections.reverseOrder());
        for(int i = 0;i<list.size();++i) {
        	answer*=10;
        	answer+=list.get(i);
        }
        return answer;
    }
	 public static void main(String[] args) {
		 long l = 123456789L;
		 long l2 = solution(l);
	 }
}
