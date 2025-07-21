Problem 1: Minimum in Rotated Sorted Array

--------

Problem Description:
You are given a rotated version of a sorted array with no duplicate elements. Your task is to find the minimum element in the array in O(log N) time.

Input Format:

An integer N — number of elements in the array.

A line of N space-separated integers — the rotated sorted array.

Output Format:

A single integer — the minimum element in the array.

Approach 1: Binary Search (Efficient)

Use two pointers: low = 0, high = N - 1.

While low < high:

Calculate mid = (low + high) / 2.

If arr[mid] > arr[high], the min is in the right half → low = mid + 1.

Else, it’s in the left half → high = mid.

The minimum is at arr[low].

Time Complexity: O(log N)

Space Complexity: O(1)

Approach 2: Linear Search (Brute Force)

Traverse the array and keep track of the smallest element.

Time Complexity: O(N)

Space Complexity: O(1)

Problem 2: Subarray Sum Equals K
-------

Problem Description:
Given an array of integers representing calories burned each day, and a target calorie burn k, determine the total number of continuous subarrays whose sum equals k.

Input Format:

An integer n — the number of days.

An array nums of n integers — calories burned each day.

An integer k — the target calorie burn.

Output Format:

A single integer — the number of continuous subarrays whose sum equals k.

Approach 1: Brute Force

Traverse all possible subarrays using two nested loops.

Time Complexity: O(n^2)

Space Complexity: O(1)

Approach 2: Optimized Using Prefix Sum and HashMap

Maintain a cumulative sum and store frequencies in a HashMap.

If (current_sum - k) is found in the map, add its frequency to result.

Time Complexity: O(n)

Space Complexity: O(n)


Problem 3: Ruby Second House (Paint House II)
------

Problem Description:
You are given n houses and k colors. Each house must be painted such that no two adjacent houses have the same color and the total painting cost is minimized. Each painting cost is provided as a matrix costs[i][j] where i is the house index and j is the color index.

Input Format:

Two integers n and k — number of houses and number of colors.

A matrix of n rows and k columns representing painting costs.

Output Format:

A single integer — minimum total cost of painting all houses.

Approach 1: Efficient Greedy with Min1/Min2

Use two variables min1 and min2 to track lowest and second lowest cost from the previous house.

Avoid painting current house with the same color as previous house's minimum.

Time Complexity: O(n * k)

Space Complexity: O(1) (in-place update)

Approach 2: Standard Dynamic Programming

Use DP table where dp[i][j] stores min cost to paint up to house i with color j.

Ensure adjacent houses don’t have same color by checking all previous options.

Time Complexity: O(n * k^2)

Space Complexity: O(n * k)