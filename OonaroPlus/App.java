public class App {
    public static void main(String[] args) {
        var size = Integer.parseInt(System.console().readLine());
        var input = System.console().readLine().split(" ");
        var hasNegative = false;
        int[] numbers = new int[input.length];
        for (int i = 0; i < input.length; i++) {

            numbers[i] = Integer.parseInt(input[i]);
        }
        int count = 0;
        int odd = 0;
        int even = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 0) {
                hasNegative = true;
                break;
            } else if (i % 2 != numbers[i] % 2) {
                if (numbers[i] % 2 == 0) {
                    odd++;
                } else {
                    even++;
                }
                count++;
            }
        }
        // for (int i = 0; i < numbers.length; i++) {
        // if (numbers[i] < 0) {
        // hasNegative = true;
        // break;
        // }
        // }
        if (hasNegative) {
            System.out.println(-1);
        } else {

            if (size == 1) {
                if (numbers[0] % 2 == 0) {
                    System.out.println(0);
                } else {
                    System.out.println(-1);
                }
            } else if (even == odd) {
                if (count % 2 == 0) {
                    System.out.println(count / 2);
                } else {
                    System.out.println(-1);
                }
            } else {
                System.out.println(-1);

            }
        }
    }
}
