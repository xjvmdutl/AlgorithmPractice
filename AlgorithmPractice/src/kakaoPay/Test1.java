package kakaoPay;

public class Test1 {
	public static int solution(int money, int minratio,int maxratio,int ranksize,int threshold,int months) {
		int m = money;
		for(int i=0;i<months;++i) {
			m = money;
			m/=100;
			m*=100;
			int thresholdTmp = threshold;
			if(m < thresholdTmp)
				continue;
			int num = minratio;
			while(num < maxratio) {
				if(money < thresholdTmp + ranksize ) {
					break;
				}
				num++;
				thresholdTmp += ranksize;
			}
			double d = (double)num / 100;
			int n = (int) (m * d);
			money -= n;
		}
		return money;
	}
	public static void main(String[] args) {
		int result = solution(12345678,10,20,250000,10000000,4);
		System.out.println(result);
	}
}
