package progammers.level1.review;

import java.util.HashSet;
import java.util.Set;

public class ÆùÄ¹¸ó {
	public static int solution(int[] nums) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;++i) {
        	set.add(nums[i]);
        }
        if(set.size() <= nums.length/2) {
        	answer = set.size();
        }else {
        	answer = nums.length/2;
        }
        return answer;
    }
	public static void main(String[] args) {
		//nums	result
		//[3,1,2,3]	2
		//[3,3,3,2,2,4]	3
		//[3,3,3,2,2,2]	2
		
		int[] nums1 = {3,1,2,3};
		int[] nums2 = {3,3,3,2,2,4};
		int[] nums3 = {3,3,3,2,2,2};
		System.out.println(solution(nums1));
		System.out.println(solution(nums2));
		System.out.println(solution(nums3));

	}

}
