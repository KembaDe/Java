import java.util.Arrays;

class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        
        // Step 1: Every child must have at least one candy
        Arrays.fill(candies, 1);
        
        // Step 2: Forward pass - satisfy left neighbor condition
        // If a child has a higher rating than the left neighbor, give them more
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        
        // Step 3: Backward pass - satisfy right neighbor condition
        // If a child has a higher rating than the right neighbor, they must have 
        // more candies than the right neighbor while still keeping enough for the left.
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }
        
        // Step 4: Sum up the total candies
        int totalCandies = 0;
        for (int candy : candies) {
            totalCandies += candy;
        }
        
        return totalCandies;
    }
}
