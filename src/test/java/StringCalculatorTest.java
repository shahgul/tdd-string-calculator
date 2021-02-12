import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {
    StringCalculator stringCalculator = new StringCalculator();
    int actual;
    int expected;

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
}