package org.holmes.probability;

import java.util.Random;

/**
 *
 */
public class Monty {
    public static final char[] doors = {'A', 'B', 'C'};

    public static char choice(char[] doors) {
        final Random r = new Random();
        final int s = r.nextInt(doors.length);
        return doors[s];
    }

    /**
     * 求两个数组的差集
     *
     * @param a1
     * @param a2
     * @return
     */
    public static char[] substract(char[] a1, char[] a2) {
        char[] tmp = new char[a1.length];
        int length = 0;
        for (char c1 : a1) {
            boolean found = false;
            for (char c2 : a2) {
                if (c1 == c2) {
                    found = true;
                    break;
                }
            }
            if (found) {
                continue;
            }
            tmp[length++] = c1;
        }

        char[] r = new char[length];
        for (int i = 0; i < length; i++) {
            r[i] = tmp[i];
        }
        return r;
    }

    public static void usage() {
        System.out.println("usage");
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            usage();
            return;
        }

        final int times = Integer.parseInt(args[0]);
        final boolean change = args[1].equals("change");
        int bingo = 0;
        int sorry = 0;
        for (int i = 0; i < times; i++) {
            char you = choice(doors);
            final char car = choice(doors);
            final char goat = choice(substract(doors, new char[]{you, car}));

            if (change) {
                you = choice(substract(doors, new char[]{you, goat}));
            }

            if (you == car) {
                bingo++;
            }
            else {
                sorry++;
            }
        }

        String result = String.format("bingo = %.2f%%, sorry = %.2f%%", bingo * 100.00 / times, sorry * 100.00 / times);
        System.out.println(result);
    }
}
