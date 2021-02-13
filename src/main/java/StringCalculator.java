import java.util.*;
import java.util.regex.*;

public class StringCalculator {
    public int Add(String numbers){
        int stringLength = numbers.length();
        if (stringLength == 1)
            return Integer.parseInt(numbers);
        else if (stringLength == 2){
            if (Integer.parseInt(numbers)<0)
                throw new NumberFormatException("Negatives are not allowed " + numbers);
            else
                return Integer.parseInt(String.valueOf(numbers.charAt(0))) + Integer.parseInt(String.valueOf(numbers.charAt(1)));
        }
        else if (stringLength > 2){
            if (checkAndReturnNegatives(numbers).size()==0){
                int sum = 0;
                for (int i = 0; i< stringLength; i++){
                    char ch = numbers.charAt(i);
                    if ((ch>='0')&&(ch<='9'))
                        sum+=ch-48;
                }
                return sum;
            }
            else
                throw new NumberFormatException("Negatives are not allowed " + checkAndReturnNegatives(numbers));
        }
        return 0;
    }

    List<String> checkAndReturnNegatives(String s) {
        String regex = "(-\\d)";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(s);
        List<String> ls = new ArrayList<>();
        while(m.find()) ls.add(m.group());
        return ls;
    }
}