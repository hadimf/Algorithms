public class App4 {
    public static void main(String[] args) {
        var input = Integer.parseInt(System.console().readLine());

        for (int i = 1; i <= input; i += 2) {
            show2(i, input);
        }
        for (int j = input - 2; j >= 1; j -= 2) {
            show2(j, input);
        }

    }

    public static void show2(int size, int input) {
        for (int i = 0; i < (input - size) / 2; i++) {
            System.out.print(" ");
        }
        for (int i = 0; i < size; i++) {
            System.out.print("*");
        }
        for (int i = 0; i < (input - size) / 2; i++) {
            System.out.print(" ");
        }
        for (int i = 0; i < (input - size) / 2; i++) {
            System.out.print(" ");
        }
        for (int i = 0; i < size; i++) {
            System.out.print("*");
        }
        for (int i = 0; i < (input - size) / 2; i++) {
            System.out.print(" ");
        }

        System.out.println();
    }
}
