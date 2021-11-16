package progammers.golevelkit;

import java.util.HashMap;
import java.util.Map;

public class ¿ß¿Â {
	public static int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();
        for(int i=0;i<clothes.length;++i) {
        	map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0)+1);
        }
        
        for(String cloth : map.keySet()) {
        	answer *= map.get(cloth) + 1;
        }
        return answer - 1;
    }
	public static void main(String[] args) {
		//clothes	return
		//[["yellowhat", "headgear"], ["bluesunglasses", "eyewear"], ["green_turban", "headgear"]]	5
		//[["crowmask", "face"], ["bluesunglasses", "face"], ["smoky_makeup", "face"]]	3
		String[][] clothes1 = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
		System.out.println(solution(clothes1));
		String[][] clothes2 = {{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}};
		System.out.println(solution(clothes2));
	}

}
