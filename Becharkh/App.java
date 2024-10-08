
import java.util.Random;

public class App {
    public static void main(String[] args) {
        var input1 = Double.parseDouble(System.console().readLine());
        var input2 = Double.parseDouble(System.console().readLine());

        var random = new Random();
        for (int i = 0; i < 5; i++) {
            
            System.out.print(input1 + random.nextDouble(input2 - input1) + " ");
        }
    }
}
