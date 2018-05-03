/**
 * Given two arrays, write a function to compute their intersection.
 * 
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
 * 
 * Note:
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 * 
 * Follow up:
 * 	What if the given array is already sorted ? How would you optimize your algorithm ?
 * 	What if nums1's size is small compared to nums2's size ? Which algorithm is better ?
 * 	What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into
 * 	the memory at once?
 */

public class IntersectionOfTwoArraysII {
	/*
     * Answers to follow up questions:
     * 
     * 1. What if the given array is already sorted? How would you optimize your algorithm?
     * 	  The two pointers solution is clearly better since it only takes O(min(m, n)) time and O(1) space.
     *
     *    Time Complexity from O(m+n) or O(n log n + m log m) to => O(min(n,m))
     * 
     * 2. What if nums1's size is small compared to nums2's size? Which algorithm is better?
     *    * Note given array is not sorted
     *    
     *    If nums1's size is small (O(1) vs O(min(m, n))), which we can ignore, the HashMap solution would be better because it much faster in time.
     * 
     * 3. What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements
     * 	  into the memory at once?
     *	  * Note given array is not sorted
     * 	  
     *    Still we can scan nums1 to build the frequency map, then process nums2 chunk by chunk (based on memory limit).
     */

 	/*
        Solution 1:
        Given a sorted Array so we can use two pointers to merge

        Time Complexity from O(m+n) or O(n log n + m log m) to => O(min(n,m))
        Space Complexity O(1)

    */
    public int[] intersection1(int[] nums1, int[] nums2) {
        
        if(nums1 == null || nums2 == null){
            return new int[0];
        }
        
      
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

    /**
     * A HashMap solution. It's similar to Intersection of Two Arrays, just here we need a map rather than a set to also
     * record the frequency of each element.
     * 
     * Time complexity: O(m + n)
     * Space complexity: O(min(m, n))
     */
   
 	public int[] intersect2(int[] nums1, int[] nums2) {

            if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
                return new int[0];
            }

            // ensure nums1 is shorter
            if (nums1.length > nums2.length) {
                int[] temp = nums1;
                nums1 = nums2;
                nums2 = temp;
            }

            // extra memory
            Map<Integer, Integer> map = new HashMap<>();
            for (int e : nums1) {
                map.put(e, map.getOrDefault(e, 0) + 1);
            }

            List<Integer> list = new ArrayList<>();
            for (int e : nums2) {
                if (map.containsKey(e) && map.get(e) > 0) {
                    map.put(e, map.get(e) - 1);
                    list.add(e);
                }
            }

            int[] result = new int[list.size()];
            for (int k = 0; k < list.size(); k++) {
                result[k] = list.get(k);
            }

            return result;
        }


}