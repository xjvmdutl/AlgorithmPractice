package progammers.level3;


public class ÀÚ¹°¼è¿Í¿­¼è {
	public static boolean solution(int[][] key, int[][] lock) {
        int M = key.length;
        int[][][] rotationKey = new int[4][M][M];
        rotationKey[0] = key;
        for(int i = 1;i < 4; ++i){
            rotationKey[i] = Rotation(rotationKey[i-1],M);
        }
        int size = lock.length - 1;
        for(int k=0;k<4;++k){
            int[][] paddingKey = Padding(rotationKey[k],M,size);
            for(int i = 0 ; i < paddingKey.length - size; ++i) {
    			OUTER:for(int j = 0 ; j < paddingKey[0].length - size ; ++j) { 
                    int N = lock.length;
                    for(int R=0;R<N;++R){
                        for(int C=0;C<N;++C){
                            if(paddingKey[R+i][C+j] == lock[R][C])
                                continue OUTER;
                        }   
                    }            
                    return true;
                }
            }
        }
        return false;
    }
    public static int[][] Rotation(int[][] key,int M){
        int[][] rotation = new int[M][M];
        for(int i=0;i<M;++i){
            for(int j=0;j<M;++j){
                rotation[M - 1 - j][i] = key[i][j];
            }
        }
        return rotation;
    }
    public static int[][] Padding(int[][] key,int M,int N){
        int[][] padding = new int[M + N*2][M + N*2];
        for(int i=0;i<M;++i){
            for(int j=0;j<M;++j){
                padding[i+N][j+N] = key[i][j];
            }
        }
        return padding;
    }
	public static void main(String[] args) {
		int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
		int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
		System.out.println(solution(key,lock));
	}

}
