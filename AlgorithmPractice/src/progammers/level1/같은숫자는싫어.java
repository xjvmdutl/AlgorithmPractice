package progammers.level1;

import java.util.ArrayList;
import java.util.List;

public class 같은숫자는싫어 {
	 public static int[] solution(int []arr) {
        List<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        for(int i=1;i<arr.length;++i){
            if(arr[i] != arr[i-1] ){
                list.add(arr[i]);
            }
        }
        int[] answer = new int[list.size()];
        for(int i=0;i<answer.length;++i){
            answer[i]=list.get(i);
        }
        return answer;
    }
	 /*
	  * ArrayList<Integer> tempList = new ArrayList<Integer>();
        int preNum = 10;
        for(int num : arr) {
            if(preNum != num)
                tempList.add(num);
            preNum = num;
        }       
        int[] answer = new int[tempList.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = tempList.get(i).intValue();
        }
        return answer;
	  */
	public static void main(String[] args) {
		int[] arr= {1,1,3,3,0,1,1};
		int[] arr2 = solution(arr);
	}

}
