package backJun.stepBystep.funcTest;

public class ¼¿ÇÁ³Ñ¹ö {
	public static boolean[] selfNum = new boolean[10001];
	public static void main(String[] args) {
		for(int i=1;i<=10000;++i) {
			int n = d(i);
			if(n < 10001) {
				selfNum[n] = true;
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<selfNum.length;++i) {
			if(!selfNum[i])
				sb.append(i + "\n");
		}
		System.out.println(sb.toString());
	}
	private static int d(int num) {
		int sum = num;
		while(num>0) {
			sum += num%10;
			num /= 10;
		}
		return sum;
	}

}
