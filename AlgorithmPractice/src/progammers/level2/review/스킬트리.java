package progammers.level2.review;

import java.util.LinkedList;
import java.util.Queue;

public class 스킬트리 {
	public static int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for(int i=0;i<skill_trees.length;++i) {
        	String str = skill_trees[i];
        	Queue<Character> que = new LinkedList<>();
        	for(int j=0;j<skill.length();++j) {
            	que.offer(skill.charAt(j));
            }
        	boolean flag = true;
        	for(int j = 0;j<skill_trees[i].length();++j) {
        		if(que.contains(skill_trees[i].charAt(j))) {
        			 if(skill_trees[i].charAt(j) != que.poll()) {
        				 flag = false;
        				 break;
        			 }
        		}
        	}
        	if(flag) {
        		answer++;
        	}
        }
        return answer;
    }
	public static void main(String[] args) {
		//skill	skill_trees	return
		//"CBD"	["BACDE", "CBADF", "AECB", "BDA"]	2
		String skill = "CBD";
		String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
		System.out.println(solution(skill,skill_trees));
	}

}
