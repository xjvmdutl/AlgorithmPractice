package progammers.kakao;

public class 거리두기확인하기 {
    public static int[] solution(String[][] places) {
    	int[] answer = {};
        return answer;
    }
	public static void main(String[] args) {
		String[][] str = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
		int[] result = solution(str);
		for(int i : result)
			System.out.println(i);
	}

}
