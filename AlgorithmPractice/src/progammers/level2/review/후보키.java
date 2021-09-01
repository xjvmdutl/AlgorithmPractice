package progammers.level2.review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ÈÄº¸Å° {
	public static boolean[] visit;
	public static String[][] datas;
	public static List<HashSet<Integer>> list;
	public static int solution(String[][] relation) {
        list = new ArrayList<>();
        datas = new String[relation[0].length][relation.length];
        for(int i =0;i<relation.length;++i) {
        	for(int j=0;j<relation[i].length;++j) {
        		datas[j][i]= relation[i][j];
        	}
        }
        visit = new boolean[datas.length];
        for(int i=1;i<=relation[0].length;++i) {
        	int[] per = new int[i];
        	dfs(relation,per,0,i);
        }
        return list.size();
    }
	private static void dfs(String[][] relation, int[] per, int index, int length) {
		if(index == length) {
			HashSet<Integer> set = new HashSet<>();
			for(int i=0;i<per.length;++i) {
				set.add(per[i]);
			}
			for(HashSet<Integer> key : list) {
				if(set.containsAll(key)) {
					return;
				}
			}
			if(isUnique(set,relation)) {
				list.add(set);
			} 
			return;
		}
		for(int i=index;i<datas.length;++i) {
			if(!visit[i]) {
				visit[i] = true;
				per[index] = i;
				dfs(relation, per, index+1, length);
				visit[i] = false;
			}
		}
	}
	private static boolean isUnique(HashSet<Integer> set, String[][] relation) {
		List<String> tmpList = new ArrayList<>();
		for(int i=0;i<datas[0].length;++i) {
			StringBuilder sb = new StringBuilder();
			for(int index : set) {
				sb.append(datas[index][i]);
			}
			if(tmpList.contains(sb.toString())) {
				return false;
			}
			tmpList.add(sb.toString());
		}
		
		return true;
	}
	public static void main(String[] args) {
		//relation	result
		//[["100","ryan","music","2"],["200","apeach","math","2"],["300","tube","computer","3"],["400","con","computer","4"],["500","muzi","music","3"],["600","apeach","music","2"]]	2
		String[][] relation1 = {
				{"100","ryan","music","2"}
				,{"200","apeach","math","2"}
				,{"300","tube","computer","3"}
				,{"400","con","computer","4"}
				,{"500","muzi","music","3"}
				,{"600","apeach","music","2"}};
		System.out.println(solution(relation1));
		String[][] relation2 = {
				{"100","100","ryan","music","2"}
				, {"200","200","apeach","math","2"}
				, {"300","300","tube","computer","3"}
				, {"400","400","con","computer","4"}
				, {"500","500","muzi","music","3"}, 
				 {"600","600","apeach","music","2"}};
		System.out.println(solution(relation2));
	}

}
