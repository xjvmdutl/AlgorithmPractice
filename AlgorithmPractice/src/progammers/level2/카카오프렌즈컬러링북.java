package progammers.level2;
import java.util.Queue;
import java.util.LinkedList;

public class īī���������÷����� {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static class Node {
        int x;
        int y;
        
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static Queue<Node> queue = new LinkedList<Node>();
    static boolean[][] visited;
    static int size = 0;// ĭ�� ����

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
      int maxSizeOfOneArea = 0;
      
      visited = new boolean[m][n];
      
      for(int i = 0; i < m; i++){
          for(int j = 0; j < n; j++){
              if(picture[i][j] > 0 && visited[i][j] != true){
                  size = 1;
                  bfs(picture, i, j, m, n);
                  numberOfArea++;
                  if(maxSizeOfOneArea < size)
                      maxSizeOfOneArea = size;
              }
              
          }
      }
      
      int[] answer = new int[2];
      answer[0] = numberOfArea;
      answer[1] = maxSizeOfOneArea;
      return answer;
    }
     static void bfs(int[][] pic, int x, int y, int m, int n){
        queue.add(new Node(x, y));
        visited[x][y] = true;
        
        while(!queue.isEmpty()){
            Node now = queue.poll();
            
            for(int i = 0; i < 4; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                
                if(0 <= nx && nx < m && 0 <= ny && ny < n){
                    if(pic[nx][ny] == pic[x][y] && visited[nx][ny] != true){
                        queue.add(new Node(nx, ny));
                        visited[nx][ny] = true;
                        size++; // ������ ĭ�� ����
                    
                    }
                }
            }
        }
    }
    
}