package org.rekdev.leetcode;

public class ContainerWithMostWater {

  /**
   * 11. Container With Most Water
   * https://leetcode.com/problems/container-with-most-water/description/?envType=study-plan-v2&envId=top-interview-150
   * <p>
   * You are given an integer array height of length n. There are n vertical lines drawn such that
   * the two endpoints of the ith line are (i, 0) and (i, height[i]).
   * </p>
   * <p>
   * Find two lines that together with the x-axis form a container, such that the container contains
   * the most water.
   * </p>
   * <p>
   * Return the maximum amount of water a container can store.
   * </p>
   * <p>
   * Notice that you may not slant the container.
   * </p>
   * <p>
   * Example 1:<br/>
   * <pre>
   * 9
   * 8   *         *
   * 7   *         *   *
   * 6   * *       *   *
   * 5   * *   *   *   *
   * 4   * *   * * *   *
   * 3   * *   * * * * *
   * 2   * * * * * * * *
   * 1 * * * * * * * * *
   * 0 1 2 3 4 5 6 7 8 9
   * </pre>
   * Input: height = [1,8,6,2,5,4,8,3,7]<br/>
   * Output: 49<br/>
   * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this
   * case, the max area of water (blue section) the container can contain is 49.
   * <p>
   * Example 2:<br/>
   * Input: height = [1,1]<br/>
   * Output: 1
   * </p>
   * <p>
   * Constraints:<br/>
   * - n == height.length<br/>
   * - 2 <= n <= 10^5<br/>
   * - 0 <= height[i] <= 10^4
   * </p>
   *
   * Key insight: This is an exercise in calculating area. I was unable to understand the 49 in
   * Example 1 until Gemini explained that the "walls" have no effect on the water contained within
   * the area. This still strikes me as odd.
   *
   * @param height
   * @return
   */
  public int maxArea(int[] height) {
    int leftIx = 0;
    int rightIx = height.length - 1;
    int maxArea = 0;
    while (leftIx < rightIx) {
      int h = Math.min(height[leftIx], height[rightIx]);
      int w = rightIx - leftIx;
      maxArea = Math.max(maxArea, h * w);
      if (height[leftIx] < height[rightIx]) {
        leftIx++;
      } else {
        rightIx--;
      }
    }
    return maxArea;
  }
}
