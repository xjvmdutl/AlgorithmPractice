package progammers.golevelkit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
class Elebum{
	int number;
	int plays;
	public Elebum(int number,int plays) {
		this.number = number;
		this.plays = plays;
	}
}
public class º£½ºÆ®¾Ù¹ü {
	public static int[] solution(String[] genres, int[] plays) {
        
        Map<String,List<Elebum>> detailMap = new HashMap<>();
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<genres.length;++i) {
        	if(!detailMap.containsKey(genres[i])) {
        		List<Elebum> list = new ArrayList<>();
        		detailMap.put(genres[i], list);
        	}
        	map.put(genres[i], map.getOrDefault(genres[i], 0)+ plays[i]);
        	List<Elebum> list = detailMap.get(genres[i]);
        	list.add(new Elebum(i, plays[i]));
        	detailMap.put(genres[i], list);
        	
        }
 		List<Entry<String, Integer>> list_entries = new ArrayList<Entry<String, Integer>>(map.entrySet());
 		Collections.sort(list_entries, new Comparator<Entry<String, Integer>>() {
 			public int compare(Entry<String, Integer> obj1, Entry<String, Integer> obj2)
 			{
 				return obj2.getValue().compareTo(obj1.getValue());
 			}
 		});

 		List<Integer> result = new ArrayList<>();
        int idx =0;
        for(Entry<String, Integer> entry : list_entries) {
			String key = entry.getKey();
			List<Elebum> list = detailMap.get(key);
			Collections.sort(list,(o1,o2)->{
				if(o2.plays == o1.plays)
					return o1.number - o2.number;
				return o2.plays - o1.plays;
			});
			if(list.size() == 1) {
				result.add(list.get(0).number);
			}else {
				for(int i=0;i<2;++i) {
					result.add(list.get(i).number);
				}
			}
		}
        int[] answer = new int[result.size()];
        for(int i=0;i<result.size();++i) {
        	answer[i] = result.get(i);
        }
        return answer;
    }
	public static void main(String[] args) {
		//genres	plays	return
		//["classic", "pop", "classic", "classic", "pop"]	[500, 600, 150, 800, 2500]	[4, 1, 3, 0]
		String[] genres = {"classic", "classic", "classic", "pop"};
		int[] plays = {500, 150, 800, 2500};
		System.out.println(solution(genres,plays));
	}

}
