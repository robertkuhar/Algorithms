/**
 * Practice question from UW's http://practiceit.cs.washington.edu/practiceit/list.jsp
 */
package edu.washington.cs.practiceit;

import static org.junit.Assert.*;

import org.junit.Test;

public class ContainsTest {
    interface Contains {
        boolean contains( int[] a1, int[] a2 );
    }

    class TestCase {
        public final boolean expectedResult;
        public final int[] a1;
        public final int[] a2;

        public TestCase( boolean expectedResult, int[] a1, int[] a2 ) {
            this.expectedResult = expectedResult;
            this.a1 = a1;
            this.a2 = a2;
        }
    }

    TestCase[] testCases = {
            new TestCase( true, new int[] { 1, 6, 2, 1, 4, 1, 2, 1, 8 }, new int[] { 1, 2, 1 } ),
            new TestCase( false, new int[] { 1, 2, 1 }, new int[] { 1, 2, 2, 2, 5, 7, 9, 9, 9 } ),
            new TestCase( false, new int[] { 1, 6, 2, 1, 4, 1, 2, 1, 8 }, new int[] { 2, 1, 2 } ),
            new TestCase( true, new int[] { 1, 2, 1, 2, 3 }, new int[] { 1, 2, 3 } ),
            new TestCase( true, new int[] { 1, 2, 1 }, new int[] { 1, 2, 1 } ),
            new TestCase( false, new int[] { 1, 2, 1, 2, 3 }, new int[] { 1, 2, 4 } ),
            new TestCase( true, new int[] { 8, 8, 8, 8, 4, 8, 8, 8, 8, 2, 8, 8, 8, 8, 8, -1, 8 }, new int[] { 8, 8, 8, 8, 8 } ) };

    @Test
    public void testRobertsContains() {
        Contains roberts = new Contains() {
            @Override
            public boolean contains( int[] a1, int[] a2 ) {
                int i = 0;
                int j = 0;
                while ( i < a1.length ) {
                    if ( j < a2.length && a1[i] == a2[j] ) {
                        // Have all the a2 elements matched?
                        if ( j == a2.length - 1 ) {
                            return true;
                        }
                        j++;
                    } else {
                        /*
                         * Once we've determined the sequence is broken, we need
                         * to back up in a1 (by decrementing i) to the point
                         * where we fell off.
                         */
                        i = i - j;
                        j = 0;
                    }
                    i++;
                }
                return false;
            }
        };
        for ( TestCase t : testCases ) {
            assertEquals( t.expectedResult, roberts.contains( t.a1, t.a2 ) );
        }
    }

    @Test
    public void testBestContains() {
        Contains best = new Contains() {
            @Override
            public boolean contains( int[] a1, int[] a2 ) {
                for ( int i = 0; i < a1.length; i++ ) {
                    for ( int j = 0; j < a2.length; j++ ) {
                        if ( ( i + j ) < a1.length && a1[i + j] == a2[j] ) {
                            if ( j == a2.length - 1 ) {
                                return true;
                            }
                        } else {
                            // This breaks us out of the for loop on a2
                            break;
                        }
                    }
                }
                return false;
            }
        };
        for ( TestCase t : testCases ) {
            assertEquals( t.expectedResult, best.contains( t.a1, t.a2 ) );
        }
    }

    @Test
    public void testKatesContains() {
        Contains kates = new Contains() {
            @Override
            public boolean contains( int[] a1, int[] a2 ) {
                for ( int i = 0; i < a1.length; i++ ) {
                    if ( a1[i] == a2[0] ) {
                        for ( int j = 1; j < a2.length; j++ ) {
                            if ( ( i + j ) < a1.length && a1[i + j] == a2[j] ) {
                                if ( j == a2.length - 1 ) {
                                    return true;
                                }
                            } else {
                                // This breaks us out of the for loop on a2
                                break;
                            }
                        }
                    }
                }
                return false;
            }
        };
        for ( TestCase t : testCases ) {
            assertEquals( t.expectedResult, kates.contains( t.a1, t.a2 ) );
        }
    }
}
