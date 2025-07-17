import java.util.*;

public class problem1 {

    // Approach 1: Binary Search O(log N)
    public static int findMinBinarySearch(int[] arr) {
        int low = 0, high = arr.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] > arr[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return arr[low];
    }

    // Approach 2: Linear Search O(N)
    public static int findMinLinearSearch(int[] arr) {
        int min = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        return min;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Minimum (Binary Search): " + findMinBinarySearch(arr));
        System.out.println("Minimum (Linear Search): " + findMinLinearSearch(arr));
    }
}