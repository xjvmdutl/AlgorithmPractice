package progammers.level3;


public class ��������ġ {
	 public static int solution(int n, int[] stations, int w) {
		int answer = 0;
        int location = 1;//�������� ��ġ�� ���� ��ġ
        int idx = 0;//��ġ�� ������ �ε���
        while(location <= n) {
        	if(idx < stations.length && location >= stations[idx]-w) {
        		location = stations[idx] + w + 1;
        		idx++;
        	}else {//������ ��ġ
        		location += 2 * w +1;
        		answer++;
        	}
        }
        return answer;
    }
	public static void main(String[] args) {
		//N	stations	W	answer
		//11	[4, 11]	1	3
		//16	[9]	2	3
		int n1 = 11;
		int[] stations1 = {4,11};
		int w1 = 1;
		System.out.println(solution(n1,stations1,w1));
		int n2 = 16;
		int[] stations2 = {9};
		int w2 = 2;
		System.out.println(solution(n2,stations2,w2));
	}

}
