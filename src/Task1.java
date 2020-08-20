import java.util.*;
import java.util.stream.Collectors;

public class Task1 {
    /*
    имеется массив чисел, получить список вида {число, количество вхождений числа в массив},
    список должен быть отсортирован по количеству вхождений, внутри по возрастания числа.
    Использовать можно любой алгоритмический язык.
     */

    public static void main(String[] args) {
        int[] originalArray = new int[100000];
        originalArray = Arrays.stream(originalArray).map(n -> new Random().nextInt(100)).toArray();

        Map<Integer, Integer> result = new HashMap<>();

        for(int i = 0; i < originalArray.length; i++) {
            if (i == 0) {
                result.put(originalArray[i], 1);
            } else {
                if (result.get(originalArray[i]) != null)
                    result.put(originalArray[i], result.get(originalArray[i]) + 1);
                else
                    result.put(originalArray[i], 1);
            }
        }

        result = result.entrySet().stream().sorted((o1, o2) -> ! o1.getValue().equals(o2.getValue()) ?
                o2.getValue().compareTo(o1.getValue()) :
                o1.getKey().compareTo(o2.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (x, y) -> y, LinkedHashMap::new));
        System.out.println("size: " + result.size() + "\n" + result);
    }

}
