# 🧠 Problem 1: Minimum in Rotated Sorted Array

## 🔍 Problem Statement:
Given a rotated version of a sorted array with no duplicate elements, find the minimum element in the array in O(log N) time.

---

## ✅ Approach 1: Binary Search (Efficient)

### 🔸 Logic:
- Initialize two pointers: `low = 0`, `high = n - 1`.
- While `low < high`, calculate `mid = (low + high) / 2`.
- If `arr[mid] > arr[high]`, the minimum lies in the right half → `low = mid + 1`.
- Else, it lies in the left half (including mid) → `high = mid`.
- Return `arr[low]`.

### ⏱ Time Complexity: O(log N)  
### 📦 Space Complexity: O(1)

---

## ✅ Approach 2: Linear Search (Brute Force)

### 🔸 Logic:
- Traverse the entire array linearly.
- Track the smallest element found.
- Return the minimum.

### ⏱ Time Complexity: O(N)  
### 📦 Space Complexity: O(1)

---