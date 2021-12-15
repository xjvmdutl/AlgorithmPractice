package progammers.level3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
class Elbum{
	int index;
	int count;
	public Elbum(int index,int count) {
		this.count = count;
		this.index = index;
	}
}
public class 베스트앨범 {
    public static int[] solution(String[] genres, int[] plays) {
    	Map<String,ArrayList<Elbum>> playtimes = new HashMap<>();
    	Map<String,Integer> map = new HashMap<>();
    	for(int i=0;i<genres.length;++i) {
    		ArrayList<Elbum> list = new ArrayList<>();
    		if(map.containsKey(genres[i])) {
    			list = playtimes.get(genres[i]);
    		}
    		list.add(new Elbum(i,plays[i]));
    		map.put(genres[i], map.getOrDefault(genres[i], 0)+ plays[i]);
    		playtimes.put(genres[i], list);
    	}
    	// Map.Entry 리스트 작성
		List<Entry<String, Integer>> list_entries = new ArrayList<Entry<String, Integer>>(map.entrySet());
		Collections.sort(list_entries,(o1,o2)->{
			return o2.getValue() - o1.getValue();
		});
		List<Integer> results = new ArrayList<>();
		for(Entry<String,Integer> entry : list_entries) {
			ArrayList<Elbum> list = playtimes.get(entry.getKey());
			Collections.sort(list,(o1,o2)->{
				return o2.count - o1.count;
			});
			for(int i=0;i<list.size();++i) {
				if(i >= 2)
					break;
				results.add(list.get(i).index);
			}
			
		}
		int[] answer = results.stream().mapToInt(Integer::intValue).toArray();
    	return answer;
    }
	public static void main(String[] args) {
		//genres	plays	return
		//["classic", "pop", "classic", "classic", "pop"]	[500, 600, 150, 800, 2500]	[4, 1, 3, 0]
		String[] genres = {"classic", "pop", "classic", "classic", "pop"};
		int[] plays = {500, 600, 150, 800, 2500};
		System.out.println(solution(genres,plays));
	}

}
