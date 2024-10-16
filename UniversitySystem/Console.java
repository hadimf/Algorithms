import classes.Course;
import classes.Student;
import classes.Term;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.zip.CheckedInputStream;

public class Console {

    public static void menuMain() {
        System.out.println("1.Manage Term");
        System.out.println("2.Create Student");
        System.out.println("3.Login Student");
        System.out.println("4.Show Details");
        System.out.print("input : ");
    }

    public static int getIntInput() {
        return Integer.parseInt(System.console().readLine());
    }

    public static void manageMenu(int input) {
        switch (input) {
            case 1:
                showExistTerms();
                var term = ManageTerm.createTerm();
                var coursesPerTerm = createCourse();
                setTerm2Course(term, coursesPerTerm);
                break;
            case 2:
                String again;
                do {
                    var student = ManageStudent.createStudent();
                    student.addStudent();
                    System.out.println("");
                    System.out.println("id student : " + student.getId());
                    again = checkStudentAgain();
                    Student.showExistStudent();

                } while ("y".equals(again));
                break;
            case 3:
                System.out.println("Enter Student Id:");
                var id = Integer.parseInt(System.console().readLine());
                if (!Student.checkStudentById(id)) {
                    System.out.println("Not Found Student");
                    break;
                }
                clearScreen();
                var student = Student.getStudentById(id);
                var inputShow = showMenuStudent(student);
                checkInputStudent(inputShow, student);

                break;
            case 4:
                var inputDetail = showDetailsMenu();
                checkedInputDetail(inputDetail);

                break;
            default:
                System.exit(1);
        }
    }

    private static void showExistTerms() {
        clearScreen();
        System.out.println("Exist Term:  ");
        Term.showExistTerms();
        System.out.println("-------------------------------");
    }

    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static ArrayList<Course> createCourse() {
        // Create Course for term
        System.out.println("How many course do u want?");
        var coursesCount = Integer.parseInt(System.console().readLine());

        var coursesPerTerm = new ArrayList<Course>();
        for (int i = 1; i <= coursesCount; i++) {
            System.out.println("Enter Your Course " + i + " Name ?");
            var courseName = System.console().readLine();

            System.out.println("How many units it does have course " + i + " ?");
            var units = Integer.parseInt(System.console().readLine());

            System.out.println("where is your location course " + i + " ?");
            var location = System.console().readLine();

            System.out.println("Enter day of course " + i + " ?");
            System.out
                    .println(
                            "1.Saturday 2.Sunday 3.Monday 4.Tuesday 5.Wednesday 6.Thursday 7.Friday class "
                                    + i + " ?");
            var dayInput = getIntInput();
            var day = checkDayWeak(dayInput);

            System.out.println("Enter Start of hour course " + i + " ? ex(01:00)");
            var hour = System.console().readLine();
            var startTime = LocalTime.parse(hour);

            System.out.println("Enter Duration of course " + i + " ? (minutes)");
            var duration = Integer.parseInt(System.console().readLine());

            var course = new Course(courseName, units, location, day, startTime, duration);
            coursesPerTerm.add(course);

        }

        return coursesPerTerm;
    }

    private static String checkDayWeak(int dayInput) {
        String day = "";
        switch (dayInput) {
            case 1:
                day = "Saturday";
                break;
            case 2:
                day = "Sunday";
                break;
            case 3:
                day = "Monday";
                break;
            case 4:
                day = "Tuesday";
                break;
            case 5:
                day = "Wednesday";
                break;
            case 6:
                day = "Thursday";
                break;
            case 7:
                day = "Friday";
                break;
            default:
                throw new IllegalArgumentException("Value Error");
        }

        return day;
    }

    private static void setTerm2Course(Term term, ArrayList<Course> coursesPerTerm) {
        term.setCoursesTermList(coursesPerTerm);
        for (var course : term.getCoursesTermList()) {
            course.setTerm(term);
        }
        Term.addExistTerm(term);
    }

    private static String checkStudentAgain() {
        System.out.println("do u want again? (y/n)");
        return System.console().readLine();
    }

    private static int showMenuStudent(Student student) {
        System.out.println("Id Student: " + student.getId());

        System.out.println("------------------------------------");
        System.out.println("1.Calculate All units in one term");
        System.out.println("2.Calculate All units take by student");
        System.out.println("3.Take Course");
        return Integer.parseInt(System.console().readLine());
    }

    private static void checkInputStudent(int inputStudent, Student student) {
        switch (inputStudent) {
            case 1:
                showSumUnitsInOneTerm(student);
                break;
            case 2:
                clearScreen();
                student.calSumUnits();
                break;

            case 3:
                clearScreen();
                // Show Courses Of Term By Year and HalfYear
                var inputs = showCoursesTermByYear_HalfYear();

                // Take Course of Term
                System.out.println("Enter Number Course ");
                var courseNumber = Integer.parseInt(System.console().readLine());
                var course = Term.getCourseByYear_HalfYear_Id(inputs[0], inputs[1],
                        courseNumber);
                student.addCourse(inputs[0], inputs[1], courseNumber);

                break;
            default:
                break;
        }
    }

    private static void showSumUnitsInOneTerm(Student student) {
        clearScreen();
        var sumUnits = student.calSumUnitsInOneTerm();
        if (sumUnits > 0) {
            System.out.println("All units in one term " + sumUnits);
        }
    }

    private static int[] showCoursesTermByYear_HalfYear() {
        int[] inputs = new int[2];
        System.out.println("Enter Year of Term do want Take Course");
        var yearTermInput = Integer.parseInt(System.console().readLine());
        inputs[0] = yearTermInput;
        System.out.println("Enter Half Year of Term do u want Take Course");
        var halfYearTermInput = Integer.parseInt(System.console().readLine());
        inputs[1] = halfYearTermInput;

        Term.showCoursesByYear_HalfYear(yearTermInput, halfYearTermInput);
        return inputs;
    }

    private static int showDetailsMenu() {
        clearScreen();

        System.out.println("1.Show All Terms");
        System.out.println("2.Show All Courses");
        System.out.println("3.Show Count Courses and Show Count Units");
        return getIntInput();
    }

    private static void checkedInputDetail(int inputDetail) {
        switch (inputDetail) {
            case 1:
                Term.showExistTerms();
                break;
            case 2:
                Term.showCourses();

                break;
            case 3:
                Term.showDetailsCourseByYear_HalfYear();

                break;

            default:
                System.exit(1);
                break;
        }
    }
}
