
import java.lang.reflect.Array;
import java.util.Arrays;

public class App4 {
    public static void main(String[] args) {
        var input = System.console().readLine().split(" ");
        var password = System.console().readLine().split(" ");
        var passwordList = Arrays.asList(password);

        var size = Integer.parseInt(input[0]);
        var shift = Integer.parseInt(input[1]);
        shift = shift % size;


        var newpass = new String[size];

        for (var number : passwordList) {
            if (passwordList.indexOf(number) < shift) {
                var index = passwordList.indexOf(number);
                index = index - shift;
                var newIndex = size + index;
                newpass[newIndex] = number;

            } else {
                var index = passwordList.indexOf(number);
                var newIndex = index - shift;
                newpass[newIndex] = number;
            }
        }

        for (var number : newpass) {
            System.out.print(number + " , ");
        }


    }
}
