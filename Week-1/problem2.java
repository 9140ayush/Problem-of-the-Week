import java.util.*;

// Subarray Sum Equals K

public class problem2 {

    // Brute Force Approach (O(n^2))
    public static int bruteForce(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; start++) {
            int sum = 0;
            for (int end = start; end < nums.length; end++) {
                sum += nums[end];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    // Optimized Approach using Prefix Sum + HashMap (O(n))
    public static int optimized(int[] nums, int k) {
        int sum = 0, result = 0;
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (preSum.containsKey(sum - k)) {
                result += preSum.get(sum - k);
            }
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 🔸 Input Format:
        // An integer n — the number of days.
        int n = sc.nextInt();
        int[] nums = new int[n];

        // An array nums of n integers — calories burned each day.
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // An integer k — the target calorie burn.
        int k = sc.nextInt();

        // 🔹 Output Format:
        // A single integer — the total number of continuous subarrays whose sum equals k.
        System.out.println("Brute Force Result: " + bruteForce(nums, k));
        System.out.println("Optimized Result: " + optimized(nums, k));

        sc.close();
    }
}
