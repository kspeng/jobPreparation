public class Solution {
    /*
     * @param numCourses: a total of n courses
     * @param prerequisites: a list of prerequisite pairs
     * @return: true if can finish all courses or false
     */
     /*
        Note: they may have course that has no connectivity at all
     
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //1. find indegree, an array of list
        List[] edges =  new ArrayList[numCourses];// look b to unlock a
        int[] indegree = new int[numCourses]; // how many dependency for a 
         for(int i = 0; i < numCourses; i++){
            edges[i] = new ArrayList<Integer>();
         }
        for(int i = 0; i < prerequisites.length; i++){
            indegree[ prerequisites[i][0] ]++; // to course has dependency
            edges[  prerequisites[i][1]  ].add(prerequisites[i][0] ); //b to unlock a
        }
        
        //2. find root 
        Queue<Integer> queue = new LinkedList();
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }
        int count = 0;
        while(queue.isEmpty() == false){
            int course = queue.poll();
            count++;
            int n = edges[course].size(); // n course can be unlocked
            for(int i = 0 ; i < n ;i++){
                int toBeUnlock = (int)edges[course].get(i);
                indegree[toBeUnlock] --;
                if(indegree[toBeUnlock]  == 0){
                    queue.add(toBeUnlock);
                }
            }
            
        }
        
        return numCourses == count;
        
    }
}






