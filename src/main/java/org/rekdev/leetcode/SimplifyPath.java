package org.rekdev.leetcode;

import java.util.Stack;

public class SimplifyPath {

  /**
   * 71. Simplify Path
   * https://leetcode.com/problems/simplify-path/description/?envType=study-plan-v2&envId=top-interview-150
   * <p>
   * You are given an absolute path for a Unix-style file system, which always begins with a slash
   * '/'. Your task is to transform this absolute path into its simplified canonical path.
   * </p>
   * <p>
   * The rules of a Unix-style file system are as follows:<br/>
   * - A single period '.' represents the current directory.<br/>
   * - A double period '..' represents the previous/parent directory.<br/>
   * - Multiple consecutive slashes such as '//' and '///' are treated as a single slash '/'.<br/>
   * - Any sequence of periods that does not match the rules above should be treated as a valid
   * directory or file name. For example, '...' and '....' are valid directory or file names.<br/>
   * </p>
   * <p>
   * The simplified canonical path should follow these rules:<br/>
   * - The path must start with a single slash '/'.<br/>
   * - Directories within the path must be separated by exactly one slash '/'.<br/>
   * - The path must not end with a slash '/', unless it is the root directory.<br/>
   * - The path must not have any single or double periods ('.' and '..') used to denote current or
   * parent directories.<br/>
   * </p>
   * <p>
   * Return the simplified canonical path.
   * </p>
   * <p>
   * Example 1:<br/>
   * Input: path = "/home/"<br/>
   * Output: "/home"<br/>
   * Explanation: The trailing slash should be removed.
   * </p>
   * <p>
   * Example 2:<br/>
   * Input: path = "/home//foo/"<br/>
   * Output: "/home/foo"<br/>
   * Explanation: Multiple consecutive slashes are replaced by a single one.
   * </p>
   * <p>
   * Example 3:<br/>
   * Input: path = "/home/user/Documents/../Pictures"<br/>
   * Output: "/home/user/Pictures"<br/>
   * Explanation: A double period ".." refers to the directory up a level (the parent directory).<br/>
   * </p>
   * <p>
   * Example 4:<br/>
   * Input: path = "/../"<br/>
   * Output: "/"<br/>
   * Explanation: Going one level up from the root directory is not possible.<br/>
   * </p>
   * Example 5:<br/>
   * Input: path = "/.../a/../b/c/../d/./"<br/>
   * Output: "/.../b/d"<br/>
   * Explanation: "..." is a valid name for a directory in this problem.
   * </p>
   * <p>
   * Constraints:<br/>
   * - 1 <= path.length <= 3000<br/>
   * - path consists of English letters, digits, period '.', slash '/' or '_'.<br/>
   * - path is a valid absolute Unix path.<br/>
   * </p>
   *
   * @param path input path
   * @return simplified path with any "." and ".." normalized away and any trailing "/" removed.
   */
  public String simplifyPath(String path) {
    String[] paths = path.split("/");
    Stack<String> stack = new Stack<>();
    for (String p : paths) {
      if ("..".equals(p)) {
        if (!stack.isEmpty()) {
          stack.pop();
        }
      } else if (".".equals(p) || "".equals(p)) {
        continue;
      } else {
        stack.push(p);
      }
    }
    // This works because Java's Stack is an Iterable and the elements come out in FIFO order
    return "/" + String.join("/", stack);
  }
}
