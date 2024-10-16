import classes.Student;

public class ManageStudent {
    public static Student createStudent() {
        System.out.println("Enter Name of of Student");
        var name = System.console().readLine();
        System.out.println("Enter LastName of Student");
        var lastName = System.console().readLine();

        return new Student(name, lastName);
    }
}
