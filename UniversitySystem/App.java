
import classes.Course;
import classes.Student;
import classes.Term;
import java.time.LocalTime;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        while (true) {
            Console.menuMain();
            var input = Console.getIntInput();
            Console.manageMenu(input);
        }
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
