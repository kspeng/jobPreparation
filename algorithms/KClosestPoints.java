/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * } * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */

public class Solution {
    /**
     * @param points: a list of points
     * @param origin: a point
     * @param k: An integer
     * @return: the k closest points
     */
    private Point ORIGIN = null;
    public Point[] kClosest(Point[] points, Point origin, int k) {
       if (points == null || points.length == 0 || k == 0 || origin == null) {
            return new Point[]{};
        }
        
        ORIGIN = origin;

        PriorityQueue<Point> maxQueue = new PriorityQueue<Point> (k, distanceComparator);
        
        for (int i = 0; i < points.length; i++){
            maxQueue.offer(points[i]);
            // keep k elements
            if(maxQueue.size() > k){
                maxQueue.poll();
            }
        }

        // retreve data backward
        Point[] results = new Point[maxQueue.size()];
        for (int i = maxQueue.size() - 1; maxQueue.size() > 0; i--){
             results[i] = maxQueue.poll();
        }
        
        return results;
        
    }
    // Custom Comparator
    public Comparator<Point> distanceComparator = new Comparator<Point>(){
 
         @Override
         public int compare(Point a, Point b){
               //  a - b
               //     return 1 if rhs should be before lhs 
               //     return -1 if lhs should be before rhs
               //     return 0 otherwise
               // Note in here we use b - a for maxHeap
     
               int diff = calculateDistance(b, ORIGIN) - calculateDistance(a, ORIGIN) ;
               if(diff == 0){
                   diff = b.x - a.x;
               }
               if(diff == 0){
                   diff = b.y - a.y;
               }
               return diff;
           } 
    };
    
    private int calculateDistance(Point origin, Point target) {
        int internalX = (origin.x - target.x) * (origin.x - target.x);
        int internalY = (origin.y - target.y) * (origin.y - target.y);
        return internalX + internalY;
    }
    
}