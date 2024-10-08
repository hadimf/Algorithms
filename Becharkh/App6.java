
import java.util.ArrayList;

public class App6 {
    public static void main(String[] args) {
        String input;
        var numbers = new ArrayList<String>();
        while (true) {
            input = System.console().readLine();
            if (input.equals("0")) {
                break;
            }
            numbers.add(reverse(input));

        }

        for (String number : numbers) {
            System.out.println((number));
            showNumbers(number);
        }

    }

    public static String reverse(String input) {
        String reverseString = "";

        for (int i = input.length() - 1; i >= 0; i--) {
            reverseString += input.charAt(i);
        }
        return reverseString;
    }

    public static void showNumbers(String input) {
        for (int i = 0; i < input.length(); i++) {
            var index = input.charAt(i);
            for (int j = 0; j < Integer.parseInt(String.valueOf(index)); j++) {
                System.out.print(input.charAt(i));
            }
            System.out.println();
        }
    }

}
