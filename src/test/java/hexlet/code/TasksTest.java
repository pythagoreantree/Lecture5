package hexlet.code;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TasksTest {

    @Disabled
    @Test
    void calculateDeposit() {
        int sixDaysSum = Tasks.calculateDeposit(6);
        System.out.println(sixDaysSum);
        assertEquals(21, sixDaysSum);

        int tenDaysSum = Tasks.calculateDeposit(10);
        System.out.println(tenDaysSum);
        assertEquals(37, tenDaysSum);

        int fifteenDaysSum = Tasks.calculateDeposit(15);
        System.out.println(fifteenDaysSum);
        assertEquals(66, fifteenDaysSum);

        int oneDaySum = Tasks.calculateDeposit(1);
        assertEquals(1, oneDaySum);
    }

    @Disabled
    @Test
    void encode() {
        String testString = "aabbbccccc";
        String resultString = Tasks.encode(testString);
        assertEquals("a2b3c5", resultString);

        String testString2 = "a";
        String resultString2 = Tasks.encode(testString2);
        assertEquals("a", resultString2);

        String testString3 = "abbbcdee";
        String resultString3 = Tasks.encode(testString3);
        assertEquals("ab3cde2", resultString3);

        String testString4 = "aaAAaaBBb";
        String resultString4 = Tasks.encode(testString4);
        assertEquals("a2A2a2B2b", resultString4);
    }

    @Test
    void mayBeTheSame() {
        String s1 = "1b4A";
        String s2 = "5aa";
        boolean ifSame = Tasks.mayBeTheSame(s1, 7, s2, 7);
        System.out.println(ifSame);
    }

    @Test
    void fizzbuzz() {
//        Tasks.fuzzbuzz();
    }

    @Test
    void getBrickWeight() {
        double delta = Tasks.getBrickWeight(1, 1);
        System.out.println(delta);

    }

    @Test
    void getBrickWeightII() {
        double delta = Tasks.getBrickWeightII(2, 1) - 1;
        System.out.println(delta);
    }
}