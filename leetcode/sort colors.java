class Solution {
    public void sortColors(int[] nums) {
        int low = 0;           // Pointer for the next position of 0
        int curr = 0;          // Current pointer to explore the array
        int high = nums.length - 1; // Pointer for the next position of 2

        while (curr <= high) {
            if (nums[curr] == 0) {
                // If it's a 0, swap it to the low boundary and move both pointers
                swap(nums, curr, low);
                curr++;
                low++;
            } else if (nums[curr] == 2) {
                // If it's a 2, swap it to the high boundary. 
                // Don't increment curr yet, because the swapped element needs checking.
                swap(nums, curr, high);
                high--;
            } else {
                // If it's a 1, just move the current pointer
                curr++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
