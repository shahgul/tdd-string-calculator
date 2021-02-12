public class StringCalculator {
    public int Add(String numbers){
        int stringLength = numbers.length();
        if (stringLength ==1)
            return Integer.parseInt(numbers);
        else if (stringLength ==2)
            return Integer.parseInt(String.valueOf(numbers.charAt(0))) + Integer.parseInt(String.valueOf(numbers.charAt(1)));
        else if (stringLength >2){
            int sum = 0;
            for (int i = 0; i< stringLength; i++){
                char ch = numbers.charAt(i);
                if ((ch>='0')&&(ch<='9'))
                    sum+=ch-48;
            }
            return sum;
        }
        return 0;
    }
}