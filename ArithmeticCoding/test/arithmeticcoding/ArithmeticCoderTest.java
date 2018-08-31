/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arithmeticcoding;

import java.math.BigDecimal;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 15052401
 */
public class ArithmeticCoderTest {

    public ArithmeticCoderTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of encode method, of class ArithmeticCoder.
     */
    @Test
    public void testEncode() {
        System.out.println("Testing encoder against known value for BILL GATES:0.25721677520");
        String string = "";
        ArithmeticCoder instance = new ArithmeticCoder();
        BigDecimal expResult = new BigDecimal("0.25721677520");
        EncodedString result = instance.encode("BILL GATES");
        assertEquals(expResult, result.getStringLow());
    }

    /**
     * Test of decode method, of class ArithmeticCoder.
     */
    @Test
    public void testDecode1() {
        long startTime = System.currentTimeMillis();

        System.out.println("Testing decode for every string length up to 100 checking inputs and outputs are equal for string 1");
        String string = "ABCDEFGHIJKLMNOPQRSTUVWXYZ ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZ ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZ ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        ArithmeticCoder instance = new ArithmeticCoder();
        boolean result = true;
        for (int i = 1; i < 100; i++) {
            EncodedString results = instance.encode(string.substring(0, i));
            String outputString = instance.decode(results);
            if (!outputString.equalsIgnoreCase(string.substring(0, i))) {
                System.out.println("failed");
                result = false;
            }
        }
        boolean expResult = true;
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("total time: "+totalTime);
        assertEquals(expResult, result);
    }

    @Test
    public void testDecode2() {
        System.out.println("Testing decode for every string length up to 100 checking inputs and outputs are equal for string 2");
        String string = "	Note: bandwidth keeps increasing, but so does the size of the data. At any given time, the ability of the Internet to transfer data is fixed. Thus, if data can be compressed wherever possible, significant improvements of data throughput can be achieved. Many files can be combined into one compressed document making sending easier.";
        ArithmeticCoder instance = new ArithmeticCoder();
        boolean result = true;
        for (int i = 1; i < 100; i++) {
            EncodedString results = instance.encode(string.substring(0, i));
            String outputString = instance.decode(results);
            if (!outputString.equalsIgnoreCase(string.substring(0, i))) {
                System.out.println("failed: " + i);
                result = false;
            }
        }
        boolean expResult = true;
        assertEquals(expResult, result);
    }

    @Test
    public void testDecode3() {
        System.out.println("Testing decode for every string length up to 100 checking inputs and outputs are equal for string 3");
        String string = "Transmission: less network bandwidth can be used, by compressing data at the sending end and decompressing data at the receiving end.";
        ArithmeticCoder instance = new ArithmeticCoder();
        boolean result = true;
        for (int i = 1; i < 100; i++) {
            EncodedString results = instance.encode(string.substring(0, i));
            String outputString = instance.decode(results);
            if (!outputString.equalsIgnoreCase(string.substring(0, i))) {
                System.out.println("failed: " + i);
                result = false;
            }
        }
        boolean expResult = true;
        assertEquals(expResult, result);
    }

    @Test
    public void testDecode4() {
        System.out.println("Testing decode for every string length up to 100 checking inputs and outputs are equal for string 4");
        String string = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        ArithmeticCoder instance = new ArithmeticCoder();
        boolean result = true;
        for (int i = 1; i < 100; i++) {
            EncodedString results = instance.encode(string.substring(0, i));
            String outputString = instance.decode(results);
            if (!outputString.equalsIgnoreCase(string.substring(0, i))) {
                System.out.println("failed: " + i);
                result = false;
            }
        }
        boolean expResult = true;
        assertEquals(expResult, result);
    }

    @Test
    public void testDecode5() {
        System.out.println("Testing encode and decode for a string length of 1000. checking that the input and output are equal for string 5");
        String string = "The Boston Social Forum was the first North American social forum to use the methodology of the World Social Forum process and adhere closely to its Charter of Principles. It was held at the University of Massachusetts Boston in Boston, Massachusetts in the United States from July 23-25, 2004, and coordinated by the Boston-based labor-community network, the Campaign on Contingent Work (later renamed Massachusetts Global Action). CCW executive director Jason Pramas was the lead organizer of the forum.[1][2] Over 5,000 people from over 300 community organizations and labor unions participated in more than 550 workshops, plenary sessions, and convocations at the event--which was timed to take place just before the 2004 Democratic National Convention, also being held in Boston. The majority of attendees came from the Northeast of the United States, but a large minority came from around North America, and there were delegations from over a dozen other countries (with simultaneous translation available in as many languages). ";
        ArithmeticCoder instance = new ArithmeticCoder();
        boolean result;
        EncodedString results = instance.encode(string.substring(0, string.length() - 1));
        String outputString = instance.decode(results);
        result = outputString.equalsIgnoreCase(string.substring(0, string.length() - 1));
        boolean expResult = true;
        assertEquals(expResult, result);
    }

    @Test
    public void testEncodeEmpty() {
        System.out.println("Testing encoder can handel empty strings");
        String string = "";
        ArithmeticCoder instance = new ArithmeticCoder();
        int expResultLength = 0;
        ArrayList<Range> expResultEncodedRanges = null;
        BigDecimal expResultEncodedString;
        expResultEncodedString = null;
        EncodedString result = instance.encode("");

        assertEquals(expResultLength, result.getLength());
        assertEquals(expResultEncodedRanges, result.getRanges());
        assertEquals(expResultEncodedString, result.getStringLow());
    }

    /**
     * Test of decode method, of class ArithmeticCoder.
     */
    @Test
    public void testDecodeEmpty() {
        System.out.println("Testing decode that is can hadel decoding empty encoded objects");
        String input = "";
        String expResult = "Encoded object empty";
        ArithmeticCoder instance = new ArithmeticCoder();
        EncodedString results = instance.encode(input);
        String result = instance.decode(results);
        assertEquals(expResult, result);
    }
}
