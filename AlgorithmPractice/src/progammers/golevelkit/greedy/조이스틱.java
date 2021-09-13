package progammers.golevelkit.greedy;

public class ���̽�ƽ {
	public static int solution(String name) {
		int answer = 0;
        int len = name.length();
        int min = len - 1;
    	for(int i=0;i<name.length();++i) {
        	char c = name.charAt(i);
        	int mov = Math.min(c - 'A','Z' - c + 1);
        	answer += mov;
        	int nextIdx = i+1;
        	while(nextIdx < name.length() && name.charAt(nextIdx) == 'A') {
        		nextIdx++;
        	}
        	min = Math.min(min,i+i+ len - nextIdx);//ù i = ������� �Դٰ� //�ι�° i = �ٽ� ���ư���
        }
    	answer+=min; 
        return answer;
    }
	public static void main(String[] args) {
		//name	return
		//"JEROEN"	56
		//"JAN"	23
		System.out.println(solution("ABAAAAAAAAABB"));
		System.out.println(solution("JEROEN"));
		System.out.println(solution("JAN"));
	}

}
