class Solution {
    public int maxSubArray(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private int helper(int[] nums, int left, int right) {
        if (left == right) return nums[left];

        int mid = left + (right - left) / 2;
        
        int leftSum = helper(nums, left, mid);
        int rightSum = helper(nums, mid + 1, right);
        int crossSum = crossMax(nums, left, mid, right);

        return Math.max(Math.max(leftSum, rightSum), crossSum);
    }

    private int crossMax(int[] nums, int left, int mid, int right) {
        int sum = 0;
        int leftPart = Integer.MIN_VALUE;
        for (int i = mid; i >= left; i--) {
            sum += nums[i];
            leftPart = Math.max(leftPart, sum);
        }

        sum = 0;
        int rightPart = Integer.MIN_VALUE;
        for (int i = mid + 1; i <= right; i++) {
            sum += nums[i];
            rightPart = Math.max(rightPart, sum);
        }

        return leftPart + rightPart;
    }
}
