package progammers.level3;

import java.util.PriorityQueue;
import java.util.Queue;
class Time implements Comparable<Time>{
	int hour;
	int mitune;
	public Time(int hour,int mitune) {
		if(mitune >= 60) {
			hour++;
			mitune -= 60;
		}else if(mitune < 0) {
			hour--;
			mitune += 60;
		}
		
		
		this.hour = hour;
		this.mitune = mitune;
	}
	@Override
	public int compareTo(Time o) {
		if(o.hour == this.hour)
			return this.mitune - o.mitune;
		return this.hour - o.hour;
	}
}
public class ¼ÅÆ²¹ö½º {
	public static String answer;
	public static String solution(int n, int t, int m, String[] timetable) {
        answer = "";
        Queue<Time> pq = new PriorityQueue<>();
        for(int i=0;i<timetable.length;++i) {
        	int hour = Integer.parseInt(timetable[i].split(":")[0]);
        	int mitune = Integer.parseInt(timetable[i].split(":")[1]);
        	pq.offer(new Time(hour,mitune));
        }
        counting(n,t,m,pq);
        return answer;
    }
	private static void counting(int n, int t, int m, Queue<Time> pq) {
		Time bus = new Time(9, 0);
		Time corn = new Time(9, 0);
		for(int i=0;i<n;++i) {
			int people = 0;
			for(int j=0;j<m;++j) {
				if(!pq.isEmpty()) {
					Time now = pq.peek();
					if(bus.compareTo(now) >= 0) {
						corn = pq.poll();
						people++;
					}
				}
				if(i == n-1 && people == m) {
					corn = new Time(corn.hour, corn.mitune-1);
				}else if(i == n-1 && people < m) {
					corn = new Time(bus.hour,bus.mitune);
				}
			}
			bus = new Time(bus.hour, bus.mitune+t);
		}
		StringBuilder sb = new StringBuilder();
		sb.append((corn.hour < 10) ? "0"+corn.hour : corn.hour);
		sb.append(":");
		sb.append((corn.mitune < 10) ? "0"+corn.mitune : corn.mitune);
		answer = sb.toString();
	}
	public static void main(String[] args) {
		String[] timetable1 = {"08:00", "08:01", "08:02", "08:03"};
		System.out.println(solution(1,1,5,timetable1));
		String[] timetable2 = {"09:10", "09:09", "08:00"};
		System.out.println(solution(2,10,2,timetable2));
		String[] timetable3 = {"09:00", "09:00", "09:00", "09:00"};
		System.out.println(solution(2,1,2,timetable3));
		String[] timetable4 = {"00:01", "00:01", "00:01", "00:01", "00:01"};
		System.out.println(solution(2,1,2,timetable4));
		String[] timetable5 = {"23:59"};
		System.out.println(solution(1,1,1,timetable5));
		String[] timetable6 = {"23:59","23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59"};
		System.out.println(solution(10,60,45,timetable6));
	}

}
