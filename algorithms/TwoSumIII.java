/*
Design and implement a TwoSum class. It should support the following operations: add and find.

add - Add the number to an internal data structure.
find - Find if there exists any pair of numbers which sum is equal to the value.

Example:
	add(1); add(3); add(5);
	find(4) // return true
	find(7) // return false

*/



public class TwoSum {
   	/*
		tricky part is to handle mulitple nums
		add:
			Time Complexity = (1)
   	
		find:
			Time Complexity = (n)		
   	*/
    private Map <Integer,Integer> nums = new HashMap<>();

 	// <num,counter>
    private HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
    public void add(int number) {
        if(map.containsKey(number)){
            int count = map.get(number);
            map.put(number, count + 1);  
        }else{
            map.put(number,1);  
        }
    }


    /*
     * @param value: An integer
     * @return: Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean find(int value) {
     	for (int num : map.keySet()) {
           int target = value - num;
           // self
           if (num == target && map.get(target) > 1){
               return true;
           }
           // != self
           if (num != target && map.containsKey(target)){
               return true;
           }
       }
       return false;
    }
}