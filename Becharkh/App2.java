public class App2 {
    public static void main(String[] args) {
        var input = Integer.parseInt(System.console().readLine());
        for (int i = 0; i < input; i++) {
            System.out.print("*");
        }
        for (int i = 0; i < input-2; i++) {
            
            show(input);
        }
        for (int i = 0; i < input; i++) {
            System.out.print("*");
        }
        

    }

    public static void show(int input) {
        System.out.println();
        System.out.print("*");
        for (int i = 0; i < input-2; i++) {
            System.out.print(" ");
        }
        System.out.print("*");
        System.out.println();
    }
}
