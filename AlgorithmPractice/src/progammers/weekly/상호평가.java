package progammers.weekly;

import java.util.Arrays;

public class 상호평가 {

	public static void main(String[] args) {
		//scores	result
		//[[100,90,98,88,65],[50,45,99,85,77],[47,88,95,80,67],[61,57,100,80,65],[24,90,94,75,65]]	"FBABD"
		//[[50,90],[50,87]]	"DA"
		//[[70,49,90],[68,50,38],[73,31,100]]	"CFD
		int[][] scores1 = {{100,90,98,88,65},{50,45,99,85,77},{47,88,95,80,67},{61,57,100,80,65},{24,90,94,75,65}};
		int[][] scores2 = {{50,90},{50,87}};
		int[][] scores3 = {{70,49,90},{68,50,38},{73,31,100}};
		System.out.println(solution(scores1));
		System.out.println(solution(scores2));
		System.out.println(solution(scores3));
	}

	private static String solution(int[][] scores) {
		StringBuilder sb = new StringBuilder();
		for(int j=0;j<scores[0].length;++j) {
			//열
			int sum = 0;
			int count = scores.length;
			int[] scr = new int[scores.length];
			for(int i=0;i<scores.length;++i) {
				scr[i] = scores[i][j];
				sum += scr[i];
			}
			int max = Arrays.stream(scr).max().getAsInt();
			int min = Arrays.stream(scr).min().getAsInt();
			if(Arrays.stream(scr).filter((i)->max == i).count() == 1) {
				if(max == scr[j]) {
					sum -= scr[j];
					count--;
				}
			}
			if(Arrays.stream(scr).filter((i)-> min == i).count() == 1) {
				if(min == scr[j]) {
					sum -= scr[j];
					count--;
				}
			}
			
			double result = (double)sum / count;
			
			if(result >= 90)
				sb.append("A");
			else if(result >= 80)
				sb.append("B");
			else if(result >= 70)
				sb.append("C");
			else if(result >= 50)
				sb.append("D");
			else 
				sb.append("F");
		}
		
		
		
		return sb.toString();
	}
}

