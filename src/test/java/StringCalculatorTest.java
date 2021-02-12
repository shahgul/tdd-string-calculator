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
        assertEquals(actual,expected);
    }

    @Test
    void shouldReturnSameWhenStringIsSingleLength(){
        actual = stringCalculator.Add("1");
        expected = 1;
        assertEquals(actual,expected);
    }
}