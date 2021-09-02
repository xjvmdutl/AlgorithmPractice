package progammers.level3;

public class NQueen {
	public static int[] visit;
	public static int answer;
	public static int solution(int n) {
        answer = 0;
        visit = new int[n];//2���� �迭�� �ƴ� 1���� �迭�� �� ���� �ش� index�� ���� �Ǳ� ����
        nQueue(0,n);//��Ʈ��ŷ
        return answer;
    }
	private static void nQueue(int col, int n) {
		if(col == n) {
			//������� �°��� ����
			answer++;
			return;
		}
		for(int i=0;i<n;++i) {//����� 
			visit[col] = i;//�ప�� ����
			if(isPossible(col)) {//�ش� �࿡ ������ �ֵ��� �Ǵ��� ���� ���� �Ǵ�
				nQueue(col+1, n);//���
			}
		}
	}
	private static boolean isPossible(int col) {
		
		for(int i=0;i<col;++i) {//���翭���� �� üũ
			if(visit[col] == visit[i]) {//���� ���̸� �ȵȴ�
				return false;
			}else if(Math.abs(col - i) == Math.abs(visit[col] - visit[i])) {
				//�밢�� �Ǻ�
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		System.out.println(solution(8));
	}

}
