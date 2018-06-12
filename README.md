# jobPreparation
LeetCode/LintCode solutions in Java
Reference to Jerry's git https://github.com/liangchiwuu/leetcode

## Algorithms

★ indicates critical problems, IMO.  
☆ indicates LeetCode subscribers only.  
L indidates Ladder from LintCode questions.  

| |#|Source|Difficulty|Problem|Solution|Tag| 
|-|-|-|----------|-------|--------|---|
|★|1|LeetCode|Easy|[Two Sum](https://leetcode.com/problems/two-sum/)|[Java](./algorithms/TwoSum.java)|Hash|
||14|LintCode|Easy|[First Position of Target ](https://www.lintcode.com/en/problem/first-position-of-target/)|[Java](./algorithms/FirstPositionOfTarget.java)|Binary Search|
||20|LintCode|Easy|[Valid Parentheses](https://leetcode.com/problems/valid-parentheses/description/)|[Java](./algorithms/ValidParentheses.java)|String, Stack|
|L|28/13|LeetCode/LintCode|Easy|[strStr](https://leetcode.com/problems/implement-strstr/description/)|[Java](./algorithms/strStr.java)|String|
||57|LintCode|Easy|[ThreeSum](https://www.lintcode.com/problem/3sum/description)|[Java](./algorithms/ThreeSum.java)|Two Pointer|
||74|LintCode|Medium|[First Bad Version](https://www.lintcode.com/en/problem/first-bad-version/)|[Java](./algorithms/FirstBadVersion.java)|Binary Search|
|L|125/415|LeetCode/LintCode|Easy|[Valid Palindrome](https://leetcode.com/problems/valid-palindrome/description/)|[Java](./algorithms/ValidPalindrome.java)|Two Pointers|
||167|LeetCode|Easy|[Two Sum II](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/)|[Java](./algorithms/TwoSumII.java)|Two Pointers|
|L|140|LintCode|Medium|[Fast Power](https://www.lintcode.com/en/problem/fast-power/)|[Java](./algorithms/FastPower.java)|Binary Search|
||170/607|LeetCode/LintCode|Easy|[Two Sum III](https://www.lintcode.com/en/problem/two-sum-iii-data-structure-design/)|[Java](./algorithms/TwoSumIII.java)|Two Pointers|
||206|LeetCode|Easy|[Reverse Linked List](https://leetcode.com/problems/reverse-linked-list/description/)|[Java](./algorithms/reverseList.java)| Pointers|
|L|228|LeetCode|Naive|[Middle of Linked List](https://www.lintcode.com/problem/middle-of-linked-list/description)|[Java](./algorithms/MiddleOfLinkedList.java)|Two Pointers|
|L|409/627|LeetCode/LintCode|Easy|[Longest Palindrome](https://www.lintcode.com/en/problem/longest-palindrome/)|[Java](./algorithms/LongestPalindrome.java)|Hash|
||344|LeetCode|Easy|[Reverse String](https://leetcode.com/problems/reverse-string/description/)|[Java](./algorithms/ReverseString.java)|Two Pointers, String|
|★|349|LeetCode|Easy|[Intersection of Two Arrays](https://leetcode.com/problems/intersection-of-two-arrays/description/)|[Java](./algorithms/IntersectionOfTwoArrays.java)|Two Pointers, Set|
|★|350|LeetCode|Easy|[Intersection of Two ArraysII](https://leetcode.com/problems/intersection-of-two-arrays-ii/description/)|[Java](./algorithms/IntersectionOfTwoArraysII.java)|Two Pointers, Set|
|L|428|LintCode|Medium|[Pow(x, n)](https://www.lintcode.com/en/problem/powx-n/)|[Java](./algorithms/Powx-n.java)|Binary Search|
|L|447|LintCode|Medium|[Search in a Big Sorted Array](https://www.lintcode.com/en/problem/search-in-a-big-sorted-array/)|[Java](./algorithms/SearchInABigSortedArray.java)|Binary Search|
||457|LintCode|Easy|[Classical Binary Search](https://www.lintcode.com/en/problem/classical-binary-search/)|[Java](./algorithms/ClassicalBinarySearch.java)|Binary Search|
|L|458|LintCode|Easy|[Last Position of Target](https://www.lintcode.com/en/problem/last-position-of-target/)|[Java](./algorithms/LastPositionOfTarget.java)|Binary Search|
||460|LintCode|Medium|[Find K Closest Elements](https://www.lintcode.com/problem/find-k-closest-elements/description)|[Java](./algorithms/findkClosestElements.java)|Heap|
|L|521|LintCode|Easy|[Remove Duplicate Numbers In Array](https://www.lintcode.com/problem/remove-duplicate-numbers-in-array/description)|[Java](./algorithms/RemoveDuplicateNumbersInArray.java)|Set, Sort|
||604|LintCode|Easy|[Window Sum](https://www.lintcode.com/problem/window-sum/description)|[Java](./algorithms/WindowSum.java)|Two Pointers|
|★L|612|LintCode|Medium|[K Closest Points](https://www.lintcode.com/en/old/problem/k-closest-points/)|[Java](./algorithms/KClosestPoints.java)|Priority Queue|
|★|647|LeetCode|Medium|[Palindromic Substrings](https://leetcode.com/problems/palindromic-substrings/description/)|[Java](./algorithms/PalindromicSubstrings.java)|Two Pointers, DP|
## Handy Java Syntax

### Array length  
int[] nums = {10,20}  
int [] hashData = new int [256];  
Arrays.sort(nums);  
for (int left = 0; left < nums.length; left++)  

### String length()  
s.length()  
for (char c : s.toCharArray())  
  
### List size()  
ArrayList<Integer> arrli = new ArrayList<Integer>();  
arrli.add(i);  
arrli.remove(index);  
for (int i=0; i<arrli.size(); i++)  
Collections.sort(arrli);  

### Map size()  
Map<Integer, Boolean> mp = new HashMap<Integer, Boolean>();  
mp.size()  
mp.put(nums[i], true);   
mp.remove(key);  
for (Map.Entry<Integer, Boolean> entry : mp.entrySet())  

### Set size()  
Set <Integer> sets = new HashSet<Integer>();  
set.size();  
set.remove(object);  
sets.add(nums[left]);   
for (Integer data : sets)  

### Heap and comparable
```java 
// Max heap
PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k,new Comparator<Integer>(){
        @Override
        public int compare(Integer a, Integer b){
            // if dist > 0, swap a and b
            int dist = Math.abs(b-target) - Math.abs(a-target);
            // if b > a, return postive, then swap b and a
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
```
n = num of elements, k = num of elements in the PQ  

O(log k) time for the enqueing and dequeing methods (offer, poll, remove() and add) => O(n * log k)
O(k) for the remove(Object) and contains(Object) methods  
O(1) for the retrieval methods (peek, element, and size)  

## Time Complexity

常见的算法时间复杂度由小到大依次为：Ο(1)＜Ο(log2n)＜Ο(n)＜Ο(nlog2n)＜Ο(n2)＜Ο(n3)＜…＜Ο(2n)＜Ο(n!)


![Screenshot](timeComplexity.png)