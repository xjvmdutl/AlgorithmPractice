package progammers.level3;

import java.util.Arrays;

public class ±¤°í»ðÀÔ {
	public static String solution(String play_time, String adv_time, String[] logs) {
        int playTime = strToSecond(play_time);
        int advTime = strToSecond(adv_time);
        int[] counts = new int[playTime+1];
        for(String log : logs) {
        	String[] times = log.split("-");
        	int startTime = strToSecond(times[0]);
        	int endTime = strToSecond(times[1]);
        	for(int i=startTime;i<endTime;++i) {
        		counts[i]++;
        	}
        }
        int startTime = 0;
        int endTime = advTime;
        long sum = 0;
        for(int i=startTime;i<endTime;++i) {
        	sum += counts[i];
        }
        long max = sum;
        int maxStartTime = 0;
        while (endTime <= playTime) {
        	sum -= counts[startTime];
        	sum += counts[endTime];
        	if(sum > max) {
                max = sum;
                maxStartTime = startTime + 1;
            }
        	startTime++;
            endTime++;
        }
        
        return secondToStr(maxStartTime);
    }
	public static int strToSecond(String time) {
		String[] now = time.split(":");
		return Integer.parseInt(now[0])*60*60
				+ Integer.parseInt(now[1])*60
				+ Integer.parseInt(now[2]);
	}
	
	public static String secondToStr(int time) {
		int hour = time / 3600;
        time %= 3600;
        int minute = time / 60;
        int second = time % 60;
        StringBuilder sb = new StringBuilder();
        sb.append(hour < 10 ? "0"+hour : hour);
        sb.append(":");
        sb.append(minute < 10 ? "0"+minute : minute);
        sb.append(":");
        sb.append(second < 10 ? "0"+second : second);
        return sb.toString();
	}
	
	public static void main(String[] args) {
		//play_time	adv_time	logs	result
		//"02:03:55"	"00:14:15"	["01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"]	"01:30:59"
		//"99:59:59"	"25:00:00"	["69:59:59-89:59:59", "01:00:00-21:00:00", "79:59:59-99:59:59", "11:00:00-31:00:00"]	"01:00:00"
		//"50:00:00"	"50:00:00"	["15:36:51-38:21:49", "10:14:18-15:36:51", "38:21:49-42:51:45"]	"00:00:00"
		String[] logs1 = {"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"};
		System.out.println(solution("02:03:55","00:14:15",logs1));
		String[] logs2 = {"69:59:59-89:59:59", "01:00:00-21:00:00", "79:59:59-99:59:59", "11:00:00-31:00:00"};
		System.out.println(solution("99:59:59","25:00:00",logs2));
		String[] logs3 = {"15:36:51-38:21:49", "10:14:18-15:36:51", "38:21:49-42:51:45"};
		System.out.println(solution("50:00:00","50:00:00",logs3));
	}

}
