
import classes.Course;
import classes.Student;
import classes.Term;
import java.time.LocalTime;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        while (true) {

            System.out.println("Welcome to University System");
            //
            System.out.println("1.Manage Term");
            System.out.println("2.Create Student");
            System.out.println("3.Login Student");
            System.out.println("4.Show Details");
            System.out.print("input : ");
            var input = Integer.parseInt(System.console().readLine());

            switch (input) {
                case 1:
                    clearScreen();
                    System.out.println("Exist Term:  ");
                    Term.showExistTerms();
                    System.out.println("-------------------------------");

                    // Create new term
                    System.out.println("Enter Year of Term");
                    var yearTerm = Integer.parseInt(System.console().readLine());
                    System.out.println("Enter Your Half of year of Term : ");
                    var halfYear = Integer.parseInt(System.console().readLine());
                    var term = new Term(yearTerm, halfYear);

                    // Create Course for term
                    System.out.println("How many course do u want?");
                    var coursesCount = Integer.parseInt(System.console().readLine());

                    var coursesPerTerm = new ArrayList<Course>();
                    for (int i = 1; i <= coursesCount; i++) {
                        // coursesPerTerm = new ArrayList<>();

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
                        var dayInput = Integer.parseInt(System.console().readLine());
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

                        System.out.println("Enter Start of hour course " + i + " ? ex(01:00)");
                        var hour = System.console().readLine();
                        var startTime = LocalTime.parse(hour);

                        System.out.println("Enter Duration of course " + i + " ? (minutes)");
                        var duration = Integer.parseInt(System.console().readLine());

                        var course = new Course(courseName, units, location, day, startTime, duration);
                        coursesPerTerm.add(course);

                    }

                    term.setCoursesTermList(coursesPerTerm);
                    for (var course : term.getCoursesTermList()) {
                        course.setTerm(term);
                    }
                    Term.addExistTerm(term);
                    break;
                case 2:
                    // Getting Student
                    String again;
                    do {
                        System.out.println("Enter Name of of Student");
                        var name = System.console().readLine();
                        System.out.println("Enter LastName of Student");
                        var lastName = System.console().readLine();
                        var student = new Student(name, lastName);
                        student.addStudent();
                        System.out.println("");
                        System.out.println("id student : " + student.getId());
                        System.out.println("do u want again? (y/n)");
                        again = System.console().readLine();
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
                    System.out.println("Id Student: " + student.getId());

                    System.out.println("------------------------------------");
                    System.out.println("1.Calculate All units in one term");
                    System.out.println("2.Calculate All units take by student");
                    System.out.println("3.Take Course");
                    var inputStudent = Integer.parseInt(System.console().readLine());

                    switch (inputStudent) {
                        case 1:
                            clearScreen();
                            var sumUnits = student.calSumUnitsInOneTerm();
                            System.out.println("All units in one term " + sumUnits);
                            break;
                        case 2:
                            clearScreen();
                            student.calSumUnits();
                            break;

                        case 3:
                            clearScreen();
                            // Show Courses Of Term By Year and HalfYear
                            System.out.println("Enter Year of Term do want Take Course");
                            var yearTermInput = Integer.parseInt(System.console().readLine());
                            System.out.println("Enter Half Year of Term do u want Take Course");
                            var halfYearTermInput = Integer.parseInt(System.console().readLine());
                            Term.showCoursesByYear_HalfYear(yearTermInput, halfYearTermInput);

                            // Take Course of Term
                            System.out.println("Enter Number Course ");
                            var courseNumber = Integer.parseInt(System.console().readLine());
                            var course = Term.getCourseByYear_HalfYear_Id(yearTermInput, halfYearTermInput,
                                    courseNumber);
                            student.addCourse(yearTermInput, halfYearTermInput, courseNumber);

                            break;
                        default:
                            break;
                    }
                    break;

                case 4:
                    clearScreen();
                    
                    System.out.println("1.Show All Terms");
                    System.out.println("2.Show All Courses");
                    System.out.println("3.Show Count Courses and Show Count Units");
                    var inputShow = Integer.parseInt(System.console().readLine());
                    switch (inputShow) {
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
                    break;

                default:
                    System.exit(1);
            }

        }
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
