package progammers.level2.review;

public class ¡∂¿ÃΩ∫∆Ω {
	public static int solution(String name) {
        int answer = 0;
        int len = name.length();
        int min = len - 1;
    	for(int i=0;i<name.length();++i) {
        	char c = name.charAt(i);
        	int n1 = c - 'A';
        	int n2 = 'Z' - c + 1;
        	int mov = Math.min(n1, n2);
        	answer += mov;
        	int nextIdx = i+1;
        	while(nextIdx < name.length() && name.charAt(nextIdx) == 'A') {
        		nextIdx++;
        	}
        	min = Math.min(min,(i*2) + len -nextIdx);
        }
    	answer+=min; 
        return answer;
    }
	public static void main(String[] args) {
		//name	return
		//"JEROEN"	56
		//"JAN"	23
		System.out.println(solution("JAAAZ"));
		System.out.println(solution("JEROEN"));
		System.out.println(solution("JAN"));
	}
}
