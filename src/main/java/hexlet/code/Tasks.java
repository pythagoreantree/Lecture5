package hexlet.code;

import java.util.ArrayList;
import java.util.List;

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
       return 0;
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
        return 0.0;
    }


}