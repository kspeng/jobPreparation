public class Solution {
    /*
     * @param A: Given an integer array
     * @return: nothing
     */

    /*

        time = O(nlog(n))

    */
    public void heapify1(int[] A) {
        for(int i = 0 ; i < A.length ; i++){
            shiftUp(A,i);
        }
    }
    
    private void shiftUp(int[] A, int k){
        while(k != 0){
            int father = ( k - 1 ) / 2;
            if(A[k] > A[father]){
                break;
            }
            
            int temp = A[k];
            A[k] = A[father];
            A[father] = temp;
            k = father;
        }
    }
    
}