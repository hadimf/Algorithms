import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class App {
    public static void main(String[] args) {
        var input = System.console().readLine().split(" ");

        var numberSet = removeDuplicates(input);
        List<Integer> numbersList = new ArrayList<>(numberSet);

        Collections.sort(numbersList);
        if (numbersList.size() == 1) {
            System.out.println(numbersList.get(0));
            System.out.println(numbersList.get(0));
        } else if (numbersList.size() == 2) {
            System.out.println(numbersList.get(1));
            System.out.println(numbersList.get(0));

        } else if (numbersList.size() == 3) {
            System.out.println(numbersList.get(1));
            System.out.println(numbersList.get(1));

        } else {
            System.out.println(numbersList.get(numbersList.size() - 2));
            System.out.println(numbersList.get(1));
        }

    }

    public static HashSet<Integer> removeDuplicates(String[] a) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < a.length; i++)
            set.add(Integer.parseInt(a[i]));

        return set;
    }
}
