package progammers.level2;

public class 스킬트리 {
	public static int solution(String skill, String[] skill_trees) {
		int answer = 0;
        for(String skill_tree:skill_trees){
            boolean flag = true;
            for(int i=0;i<skill.length()-1;++i){
                int index1 = skill_tree.indexOf(skill.charAt(i));
                int index2 = skill_tree.indexOf(skill.charAt(i+1));
                if(index1 != -1 && index2 != -1){
                    if(index1 > index2){
                        flag =false;
                        break;
                    }
                }else if(index1 == -1 && index2 != -1){
                    flag =false;
                    break;
                }
            }
            if(flag){
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
		System.out.println(solution(skill, skill_trees));
	}
	
}
