
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.print.attribute.SetOfIntegerSyntax;

public class App2 {
    public static void main(String[] args) {
        var stations = new HashMap<String, ArrayList<int[]>>();
        double shortestDistance;
        int[] firstDistance = {};

        var size = Integer.parseInt(System.console().readLine());
        for (int i = 0; i < size; i++) {
            var value = new ArrayList<int[]>();
            var input = System.console().readLine().split(" ");

            value = stations.getOrDefault(input[0], new ArrayList<int[]>());
            value.add(Arrays.stream(input[1].split(",")).mapToInt(Integer::parseInt).toArray());
            stations.put(input[0], value);
            if (i == 0) {
                firstDistance = Arrays.stream(input[1].split(",")).mapToInt(Integer::parseInt).toArray();
            }
        }

        var start = Arrays.stream(System.console().readLine().split(",")).mapToInt(Integer::parseInt).toArray();
        shortestDistance = calDistance(start, firstDistance);

        var nearest_stations = new HashMap<String, ArrayList<int[]>>();
        for (var set : stations.values()) {
            for (var distance : set) {
                if (calDistance(start, distance) <= shortestDistance) {
                    shortestDistance = calDistance(start, distance);
                }
            }
        }

        var tempStations = new HashMap<>(stations);
        for (var set : tempStations.entrySet()) {

            for (var distance : set.getValue()) {
                var value = new ArrayList<int[]>();

                if (calDistance(start, distance) == shortestDistance) {

                    value = nearest_stations.getOrDefault(set.getKey(), new ArrayList<int[]>());
                    value.add(distance);
                    nearest_stations.put(set.getKey(), value);
                }
            }
        }

        System.out.println("The nearest station(s) to you:");
        sortbykey(nearest_stations);
        System.out.println("about " + ((int) shortestDistance) + " meters away from you");

    }

    public static double calDistance(int[] start, int[] distance) {
        return Math.sqrt(((Math.pow((distance[0] - start[0]), 2)) + (Math.pow((distance[1] - start[1]), 2))));
    }

    public static void sortbykey(Map<String, ArrayList<int[]>> map) {

        ArrayList<String> sortedKeys = new ArrayList<String>(map.keySet());

        Collections.sort(sortedKeys);

        for (var sets : map.entrySet()) {
            System.out.print(sets.getKey() + " ");
            for (var value : sets.getValue()) {
                System.out.print("at (");
                System.out.print(value[0]);
                System.out.print(", ");
                System.out.print(value[1]);
                System.out.print(")");
                System.out.println();
            }
        }

    }
}
