// Leetcode 문제 322번 다이나믹 프로그래밍

// Example 1:
// Input: coins = [1,2,5], amount = 11
// Output: 3
// Explanation: 11 = 5 + 5 + 1

// Example 2:
// Input: coins = [2], amount = 3
// Output: -1

// Example 3:
// Input: coins = [1], amount = 0
// Output: 0

package org.example;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        // dp배열을 (amount + 1)으로 초기화
        int[] dp = new int[amount + 1];
        
        // 베이스 케이스 dp[0] = 0
        // 0일땐 코인 필요 X
        dp[0] = 0;
        
        // 최솟값을 찾는 것이므로 모든 dp[i] 를 큰 값으로 초기화
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        // 1부터 목표금액까지 Bottom-up 순회
        // dp[i]: 금액 i를 만들기 위해 필요한 최소 동전 개수
        for (int i = 1; i <= amount; i++) {
            // coins 배열에 있는 모든 동전 단위를 하나씩 시도해서 i를 만들수 있는지 확인
            for (int j = 0; j < coins.length; j++) {
                int coin = coins[j];
                // i - coin >= 0: i에서 coin을 뺀 값이 0 이상인지 확인 (0 이상이면 동전 사용 가능)
                // dp[i - coin] != Integer.MAX_VALUE: i - coin을 만들 수 있는 유효한 값 존재 확인
                if (i - coin >= 0 && dp[i - coin] != Integer.MAX_VALUE) {     
                    // 점화식 dp[i] = min(dp[i], dp[i - coin] + 1) 도출 과정
                    // 사용 가능한 동전은 매개변수 coins 배열의 값들
                    // 목표금액 i를 만들기 위해 coin을 사용하면 남은 금액은 i - coin
                    // 남은 금액 i - coin을 만들기 위해 필요한 동전의 최소 개수는 dp[i - coin]
                    // 그러므로 금액 i를 만드는데 필요한 동전 개수는 dp[i - coin] + 1 (여기서 +1은 바로 이전에 사용한 동전 1개)
                    // 최소 동전 개수를 구해야 하므로, 사용 가능한 모든 동전의 dp[i - coin] + 1을 계산 후, 최솟값을 선택해야함
                    // dp[i] = min(dp[i - coin] + 1) ∀ coin ∈ coins
                    // 각 동전을 dp[i - coin] + 1과 비교해 더 작은 값을 dp[i]에 저장 (dp[i]의 초기값은 Integer.MAX_VALUE)
                    // 이것을 점화식으로 나타내면 dp[i] = Math.min(dp[i], dp[i - coin] + 1) 
                    // 못해먹겠다
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        
        // dp[amount]: 목표 금액 amount를 만들기 위한 최소 동전 개수
        // dp[amount]가 Integer.MAX_VALUE일 경우, 목표 금액을 만드는것이 불가능함으로 -1을 리턴
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
    // 테스트
    public static void main(String[] args) {
        CoinChange test = new CoinChange();
        int[] coins = {1, 3, 4, 5};
        int amount = 7;
        int result = test.coinChange(coins, amount);
        System.out.println("Minimum Coin Required: " + result); // 2
    }

}
