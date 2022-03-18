package test.home;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringTokenizer;

public class test01 {
	
	public static void main(String[] args) {
		//products																						purchased						result
		//"sofa red long", "blanket blue long", "towel red", "mattress long", "curtain blue long cheap" "towel", "mattress", "curtain"
		//["towel red long thin", "blanket red thick short", "curtain red long wide", "mattress thick", "hat red thin", "pillow red long", "muffler blue thick long"]	["blanket", "curtain", "hat", "muffler"]	"towel"
		String[] products1 = {"sofa red long", "blanket blue long", "towel red", "mattress long", "curtain blue long cheap"};
		String[] purchsed1 = {"towel", "mattress", "curtain"};
		System.out.println(solution(products1, purchsed1));
		
		String[] products2 = {"towel red long thin", "blanket red thick short", "curtain red long wide", "mattress thick", "hat red thin", "pillow red long", "muffler blue thick long"};
		String[] purchsed2 = {"blanket", "curtain", "hat", "muffler"};
		System.out.println(solution(products2, purchsed2));
	}

	private static String solution(String[] products, String[] purchased) {
		String answer = "";
		Map<String, Integer> map = new HashMap<>();
		Map<String, HashSet<String>> productMap = new HashMap<>();
		for(String product : products) {//备概 格废
			HashSet<String> set=  new HashSet<>();
			StringTokenizer tokens = new StringTokenizer(product);
			String key = tokens.nextToken();
			while(tokens.hasMoreTokens()) {
				set.add(tokens.nextToken());
			}
			productMap.put(key, set);
		}
		for(String purchase : purchased) {//备概 格废
			Set<String> set = productMap.get(purchase);
			for(String attr : set) {
				map.put(attr, map.getOrDefault(attr, 0)+1);
			}
			productMap.remove(purchase);
		}
		List<Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());
		Collections.sort(entries, (o1, o2)->{
			if(o2.getValue() == o1.getValue()) {
				return o1.getKey().compareTo(o2.getKey());
			}
			return o2.getValue() - o1.getValue();
		});
		for(Entry<String, Integer> entry : entries) {
			List<String> keys = new ArrayList<>();
			if(productMap.size() == 1) {
				break;
			}
			for(String key : productMap.keySet()) {
				if(!productMap.get(key).contains(entry.getKey())){
					keys.add(key);
				}
			}
			if(keys.isEmpty()) {
				continue;
			}else if(keys.size() == productMap.size()) {
				continue;
			}else {
				for(String key : keys) {
					productMap.remove(key);
				}
			}
			
		}
		for(String key :productMap.keySet()) {
			answer = key;
		}
		return answer;
	}
}
