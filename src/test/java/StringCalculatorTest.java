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
        actual = stringCalculator.Add("1,2");
        expected = 3;
        assertEquals(expected,actual);
    }

    @Test
    void shouldReturnSumOfAllNumbersWhenLengthIsGreaterThantwo(){
        actual = stringCalculator.Add("1,2,3,2");
        expected = 8;
        assertEquals(expected,actual);
    }

    @Test
    void allowingNewLinesBetweenNumbers(){
        actual = stringCalculator.Add("1\n2,3");
        expected = 6;
        assertEquals(expected,actual);
    }

    @Test
    void supportingDelimiters(){
        actual = stringCalculator.Add("//[;]\n1;2;5;6");
        expected = 14;
        assertEquals(expected,actual);
    }

    @Test
    void throwingExceptionOnOneNegativeNumber(){
        assertThrows(NumberFormatException.class, ()->stringCalculator.Add("-9"),"Negatives are not allowed");
    }

    @Test
    void throwingExceptionOnMultipleNegativeNumber(){
        assertThrows(NumberFormatException.class, ()->stringCalculator.Add("-9-2-5-8"),"Negatives are not allowed, there are multiple");
    }

    @Test
    void numberBiggerThan1000ShouldNotBeAdded(){
        actual = stringCalculator.Add("2,1001");
        expected = 2;
        assertEquals(expected,actual);
    }

    @Test
    void supportingDelimitersOfAnyLength(){
        actual = stringCalculator.Add("//[***]\n1***2***3");
        expected = 6;
        assertEquals(expected,actual);
    }

    @Test
    void supportMultipleDelimiters(){
        actual = stringCalculator.Add("//[**][^][%][+]\n6**2^7%3+9");
        expected = 27;
        assertEquals(expected,actual);
    }
}