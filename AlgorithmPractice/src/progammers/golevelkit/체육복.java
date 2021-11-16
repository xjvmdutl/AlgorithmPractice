package progammers.golevelkit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ã¼À°º¹ {
	public static int solution(int n, int[] lost, int[] reserve) {
        
        List<Integer> reserveList = new ArrayList<>();
        List<Integer> lostList = new ArrayList<>();
        for(int i=0;i<reserve.length;++i) {
        	reserveList.add(reserve[i]);
        }
        for(int i=0;i<lost.length;++i) {
        	if(reserveList.contains(lost[i])) {
        		reserveList.remove((Object)lost[i]);
        		continue;
        	}
        	lostList.add(lost[i]);
        }
        Collections.sort(reserveList);
        Collections.sort(lostList);
        for(int i=0;i<lostList.size();++i) {
        	int n1 = lostList.get(i) - 1;
        	int n2 = lostList.get(i) + 1;
        	if(reserveList.contains(n1)) {
        		reserveList.remove((Object)n1);
        		lostList.remove(i);
        		i--;
        	}else if(reserveList.contains(n2)){
        		reserveList.remove((Object)n2);
        		lostList.remove(i);
        		i--;
        	}		
        }
        return n - lostList.size();
    }
	public static void main(String[] args) {
		//n	lost	reserve	return
		//5	[2, 4]	[1, 3, 5]	5
		//5	[2, 4]	[3]			4
		//3	[3]		[1]			2
		int[] lost1 = {3,1,2};
		int[] reserve1 = {2,4,3};
		System.out.println(solution(4,lost1,reserve1));
		int[] lost2 = {2,4};
		int[] reserve2 = {3};
		System.out.println(solution(5,lost2,reserve2));
		int[] lost3 = {3};
		int[] reserve3 = {1};
		System.out.println(solution(3,lost3,reserve3));
	}

}
