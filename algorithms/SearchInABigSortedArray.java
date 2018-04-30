public class Solution {
    /*
     * @param reader: An instance of ArrayReader.
     * @param target: An integer
     * @return: An integer which is the first index of target.
     */

    /*
      Time O (log(n))

    */
    public int searchBigSortedArray(ArrayReader reader, int target) {
       
       int end = 1;
       // find the max range first
       while(reader.get(end) < target){
           end = end * 2;
       } 
       int start = 0;
       
       while(start + 1 < end){
           int mid = start + (end - start) / 2;
           // search for the left
           if(reader.get(mid) == target){
               // move left
               end = mid;
           } else if(reader.get(mid) > target){
                end = mid;
           } else {
                start = mid;
           }
       }
       
      if(reader.get(start) == target){
          return start;
      }
       if(reader.get(end) == target){
          return end;
      }
       return -1;
       
       
    }
}