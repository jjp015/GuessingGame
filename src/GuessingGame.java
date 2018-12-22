// @author: Jeremy Park
// @email:  jjp015@ucsd.edu

// @compile: javac GuessingGame.java
// @run:     java GuessingGame.java


import java.util.Scanner;

/**
 * The GuessingGame class program contains the main method that the user
 * will determine if the right number was guessed from the computer
 */
public class GuessingGame {
    /**
     * The main method starts at program execution, take two user inputs for
     * the minimum and maximum boundary, and the user will determine if the
     * number was guessed right from the computer between the boundaries
     */
    public static void main(String[] args) {
        int minNum;
        int maxNum;
        int midMinMax;       // average of min and max numbers
        char checkGuess;     // response for computer guess

        Scanner scnr = new Scanner(System.in);

        System.out.println("Your number is in this range...(enter 2 numbers)");
        minNum = scnr.nextInt();  // store user input number as minimum
        maxNum = scnr.nextInt();  // store user input number as maximum

        /* If the first input entered is greater than the second, swap so it
         * will correctly store in the right variable
         * */
        int temp;
        if (minNum > maxNum) {
            temp = minNum;
            minNum = maxNum;
            maxNum = temp;
        }

        /* Instructions for user input; inputs are sane to computer's response
         * and obvious answers outputted
         */
        System.out.println("Type 'h' for too high, 'l' for 'too low', and " +
                "'c' if I got it right");
        do {
            midMinMax = (minNum + maxNum) / 2;
            System.out.println("Is it " + midMinMax + "?");
            checkGuess = scnr.next().charAt(0);   // user's input response of guess

            // split range of numbers to upper half and guess middle number
            if(checkGuess == 'l') {
                minNum = midMinMax + 1;
                midMinMax = (minNum + maxNum) / 2;
            }

            // split range of numbers to bottom half and guess middle number
            else if(checkGuess == 'h') {
                maxNum = midMinMax - 1;
                midMinMax = (minNum + maxNum) / 2;
            }

            // break out after last number remaining found
            if(minNum == maxNum) {
                System.out.println("We're left with one number...");
                break;
            }
        }while(checkGuess != 'c');

        System.out.println("It's " + midMinMax + "!");

        return;
    }
} // End of public class GuessingGame
