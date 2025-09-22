package org.rekdev;

public class PrimeNumberGenerator {

  public static boolean isPrime(int candidate) {
    if (candidate < 2) {
      return false;
    }
    int limit = (int) Math.sqrt(candidate);
    for (int i = 2; i <= limit; i++) {
      if (candidate % i == 0) {
        return false;
      }
    }
    return true;
  }
}
