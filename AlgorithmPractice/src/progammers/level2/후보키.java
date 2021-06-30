package progammers.level2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ÈÄº¸Å° {
	public static boolean[] visited;
	public static List<HashSet<Integer>> list;
	public static int solution(String[][] relation) {
        
        String[][] datas = new String[relation[0].length][relation.length];
        for(int i =0;i<relation.length;++i) {
        	for(int j=0;j<relation[i].length;++j) {
        		datas[j][i]= relation[i][j];
        	}
        }
        list = new ArrayList<>();
        visited = new boolean[datas.length];
        for(int i =1;i<=datas.length;++i) {
        	int[] nums = new int[i];
        	combine(datas,nums,0,i);
        }
        return list.size();
    }
	private static void combine(String[][] datas,int[] nums, int idx, int cnt) {
		if(cnt == idx) {
			HashSet<Integer> set = new HashSet<>();
			for(int i=0;i<nums.length;++i) {
				set.add(nums[i]);
			}
			for(HashSet<Integer> key : list) {
				if(set.containsAll(key)) {
					return;
				}
			}
			if(isUnique(set, datas)) {
				list.add(set);
			} 
			
			
			return;
		}
		for(int i=idx;i<datas.length;++i) {
			if(!visited[i]) {
				visited[i] =true;
				nums[idx]= i;
				combine(datas,nums, idx+1, cnt);
				visited[i] = false;
			}
		}
	}
	private static boolean isUnique(HashSet<Integer> keySet, String[][] relation) {
		Set<String> data= new HashSet<>();
		for(int i=0;i<relation[0].length;++i) {
			String key = "";
			
			for(int c : keySet) {
				
				key += relation[c][i];
				
					
			}
			if(data.contains(key)) return false;
			data.add(key);
		}
		
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//relation	result
		//[["100","ryan","music","2"],["200","apeach","math","2"],["300","tube","computer","3"],["400","con","computer","4"],["500","muzi","music","3"],["600","apeach","music","2"]]	2
		String[][] relation = {{"100","ryan","music","2"}
							  ,{"200","apeach","math","2"}
							  ,{"300","tube","computer","3"}
							  ,{"400","con","computer","4"}
							  ,{"500","muzi","music","3"}
							  ,{"600","apeach","music","2"}};
		System.out.println(solution(relation));
	}

}
