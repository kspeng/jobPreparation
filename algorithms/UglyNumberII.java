public class Solution {
    

    /**
     * Repeatedly find the next ugly number until there are n ugly numbers. The key here is how to find the next ugly
     * number. By definition, we know that the next ugly number must be "one of the existing ugly numbers" times either
     * 2 or 3 or 5. So we can find the minimum number that > current max divided by 2/3/5, then multiply by 2/3/5
     * respectively to make then just bigger then current max, then the minimum among these three will be the next ugly
     * number.
     * 
     * Time complexity: O(n)
     */
    public int nthUglyNumber(int n) {
        
        List<Integer> uglys = new ArrayList<>();
        uglys.add(1);
        
        while(uglys.size() < n){
            int nextUgly = findNext(uglys);
            uglys.add(nextUgly);
        }
        
        return uglys.get(uglys.size() -1);
    }
    
   private int findNext(List<Integer> uglys) {
       int last =  uglys.get(uglys.size() -1);
       int p2 = 0;
       int p3 = 0;
       int p5 = 0;
       
       while(uglys.get(p2) * 2 <= last){
           p2++;
       }
       while(uglys.get(p3) * 3 <= last){
           p3++;
       }
       while(uglys.get(p5) * 5 <= last){
           p5++;
       }
       // get next larger ugly number
       return Math.min(uglys.get(p2) * 2, Math.min(uglys.get(p3) * 3,uglys.get(p5) * 5));
   }
}