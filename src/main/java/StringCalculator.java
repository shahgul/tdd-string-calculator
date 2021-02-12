public class StringCalculator {
    public int Add(String numbers){
        if (numbers.length()==1)
            return Integer.parseInt(numbers);
        else if (numbers.length()==2)
            return Integer.parseInt(String.valueOf(numbers.charAt(0))) + Integer.parseInt(String.valueOf(numbers.charAt(1)));
        else if (numbers.length()>2){
            int sum = 0;
            for (int i = 0; i<numbers.length(); i++){
                char ch = numbers.charAt(i);
                sum+=ch-48;
            }
            return sum;
        }
        return 0;
    }
}