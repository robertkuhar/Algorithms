package org.rekdev;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class PrimeNumberGeneratorTest {

  @ParameterizedTest(name = "Test that non-prime number {0} is correctly identified")
  @ValueSource(ints = {4, 6, 8, 9, 10, 12, 14, 15, 16, 18, 20, 21, 22, 24, 25})
  void testNonPrimeNumbers(int candidate) {
    assertThat(PrimeNumberGenerator.isPrime(candidate)).isFalse();
  }

  @ParameterizedTest(name = "Test that prime number {0} is correctly identified")
  @ValueSource(ints = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47})
  void testPrimeNumbers(int candidate) {
    assertThat(PrimeNumberGenerator.isPrime(candidate)).isTrue();
  }

  @Test
  void testZeroIsNonPrime() {
    assertThat(PrimeNumberGenerator.isPrime(0)).isFalse();
  }

  @Test
  void testOneIsNonPrime() {
    assertThat(PrimeNumberGenerator.isPrime(1)).isFalse();
  }
}