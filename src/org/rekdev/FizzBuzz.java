package org.rekdev;

public class FizzBuzz {

  /**
   * Write a function that prints the numbers from 1 to n and has the following
   * properties.
   * <p>
   * For multiples of 3, print "Fizz"<br/>
   * For multiples of 5, print "Buzz"<br/>
   * For numbers which are multiples of both 3 and 5, print "FizzBuzz"<br/>
   * Otherwise, just print the number.<br/>
   * 
   * @param n - number of iterations
   */
  public static void fizzBuzz(int n) {
    for (int i = 1; i < n; i++) {
      if (i % 15 == 0) {
        System.out.println("FizzBuzz");
      } else if (i % 3 == 0) {
        System.out.println("Fizz");
      } else if (i % 5 == 0) {
        System.out.println("Buzz");
      } else {
        System.out.println(i);
      }
    }
  }

  public static void main(String[] args) {
    fizzBuzz(20);
  }

}
