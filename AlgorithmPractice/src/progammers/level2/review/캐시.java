package progammers.level2.review;

import java.util.ArrayList;
import java.util.List;

public class 캐시 {
	 public static int solution(int cacheSize, String[] cities) {
        int answer = 0;
        if(cacheSize == 0) {
        	return 5 * cities.length;
        }
        List<String> list = new ArrayList<>();
        for(int i=0;i<cities.length;++i) {
        	cities[i] = cities[i].toLowerCase();
        	if(!list.contains(cities[i])) {
        		answer += 5;
        		list.add(cities[i]);
        		if(list.size() > cacheSize) {
        			list.remove(0);	
        		}
        	}else {
        		answer += 1;
        		int index = list.indexOf(cities[i]);
        		list.remove(index);
        		list.add(cities[i]);
        	}
        }
        return answer;
    }
	public static void main(String[] args) {
		//캐시크기(cacheSize)	도시이름(cities)	실행시간
		//3	["Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"]	50
		//3	["Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"]	21
		//2	["Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"]	60
		//5	["Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"]	52
		//2	["Jeju", "Pangyo", "NewYork", "newyork"]	16
		//0	["Jeju", "Pangyo", "Seoul", "NewYork", "LA"]	25
		int cacheSize1 = 3;
		String[] cities1 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
		System.out.println(solution(cacheSize1,cities1));
		int cacheSize2 = 3;
		String[] cities2 = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
		System.out.println(solution(cacheSize2,cities2));
		int cacheSize3 = 2;
		String[] cities3 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
		System.out.println(solution(cacheSize3,cities3));
		int cacheSize4 = 5;
		String[] cities4 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
		System.out.println(solution(cacheSize4,cities4));
		int cacheSize5 = 2;
		String[] cities5 = {"Jeju", "Pangyo", "NewYork", "newyork"};
		System.out.println(solution(cacheSize5,cities5));
		int cacheSize6 = 0;
		String[] cities6 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
		System.out.println(solution(cacheSize6,cities6));
	}

}
