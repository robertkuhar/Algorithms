package org.rekdev;

public class FizzBuzz {

  /**
   * Write a function that has the following properties.
   * <p>
   * If x is a multiple of 3, return "Fizz"<br/>
   * If x is a multiple of 5, return "Buzz"<br/>
   * If x is a multiple of both 3 and 5, return FizzBuzz"<br/>
   * Otherwise, just return string value of x<br/>
   * 
   * @param x - candidate
   * @return "Fizz", "Buzz", "FizzBuzz", or string value of x.
   */
  public static String fizzBuzz(int x) {
      if (x % 15 == 0) {
        return "FizzBuzz";
      } else if (x % 3 == 0) {
        return "Fizz";
      } else if (x % 5 == 0) {
        return "Buzz";
      }
      return "" + x;
  }

  /**
   * For the numbers 1 through 20, call the fizzBuzz function and
   * output to standard out the results like "fizzBuzz(3) => Fizz".
   */
  public static void main(String[] args) {
    for(int i = 1; i <= 20; i++) {
      System.out.println(String.format("fizzBuzz(%d) => %s",i,fizzBuzz(i)));
    }
  }
}
