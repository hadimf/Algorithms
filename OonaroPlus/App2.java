import java.util.Arrays;
import java.util.HashMap;

public class App2 {
    public static void main(String[] args) {
        var times = Integer.parseInt(System.console().readLine());

        var total = new HashMap<String, Integer>();
        var hasWinner = false;
        total.put("x", 0);
        total.put("o", 0);
        total.put("tie", 0);

        for (int i = 0; i < times; i++) {
            var input1 = System.console().readLine().split("");
            var input2 = System.console().readLine().split("");
            var input3 = System.console().readLine().split("");
            input1 = Arrays.stream(input1).map(item -> item.toLowerCase()).toArray(String[]::new);
            input2 = Arrays.stream(input2).map(item -> item.toLowerCase()).toArray(String[]::new);
            input3 = Arrays.stream(input3).map(item -> item.toLowerCase()).toArray(String[]::new);
            String[][] inputs = { input1, input2, input3 };

            hasWinner = checkOfoghi(inputs, total);
            if (!hasWinner) {
                hasWinner = checkAmoodi(inputs, total);
            }
            if (!hasWinner) {
                hasWinner = checkOrib(inputs, total);
            }
            if (!hasWinner) {
                total.put("tie", (total.get("tie") + 1));
            }

        }
        System.out.println("X: " + total.get("x"));
        System.out.println("Ties: " + total.get("tie"));
        System.out.println("O: " + total.get("o"));
        if (total.get("x") > total.get("o")) {
            System.out.println("Champ: X");
        } else if (total.get("x") < total.get("o")) {
            System.out.println("Champ: O");

        } else {
            System.out.println("N");
        }

    }

    public static boolean checkOfoghi(String[][] inputs, HashMap<String, Integer> total) {
        for (int i = 0; i < 3; i++) {
            int xTimes = 0;
            int oTimes = 0;
            for (int j = 0; j < 3; j++) {

                if (inputs[i][j].equals("x")) {
                    xTimes += 1;
                } else if (inputs[i][j].equals("o")) {
                    oTimes += 1;
                }

            }
            if (xTimes == 3) {
                // System.out.println("x win");
                total.put("x", total.get("x") + 1);
                return true;

            } else if (oTimes == 3) {
                // System.out.println("o win");
                total.put("o", total.get("o") + 1);
                return true;

            }
        }
        return false;
    }

    public static boolean checkAmoodi(String[][] inputs, HashMap<String, Integer> total) {
        for (int i = 0; i < 3; i++) {
            int xTimes = 0;
            int oTimes = 0;
            for (int j = 0; j < 3; j++) {
                if (inputs[j][i].equals("x")) {
                    xTimes += 1;
                } else if (inputs[j][i].equals("o")) {
                    oTimes += 1;
                }
            }
            if (xTimes == 3) {
                // System.out.println("x win");
                total.put("x", total.get("x") + 1);
                return true;

            } else if (oTimes == 3) {
                // System.out.println("o win");
                total.put("o", total.get("o") + 1);
                return true;

            }
        }
        return false;

    }

    public static boolean checkOrib(String[][] inputs, HashMap<String, Integer> total) {
        if (inputs[0][0].equals(inputs[1][1]) && inputs[1][1].equals(inputs[2][2]) && inputs[0][0].equals("x") ||
                inputs[0][2].equals(inputs[1][1]) && inputs[1][1].equals(inputs[2][2]) && inputs[2][0].equals("x")) {
            // System.out.println("x win");
            total.put("x", total.get("x") + 1);
            return true;

        } else if (inputs[0][0].equals(inputs[1][1]) && inputs[1][1].equals(inputs[2][2]) && inputs[0][0].equals("o") ||
                inputs[0][2].equals(inputs[1][1]) && inputs[1][1].equals(inputs[2][2]) && inputs[2][0].equals("o")) {
            // System.out.println("o win");
            total.put("o", total.get("o") + 1);
            return true;
        }
        return false;
    }

}
