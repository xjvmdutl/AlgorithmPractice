package progammers.level1;

public class 년2016 {
	 public static String solution(int a, int b) {
       String[] week = {"SUN","MON","TUE","WED","THU","FRI","SAT"};
        int sum = 0; //1일 부터 시작
        
        for(int i=1; i<a; i++){
            if(i==4 || i==6|| i==9|| i==11){
                sum+=30;
            }else if(i == 2){
                sum+=29;
            }else{
                sum+=31;
            }
        }   
        
        return week[(sum+b+4)%7];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s= solution(5,24);
	}

}
