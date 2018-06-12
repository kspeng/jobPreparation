public class Solution {
    /**
     * @param numbers: Give an array numbers of n integer
     * @return: Find all unique triplets in the array which gives the sum of zero.
     */
    public List<List<Integer>> threeSum(int[] numbers) {
     List<List<Integer>> results = new ArrayList<>();
    /*
    timeComplexity O(n^2)

    */
      if(numbers == null || numbers.length < 3){
          return results;
      }
         // avoid duplicate
      Arrays.sort(numbers);
      
      for (int i = 0; i <  numbers.length - 2 ; i++){
            // avoid duplicate
          if(i > 0 && numbers[i] == numbers[i-1]){
              continue;
          }
          
          for (List<Integer> data: twoSum(numbers,i + 1, numbers.length - 1, - numbers[i])) {
              data.add(0, numbers[i]); // add i back to index 0 or ordering
              results.add(data);
          }
      }
      
      return results;
      
    }

    // find all unique pairs
    List<List<Integer>> twoSum(int[] numbers, int start, int end, int target) {
        int left = start;
        int right = end;
        List<List<Integer>> results = new ArrayList<>();
        while(left < right){
            if(numbers[left] + numbers[right] > target){
                right --;
            } else if (numbers[left] + numbers[right] < target){
                left++;
            } else {
                List<Integer> triplet = new ArrayList<>();
                
                triplet.add(numbers[left]);
                triplet.add(numbers[right]);
                results.add(triplet);
                
                left++;
                // avoid duplicate
                while(left < right && numbers[left] == numbers[left-1]){
                    left++;
                }

                right--; 
                // avoid duplicate
                while(left < right && numbers[right] == numbers[right+1]){
                    right--;
                }
                
            }
        }
        
        return results;
    }
}






