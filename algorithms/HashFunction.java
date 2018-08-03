public class Solution {
    /**
     * @param key: A string you should hash
     * @param HASH_SIZE: An integer
     * @return: An integer
     */
    public int hashCode(char[] key, int HASH_SIZE) {
        long ans = 0;
        for(int i = 0; i < key.length; i++){
            // (ans * key + data) % size
            ans = ans * 33 + (int) key[i];
            ans = ans % HASH_SIZE;
        }
        return (int)ans;
    }
}