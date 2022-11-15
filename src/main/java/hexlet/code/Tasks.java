package hexlet.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tasks {

    /*
    * Один человек хотел накопить денег на видеокарту и у него родился следующий план накоплений.
    * Каждый день недели он будет откладывать на 1 рубль больше, чем в предыдущий, а каждый понедельник
    * на 1 рубль больше, чем в прошлый понедельник. Начать он решил с 1 рубля в понедельник. Нужно будет
    * написать программу, которая будет определять, сколько рублей будет у человека через N дней.
    *
    * 1 <= N <= 1000
    *
    * Примеры:
    * 6 дней: 1 + 2 + 3 + 4 + 5 + 6 = 21
    * 10 дней: (1 + 2 + 3 + 4 + 5 + 6 + 7) + (2 + 3 + 4) = 37
    * */
    public static int calculateDeposit(int days) {
        int weekCount = days / 7;
        int sum = 0;
        int dayLeft = days % 7;

        for (int i = 1; i <= weekCount; i++) {
            int last = i + 6;
            sum += sumProgress(i, last, 7);
        }

        sum += sumProgress(weekCount + 1, weekCount + dayLeft, dayLeft);
        return sum;
    }

    public static int sumProgress(int a, int b, int n) {
        return (a + b) * n / 2;
    }

    /*
    * Звездочки
    *
    * Задача 1: Строка a2b3c5 после разжатия становится строкой aabbbccccc. Сделать encode
    *
    * Задача 2: Есть 2 строки. В каждой известны какие-то символы. Если какие-то символы неизвестны,
    *           то они кодируются количеством этих символов. Т.е. если написано A5b, значит строка состоит
    *           из 7 символов, из которых известны только A и b, а все что между ними неизвестно.
    *           Проверить, могут ли две данные строки быть равны.
    * */
    public static String encode(String inputString) {
        return null;
    }

    public static boolean mayBeTheSame(String string1, Integer l1, String string2, Integer l2) {
        return true;
    }

    /*
     * У нас есть пирамида, которая состоит из кирпичей, которые уложены друг на друга.
     * Каждый кирпич весит 1 кг, и при этом к каждому кирпичу на нижнем уровне добавляется часть веса предыдущих (см. картинку).
     * Нужно вычислить вес дельты для кирпича в определенной позиции.
     *
     * w(0, 0) = 0
     * w(1, 0) = w(1, 1) = 0.5
     * w(2, 0) = 0.75, w(2, 1) = 1.5, w(2, 2) = 0.75
     * */
    public static List<List<Double>> weights = new ArrayList<>();
    public static double getBrickWeight(int i, int j) {
        double first = 1.0;
        List<Double> list = new ArrayList<>();
        list.add(first);
        weights.add(list);

        for (int row = 1; row <= i; row++) {
            List<Double> rowList = new ArrayList<>();
            List<Double> prevRow = weights.get(row - 1);
            for (int col = 0; col <= row; col++) {
                double brickWeight = 1.0;
                if (col == 0 || col == row) {
                    brickWeight += prevRow.get(0) / 2;
                } else {
                    brickWeight += prevRow.get(col - 1) / 2 + prevRow.get(col) / 2;
                }
                rowList.add(brickWeight);
            }
            weights.add(rowList);
        }
        return weights.get(i).get(j) - 1.0;
    }


    public static Map<String, Double> dp = new HashMap();
    public static double getBrickWeightII(int i, int j) {
        if (i == 0 && j == 0)
            return 1.0;
        if (dp.containsKey(i + "-" + j)) {
            return dp.get(i + "-" + j);
        }

        double weight = 0.0;
        if (j == 0) {
            weight = 1 + getBrickWeightII(i - 1, j) / 2;
        } else if (i == j) {
            weight = 1 + getBrickWeightII(i - 1, j - 1) / 2;
        } else {
            weight = 1 + getBrickWeightII(i - 1, j - 1) / 2 + getBrickWeightII(i - 1, j) / 2;
        }
        dp.put(i + "-" + j, weight);
        return weight;
    }


}
