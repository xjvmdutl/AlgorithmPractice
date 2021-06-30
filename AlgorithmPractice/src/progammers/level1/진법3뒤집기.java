package progammers.level1;

public class 진법3뒤집기 {
	public static int solution(int n) {
        
        String s = "";
        while(n>0){
            s += n%3;
            n/=3;
        }
        int i =0;
        int sum =0;
        while(s.length()>i) {
        	int e =  (int)Math.pow(3, s.length()-i-1)
        			*(Character.getNumericValue(s.charAt(i)));
        	sum+=e;
        	i++;
        }
        return sum;
    }
	/*
	 public int solution(int n) {
        String a = "";

        while(n > 0){
            a = (n % 3) + a;
            n /= 3;
        }
        a = new StringBuilder(a).reverse().toString();


        return Integer.parseInt(a,3);
    }
    */
}
