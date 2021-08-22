package baekjoon.avatar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ³â2007ver2 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(reader.readLine());
		int m = Integer.parseInt(tokens.nextToken());
		int day = Integer.parseInt(tokens.nextToken());
		System.out.println(solution(m,day));
	}

	private static String solution(int m, int day) {
		StringBuilder sb= new StringBuilder();
		for(int i=1;i<m;++i) {
			if(i==1 || i==3 || i==5 || i==7|| i==8|| i==10|| i==12) {
				day += 31;
			}else if(i==4|| i==6|| i==9|| i==11) {
				day += 30;
			}else {
				day += 28;
			}
		}
		day %= 7;
		switch (day) {
		case 0: {
			sb.append("SUN");
			break;
		}
		case 1: {
			sb.append("MON");
			break;
		}
		case 2: {
			sb.append("TUE");
			break;
		}
		case 3: {
			sb.append("WED");
			break;
		}
		case 4: {
			sb.append("THU");
			break;
		}
		case 5: {
			sb.append("FRI");
			break;
		}
		case 6: {
			sb.append("SAT");
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + day);
		}
		return sb.toString();
		
	}

}
