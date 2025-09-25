package org.rekdev.leetcode;

public class MergeSortedArrayOptimal implements MergeSortedArray {

  @Override
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    // Pointers for the arrays
    int nums1ReadPointer = m - 1;
    int nums2ReadPointer = n - 1;
    int nums1WritePointer = m + n - 1;

    // Loop while there are still elements to consider in nums2
    while (nums2ReadPointer >= 0) {
      if (nums1ReadPointer >= 0 && nums1[nums1ReadPointer] > nums2[nums2ReadPointer]) {
        nums1[nums1WritePointer] = nums1[nums1ReadPointer];
        nums1ReadPointer--;
      } else {
        nums1[nums1WritePointer] = nums2[nums2ReadPointer];
        nums2ReadPointer--;
      }
      nums1WritePointer--;
    }
  }
}
