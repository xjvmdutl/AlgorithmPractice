package progammers.level1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class 자연수뒤집어배열로만들기 {
	public static int[] solution(long n) {
        List<Long> list = new ArrayList<>();
        while(n>0){
            list.add(n%10L);
            n/=10L;
        }
        int[] answer = new int[list.size()];
        for(int i=0;i<list.size();++i){
            answer[i]=list.get(i).intValue();
        }        
        return answer;
    }
	public static void main(String[] args) {
		solution(1235L);
	}
}
