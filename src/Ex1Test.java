import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This JUnit class represents a very partial test class for Ex1.
 * Make sure you complete all the needed JUnits
 */
public class Ex1Test {
    /*
        @Test
        void computeNumberTest() {
            String s2 = "1011b2";
            int v = Ex1.number2Int(s2);
            assertEquals(v,11);
            String s10 = "1011bA";
            v = Ex1.number2Int(s10);
            s2 = Ex1.int2Number(v,2);
            int v2 = Ex1.number2Int(s2);
            assertEquals(v,v2);
            assertTrue(Ex1.equals(s10,s2));
        }
         */

        @Test
        void isBasisNumberTest() {
            String[] good = {"1", "1b2", "01b2", "123bA", "ABbG", "0bA"};
            for(int i=0;i<good.length;i=i+1) {
                boolean ok = Ex1.isNumber(good[i]);
                assertTrue(ok);
            }
            String[] not_good = {"b2", "2b2", "1G3bG", " BbG", "0bbA", "abB", "!@b2", "A", "1bb2"};
            for(int i=0;i<not_good.length;i=i+1) {
                boolean not_ok = Ex1.isNumber(not_good[i]);
                assertFalse(not_ok);
            }
        }
        @Test
        void int2NumberTest() {
           // implement this test
        }
        @Test
        void maxIndexTest() {
            // implement this test
        }

        @Test
        void testNumber2IntValid() {
            assertEquals(10, Ex1.number2Int("1010b2"), "Binary to decimal conversion failed");
            assertEquals(123, Ex1.number2Int("123bA"), "Decimal to decimal conversion failed");
            assertEquals(255, Ex1.number2Int("FFbG"), "Hexadecimal to decimal conversion failed");
        }

        @Test
        void testNumber2IntInvalid() {
            assertEquals(-1, Ex1.number2Int("123b17"), "Should return -1 for invalid base");
            assertEquals(-1, Ex1.number2Int("12b"), "Should return -1 for missing base");
            assertEquals(-1, Ex1.number2Int("b16"), "Should return -1 for missing number");
            assertEquals(-1, Ex1.number2Int(null), "Should return -1 for null input");
        }

        @Test
        void testIsNumberValid() {
            assertTrue(Ex1.isNumber("123bA"), "Valid number format not recognized");
            assertTrue(Ex1.isNumber("FFbG"), "Valid hexadecimal format not recognized");
            assertTrue(Ex1.isNumber("1010b2"), "Valid binary format not recognized");
        }

        @Test
        void testIsNumberInvalid() {
            assertFalse(Ex1.isNumber("123b17"), "Invalid base recognized as valid");
            assertFalse(Ex1.isNumber("12 b10"), "Spaces in number should be invalid");
            assertFalse(Ex1.isNumber(""), "Empty string should be invalid");
            assertFalse(Ex1.isNumber(null), "Null input should be invalid");
        }

        @Test
        void testInt2NumberValid() {
            assertEquals("1010", Ex1.int2Number(10, 2), "Decimal to binary conversion failed");
            assertEquals("A", Ex1.int2Number(10, 16), "Decimal to hexadecimal conversion failed");
            assertEquals("10", Ex1.int2Number(16, 16), "Decimal to base-16 conversion failed");
        }

        @Test
        void testInt2NumberInvalid() {
            assertEquals("", Ex1.int2Number(-1, 10), "Negative numbers should return empty string");
            assertEquals("", Ex1.int2Number(10, 17), "Invalid base should return empty string");
            assertEquals("", Ex1.int2Number(10, 1), "Invalid base should return empty string");
        }

        @Test
        void testMaxIndex() {
            String[] numbers = {"1010b2", "FFbG", "123bA", null, "AAbG"};
            assertEquals(1, Ex1.maxIndex(numbers), "Should return index of the largest number");

            String[] numbersWithInvalid = {"1G1b2", "FFFbG", null, "124bG"};
            assertEquals(1, Ex1.maxIndex(numbersWithInvalid), "Should handle invalid numbers and nulls");
        }

        // Add additional test functions - test as much as you can.
    }
