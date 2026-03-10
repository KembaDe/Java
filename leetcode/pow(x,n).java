class Solution {
    public double myPow(double x, int n) {
        // Use long to handle the overflow case when n = Integer.MIN_VALUE
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        double result = 1;
        double currentProduct = x;

        while (N > 0) {
            // If N is odd, multiply the result by the current product
            if (N % 2 == 1) {
                result *= currentProduct;
            }
            // Square the base and halve the exponent
            currentProduct *= currentProduct;
            N /= 2;
        }

        return result;
    }
}
