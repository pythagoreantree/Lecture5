package hexlet.code;

import org.apache.commons.lang3.StringUtils;

public class TasksClue {

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
        if (days < 2) return days;

        //разделить days на недели
        int daysInWeek = 7;
        int fullWeeks = days / daysInWeek;
//        int daysLeft = days % 7;
        int daysLeft = days - fullWeeks * daysInWeek;

        int totalSum = 0;
        //итерируемся по неделям и считаем суммы
        //формула арифметической прогрессии S = (a1 + an) * n / 2 или S = (2*a1 + d*(n - 1)) * n / 2
        for (int i = 1; i <= fullWeeks; i++) {
            int sum = (2*i + daysInWeek - 1) * daysInWeek / 2;
            totalSum += sum;
        }

        if (daysLeft > 0) {
            totalSum += (2 * (fullWeeks + 1) + (daysLeft - 1)) * daysLeft / 2;
        }

        return totalSum;
    }

    private static int calcSum(int i) {
        int sum = 0;
        for (int j = i; j < (i + 7); j++) {
            sum += j;
        }
        return sum;
    }

    public static int calculateDepositII(int days) {
        if (days < 2) return days;

        //разделить days на недели
        int daysInWeek = 7;
        int fullWeeks = days / daysInWeek;
//        int daysLeft = days % 7;
        int daysLeft = days - fullWeeks * daysInWeek;

        if (fullWeeks == 0) {
            int sum = 0;
            for (int i = 1; i <= daysLeft; i++) {
                sum += i;
            }
            return sum;
        }

        int totalSum = 0;

        int currentWeekSum = 0;
        for (int i = 1; i <= daysInWeek; i++) {
            currentWeekSum += i;
        }

        totalSum += currentWeekSum;

        for (int currentWeekStart = 2; currentWeekStart <= fullWeeks; currentWeekStart++) {
            int prevWeekStartStart = currentWeekStart - 1;
            currentWeekSum -= prevWeekStartStart;
            currentWeekSum += prevWeekStartStart + daysInWeek;
            totalSum += currentWeekSum;
        }

        if (daysLeft > 0) {
            int currentWeek = fullWeeks + 1;
            for (int i = currentWeek; i < (currentWeek + daysLeft); i++) {
                totalSum += i;
            }
        }

        return totalSum;
    }

    /*
     * Звездочки
     *
     * Задача 1: Строка a2b3c5 после разжатия становится строкой aabbbccccc. Сделать encode/decode
     *
     * Задача 2: Есть 2 строки. В каждой известны какие-то символы. Если какие-то символы неизвестны,
     *           то они кодируются количеством этих символов. Т.е. если написано A5b, значит строка состоит
     *           из 7 символов, из которых известны только A и b, а все что между ними неизвестно.
     *           Проверить, могут ли две данные строки быть равны.
     * */
    public static String encode(String inputString) {
        if (inputString == null || inputString.length() <= 1) return inputString;

        StringBuilder sb = new StringBuilder();

        int counter = 1;
        char prev = inputString.charAt(0);
        for (int i = 1; i < inputString.length(); i++) {
            char current = inputString.charAt(i);
            if (current == prev) {
                counter++;
            } else {
                sb.append(Character.valueOf(prev).toString());
                sb.append(counter > 1? String.valueOf(counter): "");
                counter = 1;
                prev = current;
            }
        }

        if (counter > 1) {
            sb.append(String.valueOf(prev) + counter);
        }
        return sb.toString();
    }

    private static boolean isEqual(char current, char prev) {
        String first = String.valueOf(current).toLowerCase();
        String second = String.valueOf(prev).toLowerCase();
        return first.equals(second);
    }

    public static boolean mayBeTheSame(String string1, Integer l1, String string2, Integer l2) {

        if (l1 != l2) {
            return false;
        }

        if (l1 == l2 && l1 == 0) {
            return true; //?
        }

        int len = l1;

        int i = 0;
        int fp = 0;
        int sp = 0;

        String c1 = "", c2 = "";

        int credit1 = 0;
        int credit2 = 0;

        while (i < len) {

            if (credit1 == 0) {
                c1 = Character.toString(string1.charAt(fp));
                credit1 = getCredit(c1);
                fp++;
            }

            if (credit2 == 0) {
                c2 = Character.toString(string2.charAt(sp));
                credit2 = getCredit(c2);
                sp++;
            }

            if (credit1 == 0 && credit2 == 0 && !c1.equals(c2)) {
                return false;
            }

            if (credit1 != 0) credit1--;
            if (credit2 != 0) credit2--;

            i++;
        }

        return true;
    }

    private static int getCredit(String c) {
        return StringUtils.isNumeric(c)? Integer.parseInt(c): 0;
    }
}
