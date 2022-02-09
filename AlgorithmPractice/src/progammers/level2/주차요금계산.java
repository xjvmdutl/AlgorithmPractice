package progammers.level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class 주차요금계산 {
	private static final int MAX_HOUR = 23;
	private static final int MAX_MITUNE = 59;
	public static int[] solution(int[] fees, String[] records) {
       
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> rec = new HashMap<>();
        for(String record : records) {
        	StringTokenizer tokens = new StringTokenizer(record);
        	String time = tokens.nextToken();
        	String number = tokens.nextToken();
        	String InOut = tokens.nextToken();
        	if(InOut.equals("IN")) {
        		int hour = Integer.parseInt(time.split(":")[0]);
        		int mitune = Integer.parseInt(time.split(":")[1]);
        		int startTime = hour * 60 + mitune;
        		rec.put(number, startTime);
        	}else if(InOut.equals("OUT")){
        		int startTime = rec.get(number);
        		int hour = Integer.parseInt(time.split(":")[0]);
        		int mitune = Integer.parseInt(time.split(":")[1]);
        		int lastTime = hour * 60 + mitune;
        		rec.remove(number);
        		map.put(number, map.getOrDefault(number, 0) + lastTime - startTime);
        	}
        }
        for(String number : rec.keySet()) {
        	int startTime = rec.get(number);
    		int lastTime = MAX_HOUR * 60 + MAX_MITUNE;
    		map.put(number, map.getOrDefault(number, 0) + lastTime - startTime);
        }
        List<Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());
        entries.sort((o1,o2)->{
        	return o1.getKey().compareTo(o2.getKey());
        });
        int[] answer = new int[map.size()];
        int index = 0;
        for(Entry<String, Integer> entry : entries) {
        	if(entry.getValue() <= fees[0]) {
        		answer[index++] = fees[1];
        	}else {
        		answer[index] += fees[1];
        		int result = entry.getValue() - fees[0];
        		int count = result / fees[2];
        		if(result % fees[2] != 0)
        			count++;
        		answer[index++] += fees[3] * count;
        	}
        }
        return answer;
    }
	public static void main(String[] args) {
		//fees	records	result
		//[180, 5000, 10, 600]	["05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"]	[14600, 34400, 5000]
		//[120, 0, 60, 591]	["16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"]	[0, 591]
		//[1, 461, 1, 10]	["00:00 1234 IN"]	[14841]
		int[] fees1 = {180, 5000, 10, 600};
		String[] records1 = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
		System.out.println(solution(fees1, records1));
		int[] fees2 = {120, 0, 60, 591};
		String[] records2 = {"16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"};
		System.out.println(solution(fees2, records2));

		int[] fees3 = {1, 461, 1, 10};
		String[] records3 = {"00:00 1234 IN"};
		System.out.println(solution(fees3, records3));

	}

}
