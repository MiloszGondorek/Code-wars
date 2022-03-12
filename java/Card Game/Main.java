// task url: https://www.codewars.com/kata/61fef3a2d8fa98021d38c4e5/train/java
class Solution {
    public static long cardGame(long cards) {
        long a = 0;
        boolean aMove = true;
        while (cards > 0) {
            if (cards % 2 == 1) {
                if (aMove)
                    a++;
                cards--;
            } else {
                long x = cards / 2;
                if (x % 2 == 0 && cards != 4) {
                    if (aMove)
                        a++;
                    cards--;
                } else {
                    if (aMove)
                        a += cards / 2;
                    cards /= 2;
                }
            }
            aMove = !aMove;
        }
        return a;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(Solution.cardGame(492036915780312576l));
    }
}
