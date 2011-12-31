package org.rekdev.so;

import junit.framework.*;

/**
 * Answer to Stack Overflow question http://goo.gl/1FmfT:
 * "Java RegEx to replace a string where the beginning and end part match a specific pattern"
 * 
 * @author robertkuhar
 * 
 */
public class RegEx20111230 extends TestCase {
    public void testReplaceAll() throws Exception {
        String regex = "wsp:rsid\\w*?=\".*?\"";

        assertEquals( "", "wsp:rsidP=\"005816D6\"".replaceAll( regex, "" ) );
        assertEquals( "", "wsp:rsidR=\"005816D6\"".replaceAll( regex, "" ) );
        assertEquals( "", "wsp:rsidRDefault=\"005816D6\"".replaceAll( regex, "" ) );
        assertEquals( "a=\"1\" >", "a=\"1\" wsp:rsidP=\"005816D6\">".replaceAll( regex, "" ) );
        assertEquals(
                "bob   kuhar",
                "bob wsp:rsidP=\"005816D6\" wsp:rsidRDefault=\"005816D6\" kuhar".replaceAll( regex, "" ) );
        assertEquals(
                " keepme=\"yes\" ",
                "wsp:rsidP=\"005816D6\" keepme=\"yes\" wsp:rsidR=\"005816D6\"".replaceAll( regex, "" ) );
        assertEquals(
                "<node a=\"l\"  b=\"m\"  c=\"r\">",
                "<node a=\"l\" wsp:rsidP=\"0\" b=\"m\" wsp:rsidR=\"0\" c=\"r\">".replaceAll( regex, "" ) );
        // Sadly doesn't handle the embedded \" case...
        // assertEquals( "", "wsp:rsidR=\"hello\\\"world\"".replaceAll( regex, "" ) );
    }
}
