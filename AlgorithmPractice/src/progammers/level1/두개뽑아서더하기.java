package progammers.level1;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class �ΰ��̾Ƽ����ϱ� {

	public static void main(String[] args) {
		int[] numbers = {2,1,3,4,1};
		int[] result = solution(numbers);
	}
	public static int[] solution(int[] numbers) {
		Set<Integer> list = new HashSet<>();
		for(int i=0;i<numbers.length;++i) {
			for(int j=0;j<numbers.length;++j) {
				if(i!=j) {
					list.add(numbers[i]+numbers[j]);
				}
			}
		}
		int size = 0;
		int[] answer = new int[list.size()];
		for(int data : list) {
			answer[size++] = data;
		}
		return answer;
	}
	public static void catchData(Set<Integer> list, int i, int j,int[] numbers) {
		
		
	}
	/*
	 public int[] solution(int[] numbers) {
		Set<Integer> list = new HashSet<Integer>();
        for(int i=0;i<numbers.length;++i){
            for(int j=i+1;j<numbers.length;++j){
                list.add(numbers[i]+numbers[j]);
            }
        }
        Iterator<Integer> it = list.iterator(); // �ݺ��� ����
        int[] answer = new int[list.size()];
        int i=0;
    	while (it.hasNext()) {
    		answer[i] = it.next(); // set�� ����� ���� ��ü�� ������ ����
    		i++;
		}
        return answer;
    }
    */
}
