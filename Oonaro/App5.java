import java.util.Scanner;

public class App5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        var sizes = System.console().readLine().split(" ");
        var satr1 = Integer.parseInt(sizes[0]);
        var moshtarak = Integer.parseInt(sizes[1]);
        var satr2 = Integer.parseInt(sizes[2]);

        int[][] matrix1 = new int[satr1][moshtarak];
        int[][] matrix2 = new int[moshtarak][satr2];

        // get matrix1
        for (int i = 0; i < Integer.parseInt(sizes[0]); i++) {
            var input = System.console().readLine().split(" ");
            for (int j = 0; j < input.length; j++) {
                matrix1[i][j] = Integer.parseInt(input[j]);
            }

        }

        // get matrix2
        for (int i = 0; i < Integer.parseInt(sizes[1]); i++) {
            var input = System.console().readLine().split(" ");
            for (int j = 0; j < input.length; j++) {
                matrix2[i][j] = Integer.parseInt(input[j]);
            }

        }
        int sum = 0;
        for (int i = 0; i < satr1; i++) {
            for (int j = 0; j < satr2; j++) {
                sum = 0;
                for (int k = 0; k < moshtarak; k++) {

                    sum += matrix1[i][k] * matrix2[k][j];

                }
                System.out.print(sum + " ");
            }
            System.out.println();
        }
    }

}
