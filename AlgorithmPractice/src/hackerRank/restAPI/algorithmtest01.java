package hackerRank.restAPI;

import java.util.ArrayList;
import java.util.List;

public class algorithmtest01 {
	private static int solution(List<Integer> parents, List<Integer> file_size) {
		int[] arr= new int[parents.size()];
		
		for(int i =0;i<parents.size();++i) {
			int index = i;
			while(index != -1) {
				arr[index] += file_size.get(index);
				index = parents.get(index);
			}
			
		}
		int answer = Math.abs(arr[0] - (2 * arr[1]));
		for(int i=2;i<parents.size();++i) {
			if(answer > Math.abs(arr[0] - 2 * arr[i])) {
				answer = Math.abs(arr[0] - 2 * arr[i]);
			}
		}
		return answer;
	}
	
	public static void main(String[] args) {
		List<Integer> parents = new ArrayList<Integer>();
		parents.add(-1);
		parents.add(0);
		parents.add(0);
		parents.add(1);
		parents.add(1);
		parents.add(2);
		List<Integer> file_size = new ArrayList<Integer>();
		file_size.add(1);
		file_size.add(2);
		file_size.add(2);
		file_size.add(1);
		file_size.add(1);
		file_size.add(1);
		System.out.println(solution(parents,file_size));
	}
	
}
