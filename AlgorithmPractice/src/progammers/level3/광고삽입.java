package progammers.level3;

import java.util.Arrays;

public class ±¤°í»ğÀÔ {
	public static String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";
       
        Arrays.sort(logs,(o1,o2)->{
        	String[] time1 = o1.split("-");
        	int startTime1 = Integer.parseInt(time1[0].split(":")[0])*60*60
        					+ Integer.parseInt(time1[0].split(":")[1])*60
        					+ Integer.parseInt(time1[0].split(":")[2]);
        	String[] time2 = o2.split("-");
        	int startTime2 = Integer.parseInt(time2[0].split(":")[0])*60*60
        					+ Integer.parseInt(time2[0].split(":")[1])*60
        					+ Integer.parseInt(time2[0].split(":")[2]);
        	return startTime1 - startTime2;
        });
        int adv = Integer.parseInt(adv_time.split(":")[0])*60*60
				+ Integer.parseInt(adv_time.split(":")[1])*60
				+ Integer.parseInt(adv_time.split(":")[2]);
        for(int i=0;i<logs.length;++i) {
        	String[] time = logs[i].split("-");
        	int startTime = Integer.parseInt(time[0].split(":")[0])*60*60
        					+ Integer.parseInt(time[0].split(":")[1])*60
        					+ Integer.parseInt(time[0].split(":")[2]);
        	int endTime = startTime + adv;
        	int count = 0;
        	for(int j = i+1;j<logs.length;++j) {
        		String[] tmpTime = logs[j].split("-");
            	int tmpStartTime = Integer.parseInt(tmpTime[0].split(":")[0])*60*60
            					+ Integer.parseInt(tmpTime[0].split(":")[1])*60
            					+ Integer.parseInt(tmpTime[0].split(":")[2]);
            	if(endTime < tmpStartTime)
            		break;
            	count++;
        	}
        }
        
        return answer;
    }
	public static void main(String[] args) {
		//play_time	adv_time	logs	result
		//"02:03:55"	"00:14:15"	["01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"]	"01:30:59"
		//"99:59:59"	"25:00:00"	["69:59:59-89:59:59", "01:00:00-21:00:00", "79:59:59-99:59:59", "11:00:00-31:00:00"]	"01:00:00"
		//"50:00:00"	"50:00:00"	["15:36:51-38:21:49", "10:14:18-15:36:51", "38:21:49-42:51:45"]	"00:00:00"
		String[] logs1 = {"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"};
		System.out.println(solution("02:03:55","00:14:15",logs1));
	}

}
