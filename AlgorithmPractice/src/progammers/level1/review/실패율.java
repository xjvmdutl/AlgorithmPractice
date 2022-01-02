package progammers.level1.review;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.ToIntFunction;
class Solve{
    double fail;
    int idx;
    public Solve(int idx,double fail){
        this.idx = idx;
        this.fail = fail;
    }
}
public class 실패율 {
	public static int[] solution(int N, int[] stages) {
       Map<Integer,Integer> map = new HashMap<>();
       for(int i=0;i<stages.length;++i){
            map.put(stages[i],map.getOrDefault(stages[i],0)+1);
        }
        int now = stages.length;
        List<Solve> solves = new ArrayList<>();
        for(int i=1;i<=N;++i){
            if(map.containsKey(i)){
            	solves.add(new Solve(i,(double)map.get(i)/now));
                now -= map.get(i);
            }else{
            	solves.add(new Solve(i,0));
            }
        }
        				//1			//2
        Collections.sort(solves, (o1,o2) ->{
			if(o1.fail == o2.fail) {
				return o1.idx - o2.idx;
			}
			return Double.compare(o1.fail, o2.fail);
		});
        //solve의 stream객체를 꺼내 리스트요소안의 idx를 int형으로 변경한뒤 이걸 배열형식으로 리턴하겠다.
        
        return solves.stream().mapToInt(new ToIntFunction<Solve>() {
			@Override
			public int applyAsInt(Solve value) {
				return value.idx;
			}
		}).toArray();
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
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<10;++i)
			list.add(i+1);
	}
	
}
