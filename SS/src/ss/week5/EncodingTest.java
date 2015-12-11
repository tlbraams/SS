package ss.week5;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

/**
 * A simple class that experiments with the Hex encoding
 * of the Apache Commons Codec library.
 *
 */
public class EncodingTest {
    public static void main(String[] args) throws DecoderException {
        //encode in hex:
    	String input = "Hello Big World";
        // Big adds 20426967 to the middle of the string for Hello World.
        System.out.println(Hex.encodeHexString(input.getBytes()));
        
        //decode from hex:
        String hex = "4d6f64756c652032";
        String decode = new String(Hex.decodeHex(hex.toCharArray()));
        System.out.println(decode);
       
        //encode in base64:
        String input64 = "Hello Wolrd";
        System.out.println(Base64.encodeBase64String(input64.getBytes()));
        
        //decode from hex and encode to base64:
        String inputhex = "010203040506";
        byte[] array = Hex.decodeHex(inputhex.toCharArray());
        String encode = Base64.encodeBase64String(array);
        System.out.println(encode);
        
    }
}
