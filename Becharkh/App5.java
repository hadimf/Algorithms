
import java.lang.reflect.Array;

public class App5 {
    public static void main(String[] args) {
        var input = System.console().readLine().split(" ");
        int first = 0;
        int second = 0;

        if (Integer.parseInt(input[0]) > Integer.parseInt(input[1])) {
            first = Integer.parseInt(input[1]);
            second = Integer.parseInt(input[0]);
        } else {
            first = Integer.parseInt(input[0]);
            second = Integer.parseInt(input[1]);
        }

        showPrimary(first, second);
        System.out.println();
        fibo(first, second);

    }

    public static void showPrimary(int first, int second) {
        for (int i = first + 1; i < second; i++) {
            if (primary(i) != -1) {

                System.out.print(i + " ");
            }
        }
    }

    public static int primary(int input) {
        int counter = 0;
        for (int i = 1; i <= input; i++) {
            if (input % i == 0) {
                counter++;
            }
        }
        if (counter == 2) {
            return input;
        } else {
            return -1;
        }
    }

    public static void fibo(int start, int last) {
        var first = 0;
        var second = 1;
        int temp;

        while (second < last) {

            temp = first;
            first = second;
            second = temp + first;
            if (second < last && second >= start) {

                System.out.print(second + " ");
            }
        }

    }
}
