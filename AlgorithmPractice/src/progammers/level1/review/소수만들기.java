package progammers.level1.review;

import java.util.ArrayList;
import java.util.List;

public class 소수만들기 {
	public static boolean[] visit;
	public static List<Integer> list;
	public static int answer;
	public static int solution(int[] nums) {
        visit = new boolean[nums.length];
        list = new ArrayList<>();
        answer = 0;
        dfs(nums,0);
        return answer;
    }
	private static void dfs(int[] nums, int idx) {
		if(list.size() == 3) {
			if(isSosu(list.get(0) + list.get(1) + list.get(2))) {
				answer++;
			}
			return;
		}
		for(int i=idx;i<nums.length;++i) {
			list.add(nums[i]);
			dfs(nums, i+1);
			list.remove(list.size()-1);
		}
	}
	private static boolean isSosu(int sum) {
		for(int i=2;i<sum;++i) {
			if(sum%i == 0)
				return false;
		}
		return true;
	}
	public static void main(String[] args) {
		//nums	result
		//[1,2,3,4]	1
		//[1,2,7,6,4]	4
		int[] nums1 = {1,2,3,4};
		System.out.println(solution(nums1));
		int[] nums2 = {1,2,7,6,4};
		System.out.println(solution(nums2));
		
	}

}
