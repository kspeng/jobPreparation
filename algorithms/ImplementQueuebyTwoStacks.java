public class MyQueue1 {
    
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /*
     * @param element: An integer
     * @return: nothing
     */
    public void push(int element) {
        while(stack2.isEmpty() == false){
           int data  = stack2.pop();
           stack1.push(data);
         }
        stack2.push(element);
    }

    /*
     * @return: An integer
     */
    public int pop() {
       while(stack1.isEmpty() == false){
           int data  = stack1.pop();
           stack2.push(data);
       }
       
       return stack2.pop();
    }

    /*
     * @return: An integer
     */
    public int top() {
        while(stack1.isEmpty() == false){
           int data  = stack1.pop();
           stack2.push(data);
       }
        return stack2.peek();
    }
}


public class MyQueue2 {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    public MyQueue() {
         stack1 = new Stack<>();
         stack2 = new Stack<>();
    }
    
    private void stack2ToStack1(){
        while(stack2.isEmpty() == false){
            stack1.push(stack2.pop());
        }
    }

    /*
     * @param element: An integer
     * @return: nothing
     */
    public void push(int element) {
        stack2.push(element);
    }

    /*
     * @return: An integer
     */
    public int pop() {
        if(stack1.empty() == true){
            stack2ToStack1();
        }
        
        return stack1.pop();
    }

    /*
     * @return: An integer
     */
    public int top() {
        if(stack1.empty() == true){
            stack2ToStack1();
        }
        
        return stack1.peek();
    }
}