class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        Map<Integer, Long> nextAvailableTime = new HashMap<>();
        long currentTime = 0;

        for (int task : tasks) {
            currentTime++;  // move to the next day
            
            if (nextAvailableTime.containsKey(task)) {
                long lastAvailable = nextAvailableTime.get(task);
                if (currentTime <= lastAvailable) {
                    currentTime = lastAvailable + 1;  // wait until the task can be executed
                }
            }
            
            nextAvailableTime.put(task, currentTime + space);  // update when this task can be executed again
        }
        
        return currentTime;
    }
}
