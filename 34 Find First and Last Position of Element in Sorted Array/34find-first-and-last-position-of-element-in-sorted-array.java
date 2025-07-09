class Solution {
    public int[] searchRange(int[] nums, int target) {

        int firstPositionIndex = firstPositionIndex(nums, target);

        int lastPositionIndex = lastPositionIndex(nums, target);
        return new int[] { firstPositionIndex, lastPositionIndex };

    }

    private int lastPositionIndex(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int lastPositionIndex = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                lastPositionIndex = mid;
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else
                right = mid - 1;
        }
        return lastPositionIndex;
    }

    private int firstPositionIndex(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int firstPositionIndex = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                firstPositionIndex = mid;
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return firstPositionIndex;
    }
}
