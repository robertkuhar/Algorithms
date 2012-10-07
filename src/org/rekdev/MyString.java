package org.rekdev;

public class MyString {
    private char[] myChars = null;

    public MyString( char[] chars ) {
        if ( chars == null ) {
            throw new IllegalArgumentException( "chars cannot be null!" );
        }
        this.myChars = new char[chars.length];
        System.arraycopy( chars, 0, this.myChars, 0, chars.length );
    }

    /**
     * The charAt method return the character at the input index.
     * 
     * @param ix index of target character
     * @return character at the index input as is.
     * @throws IndexOutOfBoundsException if input ix is not valid.
     */
    public char charAt( int ix ) {
        return this.myChars[ix];
    }

    /**
     * Compares this object to the specified object. The result is true if and
     * only if the argument is not null and is a MyString object that contains
     * the same values in its myChars array as this object.
     * 
     * @param obj the object to compare with
     * @return true if the objects are the same; false otherwise.
     */
    public boolean equals( Object obj ) {
        if ( obj instanceof MyString ) {
            MyString that = (MyString) obj;
            if ( this.myChars.length == that.myChars.length ) {
                for ( int i = 0; i < this.myChars.length; i++ ) {
                    if ( this.myChars[i] != that.myChars[i] ) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    /**
     * Returns a HashCode for this instance of MyString.
     * 
     * @return HashCode for this instance of MyString.
     */
    public int hashCode() {
        int hashCode = 0;
        for ( int i = 0; i < this.myChars.length; i++ ) {
            hashCode += this.myChars[i];
        }
        return hashCode;
    }

    /**
     * Detects presence of target array in MyString internal array returning the
     * index of the first occurrence of target in MyString internal array.
     * 
     * @param target target array to search for
     * @return index of first occurrence of target in MyString. -1 if not found.
     */
    public int indexOf( char[] target ) {
        if ( target == null || target.length == 0 ) {
            throw new IllegalArgumentException( "target cannot be null or empty" );
        }
        int indexOf = -1;
        int targetIx = 0;
        if ( target.length <= this.myChars.length ) {
            for ( int i = 0; i < this.myChars.length; i++ ) {
                char c = this.myChars[i];
                if ( c == target[targetIx] ) {
                    if ( targetIx == 0 ) {
                        indexOf = i;
                    }
                    if ( targetIx == ( target.length - 1 ) ) {
                        return indexOf;
                    }
                    targetIx++;
                } else {
                    if ( targetIx > 0 ) {
                        i = indexOf;
                    }
                    indexOf = -1;
                    targetIx = 0;
                }
            }
        }
        return -1;
    }

}
