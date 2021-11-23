package progammers.level3;

import java.util.HashSet;
import java.util.Set;

public class 추석트래픽 {
   public static int solution(String[] lines) {
        int answer = 0;
        int[] startOfTimes = new int[lines.length];
        int[] endOfTimes = new int[lines.length];
        init(startOfTimes,endOfTimes,lines);
        for(int i=0;i<lines.length;++i) {
        	int startOfSection = startOfTimes[i];
        	int endOfSection = startOfSection + 1000;
        	int count = 0;
        	for(int j=0;j<lines.length;++j) {
        		if(startOfSection <= startOfTimes[j] && startOfTimes[j] < endOfSection) {
        			count++;
        		}else if(startOfSection <= endOfTimes[j] && endOfTimes[j] < endOfSection) {
        			count++;
        		}else if(startOfTimes[j] <= startOfSection && endOfSection <= endOfTimes[j]) {
        			count++;
        		}
        	}
        	answer = Math.max(count, answer);
        }
        for(int i=0;i<lines.length;++i) {
        	int startOfSection = endOfTimes[i];
        	int endOfSection = startOfSection + 1000;
        	int count = 0;
        	for(int j=0;j<lines.length;++j) {
        		if(startOfSection <= startOfTimes[j] && startOfTimes[j] < endOfSection) {
        			count++;
        		}else if(startOfSection <= endOfTimes[j] && endOfTimes[j] < endOfSection) {
        			count++;
        		}else if(startOfTimes[j] <= startOfSection && endOfSection <= endOfTimes[j]) {
        			count++;
        		}
        	}
        	answer = Math.max(count, answer);
        }
        return answer;
    }
	private static void init(int[] startOfTimes, int[] endOfTimes, String[] lines) {
		for(int i=0;i<lines.length;++i) {
			String[] log = lines[i].split(" ");
			int endTime = 0;
			String[] time = log[1].split(":");
			int hour = Integer.parseInt(time[0]);
			int mitune = Integer.parseInt(time[1]);
			int second = (int)(Double.parseDouble(time[2])* 1000);
			endTime += hour * 60 * 60 * 1000;
			endTime += mitune * 60 * 1000;
			endTime += second;
			int processingTime = (int)(Double.parseDouble(log[2].substring(0, log[2].length() - 1)) * 1000);
			int startTime = endTime - processingTime + 1;
			startOfTimes[i] = startTime;
			endOfTimes[i] = endTime;
		}
	}
	public static void main(String[] args) {
		String[] l = {"2016-09-15 20:59:57.421 0.351s",
				"2016-09-15 20:59:58.233 1.181s",
				"2016-09-15 20:59:58.299 0.8s",
				"2016-09-15 20:59:58.688 1.041s",
				"2016-09-15 20:59:59.591 1.412s",
				"2016-09-15 21:00:00.464 1.466s",
				"2016-09-15 21:00:00.741 1.581s",
				"2016-09-15 21:00:00.748 2.31s",
				"2016-09-15 21:00:00.966 0.381s",
				"2016-09-15 21:00:02.066 2.62s"};
		System.out.println(solution(l));
	}

}
