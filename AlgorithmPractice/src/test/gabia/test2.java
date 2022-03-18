package test.gabia;

public class test2 {

	public static void main(String[] args) {
		System.out.println(solution("<<<><"));
	}

	private static int solution(String str) {
		boolean[] visit = new boolean[str.length()];
		int answer = 0;
		for(int i=0;i<visit.length;++i) {
			if(str.charAt(i) == '<')
				answer++;
			else
				break;
		}
		for(int i=str.length()-1;i>=0;--i) {
			if(str.charAt(i) == '>')
				answer++;
			else
				break;
		}
		return answer;
	}

}
