import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task2 {
    /*
    написать алгоритм проверки корректности регулярного выражения, которое включает [,],(,)
т.е., например ([][[]()]) - правильно, ([][]()]) – неправильно
     */

    public static void main(String[] args) {
        List<String> regExs = new ArrayList<>();
        regExs.add("[][[]()]"); // correct
        regExs.add("[]([[]()])"); // correct
        regExs.add("[([][])]"); // correct
        regExs.add("[[][[]()]]"); // correct
        regExs.add("[][[]()]"); // correct
        regExs.add("[][][][]()]"); // incorrect
        regExs.add("[][[)(]][()]"); // incorrect
        regExs.add("[][]()]"); // incorrect
        regExs.add("[]([[(]()])"); // incorrect
        regExs.add("[]([[]())]"); // incorrect
        regExs.add("][[[][[](])]"); // incorrect
        regExs.add("(()[)](())([])[[]])("); // incorrect

        List<Boolean> result = check(regExs);
        System.out.println(result);

    }

    public static List<Boolean> check(List<String> regEx) {
        List<Boolean> result = new ArrayList<>();
        Map<Integer, Character> lvlMap = new HashMap<>();
        for(String str : regEx) {
            char[] originals = str.toCharArray();
            if (originals[0] != '[' && originals[0] != '(' ||
                    originals[originals.length - 1] != ']' && originals[originals.length - 1] != ')') {
                result.add(false);
                continue;
            }
            int lvl = 0;
            boolean correct = true;
            for (char original : originals) {
                if (original == '[' || original == '(') {
                    lvlMap.put(++lvl, original);
                    continue;
                }
                if (original == ']') {
                    if (lvlMap.get(lvl) == null || '[' != lvlMap.get(lvl)) {
                        correct = false;
                        break;
                    }
                    lvl--;
                }
                if (original == ')') {
                    if (lvlMap.get(lvl) == null || '(' != lvlMap.get(lvl)) {
                        correct = false;
                        break;
                    }
                    lvl--;
                }
            }
            if(correct)
                result.add(true);
            else
                result.add(false);

        }
        return result;
    }
}
