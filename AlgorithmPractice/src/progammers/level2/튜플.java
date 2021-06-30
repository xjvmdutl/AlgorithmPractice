package progammers.level2;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class Æ©ÇÃ {
	public static int[] solution(String s) {
		
		String[] strs = s.replaceAll("[{}]", " ").trim().split(" ,");
		int[] answer = new int[strs.length];
		Set<Integer> hs = new HashSet<Integer>();
		Arrays.sort(strs,(a,b)->(
			a.length() - b.length()
		));
		int index = 0;
		for(String str : strs) {
			StringBuilder sb= new StringBuilder();
			for(String st : str.split(",")) {
				int num = Integer.parseInt(st.trim());
				if(hs.contains(num)) {
					continue;
				}
				hs.add(num);
				answer[index++] = num;
			}

		}
        return answer;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//s	result
		//"{{2},{2,1},{2,1,3},{2,1,3,4}}"	[2, 1, 3, 4]
		//"{{1,2,3},{2,1},{1,2,4,3},{2}}"	[2, 1, 3, 4]
		//"{{20,111},{111}}"	[111, 20]
		//"{{123}}"	[123]
		//"{{4,2,3},{3},{2,3,4,1},{2,3}}"	[3, 2, 4, 1]
		String s1 = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
		int[] result1 = solution(s1);
		for(int i : result1)
			System.out.println(i);
		String s2 = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
		int[] result2 = solution(s2);
		for(int i : result2)
			System.out.println(i);
		String s3 = "{{20,111},{111}}";
		int[] result3 = solution(s3);
		for(int i : result3)
			System.out.println(i);
		String s4 = "{{123}}";
		int[] result4 = solution(s4);
		for(int i : result4)
			System.out.println(i);
		String s5 = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
		int[] result5 = solution(s5);
		for(int i : result5)
			System.out.println(i);
	}

}
