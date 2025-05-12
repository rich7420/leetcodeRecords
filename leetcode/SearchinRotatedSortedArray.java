//33. Search in Rotated Sorted Array
// use while to find
// a variant binary search
class SearchinRotatedSortedArray {
    public int search(int[] nums, int target) {
        // to set start and end
        int start = 0, end = nums.length - 1;
        // set a right one
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) return mid;
            if (nums[start] <= nums[mid]) {
                if (nums[start] <= target && target < nums[mid]) end = mid - 1;
                else start = mid + 1;
            } else {
                if (nums[mid] < target && target <= nums[end]) start = mid + 1;
                else end = mid - 1;
            }
        }
        return -1;
    }
}