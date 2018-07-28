public class RandomizedSet {
    
    ArrayList<Integer> nums;
    // val, location
    HashMap<Integer, Integer> map;
    Random rand;


    public RandomizedSet() {
        nums = new ArrayList<Integer>();
        map = new HashMap<Integer, Integer>();
        rand = new Random();
    }

    /*
     * @param val: a value to the set
     * @return: true if the set did not already contain the specified element or false
     */
    public boolean insert(int val) {
       boolean contain = map.containsKey(val);
       if(contain){
           return false;
       }
       // size before add
       map.put(val, nums.size());
       nums.add(val);
       return true;
    }

    /*
     * @param val: a value from the set
     * @return: true if the set contained the specified element or false
     */
    public boolean remove(int val) {
        boolean contain = map.containsKey(val);
        
        if (contain == false) {
            return false;
        }
        
        int location = map.get(val);
        if (location < nums.size() - 1){
            int last = nums.get(nums.size() - 1);
            // swap location
            nums.set(location,last);
            map.put(last,location);
        }
        map.remove(val);
        nums.remove(nums.size() - 1);
        return true;
    }

    /*
     * @return: Get a random element from the set
     */
    public int getRandom() {
       return nums.get(rand.nextInt(nums.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param = obj.insert(val);
 * boolean param = obj.remove(val);
 * int param = obj.getRandom();
 */