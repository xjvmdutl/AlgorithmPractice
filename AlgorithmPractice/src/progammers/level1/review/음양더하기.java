package progammers.level1.review;

public class 음양더하기 {
	public static int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for(int i=0;i<absolutes.length;++i) {
        	int num = absolutes[i];
        	num *= signs[i] ? 1 : -1;
        	answer+=num;
        }
        return answer;
	}
	public static void main(String[] args) {
		//absolutes	signs	result
		//[4,7,12]	[true,false,true]	9
		//[1,2,3]	[false,false,true]	0
		int[] absolutes1 = {4,7,12};
		boolean[] signs1 = {true,false,true};
		System.out.println(solution(absolutes1,signs1));
		int[] absolutes2 = {1,2,3};
		boolean[] signs2 = {false,false,true};
		System.out.println(solution(absolutes2,signs2));
	}

}
