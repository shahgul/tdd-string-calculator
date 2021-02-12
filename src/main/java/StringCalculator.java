public class StringCalculator {
    public int Add(String numbers){
        if (numbers.length()==1)
            return Integer.parseInt(numbers);
        else if (numbers.length()==2)
            return Integer.parseInt(String.valueOf(numbers.charAt(0))) + Integer.parseInt(String.valueOf(numbers.charAt(1)));
        return 0;
    }
}