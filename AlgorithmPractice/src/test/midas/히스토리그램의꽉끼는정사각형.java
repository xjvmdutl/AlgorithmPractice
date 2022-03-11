package test.midas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class 히스토리그램의꽉끼는정사각형 {
	public static long[][] solution(int[] H) {
		/*
		Map<Integer, Long> map = new HashMap<>();
    	for(int i=0;i<H.length;++i) {
    		int min = H[i];
    		map.put(min, map.getOrDefault(min, 0L)+1);
    		for(int j=i+1;j<H.length;++j) {
    			if(min > H[j]) {
    				min = H[j];
    			}
        		map.put(min, map.getOrDefault(min, 0L)+1);
    		}
        }	
    	List<Entry<Integer, Long>> entries = new ArrayList<>(map.entrySet());
    	
    	Collections.sort(entries, (o1, o2)->{
    		return o1.getKey() - o2.getKey();
    	});
    	long[][] answer = new long[map.size()][2];
    	for(int i=0;i<entries.size();++i) {
    		answer[i][0] = entries.get(i).getKey();
    		answer[i][1] = entries.get(i).getValue();
    	}
        return answer;
        */
		Map<Integer, Long> map = new HashMap<>();
        for(int i=0;i<H.length;++i){
            int min = H[i];
            map.put(min, map.getOrDefault(min,0L) + 1);
            for(int j=i+1;j<H.length;++j){
                if(min > H[j]){
                    min = H[j];
                }
                map.put(min, map.getOrDefault(min,0L) + 1);
            }
        }
        List<Entry<Integer,Long>> entries = new ArrayList<>(map.entrySet());
        Collections.sort(entries, (o1, o2)->{
            return o1.getKey() - o2.getKey();
        });
        long[][] answer = new long[entries.size()][2];
        for(int i=0;i<entries.size();++i){
            answer[i][0] = entries.get(i).getKey();
            answer[i][1] = entries.get(i).getValue();
        }
        return answer;
    }
	 public static void main(String[] args) {
		int[] h = {3,2,1,1,3};
		System.out.println(solution(h));
	 }
}
