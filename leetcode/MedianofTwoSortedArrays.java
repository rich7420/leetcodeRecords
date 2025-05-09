//4. Median of Two Sorted Arrays
// use jumpping binary search
class Solution {
    // Method to find the median of two sorted arrays
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int totalLen = m + n;

        // If the total length is odd, return the (m + n) / 2 + 1-th element
        if (totalLen % 2 == 1) {
            return findKth(nums1, nums2, totalLen / 2 + 1);
        } 
        // If the total length is even, return the average of the k-th and (k+1)-th elements
        else {
            return (findKth(nums1, nums2, totalLen / 2) + findKth(nums1, nums2, totalLen / 2 + 1)) / 2.0;
        }
    }

    // Method to find the k-th smallest element in the merged sorted arrays
    private int findKth(int[] nums1, int[] nums2, int k) {
        int index1 = 0, index2 = 0;

        while (true) {
            // If nums1 is exhausted, return the k-th element in nums2
            if (index1 == nums1.length) {
                return nums2[index2 + k - 1];
            }
            // If nums2 is exhausted, return the k-th element in nums1
            if (index2 == nums2.length) {
                return nums1[index1 + k - 1];
            }
            // If k == 1, return the smaller of the two elements
            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }

            // Calculate the step size for skipping elements
            int step = k / 2;
            // Determine the new indices for comparison, making sure we don't exceed array bounds
            int newIndex1 = Math.min(index1 + step, nums1.length) - 1;
            int newIndex2 = Math.min(index2 + step, nums2.length) - 1;
            int pivot1 = nums1[newIndex1];
            int pivot2 = nums2[newIndex2];

            // If nums1's element is smaller, move the index of nums1 forward
            if (pivot1 <= pivot2) {
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            } else {
                // If nums2's element is smaller, move the index of nums2 forward
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }
}
