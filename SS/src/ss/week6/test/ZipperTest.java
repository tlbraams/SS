package ss.week6.test;

import org.junit.Test;
import ss.week6.ArgumentLengthsDifferException;
import ss.week6.TooFewArgumentsException;
import ss.week6.Zipper;

import static org.junit.Assert.assertEquals;

/**
 * Testprogram for Zipper.
 * Lab Exercise SoftwareSystems
 * @author Jip Spel
 * @version $Revision: 1.0 $
 */
public class ZipperTest {

    /**
     * Test for zipping with too few arguments.
     */
    @Test(expected = TooFewArgumentsException.class)
    public void testFirstArgumentNull() 
    		throws TooFewArgumentsException, ArgumentLengthsDifferException {
        Zipper.zip2(null, "Hello World!");
    }

    /**
     * Test for zipping with too few arguments.
     */
    @Test(expected = TooFewArgumentsException.class)
    public void testSecondArgumentNull()
    		throws TooFewArgumentsException, ArgumentLengthsDifferException {
        Zipper.zip2("Hello World!", null);
    }

    /**
     * Test for zipping with arguments of different length.
     */
    @Test(expected = ArgumentLengthsDifferException.class)
    public void testDifferentArgumentLengths() 
    		throws ArgumentLengthsDifferException, TooFewArgumentsException {
        Zipper.zip2("Hello World!", "Hello World");
    }

    @Test
    public void testCorrectInput() throws ArgumentLengthsDifferException, TooFewArgumentsException {
        assertEquals("HelloWorld", Zipper.zip2("Hlool", "elWrd"));
    }

}
