public class Task3 {
    /*
    написать алгоритм, как в целом числе самый правый ноль превратить в единицу не используя циклы и рекурсию.
     */


    public static void main(String[] args) {

////        if binary number
//        int example = 1001010101;
//
//        System.out.println(Integer.toBinaryString(
//                Integer.parseInt(example + "", 2) |
//                        (Integer.parseInt(example + "", 2) +
//                                Integer.parseInt(1 + "", 2))));

////        if decimal number
        int example = 503040602;

        String result = new StringBuilder(new StringBuilder(example + "").reverse()
                .toString().replaceFirst("0", "1")).reverse().toString();
        System.out.println(result);
    }
}
