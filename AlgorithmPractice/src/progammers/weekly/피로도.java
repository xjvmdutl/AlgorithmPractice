package progammers.weekly;


public class ÇÇ·Îµµ {
	public static int answer;
	public static boolean[] visit;
	public static int[] permulation;
	public static int solution(int k, int[][] dungeons) {
        answer = 0;
        visit = new boolean[dungeons.length];
        permulation = new int[dungeons.length];
        dfs(dungeons,0,dungeons.length,k);
        
        return answer;
    }
	private static void dfs(int[][] dungeons, int index, int length,int k) {
		if(index == length) {
			isOkay(dungeons,k);
			return;
		}
		for(int i=0;i<dungeons.length;++i) {
			if(!visit[i]) {
				visit[i] = true;
				permulation[index] = i;
				dfs(dungeons, index+1, length,k);
				visit[i] = false;
			}
		}
	}
	private static void isOkay(int[][] dungeons, int k) {
		int sum = 0;
		for(int i=0;i<permulation.length;++i) {
			int least = dungeons[permulation[i]][0];
			int somo = dungeons[permulation[i]][1];
			if(k < least)
				break;
			k -= somo;
			sum++;
		}
		answer = Math.max(answer, sum);
	}
	public static void main(String[] args) {
		int k1 = 80;
		int[][] dungeons1 = {{80,20},{50,40},{30,10}}; 
		System.out.println(solution(k1,dungeons1));
		
		int k2 = 80;
		int[][] dungeons2 = {{80,70},{20,10},{20,10},{20,10}}; 
		System.out.println(solution(k2,dungeons2));
	}

}
