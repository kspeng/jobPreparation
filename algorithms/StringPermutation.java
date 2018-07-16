public class Solution {
    /**
     * @param A: a string
     * @param B: a string
     * @return: a boolean
     */
    public boolean Permutation(String A, String B) {
       int[] bucket = new int [500];
       for(int i = 0; i < A.length(); i++){
           bucket[(int)A.charAt(i)]++;
       }
       
       for(int i = 0; i < B.length(); i++){
           bucket[(int)B.charAt(i)]--;
       }
       for(int i = 0; i < 500; i++){
           if(bucket[i] != 0){
               return false;
           }
       }
       
       return true;
    }
}