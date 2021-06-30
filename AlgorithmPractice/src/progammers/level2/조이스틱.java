package progammers.level2;

public class ¡∂¿ÃΩ∫∆Ω {
	public static int solution(String name) {
        int answer = 0;
        int len = name.length();
        int min = len - 1;
        for(int i=0;i<name.length();++i) {
        	char c = name.charAt(i);
        	int mov = c - 'A' > 'Z' - c + 1 ?  'Z' - c + 1 : c - 'A';
        	answer += mov;
        	int nextIdx = i+1;
        	while(nextIdx < len && name.charAt(nextIdx) == 'A') {
        		nextIdx++;
        	}
        	min = Math.min(min,(i*2) + len -nextIdx);
        }
        answer+=min;        	
        
        return answer;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//name	return
		//"JEROEN"	56
		//"JAN"	23
		String name1 = "JEROEN";
		System.out.println(solution(name1));
		String name2 = "JAN";
		System.out.println(solution(name2));
		String name3 = "AZAZ";
		System.out.println(solution(name3));
	}

}
