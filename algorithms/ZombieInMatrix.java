class Coordinate {
    int x;
    int y;
    public Coordinate(int x, int y){
        this.x = x;
        this.y = y;
    }
}



public class Solution {
    /**
     * @param grid: a 2D integer grid
     * @return: an integer
     */
     
     /*
     分层次的 bfs 
     
        Time（n * m） + O(V+E)
     
     */
    final int PEOPLE = 0;
    final int ZOMBIE = 1;
    final int WALL = 2;
    int dx[] = {1,0,-1,0};
    int dy[] = {0,1,0,-1};
    
        
    public int zombie(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length ==0){
            return 0;
        }
        
        
        
        int totalPepole = 0;
        int n = grid.length;
        int m = grid[0].length;
        
        Queue<Coordinate> quque = new LinkedList<>(); 
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m ; j++){
               int data = grid[i][j];
               if(data == PEOPLE){
                   totalPepole++;
               } else if(data == ZOMBIE){
                   Coordinate coordinate = new Coordinate(i,j);
                   quque.offer(coordinate);
               }
            } 
        }
        
        if(totalPepole == 0){
            return 0;
        }
        
        int level = 0;
        while (quque.isEmpty() == false){
            level++; 
            int size = quque.size();
            for(int i = 0; i < size;  i++){
                Coordinate coordinate = quque.poll();
                for(int d = 0; d < 4; d++){
                    Coordinate nb = new Coordinate( coordinate.x + dx[d], coordinate.y + dy[d]);
                    if(isPeople(grid,nb) == false){
                        continue;
                    } 
                    grid[nb.x][nb.y] = ZOMBIE;
                    totalPepole--;
                    if(totalPepole == 0){
                        return level;
                    }
                    quque.offer(nb);
                }
            }
        }
        return -1;
    }
    
    boolean isPeople(int[][] grid,Coordinate c){
        int n = grid.length;
        int m = grid[0].length;
        if(c.x < 0 || c.x >= n){
            return false;
        }
        if(c.y < 0 || c.y >= m){
            return false;
        }
        if(grid[c.x][c.y] == PEOPLE){
           return true; 
        }
        return false;
    }
}







