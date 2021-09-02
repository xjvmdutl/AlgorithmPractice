package progammers.level2.review;

public class ¹æ±Ý±×°î {
	public static String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        StringBuilder now = new StringBuilder(m.replaceAll("A#", "H").replaceAll("C#", "I").replaceAll("D#", "J").replaceAll("F#", "K").replaceAll("G#", "L"));
        int maxMin = 0;
        for(int i=0;i<musicinfos.length;++i) {
        	String[] musicinfo = musicinfos[i].split(",");
        	String[] startTime = musicinfo[0].split(":");
        	String startT = startTime[0];
        	String startM = startTime[1];
        	String[] endTime = musicinfo[1].split(":");
        	String endT = endTime[0];
        	String endM = endTime[1];
        	String title = musicinfo[2];
        	String melody = musicinfo[3];
        	int time = Integer.parseInt(endT) - Integer.parseInt(startT);
        	int min = (time * 60) + Integer.parseInt(endM) - Integer.parseInt(startM);
        	melody = melody.replaceAll("A#", "H").replaceAll("C#", "I").replaceAll("D#", "J").replaceAll("F#", "K").replaceAll("G#", "L");
        	StringBuilder sb = new StringBuilder();
        	for(int j=0;j<min / melody.length();++j) {
        		sb.append(melody);
        	}
        	sb.append(melody.substring(0,min % melody.length()));
        	
        	if(sb.toString().contains(now.toString())) {
        		if(!answer.equals("(None)")) {
        			if(maxMin >= min) {
        				continue;
        			}
        		}
        		maxMin = min;
        		answer = title;
        	}
        }
        return answer;
    }
	public static void main(String[] args) {
		//m						musicinfos													answer
		//"ABCDEFG"				["12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"]	"HELLO"
		//"CC#BCC#BCC#BCC#B"	["03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"]	"FOO"
		//"ABC"					["12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"]	"WORLD"
		String m1 = "ABCDEFG"; 
		String[] musicinfos1 = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};
		System.out.println(solution(m1,musicinfos1));
		String m2 = "CC#BCC#BCC#BCC#B"; 
		String[] musicinfos2 = {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};
		System.out.println(solution(m2,musicinfos2));
		String m3 = "ABC"; 
		String[] musicinfos3 = {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};
		System.out.println(solution(m3,musicinfos3));
	}

}
