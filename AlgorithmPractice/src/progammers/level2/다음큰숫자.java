package progammers.level2;

public class 다음큰숫자 {
	public static int solution(int n) {
		
		String binary = Integer.toBinaryString(n);
		int oneCount =0;
		for(int i=0;i<binary.length();++i) {
			if(binary.charAt(i) == '1')
				oneCount++;
		}
		int cnt = 0;
		String answer = "";
		do {
			cnt = 0;
			String tmp=Integer.toBinaryString(++n);
			for(int i=0;i<tmp.length();++i) {
				if(tmp.charAt(i) == '1')
					cnt++;
			}
			answer = tmp;
		}while(!(oneCount == cnt));
		return Integer.parseInt(answer,2);
	}
		
	public static void main(String[] args) {
		int n1 = 78;
		int n2 = 15;
		System.out.println(solution(n1));
		System.out.println(solution(n2));
	}

}
