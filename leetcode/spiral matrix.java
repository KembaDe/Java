import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0) return res;
        
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        
        while (top <= bottom && left <= right) {
            // 1. Traverse Right
            for (int j = left; j <= right; j++) res.add(matrix[top][j]);
            top++;
            
            // 2. Traverse Down
            for (int i = top; i <= bottom; i++) res.add(matrix[i][right]);
            right--;
            
            // 3. Traverse Left (Check if row still exists)
            if (top <= bottom) {
                for (int j = right; j >= left; j--) res.add(matrix[bottom][j]);
                bottom--;
            }
            
            // 4. Traverse Up (Check if column still exists)
            if (left <= right) {
                for (int i = bottom; i >= top; i--) res.add(matrix[i][left]);
                left++;
            }
        }
        
        return res;
    }
}
