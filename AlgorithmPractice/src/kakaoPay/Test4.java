package kakaoPay;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Test4 {

	public static void main(String[] args) {
		int[] ages = {35,25,3,8,7};
		int[][] wires = {{1,2,5},{2,1,5},{1,3,2},{3,4,2},{3,5,20},{4,5,1}};
		int[] result = solution(ages,wires);
	}

	private static int[] solution(int[] ages, int[][] wires) {
		int[] answer = new int[ages.length];
		int[][] data = new int[ages.length][ages.length];
		HashMap<Integer,Integer> map = new HashMap<>();
		int order = 0;
		init(data,wires);
		while(true) {
			int count = 0;
			for(int i=0;i<data.length;++i) {
				for(int j=0;j<data[i].length;++j) {
					if(ages[i] <= 0) {
						if(data[i][j] != 0) {
							data[i][j]--;
						}
					}
					if(data[i][j] > 0) {
						ages[j] ++;
						ages[i] --;
					}
				}
			}
			for(int i=0;i<ages.length;++i) {
				ages[i] -= 1;
				if(ages[i] <= 0) {
					count++;
				}
				if( ages[i] <= 0 
						&&!map.containsKey(i)) {
					map.put(i, order++);
				}
			}
			if(count ==ages.length)
				break;
		}
		List<Integer> keySetList = new ArrayList<>(map.keySet());
        // 내림차순 //
        Collections.sort(keySetList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o2).compareTo(map.get(o1));
            }
        });
         int i =0;
        for(Integer key : keySetList) {
        	answer[i++] =  map.get(key);
        }
   
		return answer;
	}

	private static void init(int[][] data, int[][] wires) {
		for(int i=0;i<wires.length;++i) {
			int start = wires[i][0]-1;
			int end = wires[i][1]-1;
			int l = wires[i][2];
			data[start][end] = l;
		}
	}

}
