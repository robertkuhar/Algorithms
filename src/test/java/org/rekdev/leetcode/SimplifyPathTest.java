package org.rekdev.leetcode;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 71. Simplify Path
 * https://leetcode.com/problems/simplify-path/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class SimplifyPathTest {

  SimplifyPath simplifyPath;

  @BeforeEach
  public void setup() {
    simplifyPath = new SimplifyPath();
  }

  @Test
  public void testExample1() {
    final String actual = simplifyPath.simplifyPath("/home/");
    assertThat(actual).isEqualTo("/home");
  }

  @Test
  public void testExample2() {
    final String actual = simplifyPath.simplifyPath("/home//foo/");
    assertThat(actual).isEqualTo("/home/foo");
  }

  @Test
  public void testExample3() {
    final String actual = simplifyPath.simplifyPath("/home/user/Documents/../Pictures");
    assertThat(actual).isEqualTo("/home/user/Pictures");
  }

  @Test
  public void testExample4() {
    final String actual = simplifyPath.simplifyPath("/../");
    assertThat(actual).isEqualTo("/");
  }

  @Test
  public void testExample5() {
    final String actual = simplifyPath.simplifyPath("/.../a/../b/c/../d/./");
    assertThat(actual).isEqualTo("/.../b/d");
  }
}
