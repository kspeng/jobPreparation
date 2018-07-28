public class Stack {
    /*
     * @param x: An integer
     * @return: nothing
     */
     
    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();
    
    private void findLastItem() {
        // find the last one
        while (queue1.size() != 1) {
            queue2.offer(queue1.poll());
        }
    }
    
    private void swapQueues() {
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }
    
    public void push(int x) {
        queue1.offer(x);
    }

    /*
     * @return: nothing
     */
    public void pop() {

       findLastItem();
       queue1.poll();
       swapQueues();
    }

    /*
     * @return: An integer
     */
    public int top() {
        findLastItem();
        int top = queue1.poll();
        queue2.offer(top);
        swapQueues();
        return top;
    }

    /*
     * @return: True if the stack is empty
     */
    public boolean isEmpty() {
       return queue1.isEmpty();
    }
}