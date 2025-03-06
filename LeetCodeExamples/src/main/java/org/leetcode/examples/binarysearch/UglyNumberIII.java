package org.leetcode.examples.binarysearch;

//Write a program to find the n-th ugly number. Ugly numbers are positive integers which are divisible by a or b or c.
//
//Example :
//
//Input: n = 3, a = 2, b = 3, c = 5
//Output: 4
//Explanation: The ugly numbers are 2, 3, 4, 5, 6, 8, 9, 10... The 3rd is 4.
//Input: n = 4, a = 2, b = 3, c = 4
//Output: 6
//
//Explanation: The ugly numbers are 2, 3, 4, 6, 8, 9, 10, 12... The 4th is 6.
//Nothing special. Still finding the Kth-Smallest. We need to design an enough function, given an input num,
//determine whether there are at least n ugly numbers less than or equal to num. Since a might be a multiple of b or c,
//or the other way round, we need the help of greatest common divisor to avoid counting duplicate numbers.

public class UglyNumberIII {

    public static int nthUglyNumber(int n, int a, int b, int c) {
        long ab = lcm(a, b);
        long ac = lcm(a, c);
        long bc = lcm(b, c);
        long abc = lcm((int) ab, c);

        long left = 1, right = 10000000000L;
        while (left < right) {
            long mid = left + (right - left) / 2;
            if (enough(mid, a, b, c, ab, ac, bc, abc, n)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return (int) left;
    }

    private static boolean enough(long num, int a, int b, int c, long ab, long ac, long bc, long abc, int n) {
        long total = num / a + num / b + num / c - num / ab - num / ac - num / bc + num / abc;
        return total >= n;
    }


    private static long lcm(int x, int y) {
        return (long) x * (y / (int) gcd(x, y));
    }

    private static long gcd(int x, int y) {
        while (y != 0) {
            long temp = y;
            y = x % y;
            x = (int) temp;
        }
        return x;
    }

    public static void main(String[] args) {
        int n = 5, a = 2, b = 3, c = 5;
        System.out.println(nthUglyNumber(n, a, b, c));
    }
}
