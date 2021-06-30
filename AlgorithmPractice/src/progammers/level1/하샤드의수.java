package progammers.level1;

public class ÇÏ»þµåÀÇ¼ö {
	public static boolean solution(int x) {

        int sum = 0;
        int num =x;
        while(x>0){
            sum+=num%10;
            num/=10;
        }
        return x%sum == 0 ? true:false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=9;i<=13;++i) {
			boolean c = solution(11); 
		}
		
	}

}
