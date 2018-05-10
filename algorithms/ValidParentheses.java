class Solution {
    /*
        Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

        An input string is valid if:

        Open brackets must be closed by the same type of brackets.
        Open brackets must be closed in the correct order.
        Note that an empty string is also considered valid.

        
        Time O(n)
        Space O(n)
    */
    public boolean isValid(String s) {
        if (s == null || s.length() == 0){
            return true;
        }
        
        Stack<Character> stack = new Stack<Character> ();
        for(int i = 0; i < s.length(); i++){
            Character c = s.charAt(i);
            switch(c){
                case ')':
                    if (stack.isEmpty() || stack.pop() != '('){
                        return false;
                    }
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{'){
                        return false;
                    }
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '['){
                        return false;
                    }
                    break;
                default:
                    stack.push(c);
            }
        }
        
        return stack.isEmpty() ;
    }
}