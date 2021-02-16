import java.util.*;
import java.util.regex.*;

public class StringCalculator {
    public int Add(String numbers) {
        int stringLength = numbers.length();
        if (stringLength == 0) return 0; //When string length is 0
        else if (stringLength == 1) return Integer.parseInt(numbers); //When string length is 1
        else if ((numbers.length() == 2) && (Integer.parseInt(numbers) < 0)) //When string is a single negative number
            throw new NumberFormatException("Negatives are not allowed " + numbers);
        else { //When string length is greater than 1
            if (checkAndReturnNegatives(numbers).size() > 0)// When string has more than 1 negative numbers
                throw new NumberFormatException("Negatives are not allowed " + checkAndReturnNegatives(numbers));
            else { // When string has Positive Integers
                String[] numbs = numbers.split("[,\n]");
                int sum = 0;
                if (numbs[0].startsWith("//[")) {
                    String extractDelimiter = extractRegex(numbs[0]);
                    String regex = escapeDanglingMetacharacter(extractDelimiter);
                    String[] delimiters = numbs[1].split(regex);
                    for (String temp : delimiters)
                        sum += Integer.parseInt(temp);
                } else {
                    for (String temp : numbs)
                        if (Integer.parseInt(temp) <= 1000)
                            sum += Integer.parseInt(temp);
                }
                return sum;
            }
        }
    }

    List<String> checkAndReturnNegatives(String s) {
        String regex = "(-\\d)";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(s);
        List<String> ls = new ArrayList<>();
        while (m.find()) ls.add(m.group());
        return ls;
    }

    String escapeDanglingMetacharacter(String s) {
        StringBuilder toReturn = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if ((ch == '*') || (ch == '+') || (ch == '$') || (ch == '^'))
                toReturn.append("\\");
            toReturn.append(ch);
        }
        return toReturn.toString();
    }

    String extractRegex(String ss) {
        String s = ss.replace("][","");
        StringBuilder toReturn = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if ((ch != '[')&&(ch != ']')&&(ch != '/')&&(ch != '\\')) {
                toReturn.append(ch);
            }
        }
        return toReturn.toString();
    }
}