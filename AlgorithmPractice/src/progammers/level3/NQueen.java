package progammers.level3;

public class NQueen {
	public static int[] visit;
	public static int answer;
	public static int solution(int n) {
        answer = 0;
        visit = new int[n];//2차원 배열이 아닌 1차원 배열로 한 이유 해당 index가 열이 되기 떄문
        nQueue(0,n);//백트래킹
        return answer;
    }
	private static void nQueue(int col, int n) {
		if(col == n) {
			//여기까지 온경우는 성공
			answer++;
			return;
		}
		for(int i=0;i<n;++i) {//모든행 
			visit[col] = i;//행값을 저장
			if(isPossible(col)) {//해당 행에 값ㅇ르 넣도도 되는지 가능 여부 판단
				nQueue(col+1, n);//재귀
			}
		}
	}
	private static boolean isPossible(int col) {
		
		for(int i=0;i<col;++i) {//현재열까지 다 체크
			if(visit[col] == visit[i]) {//같은 행이면 안된다
				return false;
			}else if(Math.abs(col - i) == Math.abs(visit[col] - visit[i])) {
				//대각선 판별
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		System.out.println(solution(8));
	}

}
