// Leetcode Question 1143

// Example 1:
// Input: text1 = "abcde", text2 = "ace" 
// Output: 3  
// Explanation: The longest common subsequence is "ace" and its length is 3.

// Example 2:
// Input: text1 = "abc", text2 = "abc"
// Output: 3
// Explanation: The longest common subsequence is "abc" and its length is 3.

// Example 3:
// Input: text1 = "abc", text2 = "def"
// Output: 0
// Explanation: There is no such common subsequence, so the result is 0.

package org.example;

public class LCS {
    // LCS Function
    public int lcsFunction(String text1, String text2) {
        int t1Length = text1.length();
        int t2Length = text2.length();
        
        // Creating DP Table
        int[][] dp = new int[t1Length + 1][t2Length + 1];
        
        // Filling DP Table 
        // Top left to Bottom Right
        for (int i = 1; i <= t1Length; i++) {
            for (int j = 1; j <= t2Length; j++) {
                // If the Character is the same
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    // Filling it with +1 Value of the left Top Diagonal
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // Compare the Value Left and Top
                    // Fill with the bigger Value
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        // Return the Bottom Right Value
        return dp[t1Length][t2Length];
    }

    public static void main(String[] args) {
        LCS lcs = new LCS();
        // Example 1
        String text1 = "abcde";
        String text2 = "ace";
        System.out.println(lcs.lcsFunction(text1, text2)); // Output: 3
        
        // Example 2
        text1 = "abc";
        text2 = "abc";
        System.out.println(lcs.lcsFunction(text1, text2)); // Output: 3
        
        // Example 3
        text1 = "abc";
        text2 = "def";
        System.out.println(lcs.lcsFunction(text1, text2)); // Output: 0
    }
}
