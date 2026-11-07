import java.util.*;

class Solution {
    public int minSwap(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[][] dp = new int[n][2];
        dp[n - 1][0] = 0;
        dp[n - 1][1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            for (int swap = 0; swap <= 1; swap++) {
                int prev1 = (swap == 1) ? nums2[i] : nums1[i];
                int prev2 = (swap == 1) ? nums1[i] : nums2[i];
                int min = Integer.MAX_VALUE / 2;
                if (nums1[i + 1] > prev1 && nums2[i + 1] > prev2)  min = Math.min(min, dp[i + 1][0]);
                if (nums2[i + 1] > prev1 && nums1[i + 1] > prev2) min = Math.min(min, 1 + dp[i + 1][1]);
                dp[i][swap] = min;
            }
        }
        return Math.min(dp[0][0], 1 + dp[0][1]);
    }
}