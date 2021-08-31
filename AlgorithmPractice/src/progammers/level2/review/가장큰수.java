package progammers.level2.review;

import java.util.ArrayList;
import java.util.List;

public class 가장큰수 {
	public static String solution(int[] numbers) {
		List<String> list = new ArrayList<>();
		for(int i=0;i<numbers.length;++i) {
			list.add(String.valueOf(numbers[i]));
		}
		list.sort((o1,o2)->{
			return (o2+o1).compareTo(o1+o2);
		});
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<list.size();++i) {
			sb.append(list.get(i));
		}
		while(sb.length() > 1 && sb.charAt(0)=='0') {
			sb.delete(0, 1);
		}
        return sb.toString();
    }
	public static void main(String[] args) {
		//numbers	return
		//[6, 10, 2]	"6210"
		//[3, 30, 34, 5, 9]	"9534330"
		//[3, 30, 34, 4, 40, 42, 421, 423, 45] "454424234214034330"
		int[] numbers1 = {0,0,0};
		System.out.println(solution(numbers1));
		int[] numbers2 = {3, 30, 34, 5, 9};
		System.out.println(solution(numbers2));
		int[] numbers3 = {3, 30, 34, 4, 40, 42, 421, 423, 45};
		System.out.println(solution(numbers3));
	}

}
