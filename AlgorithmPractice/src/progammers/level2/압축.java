package progammers.level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 압축 {
	
	public static int[] solution(String msg) {
        
		Map<String,Integer> dic = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        initDic(dic);
        
        int cnt = dic.get("Z");
        for(int idx = 0;idx<msg.length();++idx){
            StringBuilder sb = new StringBuilder(Character.toString(msg.charAt(idx)));
            boolean flag = false;
            while(dic.containsKey(sb.toString())){
                idx++;
                if(idx == msg.length()){
                    flag = true;
                    break;
                }
                sb.append(msg.charAt(idx));
            }
            if(flag){
                list.add(dic.get(sb.toString()));
                break;
            }
            dic.put(sb.toString(),++cnt);
            list.add(dic.get(sb.delete(sb.length()-1, sb.length()).toString()));
            
            idx--;
            
        }
        int[] answer = new int[list.size()];
        for(int i =0;i<list.size();++i)
        	answer[i]=list.get(i);
       
        return answer;
    }
	private static void initDic(Map<String, Integer> map) {
		// TODO Auto-generated method stub
		 //초기화
		for(int i=0;i<='Z'-'A';++i){
            map.put(Character.toString((char) ('A'+i)),i+1);
        }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//msg	answer
		//KAKAO	[11, 1, 27, 15]
		//TOBEORNOTTOBEORTOBEORNOT	[20, 15, 2, 5, 15, 18, 14, 15, 20, 27, 29, 31, 36, 30, 32, 34]
		//ABABABABABABABAB	[1, 2, 27, 29, 28, 31, 30]
		String msg1 = "KAKAO";
		int[] result1 = solution(msg1);
		for(int i : result1)
			System.out.print(i+ " ");
		System.out.println();
		String msg2 = "TOBEORNOTTOBEORTOBEORNOT";
		int[] result2 = solution(msg2);
		for(int i : result2)
			System.out.print(i+ " ");
		System.out.println();
		String msg3 = "ABABABABABABABAB";
		int[] result3 = solution(msg3);
		for(int i : result3)
			System.out.print(i+ " ");
		System.out.println();
	}

}

