public class App3 {
    public static void main(String[] args) {
        var input = System.console().readLine().split(" ");
        int start;
        int end;
        if (Integer.parseInt(input[0]) < Integer.parseInt(input[1])) {
            start = Integer.parseInt(input[0]);
            end = Integer.parseInt(input[1]);
        } else {

            start = Integer.parseInt(input[1]);
            end = Integer.parseInt(input[0]);
        }

        fibo(start, end);
        System.out.println();
        fibo(end);
        System.out.println();
        fibo();
    }

    public static void fibo(int start, int end) {
        int first = 0;
        int second = 1;
        int temp;


        while (second <= end) {

            if (second >= start) {
                System.out.print(second + " ");
            }
            temp = first;
            first = second;
            second = second + temp;

        }

    }

    public static void fibo(int end) {
        int first = 0;
        int second = 1;
        int temp;


        while (second <= end) {

            System.out.print(second + " ");
            temp = first;
            first = second;
            second = second + temp;

        }

    }

    public static void fibo() {
        int first = 0;
        int second = 1;
        int temp;
        int count = 1;

        while (count <= 10) {

            System.out.print(second + " ");
            count++;

            temp = first;
            first = second;
            second = second + temp;

        }

    }
}
