package progammers.level2;

import java.util.Arrays;
import java.util.Comparator;

public class 순위검색 {
	public static int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        int count;
        Arrays.sort(info,(a,b)->(
        		Integer.parseInt(a.split(" ")[4].trim()) - Integer.parseInt(b.split(" ")[4].trim())
        ));
        for(int i = 0; i<query.length;++i) {
        	count=0;
        	String[] qry = query[i].split(" and ");
        	String language = qry[0].trim();
        	String job = qry[1].trim();
        	String career = qry[2].trim();
        	String food = qry[3].trim().split(" ")[0];
        	int score = Integer.parseInt(qry[3].trim().split(" ")[1]);
        	int j = binarySearch(info,score);
        	for(;j<info.length;++j) {
        		String[] data = info[j].split(" ");
        		if(!language.equals("-") && !data[0].trim().equals(language)) {
        			continue;
        		}
        		if(!job.equals("-") && !data[1].trim().equals(job)) {
        			continue;
        		}
        		if(!career.equals("-") && !data[2].trim().equals(career)) {
        			continue;
        		}
        		if(!food.equals("-") && !data[3].trim().equals(food)) {
        			continue;
        		}
        		if(Integer.parseInt(data[4].trim()) >= score) {
        			continue;
        		}
        		count++;
        	}
        	answer[i] = count;
        }
        return answer;
    }
	private static int binarySearch(String[] info, int score){
        
		
	    int end = info.length-1;
		int start = 0;
	        
	    while (start <= end) // end가 start보다 같거나 작아지면, 그 값이 Lower Bound이므로 반복을 종료한다.
		{
	    	int mid = (start + end)/2;
	    	int num = Integer.parseInt(info[mid].split(" ")[4].trim());
			mid = (start + end) / 2; 
       		if (num >= score) // 중간값이 원하는 값보다 크거나 같을 경우, 끝값을 중간값으로 설정하여 다시 탐색한다.
				start = mid;
			else end = mid + 1; // 중간값이 원하는 값보다 작을 경우, 시작값을 중간값+1로 설정하여 다시 탐색한다.
		}
		return start;
	        
    }
	
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//info	query	result
		//["java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"]	["java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"]	[1,1,1
		String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
		String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
		System.out.println(solution(info, query));
	}

}
