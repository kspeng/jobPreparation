/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */

public class Solution {
    /**
     * @param grid: a chessboard included 0 (false) and 1 (true)
     * @param source: a point
     * @param destination: a point
     * @return: the shortest path 
     */
    /*
        Time O(V+E)

    */
    int[] dx = {1,1,-1,-1,2,2,-2,-2};
    int[] dy = {2,-2,2,-2,1,-1,1,-1};
    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        if(grid == null || grid.length == 0 || grid[0].length == 0 || 
        source == null || destination == null){
            return -1;
        }
  
        
        Queue<Point> queue = new LinkedList<>();
        queue.offer(source);
        int level = 0;
        while(queue.isEmpty() == false){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Point p = queue.poll();
                if(p.x == destination.x && destination.y == p.y){
                    return level;
                }
                
                for(int d = 0; d < 8; d++){
                    Point nb = new Point(
                    dx[d] + p.x , 
                    dy[d] + p.y);
                    
                    if(isLegal(grid, nb) == false){
                        continue;
                    }
                    queue.offer(nb);
                    grid[nb.x][nb.y] = true; //mark as barrier
                }
            }
            
            level++;
        }
        
        return -1;
    }
    
    
    boolean isLegal(boolean[][] grid, Point p ){
        
        int n = grid.length;
        int m = grid[0].length;
        
        if(p.x < 0 || p.x >= n){
            return false;
        }
        
        if(p.y < 0 || p.y >= m){
            return false;
        }
        if(grid[p.x][p.y] == false){
            return true;
        }
        
        return false;
        
    }
}







