package classes;

import java.time.LocalTime;

public class Course {
    private String courseName;
    private int unit;
    private String location;
    private Term term;
    private String day;
    private LocalTime startTime;
    private int duration;
    // private ArrayList<Course> coursesTakenList;

    public Course(String courseName, int unit, String location, String day, LocalTime startTime, int duration) {
        super();
        this.courseName = courseName;
        this.day = day;
        this.duration = duration;
        this.location = location;
        this.startTime = startTime;
        this.unit = unit;
        // coursesTakenList = new ArrayList<>();
    }

    public void showData() {
        System.out.println("Course Name: " + this.courseName + " Unit: " + this.unit + " In Day: " + this.day + " At : "
                + this.startTime.toString() + " Duration: " + this.duration);
    }

    public void setTerm(Term term) {
        this.term = term;
    }

    public Term getTerm() {
        return term;
    }

    public int getUnit() {
        return unit;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getDay() {
        return day;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEnd() {
        return startTime.plusMinutes(duration);
    }

}
