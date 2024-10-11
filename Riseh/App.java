import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        var pattern = System.console().readLine();
        var lineNumber = Integer.parseInt(System.console().readLine());
        var lines = new HashMap<Integer, ArrayList<String>>();
        boolean hasMatch = false;
        var index = 0;

        var size = pattern.length();
        int c = 0;
        var str = "";
        hasMatch = false;
        for (int k = 0; k < lineNumber; k++) {
            var input = System.console().readLine();

            // check Word
            for (int i = 0; i < input.length(); i++) {
                for (int j = i; j < input.length(); j++) {
                    c++;
                    str += input.charAt(j);

                    if (c == size) {
                        if (checkWord(pattern, str)) {

                            var values = lines.getOrDefault(k, new ArrayList<String>());
                            values.add(String.valueOf((i + 1)));
                            lines.put(k, values);
                            hasMatch = true;

                        }
                        c = 0;
                        str = "";
                        break;
                    }
                }
            }

            // check Upper
            for (int i = 0; i < input.length(); i++) {
                for (int j = i; j < input.length(); j++) {
                    c++;
                    str += input.charAt(j);

                    if (c == size) {
                        if (checkUpper(pattern, str)) {

                            var values = lines.getOrDefault(k, new ArrayList<String>());
                            values.add(String.valueOf((i + 1)));
                            lines.put(k, values);
                            hasMatch = true;

                        }
                        c = 0;
                        str = "";
                        break;
                    }
                }
            }
            // check Reverse
            for (int i = 0; i < input.length(); i++) {
                for (int j = i; j < input.length(); j++) {
                    c++;
                    str += input.charAt(j);

                    if (c == size) {
                        if (checkReverse(pattern, str)) {

                            var values = lines.getOrDefault(k, new ArrayList<String>());
                            values.add(String.valueOf((i + 1)));
                            lines.put(k, values);
                            hasMatch = true;

                        }
                        c = 0;
                        str = "";
                        break;
                    }
                }
            }

            // check Reverse Upper
            for (int i = 0; i < input.length(); i++) {
                for (int j = i; j < input.length(); j++) {
                    c++;
                    str += input.charAt(j);

                    if (c == size) {
                        if (checkReverseUpper(pattern, str)) {

                            var values = lines.getOrDefault(k, new ArrayList<String>());
                            values.add(String.valueOf((i + 1)));
                            lines.put(k, values);
                            hasMatch = true;

                        }
                        c = 0;
                        str = "";
                        break;
                    }
                }
            }
            if (!hasMatch) {
                var list = new ArrayList<String>();
                list.add("Substring not found");
                lines.put(k, list);
            }

            // for (int i = 0; i < input.length(); i++) {
            // index = i;
            // for (int j = i; j < input.length(); j++) {
            // c++;
            // str += input.charAt(j);

            // if (c == size) {
            // if (checkWord(pattern, str)) {

            // var values = lines.getOrDefault(k, new ArrayList<String>());
            // values.add(String.valueOf((i + 1)));
            // lines.put(k, values);
            // hasMatch = true;

            // // System.out.println("word" + (i + 1));
            // } else if (checkReverse(pattern, str)) {
            // var values = lines.getOrDefault(k, new ArrayList<String>());
            // values.add(String.valueOf((i + 1)));
            // lines.put(k, values);
            // hasMatch = true;
            // // System.out.println("wordReverse" + (i + 1));

            // } else if (checkUpper(pattern, str)) {
            // var values = lines.getOrDefault(k, new ArrayList<String>());
            // values.add(String.valueOf((i + 1)));
            // lines.put(k, values);
            // hasMatch = true;
            // // System.out.println("wordUpper" + (i + 1));

            // } else if (checkReverseUpper(pattern, str)) {
            // var values = lines.getOrDefault(k, new ArrayList<String>());
            // values.add(String.valueOf((i + 1)));
            // lines.put(k, values);
            // hasMatch = true;
            // // System.out.println("wordReverseUpper" + (i + 1));

            // }
            // c = 0;
            // str = "";
            // break;

            // }
            // }
            // }
            // if (!hasMatch) {
            // var list = new ArrayList<String>();
            // list.add("Substring not found");
            // lines.put(k, list);
            // }
        }

        for (var line : lines.entrySet()) {

            // Printing all elements of a Map
            System.out.println(line.getKey() + " = "
                    + line.getValue());
        }
    }

    public static boolean checkWord(String pattern, String word) {
        return pattern.equals(word);
    }

    public static boolean checkReverse(String pattern, String word) {
        var reverse = "";
        for (int i = pattern.length() - 1; i >= 0; i--) {
            reverse += pattern.charAt(i);
        }
        return reverse.equals(word);

    }

    public static boolean checkUpper(String pattern, String word) {
        var reverse = "";
        for (int i = 0; i < pattern.length(); i++) {
            if (Character.isUpperCase(pattern.charAt(i))) {
                reverse += String.valueOf(pattern.charAt(i)).toLowerCase();
            } else {
                reverse += String.valueOf(pattern.charAt(i)).toUpperCase();
            }
        }

        return reverse.equals(word);
    }

    public static boolean checkReverseUpper(String pattern, String word) {
        var reverseStr = "";
        var reverseUpper = "";
        for (int i = pattern.length() - 1; i >= 0; i--) {
            reverseStr += pattern.charAt(i);
        }
        for (int i = 0; i < pattern.length(); i++) {
            if (Character.isUpperCase(reverseStr.charAt(i))) {
                reverseUpper += String.valueOf(reverseStr.charAt(i)).toLowerCase();
            } else {
                reverseUpper += String.valueOf(reverseStr.charAt(i)).toUpperCase();
            }

        }
        return reverseUpper.equals(word);

    }
}
