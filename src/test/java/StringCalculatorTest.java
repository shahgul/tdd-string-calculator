import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {

    @Test
    void shouldReturnZeroWhenStringEmpty(){
        StringCalculator stringCalculator = new StringCalculator();
        int actual = stringCalculator.Add("");
        int expected = 0;
        assertEquals(actual,expected);
    }
}