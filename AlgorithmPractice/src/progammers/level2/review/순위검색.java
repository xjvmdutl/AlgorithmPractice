package progammers.level2.review;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 순위검색 {
	public static Map<String,Integer> wordMap = new HashMap<>();
	public static List<List<Integer>> scoreList = new ArrayList<>();
	
	
	public static int[] solution(String[] info, String[] query) {
		 wordMap.put("-", 0);//-기호 index 0
		 wordMap.put("cpp", 1);
		 wordMap.put("java", 2);
		 wordMap.put("python", 3);
		 wordMap.put("backend", 1);
		 wordMap.put("frontend", 2);
		 wordMap.put("junior", 1);
		 wordMap.put("senior", 2);
		 wordMap.put("chicken", 1);
		 wordMap.put("pizza", 2);
		 for(int i=0;i<4*3*3*3; ++i) {
			 scoreList.add(new ArrayList<>());
		 }//108개 짜리 크리 리스트를 만들었어
		 for(String str : info) {
			 String[] word = str.split(" ");
		 }
		 for(String str : info) {
			 String[] word = str.split(" ");
			 int[] arr = {wordMap.get(word[0]) * 3 * 3 * 3
					 ,wordMap.get(word[1]) * 3 * 3
					 ,wordMap.get(word[2]) * 3
					 ,wordMap.get(word[3])
					 };
			 int score = Integer.parseInt(word[4]);
			 for(int i=0;i<(1<<4);++i) {//1~16개
				 int idx = 0;
				 for(int j=0;j<4;++j) {
					 if((i & (1<<j)) != 0) {
						 idx += arr[j];
					 }
				 }
				 scoreList.get(idx).add(score);
			 }
		 }
		 for(int i=0;i<4*3*3*3;++i) {
			 Collections.sort(scoreList.get(i));
		 }
		 
		
		 int[] answer = new int[query.length];
		 for(int i=0;i<query.length;++i) {
			 String[] word = query[i].split(" ");
			int idx = wordMap.get(word[0]) * 3 * 3 * 3
					 +wordMap.get(word[2]) * 3 * 3
					 +wordMap.get(word[4]) * 3
					 +wordMap.get(word[6]);
			 int score = Integer.parseInt(word[7]);
			 int ret = Collections.binarySearch(scoreList.get(idx), score);
			 if(ret < 0) {
				 ret = -(ret+1);//값이 없을떄
			 }else {
				 for(int j=ret-1;j>=0;--j) {
					 if(scoreList.get(idx).get(j) == score) {
						 ret = j;
					 }else {
						 break;
					 }
				 }
			 }
			 answer[i] = scoreList.get(idx).size() - ret;
		 }
		 return answer;
	}
	
	public static void main(String[] args) {
		//info	query	result
		//["java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"]	["java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"]	[1,1,1,1,2,4]
		String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
		String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
		System.out.println(solution(info,query));
	}

}
