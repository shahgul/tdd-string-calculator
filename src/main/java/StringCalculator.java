import java.util.*;
import java.util.regex.*;

public class StringCalculator {
    public int Add(String numbers){
        int stringLength = numbers.length();
        if (stringLength==0)
            return 0;
        else if (stringLength == 1)
            return Integer.parseInt(numbers);
        else{
            if ((numbers.length()==2)&&(Integer.parseInt(numbers)<0))
                throw new NumberFormatException("Negatives are not allowed " + numbers);
            else if (checkAndReturnNegatives(numbers).size()==0){
                String[] nums = numbers.split("[,\n]");
                int sum = 0;
                for(String temp:nums)
                    sum+=Integer.parseInt(temp);
                return sum;
            }
            else
                throw new NumberFormatException("Negatives are not allowed " + checkAndReturnNegatives(numbers));
        }
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