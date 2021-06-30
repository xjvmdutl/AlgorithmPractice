package progammers.level2;

public class 쿼드압축후개수세기 {
	static int ZeroCount = 0;
    static int OneCount = 0;
    public static int[] solution(int[][] arr) {
        ZeroCount = 0;
        OneCount = 0;
        dfs(arr,0,0,arr.length);
        int[] answer = new int[]{ZeroCount,OneCount};
        return answer;
        
    }
    
    private static void dfs(int[][] arr,int x,int y,int size){
        boolean zero = true;
        boolean one = true;
        for(int i = x;i<x+size;++i){
            for(int j = y;j<y+size;++j){
                if(arr[i][j] == 0) one = false;
                if(arr[i][j] == 1) zero = false;
            }
        }
        if(zero){
            ZeroCount++;
            return;
        }
        if(one){
            OneCount++;
            return;
        }
        dfs(arr,x,y,size/2);
        dfs(arr,x,y+size/2,size/2);
        dfs(arr,x+size/2,y,size/2);
        dfs(arr,x+size/2,y+size/2,size/2);
    }
	public static void main(String[] args) {
		//arr	result
		//[[1,1,0,0],[1,0,0,0],[1,0,0,1],[1,1,1,1]]	[4,9]
		//[[1,1,1,1,1,1,1,1],[0,1,1,1,1,1,1,1],[0,0,0,0,1,1,1,1],[0,1,0,0,1,1,1,1],[0,0,0,0,0,0,1,1],[0,0,0,0,0,0,0,1],[0,0,0,0,1,0,0,1],[0,0,0,0,1,1,1,1]]	[10,15]
		int[][] arr1 = {{1,1,0,0}
						,{1,0,0,0}
						,{1,0,0,1}
						,{1,1,1,1}};
		int[][] arr2 = {{1,1,1,1,1,1,1,1}
						,{0,1,1,1,1,1,1,1}
						,{0,0,0,0,1,1,1,1}
						,{0,1,0,0,1,1,1,1}
						,{0,0,0,0,0,0,1,1}
						,{0,0,0,0,0,0,0,1}
						,{0,0,0,0,1,0,0,1}
						,{0,0,0,0,1,1,1,1}};
		int[] result1 = solution(arr1);
		for(int i : result1) {
			System.out.println(i);
		}
		int[] result2 = solution(arr2);
		for(int i : result2) {
			System.out.println(i);
		}
		
	}

}
