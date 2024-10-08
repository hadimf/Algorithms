public class App4 {
    public static void main(String[] args) {
        var input = Integer.parseInt(System.console().readLine());
        findPrimaryNumber(input);
    }

    public static void findPrimaryNumber(int input) {
        int count = 0;
        var isExist = false;
        if (input % 2 == 0) {
            input = input - 1;
        }
        for (int i = input; i > 2; i = i - 2) {
            if (primary(i) != -1) {
                count++;
            } else {
                count = 0;
            }
            if (count == 2) {
                System.out.println(i + " " + (i + 2));
                isExist = true;
                break;
            }
        }
        if (!isExist) {

            System.out.println(-1 + " " + -1);
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
}
