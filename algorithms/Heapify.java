public class Solution {
    /*
     * @param A: Given an integer array
     * @return: nothing
     */

    /*

        time = O(n*log(n))
        
        shift smaller up
    */
    public void heapify1(int[] A) {
        // n 
        for(int i = 0 ; i < A.length ; i++){
            shiftUp(A,i);
        }
    }
    // log(n)
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
    /*
        time = O(n)
        
        shift larger down
    */
     public void heapify2(int[] A) {
        // n/2
        for(int i = A.length / 2 ; i >= 0 ; i--){
            shiftDown(A,i);
        }
    }
    //    log(n/2)
    private void shiftDown(int[] A, int k){
        while(k < A.length){
            int smallIndex = k;
            // look for child 1
            if(k * 2 + 1 < A.length && A[k * 2 + 1] < A[smallIndex]){
                smallIndex = k * 2 + 1;
            }
            // look for child 2
            if(k * 2 + 2 < A.length && A[k * 2 + 2] < A[smallIndex]){
                smallIndex = k * 2 + 2;
            }
            
            if(smallIndex == k){
                break;
            }
            // shift larger down
            int temp = A[k];
            A[k] = A[smallIndex];
            A[smallIndex] = temp;
            k = smallIndex;
        }
     }
    
}