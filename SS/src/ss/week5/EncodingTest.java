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
        String input64 = "Hello World";
        System.out.println(Base64.encodeBase64String(input64.getBytes()));
        
        //decode from hex and encode to base64:
        String inputhex = "010203040506";
        byte[] array = Hex.decodeHex(inputhex.toCharArray());
        String encode = Base64.encodeBase64String(array);
        System.out.println(encode);
        
        // decode from base64":
        String inputBase = "U29mdHdhcmUgU3lzdGVtcw==";
        String decodedbase = new String(Base64.decodeBase64(inputBase));
        System.out.println(decodedbase);
        
        // encode x* "a":
        String a = "a";
        String one = new String(Base64.encodeBase64(a.getBytes()));
        String two = new String(Base64.encodeBase64((new String(a + a)).getBytes()));
        String three = new String(Base64.encodeBase64((a + a + a).getBytes()));
        String four = new String(Base64.encodeBase64((a + a + a + a).getBytes()));
        String five = new String(Base64.encodeBase64((a + a + a + a + a).getBytes()));
        System.out.println(one + " & " + two + " & " + three + " & " + four + " & " + five);
        
    }
}
