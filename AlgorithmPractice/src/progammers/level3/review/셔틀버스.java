package progammers.level3.review;

import java.util.PriorityQueue;
import java.util.Queue;


public class ¼ÅÆ²¹ö½º {
	static class Time implements Comparable<Time>{
		int hour;
		int mitune;
		public Time(int hour, int mitune) {
			if(mitune < 0) {
				hour--;
				mitune+=60;
			}else if(mitune >= 60) {
				hour++;
				mitune-=60;
			}
			this.hour = hour;
			this.mitune = mitune;
		}
		@Override
		public int compareTo(Time o) {
			if(this.hour == o.hour)
				return this.mitune - o.mitune;
			return this.hour - o.hour;
		}
	}
	public static String solution(int n, int t, int m, String[] timetable) {
        Queue<Time> pq = new PriorityQueue<>();
        for(String time : timetable) {
        	int hour = Integer.parseInt(time.split(":")[0]);
        	int mitune = Integer.parseInt(time.split(":")[1]);
        	pq.offer(new Time(hour, mitune));
        }
        
        Time bus = new Time(9,0);
        Time last = new Time(9,0);
        Time corn = new Time(9,0);
        for(int i=0;i<n;++i) {
        	int count = 0;
        	for(int j=0; j<m;++j) {
        		if(!pq.isEmpty()) {
        			Time time = pq.peek();
        			if(bus.compareTo(time) >= 0) {
        				last = pq.poll();
        				count++;
        			}
        		}
        		
        	}
        	if(i == n - 1 && count == m) {
        		corn = new Time(last.hour, last.mitune-1);
        	}else if(i == n - 1 && count < m){
        		corn = new Time(bus.hour, bus.mitune);
        	}
        	bus = new Time(bus.hour, bus.mitune + t);
        }
        
        StringBuilder sb = new StringBuilder();
		sb.append((corn.hour < 10) ? "0"+corn.hour : corn.hour);
		sb.append(":");
		sb.append((corn.mitune < 10) ? "0"+corn.mitune : corn.mitune);
		return sb.toString();
	}
	public static void main(String[] args) {
		/*
		 * n t m timetable answer 1 1 5 ["08:00", "08:01", "08:02", "08:03"] "09:00" 2
		 * 10 2 ["09:10", "09:09", "08:00"] "09:09" 2 1 2 ["09:00", "09:00", "09:00",
		 * "09:00"] "08:59" 1 1 5 ["00:01", "00:01", "00:01", "00:01", "00:01"] "00:00"
		 * 1 1 1 ["23:59"] "09:00" 10 60 45 ["23:59","23:59", "23:59", "23:59", "23:59",
		 * "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59",
		 * "23:59", "23:59", "23:59"] "18:00"
		 */
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
