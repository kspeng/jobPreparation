public class MinStack1 {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

    /*
     * @param number: An integer
     * @return: nothing
     */
    public void push(int number) {
        stack.push(number);
        if(minStack.isEmpty()){
            minStack.push(number);
        } else {
             minStack.push(Math.min(number,minStack.peek()));
        }
        
    }

    /*
     * @return: An integer
     */
    public int pop() {
        minStack.pop();
        return stack.pop();
    }

    /*
     * @return: An integer
     */
    public int min() {
        return minStack.peek();
    }
}


public class MinStack2 {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

    /*
     * @param number: An integer
     * @return: nothing
     */
    public void push(int number) {
        stack.push(number);
        // note use push equal ==
        if(minStack.isEmpty() || number <= minStack.peek()){
            minStack.push(number); 
        }
      
    }

    /*
     * @return: An integer
     */
    public int pop() {
        int data = stack.pop();
        if(minStack.peek() == data){
             minStack.pop();    
        }
        return data;
    }

    /*
     * @return: An integer
     */
    public int min() {
        return minStack.peek();
    }
}