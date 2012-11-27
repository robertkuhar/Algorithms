package org.rekdev;

/**
 * ArrayUtils contains some statics for working with Arrays in Java.
 * 
 * @author bobk
 * 
 */
public class ArrayUtils {
    public static void reverseArrayInPlace( Object[] array ) {
        if ( array == null ) {
            throw new IllegalArgumentException( "array cannot be null!" );
        }
        int i = 0;
        int j = array.length - 1;
        while ( j > i ) {
            Object tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
            i++;
            j--;
        }
    }
}
