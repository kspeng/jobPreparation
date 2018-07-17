public class Stack {
    /*
     * @param x: An integer
     * @return: nothing
     */
    ArrayList<Integer> stack = new ArrayList<>();
    
    public void push(int x) {
        stack.add(x);
    }

    /*
     * @return: nothing
     */
    public void pop() {
        stack.remove( stack.size() -1 );
    }

    /*
     * @return: An integer
     */
    public int top() {
        if(stack.size() == 0){
            return -1;
        }
        return stack.get(stack.size() -1);
    }

    /*
     * @return: True if the stack is empty
     */
    public boolean isEmpty() {
         if(stack.size() == 0){
             return true;
         }
         return false;
    }
}