package test.ahnlab;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class test05 {
	public static boolean[] visit;
	private static int CARD_MAX_COUNT = 4;
	private static int NUM_MAX_COUNT = 10;
	private static int SAME_CARD = 1;
	private static int SAME_NUM = 1;
	public static int answer;
	public static int[] per;
	public static int solution(String[] cards) {
        answer = 0;
        Arrays.sort(cards, (o1, o2)->{
        	if(o1.charAt(0) == o2.charAt(0))
        		return o1.charAt(1) - o2.charAt(1);
        	return o1.charAt(0) - o2.charAt(0);
        });
        int size = cards.length > NUM_MAX_COUNT ? NUM_MAX_COUNT : cards.length;
        for(int i=3;i<=size ;++i) {
        	visit = new boolean[cards.length];
        	per = new int[i];
        	permutation(cards, 0, 0, i);
        }
        return answer;
    }
	private static void permutation(String[] cards, int index, int count, int length) {
		if(count == length) {
			Set<Character> card = new HashSet<>();
			Set<Integer> num = new HashSet<>();
			for(int i=0;i<per.length;++i) {
				card.add(cards[per[i]].charAt(0));
				num.add(Character.digit(cards[per[i]].charAt(1), 10));
			}
			if(card.size() == SAME_CARD  && length <= CARD_MAX_COUNT) { 
				answer += length * length;
			}else if(num.size() == SAME_NUM && length <= NUM_MAX_COUNT) {
				answer += length * length;
			}else if(num.size() == per.length 
					&& card.size() == per.length
					&& length <= NUM_MAX_COUNT) { // 4보다 경우에는 모양이 다를수가 없음
				answer += length * length;
			}
			return;
		}
		for(int i=index;i<cards.length;++i) {
			if(!visit[i]) {
				visit[i] = true;
				per[count] = i; 
				permutation(cards, i, count+1, length);
				visit[i] =false;
			}
		}
	}
	public static void main(String[] args) {
		String[] str1 = {"S1","D3","S3","S4","H3","H1"};
		System.out.println(solution(str1));
		String[] str2 = {"C0","C1","C2","C3","C4","C5","C6","C7","C8","C9","D1"};
		System.out.println(solution(str2));
		String[] str3 = {"H1","H2","C9"};
		System.out.println(solution(str3));
	}

}
