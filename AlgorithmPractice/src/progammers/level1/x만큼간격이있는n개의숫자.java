package progammers.level1;

public class x��ŭ�������ִ�n���Ǽ��� {
	public long[] solution(int x, int n) {
        long[] answer = new long[n];
        for(int i=0;i<n;++i){
            answer[i] = (long)x*(i+1);
        }
        return answer;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
