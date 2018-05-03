class Solution {

    /*
        Solution 1:
        A naive solution using sets to record all intersections.

        Time Complexity O(m+n)
        Memory Complexity O(min(m,n))

    */
    public int[] intersection1(int[] nums1, int[] nums2) {
        
        if(nums1 == null || nums2 == null){
            return new int[0];
        }
        // extra space
        Set<Integer> candidate1 = new HashSet<>();

        for (int data : nums1){
            candidate1.add(data);
        }
        
        Set<Integer> result = new HashSet<>();
        for(int data : nums2){
            if(candidate1.contains(data)){
                result.add(data);
            }
        }
 
        return  toArray(result);
    }
    
    /*
        Solution 2:
        Sort first and then use two pointers to merge

        Time Complexity O(n log n + m log m)
        Memory Complexity O(1) => no extra memory

    */
    public int[] intersection2(int[] nums1, int[] nums2) {
        
        if(nums1 == null || nums2 == null){
            return new int[0];
        }
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
      
        Set<Integer> result = new HashSet<>();
        int i = 0;
        int j = 0;
        while(i < nums1.length && j < nums2.length ){
            if(nums1[i] == nums2[j]){
                result.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]){
                i++;
            } else {
                j++;
            }
        }
 
        return  toArray(result);
    }
    
    /*
        Solution 3:

        Sort first array nlog(n), then binary search for the second array

        Time Complexity O(n log n + m log n) => (m + n) log n
        Memory Complexity O(1) => no extra memory

    */
     public int[] intersection3(int[] nums1, int[] nums2) {
        
        if(nums1 == null || nums2 == null){
            return new int[0];
        }
        // nlog(n)
        Arrays.sort(nums1);
        Set<Integer> result = new HashSet<>();
        
        // mlog(n)
        for(int num2: nums2) {
            if(result.contains(num2)){
                continue;
            } 
            if(binarySearch(nums1,num2)){
                    result.add(num2);
            }
        }
        
        
        return  toArray(result);
    }
    
    private boolean binarySearch(int nums[], int target){
        
        if (nums == null || nums.length == 0) {
            return false;
        }
        
        int left = 0;
        int right = nums.length - 1;
        
        while(left + 1 < right) {
            int mid = left + (right - left) / 2;
            if( nums[mid] == target) {
                return true;
            } else if(nums[mid] < target){
                left = mid;
            } else {
                right = mid;
            }
        }
        
        if (nums[left] == target || nums[right] == target) {
            return true;
        }
        
        return false;
        
    }



    private int[] toArray(Set<Integer> set) {
            int[] result = new int[set.size()];
            int i = 0;
            for (int num : set) {
                result[i++] = num;
            }
            return result;
        }
}