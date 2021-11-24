package progammers.level3;

import java.util.HashSet;
import java.util.Set;

public class 추석트래픽 {
   public static int solution(String[] lines) {
        int answer = 0;
        int[] startOfTimes = new int[lines.length];
        int[] endOfTimes = new int[lines.length];
        fn_init(lines,startOfTimes,endOfTimes);
        for(int i=0;i<lines.length;++i) {
        	int startSection = startOfTimes[i];
        	int endSection = startSection + 1000;
        	int count = 0;
        	for(int j=0;j<lines.length;++j) {
        		if(startSection <= startOfTimes[j] && startOfTimes[j] < endSection) {
        			count++;
        		}else if(startSection <= endOfTimes[j] && endOfTimes[j] < endSection) {
        			count++;
        		}else if(startOfTimes[j] <= startSection && endSection <= endOfTimes[j]) {
        			count++;
        		}
        	}
        	answer = Math.max(answer, count);
        }
        for(int i=0;i<lines.length;++i) {
        	int startSection = endOfTimes[i];
        	int endSection = startSection + 1000;
        	int count = 0;
        	for(int j=0;j<lines.length;++j) {
        		if(startSection <= startOfTimes[j] && startOfTimes[j] < endSection) {
        			count++;
        		}else if(startSection <= endOfTimes[j] && endOfTimes[j] < endSection) {
        			count++;
        		}else if(startOfTimes[j] <= startSection && endSection <= endOfTimes[j]) {
        			count++;
        		}
        	}
        	answer = Math.max(answer, count);
        }
        return answer;
    }
	private static void fn_init(String[] lines, int[] startOfTimes, int[] endOfTimes) {
		for(int i=0;i<lines.length;++i) {
			String[] times = lines[i].split(" ");
			int endTime = 0;
			String[] splitTime = times[1].split(":");
			endTime += Integer.parseInt(splitTime[0]) * 60 * 60 * 1000;
			endTime += Integer.parseInt(splitTime[1]) * 60 *  1000;
			endTime += (int)(Double.parseDouble(splitTime[2]) * 1000);
			int processTime = (int)(Double.parseDouble(times[2].substring(0,times[2].length()-1)) * 1000);
			int startTime = endTime - processTime + 1;
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
