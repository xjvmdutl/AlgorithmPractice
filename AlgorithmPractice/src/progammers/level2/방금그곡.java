package progammers.level2;

public class ¹æ±Ý±×°î {
	public static String solution(String m, String[] musicinfos) {
        String answer = "None";
        int maxTime =0;
        m = m.replaceAll("A#", "H").replaceAll("C#", "I").replaceAll("D#", "J").replaceAll("F#", "J").replaceAll("G#", "K");
        for(String s : musicinfos) {
        	String[] datas = s.split(",");
        	String[] time = datas[0].split(":");
        	int startTime = Integer.parseInt(time[0])*60+Integer.parseInt(time[1]);
        	time = datas[1].split(":");
        	int endTime = Integer.parseInt(time[0])*60+Integer.parseInt(time[1]);
        	String title = datas[2];
        	String melody = datas[3];
        	melody = melody.replaceAll("A#", "H").replaceAll("C#", "I").replaceAll("D#", "J").replaceAll("F#", "J").replaceAll("G#", "K");
        	String totalMelody= "";
        	for(int i=0;i<(endTime-startTime)/melody.length();++i)
        		totalMelody+=melody;
        	for(int i=0;i<(endTime-startTime)%melody.length();++i) {
        		totalMelody += melody.charAt(i);
        	}
        	if(totalMelody.contains(m)) {
        		if(maxTime < endTime-startTime) {
        			maxTime=endTime-startTime;
        			answer = title;
        		}
        	}
        	
        }
        return answer;
    }
	public static void main(String[] args) {
		//m	musicinfos	answer
		//"ABCDEFG"	["12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"]	"HELLO"
		//"CC#BCC#BCC#BCC#B"	["03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"]	"FOO"
		//"ABC"	["12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"]	"WORLD"
		String m1 = "ABCDEFG";
		String[] musininfos1 = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};
		System.out.println(solution(m1, musininfos1));
		String m2 = "CC#BCC#BCC#BCC#B";
		String[] musininfos2 = {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};
		System.out.println(solution(m2, musininfos2));
		String m3 = "ABC";
		String[] musininfos3 = {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};
		System.out.println(solution(m3, musininfos3));
	}

}
