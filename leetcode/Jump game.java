class Solution {
    public boolean canJump(int[] nums) {
        int farthest = 0;
        
        for (int i = 0; i < nums.length; i++) {
            // If the current index is beyond the farthest reachable point, stop
            if (i > farthest) {
                return false;
            }
            
            // Update farthest reachable index from the current position
            farthest = Math.max(farthest, i + nums[i]);
            
            // Optimization: if we can already reach the last index, return true
            if (farthest >= nums.length - 1) {
                return true;
            }
        }
        
        return false;
    }
}
