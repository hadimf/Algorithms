
import classes.Term;

public class ManageTerm {
    public static Term createTerm() {
        System.out.println("Enter Year of Term");
        var yearTerm = Integer.parseInt(System.console().readLine());
        System.out.println("Enter Your Half of year of Term : ");
        var halfYear = Integer.parseInt(System.console().readLine());

        return new Term(yearTerm, halfYear);
    }
}
