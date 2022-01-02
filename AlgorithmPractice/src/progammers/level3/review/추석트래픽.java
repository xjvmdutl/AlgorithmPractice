package progammers.level3.review;

public class 추석트래픽 {
	public static int solution(String[] lines) {
		int answer = 0;
		int[] startWith = new int[lines.length];
		int[] endWith = new int[lines.length];
		init(lines,startWith,endWith);
		for(int i=0;i<lines.length;++i) {
			int count = 0;
			int startSec = startWith[i];
			int endSec = startSec + 1000;
			for(int j=0;j<lines.length;++j) {
				if(startSec < startWith[j] && startWith[j] < endSec) {
					count++;
				}else if(startSec < startWith[j] && endWith[j] <= endSec) {
					count++;
				}else if(startWith[j] <= startSec &&  startSec <= endWith[j]) {
					count++;
				}
			}
			answer = Math.max(answer, count);
		}
		for(int i=0;i<lines.length;++i) {
			int count = 0;
			int startSec = endWith[i];
			int endSec = startSec + 1000;
			for(int j=0;j<lines.length;++j) {
				if(startSec < startWith[j] && startWith[j] < endSec) {
					count++;
				}else if(startSec < startWith[i] && endWith[j] <= endSec) {
					count++;
				}else if(startWith[j] <= startSec &&  startSec <= endWith[j]) {
					count++;
				}
			}
			answer = Math.max(answer, count);
		}
		return answer;
	}

	private static void init(String[] lines, int[] startWith, int[] endWith) {
		for(int i=0;i<lines.length;++i) {
			String[] splits = lines[i].split(" ");
			String[] times = splits[1].split(":");
			int endTime = Integer.parseInt(times[0]) * 60 * 60 * 1000;
			endTime += Integer.parseInt(times[1]) * 60 * 1000;
			endTime += Double.parseDouble(times[2]) * 1000;
			endWith[i] = endTime;
			startWith[i] = endTime + 1 - (int)(Double.parseDouble(splits[2].replace("s", "")) * 1000);
		}
	}
	public static void main(String[] args) {
		String[] s1 = {
			"2016-09-15 20:59:57.421 0.351s",
			"2016-09-15 20:59:58.233 1.181s",
			"2016-09-15 20:59:58.299 0.8s",
			"2016-09-15 20:59:58.688 1.041s",
			"2016-09-15 20:59:59.591 1.412s",
			"2016-09-15 21:00:00.464 1.466s",
			"2016-09-15 21:00:00.741 1.581s",
			"2016-09-15 21:00:00.748 2.31s",
			"2016-09-15 21:00:00.966 0.381s",
			"2016-09-15 21:00:02.066 2.62s"
		};
		System.out.println(solution(s1));
		String[] s2 = {
				"2016-09-15 01:00:04.001 2.0s", "2016-09-15 01:00:07.000 2s"
			};
			System.out.println(solution(s2));
	}
}
