package org.leetcode.examples.patterns.fastandslowpointers;

public class HappyNumber {

    static int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /=10;
        }
        return sum;
    }

    //USING TECHNIQUE - BEST PERFORMANCE
    static boolean isHappy(int n){
        int slow = n;
        int fast = getNext(n);

        while(fast != 1 && slow != fast){
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        return fast == 1;
    }

}
