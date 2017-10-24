/*
 * Big-O demonstration exercise using exercise 21 from textbook
 * Implement a "bogus" sorting algorithm called bogo sort that uses your 
 * shuffling algorithm from the previous exercise to sort an array of numbers.
 * The bogo sort algorithim is the following:
 *
 * while (array is not sorted) {
 *      shuffle array
 * }
 *
 * Created by David Johnson, October 22, 2017
 * for CS211 course, Bellevue College
 */
package bogosort;

import java.util.*;

public class Testing {

    public static void main(String[] args) {
        int N = 6;
        int[] list = new int[N];
        long time = 0;
        Random r = new Random();
        
        System.out.println("N = " + N);
        for (int passes = 0; passes < 10; passes++) {
            for (int i = 0; i < N; i++) {
                list[i] = r.nextInt(100);
            }
            time = System.currentTimeMillis();
            bogoSort(list);
            System.out.println("Sort took " + (System.currentTimeMillis() - time) + " ms");
        }
    }
    
    public static void bogoSort(int[] numbers) {
        while (!(isSorted(numbers))) {
            shuffle(numbers);
        }
    }
    
    public static boolean isSorted(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            if (!(numbers[i] <= numbers[i + 1])) {
                return false;
            }
        }
        return true;
    }
    
    public static void shuffle(int[] numbers) {
        Random rand = new Random();
        int j = -1;
        for (int i = 0; i < numbers.length; i++) {
            // j MUST be >= i in order for this to work properly
            while (j < i) {
                j = rand.nextInt(numbers.length);
            }
            // Swap the numbers
            int temp = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = temp;
        }
    }
    
}
