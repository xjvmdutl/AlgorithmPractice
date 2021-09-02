package progammers.level2.review;

public class ¶¥µû¸Ô±â {
	 public static int solution(int[][] land) {
        int answer = 0;
        for(int i=1;i<land.length;++i) {
        	land[i][0] = Math.max(Math.max(land[i][0] + land[i-1][1], land[i][0] + land[i-1][2]),land[i][0] + land[i-1][3]);
        	land[i][1] = Math.max(Math.max(land[i][1] + land[i-1][0], land[i][1] + land[i-1][2]),land[i][1] + land[i-1][3]);
        	land[i][2] = Math.max(Math.max(land[i][2] + land[i-1][0], land[i][2] + land[i-1][1]),land[i][2] + land[i-1][3]);
        	land[i][3] = Math.max(Math.max(land[i][3] + land[i-1][0], land[i][3] + land[i-1][1]),land[i][3] + land[i-1][2]);
        }
        answer = Math.max(Math.max(Math.max(land[land.length-1][0], land[land.length-1][1]),land[land.length-1][2]),land[land.length-1][3]);
        return answer;
    }
	public static void main(String[] args) {
		//land	answer
		//[[1,2,3,5],[5,6,7,8],[4,3,2,1]]	16
		int[][] land = {{1,2,3,5},{5,6,7,8},{4,3,2,1}};
		System.out.println(solution(land));
	}

}
