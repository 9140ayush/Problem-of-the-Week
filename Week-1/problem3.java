import java.util.*;

// Ruby Second House (Medium)

public class problem3 {

    //Efficient Approach: Time = O(n * k), Space = O(1)
    // Uses min1 and min2 to avoid checking every color at each step
    public static int efficientMinCost(int[][] costs) {
        int n = costs.length;
        if (n == 0) return 0;
        int k = costs[0].length;
        if (k == 0) return 0;

        int min1 = -1, min2 = -1;

        for (int i = 0; i < n; i++) {
            int lastMin1 = min1, lastMin2 = min2;
            min1 = -1;
            min2 = -1;

            for (int j = 0; j < k; j++) {
                if (i > 0) {
                    // If current color is not the previous min1, use min1 cost
                    if (j != lastMin1) {
                        costs[i][j] += costs[i - 1][lastMin1];
                    } else {
                        // Else use second minimum
                        costs[i][j] += costs[i - 1][lastMin2];
                    }
                }

                // Update current min1 and min2
                if (min1 == -1 || costs[i][j] < costs[i][min1]) {
                    min2 = min1;
                    min1 = j;
                } else if (min2 == -1 || costs[i][j] < costs[i][min2]) {
                    min2 = j;
                }
            }
        }

        return costs[n - 1][min1];
    }

    //Standard DP Approach: Time = O(n * k^2), Space = O(n * k)
    public static int standardDPMinCost(int[][] costs) {
        int n = costs.length;
        int k = costs[0].length;

        int[][] dp = new int[n][k];

        // Initialize base case
        for (int j = 0; j < k; j++) {
            dp[0][j] = costs[0][j];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < k; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int l = 0; l < k; l++) {
                    if (l != j) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][l] + costs[i][j]);
                    }
                }
            }
        }

        int minCost = Integer.MAX_VALUE;
        for (int j = 0; j < k; j++) {
            minCost = Math.min(minCost, dp[n - 1][j]);
        }

        return minCost;
    }

    //Main method to run the program
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Input: number of houses and colors
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[][] costs = new int[n][k];

        //Input: cost matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                costs[i][j] = scanner.nextInt();
            }
        }

        // Clone the input for both approaches
        int[][] copyForDP = new int[n][k];
        for (int i = 0; i < n; i++)
            copyForDP[i] = Arrays.copyOf(costs[i], k);

        //Efficient Approach Output
        System.out.println("Efficient Approach Result: " + efficientMinCost(costs));

        //Standard DP Output
        System.out.println("Standard DP Result: " + standardDPMinCost(copyForDP));

        scanner.close();
    }
}

