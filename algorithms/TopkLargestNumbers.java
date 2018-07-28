public class Solution {
    /**
     * @param nums: an integer array
     * @param k: An integer
     * @return: the top k largest numbers in array
     */
    public int[] topk(int[] nums, int k) {
        
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(k,new Comparator<Integer>(){
        @Override
        public int compare(Integer a, Integer b){
            // if dist > 0, swap a and b
             // 5 - 4 = 1 > swap
            return a - b;
        }
    });

    for(int num: nums){
            minHeap.offer(num);
            if(minHeap.size() > k){
                minHeap.poll(); // pull the top (smallest), left largest  
            }
        }
    
    int [] results = new int [k];
    for(int i = results.length - 1; i >= 0; i--){
        int data  = minHeap.poll();
        results[i] = data;
    }
    
    return results;
    }
}