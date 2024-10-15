package classes;

import java.util.ArrayList;

public class Student {
    private String name;
    private String lastName;
    private int id;
    private ArrayList<Term> termsTaken;
    private ArrayList<Course> coursesTaken;
    private static int count = 0;
    private static ArrayList<Student> studentsExistList = new ArrayList<>();

    public Student(String name, String lastName) {
        super();
        this.termsTaken = new ArrayList<>();
        this.coursesTaken = new ArrayList<>();
        count++;
        this.id = 100 + count;
        this.name = name;
        this.lastName = lastName;

    }

    public void addStudent() {
        studentsExistList.add(this);
    }

    public static void showExistStudent() {
        System.out.println("--------------------------------");
        System.out.println("Student Exist : ");
        for (var student : studentsExistList) {
            System.out.println("Name: " + student.name + " " + student.lastName + "  id : " + student.id);
        }
        System.out.println("***********************************");
    }

    public static boolean checkStudentById(int id) {
        var isExist = false;
        for (var student : studentsExistList) {
            if (student.id == id) {
                isExist = true;
            }
        }
        return isExist;
    }

    public int getId() {
        return id;
    }

    public static Student getStudentById(int id) {
        Student stu = null;
        for (var student : studentsExistList) {
            if (student.id == id) {
                stu = student;
            }
        }
        return stu;
    }

    public int calSumUnitsInOneTerm() {
        System.out.println("Enter your year: ");
        var year = Integer.parseInt(System.console().readLine());
        System.out.println("Enter Your Half of year of Term ");
        var halfYear = Integer.parseInt(System.console().readLine());
        var hasExist = false;
        int sum = 0;
        for (var course : coursesTaken) {
            if (course.getTerm().getYearTerm() == year && course.getTerm().getHalfYearTerm() == halfYear) {
                sum += course.getUnit();
                hasExist = true;
            }
        }
        if (hasExist) {
            System.out.println("Sum units of Year of " + year + " in " + halfYear + "  half Year is : " + sum);
        }else{
            System.out.println("There is no Term");
        }
        return sum;
    }

    public int calSumUnitsInOneTermByYear_HalfYear(int yearTerm, int halfYearTerm) {
        int sum = 0;
        for (var course : coursesTaken) {
            if (course.getTerm().getYearTerm() == yearTerm && course.getTerm().getHalfYearTerm() == halfYearTerm) {
                sum += course.getUnit();
            }
        }
        return sum;
    }

    public void calSumUnits() {
        var sum = 0;
        for (var course : coursesTaken) {
            sum += course.getUnit();
        }

        System.out.println("Sum units is " + sum);
    }

    public void addCourse(int yearTerm, int halfYearTerm, int id) {
        var sum = calSumUnitsInOneTermByYear_HalfYear(yearTerm, halfYearTerm);
        var course = Term.getCourseByYear_HalfYear_Id(yearTerm, halfYearTerm, id);
        if (!checkOverlapClasses(course)) {
            sum += course.getUnit();
            if (sum <= 20) {

                coursesTaken.add(course);
                System.out.println("Added Successfully");
            } else {
                System.out.println("Maximum is 20 units!");
            }

        }

    }

    public boolean checkOverlapClasses(Course otherCourse) {

        var isOverlapped = false;
        for (var lesson : coursesTaken) {

            if ((lesson.getTerm().getYearTerm() == otherCourse.getTerm().getYearTerm()) &&
                    (lesson.getTerm().getHalfYearTerm() == otherCourse.getTerm().getHalfYearTerm())) {
                if (lesson.getCourseName().equals(otherCourse.getCourseName())) {
                    System.out.println("Duplicate class");
                    isOverlapped = true;
                    break;
                } else if ((lesson.getDay().equals(otherCourse.getDay())) &&
                        (otherCourse.getEnd().compareTo(lesson.getStartTime())) == 1 &&
                        (otherCourse.getStartTime().compareTo(lesson.getEnd())) == -1) {
                    System.out.println(otherCourse.getCourseName() + " is overlapping by " + lesson.getCourseName());
                    isOverlapped = true;
                    break;
                }
            }
        }

        return isOverlapped;
    }
}
