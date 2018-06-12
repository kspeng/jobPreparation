public class Solution {
    /**
     * @param A: an integer array
     * @param target: An integer
     * @param k: An integer
     * @return: an integer array
     */

    /**
     * A solution with heap. The idea is to define a heap that satisfy the requirements, then add each element to it.
     * Since only k closest elements are required, we can safely remove (poll) the farthest element when the heap size
     * is greater than k. 
     *
     * It takes O(log k) time to add each element to the heap, and the sorting takes O(k log k) time,
     * so the time complexity becomes O(n log k) + O(k log k) = O((n+k) log k).
     * 
     * Time complexity: O((n+k) log k)
     */

    public int[] kClosestNumbers(int[] A, int target, int k) {
       int [] arrayResults = new int[k];
        if(A == null || A.length < k || k == 0){
            return arrayResults;
        }
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>
        (k,new Comparator<Integer>(){
        
            @Override
            public int compare(Integer a, Integer b){
                // if dist > 0, swap 
                int dist = Math.abs(b-target) - Math.abs(a-target);
                // 
                if(dist == 0){
                    return b - a;
                }
                return dist;
            }
        });
        
        for(int num: A){
            maxHeap.offer(num);
            if(maxHeap.size() > k){
                maxHeap.poll(); // pull largest, left cloest  
            }
        }
        
  
        for(int i = k-1; i >= 0 && maxHeap.size() != 0 ; i--){
            arrayResults[i] = maxHeap.poll();
        }
        
      
  
        return arrayResults;
    }
}