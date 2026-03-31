import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        // There are 2^n total codes in the sequence
        int totalCodes = 1 << n;
        
        for (int i = 0; i < totalCodes; i++) {
            // Formula to convert binary index 'i' to its Gray code value
            result.add(i ^ (i >> 1));
        }
        
        return result;
    }
}
