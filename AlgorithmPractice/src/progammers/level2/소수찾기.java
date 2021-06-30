package progammers.level2;


import java.util.ArrayList;
import java.util.List;

public class 소수찾기 {
	public static boolean[] visited;
    public static List<Integer> list;
	public static int solution(String numbers) {
		int answer = 0;
        String[] strs = numbers.split("");
        int[] nums = new int[strs.length];
        for(int i=0;i<strs.length;++i){
            nums[i] = Integer.parseInt(strs[i]);
        }
        visited = new boolean[nums.length];
        list = new ArrayList<>();
        for(int i=1;i<=nums.length;++i){
            int[] num = new int[i];
            permulate(nums,num,i,0);
        }
        return list.size();
    }
	private static void permulate(int[] nums,int[] num, int cnt,int index) {
		if(cnt == index){
            StringBuilder sb = new StringBuilder();
            for(int i : num){
                sb.append(i);
            }
            int result = Integer.parseInt(sb.toString());
            if(prime(result)){
                if(!list.contains(result))
                    list.add(result);
            }
            return;    
        }
        for(int i=0;i<nums.length;++i){
        	if(!visited[i]){
                visited[i] = true;
                num[index] = nums[i];
                permulate(nums,num,cnt,index+1);
                num[index] = 0;
                visited[i] =false;
            }
        }
		
	}
	   private static boolean prime(int result){
	        if(result<=1)
	            return false;
	        if(result == 2 || result == 3)
	            return true;
	        for(int i=2;i<=Math.sqrt(result);++i)
	            if(result%i == 0)
	                return false;
	        return true;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		numbers	return
//		"17"	3
//		"011"	2
		String numbers1 = "17";
		String numbers2 = "011";
		System.out.println(solution(numbers1));
		System.out.println(solution(numbers2));
	}

}
