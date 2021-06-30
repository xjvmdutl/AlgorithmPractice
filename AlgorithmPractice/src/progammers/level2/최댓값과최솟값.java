package progammers.level2;

public class ÃÖ´ñ°ª°úÃÖ¼Ú°ª {
	public static String solution(String s) {
        String[] tmp = s.split(" ");
        int min = Integer.parseInt(tmp[0]);
        int max = Integer.parseInt(tmp[0]);
        for(int i=1;i<tmp.length;++i) {
        	int thisData= Integer.parseInt(tmp[i]);
        	if(min > thisData)
        		min = thisData;
        	if(max < thisData)
        		max = thisData;
        }
        return new String(min + " " + max);
    }
	public static void main(String[] args) {
		String s1 = "1 2 3 4";
		String s2 = "-1 -2 -3 -4";
		String s3 = "-1 -1";
		System.out.println(solution(s1));
		System.out.println(solution(s2));
		System.out.println(solution(s3));
		
	}

}
