package org.rekdev;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HelloTest {

  // These streams will capture the output
  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private final PrintStream originalOut = System.out;

  @BeforeEach
  public void setUpStreams() {
    // Redirect System.out to our custom stream
    System.setOut(new PrintStream(outContent));
  }

  @AfterEach
  public void restoreStreams() {
    // Restore the original System.out
    System.setOut(originalOut);
  }

  @Test
  void mainMethodPrintsHelloWorld() {
    // The expected output, including the platform-specific line separator
    String expectedOutput = "Hello World" + System.lineSeparator();

    // Call the main method of the class you want to test
    Hello.main(new String[]{});

    // Assert that the captured output matches the expected output
    assertEquals(expectedOutput, outContent.toString());
  }

  @Test
  void testUselessConstructor() {
    final Hello hello = new Hello();
    assertNotNull(hello);
  }
}
