package progammers.level1;

public class Ã¼À°º¹ {
	public static int solution(int n, int[] lost, int[] reserve) {
        int count =0;
        for(int i=0;i<lost.length;++i){
            for(int j=0;j<reserve.length;++j){
            	
                if(lost[i]-1== reserve[j]
                  || lost[i]+1== reserve[j]){
                    count++;
                    reserve[j]=-1;
                    break;
                }
            }
        }
        
        return n-lost.length+count;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] lost = {2,4};
		int[] reserve = {3};
		int d = solution(5,lost,reserve);
	}

}
