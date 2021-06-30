package progammers.level1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 실패율 {
	 public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        Map<Integer,Double> map = new HashMap<>();
        for(int i=1;i<=N;++i) {
        	int count = 0;
        	int fail = 0;
        	for(int j=0;j<stages.length;++j) {
        		if(stages[j]>=i) {
        			count++;
        		}
        		if(stages[j] == i) {
        			fail++;
        		}
        	}
        	double failureRate = 0;
            if(count != 0 && fail != 0) {
                failureRate = (fail / (double)count);
            }
        	map.put(i, failureRate);
        }
        List<Integer> keySetList = new ArrayList<>(map.keySet());
        // 내림차순 //
        Collections.sort(keySetList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o2).compareTo(map.get(o1));
            }
        });
        for(int i=0;i<keySetList.size();++i) {
        	answer[i]=keySetList.get(i);
        }
        return answer;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] sta = {2, 1, 2, 6, 2, 4, 3, 3};
		int[] r = solution(5,sta);
	}

}
