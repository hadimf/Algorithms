
import java.util.Random;

public class App {
    public static void main(String[] args) {
        var input1 = Double.parseDouble(System.console().readLine());
        var input2 = Double.parseDouble(System.console().readLine());
        if (input1 > input2) {
            var temp = input1;
            input1 = input2;
            input2 = temp;
        }
        var random = new Random();
        if (input1 - input2 == 0) {
            System.out.println(0);

        } else {
            for (int i = 0; i < 5; i++) {

                System.out.print(input1 + random.nextDouble(Math.abs((input2 - input1))) + " ");
            }

        }

    }
}
