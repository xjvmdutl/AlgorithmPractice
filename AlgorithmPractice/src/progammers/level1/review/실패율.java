package progammers.level1.review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 실패율 {
	 public static int[] solution(int N, int[] stages) {
       
        Arrays.sort(stages);
        Map<Integer, Double> map = new HashMap<>();
        int p = stages.length;
        int j=0;
        for(int i=1;i<=N;++i) {
        	int count = 0;
        	for(;j<stages.length;++j) {
        		if(i < stages[j]) {
        			break;
        		}
        		count++;
        	}
        	double fail = (double)count/p;
        	if(p <= 0) {
        		fail = 0;
        	}
        	map.put(i, fail);
        	p-=count;
        	
        }
        List<Integer> keySetList = new ArrayList<>(map.keySet());
        // 내림차순 //
        Collections.sort(keySetList,  (o1, o2) -> (map.get(o2).compareTo(map.get(o1))));
        int[] answer = new int[N];
        int idx = 0;
        for(Integer key : keySetList) {
        	answer[idx++] = key;
        }
        return answer;
    }
	public static void main(String[] args) {
		//N : 5
		//stages : [1,2,2,1,3]
		//result : [3,2,1,4,5]
		int[] sta1 = {1,1,1};
		int n1 = 5;
		int[] r1 = solution(n1,sta1);
		int[] sta2 = {4,4,4,4,4};
		int n2 = 5;
		int[] r2 = solution(n2,sta2);
	}
	
}
