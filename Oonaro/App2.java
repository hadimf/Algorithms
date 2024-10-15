import java.util.*;

public class App2 {
    public static void main(String[] args) {
        var input = Integer.parseInt( System.console().readLine());
        var isExist = false;
        
        HashMap<Integer, Integer> numbers = new HashMap<>();
        if (input <= 0) {
            System.exit(1);
        }
        var numbersStringList = System.console().readLine().split(" ");
        var numbersList = Arrays.stream(numbersStringList).mapToInt(Integer::parseInt).toArray();
        for (var number : numbersList) {
            if (numbers.get(number) == null) {
                numbers.put(number, 1);
            } else {
                numbers.put(number, numbers.get(number) + 1);
            }
        }
        
        for (var items : numbers.entrySet()) {
            if (items.getValue() > (input / 2) ) {
                System.out.println(items.getKey());
                isExist = true;
            }
        }
        if (!isExist) {
            System.out.println("None");
        }
    }
}
