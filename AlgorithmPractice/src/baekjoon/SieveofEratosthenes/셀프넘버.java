package baekjoon.SieveofEratosthenes;

public class ¼¿ÇÁ³Ñ¹ö {

	public static void main(String[] args) {
		System.out.println(solution());
	}

	private static String solution() {
		StringBuilder sb = new StringBuilder();
		boolean[] selfNum = new boolean[10001];
		for(int i=1;i<selfNum.length;++i) {
			if(selfNum[i])
				continue;
			int num = i;
			while(num <= 10000) {
				int sum = num;
				while(num > 0) {
					sum+=num%10;
					num/=10;
				}
				num =sum;
				if(num <= 10000)
					selfNum[num] = true;
			}
		}
		for(int i=1;i <= 10000;++i) {
			if(!selfNum[i])
				sb.append(i+"\n");
		}
		return sb.toString();
	}

}
