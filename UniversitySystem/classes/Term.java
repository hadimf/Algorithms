package classes;

import java.util.ArrayList;

public class Term {
    private int yearTerm;
    private int halfYearTerm;
    private ArrayList<Course> coursesTermList;
    private static ArrayList<Term> existTermsList = new ArrayList<>();

    public Term(int yearTerm, int halfYearTerm) {
        super();
        coursesTermList = new ArrayList<>();
        this.yearTerm = yearTerm;
        this.halfYearTerm = halfYearTerm;
    }

    public static void showCoursesByYear_HalfYear(int yearTerm, int halfYearTerm) {
        if (existTermsList.isEmpty()) {
            System.out.println("There is no Term Exist");
        }
        for (var term : existTermsList) {
            if (term.yearTerm == yearTerm && term.halfYearTerm == halfYearTerm) {
                for (int i = 1; i <= term.coursesTermList.size(); i++) {
                    System.out.print(i + " ");
                    term.coursesTermList.get((i - 1)).showData();
                }

            }
        }
    }

    public static Course getCourseByYear_HalfYear_Id(int yearTerm, int halfYearTerm, int id) {
        if (existTermsList.isEmpty()) {
            System.out.println("There is no Term Exist");
        }
        for (var term : existTermsList) {
            if (term.yearTerm == yearTerm && term.halfYearTerm == halfYearTerm) {

                return term.coursesTermList.get((id - 1));
            }
        }
        return null;
    }

    public static void showExistTerms() {
        if (existTermsList.isEmpty()) {
            System.out.println("There is no Term Exist");
        }
        for (var term : existTermsList) {
            System.out.println("Year Term : " + term.yearTerm + ", HalfYear Term: " + term.halfYearTerm);
        }
    }

    public void showDetailsCourseByYear_HalfYear(int yearTerm, int halfYearTerm) {
        var countCourse = 0;
        var countUnit = 0;
        for (var term : existTermsList) {
            for (var course : term.getCoursesTermList()) {
                countCourse++;
                countUnit += course.getUnit();
            }

        }
    }

    public static void addExistTerm(Term term) {
        existTermsList.add(term);
    }

    public void setCoursesTermList(ArrayList<Course> coursesTermList) {
        this.coursesTermList = coursesTermList;
    }

    public ArrayList<Course> getCoursesTermList() {
        return coursesTermList;
    }

    public int getYearTerm() {
        return yearTerm;
    }

    public int getHalfYearTerm() {
        return halfYearTerm;
    }
}
