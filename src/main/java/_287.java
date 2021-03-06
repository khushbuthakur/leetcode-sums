public class _287 {

  /**
   * 287. Find the Duplicate Number
   *
   * Given an array of integers nums containing n + 1 integers where each integer is in the range
   * [1, n] inclusive.
   *
   * There is only one repeated number in nums, return this repeated number.
   *
   * You must solve the problem without modifying the array nums and uses only constant extra
   * space.
   *
   * Example 1:
   *
   * Input: nums = [1,3,4,2,2] Output: 2 Example 2:
   *
   * Input: nums = [3,1,3,4,2] Output: 3 Example 3:
   *
   * Input: nums = [1,1] Output: 1 Example 4:
   *
   * Input: nums = [1,1,2] Output: 1
   *
   * Constraints:
   *
   * 1 <= n <= 105 nums.length == n + 1 1 <= nums[i] <= n All the integers in nums appear only once
   * except for precisely one integer which appears two or more times.
   *
   * Follow up:
   *
   * How can we prove that at least one duplicate number must exist in nums? Can you solve the
   * problem in linear runtime complexity?
   */

  public static void main(String[] args) {
    int[] nums1 = {1, 3, 4, 2, 2};
    System.out.println(findDuplicate(nums1)); // 2

    int[] nums2 = {1, 2, 1};
    System.out.println(findDuplicate(nums2)); // 1
  }

  public static int findDuplicate(int[] nums) {

    /**
     * We will keep on changing value of index to negative number
     * if it is already negative then we have found duplicate
     * */

    for (int i = 0; i < nums.length; i++) {
      int val = Math.abs(nums[i]);
      /**
       * as numbers are from 1 to n+1
       * and array is 0 based, so for each value we will subtract 1
       *
       * [1, 3, 4, 2, 2]
       *
       * nums[0] = 1
       * so 1 - 1 = 0
       * nums[0] = -1 * 1
       *
       * [-1, 3, 4, 2, 2]
       *
       * nums[1] = 3
       * nums[3 - 1] = nums[2] = 4
       * nums[2] = -4
       *
       * [-1, 3, -4, 2, 2]
       *
       * nums[2] = -4
       * Math.abs(-4) = 4
       *
       * nums[4-1] = nums[3] = 2
       * [-1, 3, -4, -2, 2]
       * [-1, -3, -4, -2, 2]
       *
       * nums[2 - 1] = 1
       * nums[1] = -3
       *
       * since we have already negated value at this index, thus this is repeated number
       * return 2
       */
      if (nums[val - 1] > 0) {
          nums[val - 1] = -1 * nums[val - 1];
      } else {
        return val;
      }
    }

    return 0;
  }

}
