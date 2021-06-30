package progammers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 나누어떨어지는숫자배열 {
	public static int[] solution(int[] arr, int divisor) {
        
        List<Integer> list = new ArrayList<>();
        for(int i : arr){
            if(i%divisor==0){
                list.add(i);
            }
        }
        int[] answer = new int[list.size()];
        for(int i=0;i<list.size();++i) {
        	answer[i]=list.get(i);
        }
        Arrays.sort(answer);
        
        
        return answer;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] d = {5,9,7,10}; 
		int[] a = solution(d,5);
	}

}
