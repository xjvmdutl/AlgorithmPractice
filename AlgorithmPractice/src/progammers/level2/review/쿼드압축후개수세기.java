package progammers.level2.review;

public class 쿼드압축후개수세기 {
	public static int ZeroCount = 0;
	public static int OneCount = 0;
	public static int[] solution(int[][] arr) {
        ZeroCount = 0;
        OneCount = 0;
        dfs(arr,0,0,arr.length);
        int[] answer = {ZeroCount,OneCount};
        return answer;
    }
	private static void dfs(int[][] arr, int x, int y, int size) {
		boolean zero = false;
		boolean one = false;
		for(int i=x;i<x+size;++i) {
			for(int j=y;j<y+size;++j) {
				if(arr[i][j] == 0) one = true;
				if(arr[i][j] == 1) zero = true;
			}
		}
		if(!zero) {
			ZeroCount++;
            return;
		}
		if(!one) {
			OneCount++;
            return;
		}
		
		dfs(arr,x,y,size/2);
		dfs(arr,x+size/2,y,size/2);
		dfs(arr,x,y+size/2,size/2);
		dfs(arr,x+size/2,y+size/2,size/2);
	}
	public static void main(String[] args) {
		//arr	result
		//[[1,1,0,0],[1,0,0,0],[1,0,0,1],[1,1,1,1]]	[4,9]
		//[[1,1,1,1,1,1,1,1],[0,1,1,1,1,1,1,1],[0,0,0,0,1,1,1,1],[0,1,0,0,1,1,1,1],[0,0,0,0,0,0,1,1],[0,0,0,0,0,0,0,1],[0,0,0,0,1,0,0,1],[0,0,0,0,1,1,1,1]]	[10,15]
		int[][] arr1 = {{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}};
		System.out.println(solution(arr1));
		int[][] arr2 = {{1,1,1,1,1,1,1,1},{0,1,1,1,1,1,1,1},{0,0,0,0,1,1,1,1},{0,1,0,0,1,1,1,1},{0,0,0,0,0,0,1,1},{0,0,0,0,0,0,0,1},{0,0,0,0,1,0,0,1},{0,0,0,0,1,1,1,1}};
		System.out.println(solution(arr2));
	}

}
