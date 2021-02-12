import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

    @Test
    void shouldReturnZeroWhenStringEmpty(){
        StringCalculator stringCalculator = new StringCalculator();
        int actual = stringCalculator.Add("");
        int expected = 0;
        Assertions.assertEquals(expected, actual);
        
    }
}