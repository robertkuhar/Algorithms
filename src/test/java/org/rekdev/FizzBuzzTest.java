package org.rekdev;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class FizzBuzzTest {

  @ParameterizedTest(name = "fizzBuzz({0}) => {1}")
  @CsvSource({
      "1, 1",
      "2, 2",
      "3, Fizz",
      "4, 4",
      "5, Buzz",
      "6, Fizz",
      "10, Buzz",
      "15, FizzBuzz",
      "16, 16",
      "20, Buzz",
      "30, FizzBuzz"
  })
  void fizzBuzzReturnsCorrectValue(int input, String expected) {
    assertEquals(expected, FizzBuzz.fizzBuzz(input));
  }
}
