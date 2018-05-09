package amazon.oa;

/**
 * https://leetcode.com/problems/palindromic-substrings/description/
 */
/*

	http://www.cnblogs.com/grandyang/p/7404777.html

	Given a string, your task is to count how many palindromic substrings in this string.

	The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.

	Example 1:
	Input: "abc"
	Output: 3
	Explanation: Three palindromic strings: "a", "b", "c".
	Example 2:
	Input: "aaa"
	Output: 6
	Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
	Note:
	The input string length won't exceed 1000.


	Time complexity: O(n^2)
	Space complexity: O(1)

*/
public class PalindromicSubstrings {

  // Solution 1, brute force, 从左到右遍历字符串，以每一个字符为中心，向左右两边扩展扫描，统计palindromic string

  public int countSubstrings(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int count = 1;
        for (int i = 1; i < s.length(); i++){
            //odd  a(a)aa
            count = count + counter(s,i,i);
            //even (aaaa)
            count = count + counter(s,i-1,i);
        }
        return count;
    }
    
    private int counter (String s, int start, int end ){
        int c = 0;
        while (start >= 0 && end < s.length();){
            if(s.charAt(start) != s.charAt(end)){
                break;
            }
            
            c++;
            start--;
            end++;
        }
        return c;
    }


}
