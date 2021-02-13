import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringCalculatorTest {
    StringCalculator stringCalculator = new StringCalculator();
    int actual;
    int expected = 6+2;

    @Test
    void shouldReturnZeroWhenStringEmpty(){
        actual = stringCalculator.Add("");
        expected = 0;
        assertEquals(expected,actual);
    }

    @Test
    void shouldReturnSameWhenStringIsSingleLength(){
        actual = stringCalculator.Add("1");
        expected = 1;
        assertEquals(expected,actual);
    }

    @Test
    void shouldReturnSumOfBothNumbersWhenLengthIsTwo(){
        actual = stringCalculator.Add("12");
        expected = 3;
        assertEquals(expected,actual);
    }

    @Test
    void shouldReturnSumOfAllNumbersWhenLengthIsGreaterThantwo(){
        actual = stringCalculator.Add("1232");
        expected = 8;
        assertEquals(expected,actual);
    }

    @Test
    void allowingNewLinesBetweenNumbersButNotComma(){
        actual = stringCalculator.Add("1\\n,2,3");
        expected = 6;
        assertEquals(expected,actual);
    }

    @Test
    void supportingDelimiters(){
        actual = stringCalculator.Add("“//;\\n1;2,5,6");
        expected = 14;
        assertEquals(expected,actual);
    }

    @Test
    void throwingExceptionOnOneNegativeNumber(){
        assertThrows(NumberFormatException.class, ()->stringCalculator.Add("-9"),"Negatives are not allowed");
    }
}