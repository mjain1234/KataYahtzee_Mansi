package katayahtzee_mansi;

import java.util.Random;
import java.util.*;

/**
 *
 * @author Mansi
 *
 */
class dice {

    int[] values = {1, 2, 3, 4, 5, 6};
    int score = getRandom(values);//value of the dice

    //function to get value for the dice after rolling the dice
    int getRandom(int[] array) {
        int rnd = new Random().nextInt(array.length); // randon function to generate value
        return array[rnd];
    }

}

public class KataYahtzee_Mansi {

    static int points;//points for the user for one chance
    static int Finalpoints; // total points of the user

    public static void main(String[] args) {

        int diceScores[] = new int[5];//array for 5 dices
        String tryAgain;
        int count = 1;
        Scanner reader = new Scanner(System.in);  // Reading from System.in

        System.out.println("----------------------Game Yatzee--------------");
        do {
            points = 0;
            System.out.println("Please choose a category.");

            System.out.println("1.Pair: The player scores the sum of the two highest matching dice.");
            System.out.println("2.Two pairs: If there are two pairs of dice with the same number, the player scores the sum of these dice. ");
            System.out.println("3.Three of a kind: If there are three dice with the same number, the player scores the sum of these dice.");
            System.out.println("4.Small straight: If the dice read 1,2,3,4,5, the player scores 15 (the sum of all the dice), otherwise 0.");
            System.out.println("5.Yahtzee: If all dice are the have the same number, the player scores 50 points, otherwise 0.");
            System.out.println("Enter a number: ");
            int n = reader.nextInt(); // accept user's choice

            dice d1 = new dice();//creating object for dice 

            KataYahtzee_Mansi kata = new KataYahtzee_Mansi();//creating object for KataYahtzee_Mansi

            //get values for 5 dices into an array
            for (int i = 0; i < 5; i++) {
                diceScores[i] = d1.getRandom(d1.values);
                System.out.println(diceScores[i]);
            }

            //sort the array
            Arrays.sort(diceScores);
            System.out.println(Arrays.toString(diceScores));

            //check user's choice
            switch (n) {
                case 1:
                    //for one pair
                    kata.checkPairs(diceScores);
                    break;
                case 2:
                    //for Two pairs
                    kata.checkTwoPairs(diceScores);
                    break;
                case 3:
                    //for Three of a kind
                    kata.checkThreeOfAKind(diceScores);
                    break;
                case 4:
                    //for Small straight 
                    kata.smallStraight(diceScores);
                    break;
                case 5:
                    //for Yahtzee
                    kata.yahtzee(diceScores);
                    break;

            }

            System.out.println("Try again? Yes: Y No: N");
            tryAgain = reader.next();
            count = count + 1;

        } while (tryAgain.equals("Y") && count < 4);//end of loop

        //Print user's total points
        System.out.println("Final Score:" + KataYahtzee_Mansi.Finalpoints);
    }

    //Methods
    //To check if there are two pairs
    public int checkTwoPairs(int[] arr) {
        int i = 0;
        int j = 1;
        int pair = 0;
        KataYahtzee_Mansi.points = 0;
        while (i < arr.length && j < arr.length) {
            if (arr[i] == arr[j]) { //if two consecutive elements have same value
                pair = pair + 1;
                KataYahtzee_Mansi.points = KataYahtzee_Mansi.points + arr[i] * 2; //add addition of the both values in the points for this round
                i = i + 2;//get the next to next index
                j = i + 1;
            } else {
                i = i + 1;
                j = i + 1;
            }
        }

        if (pair == 2) {//check if there are 2 pairs
            System.out.println("Congratulations..You won Two Pairs");
            System.out.println("Your points:" + KataYahtzee_Mansi.points);
        } else {
            System.out.println("Oops...No score!");
            KataYahtzee_Mansi.points = 0;
            System.out.println("Your points:" + KataYahtzee_Mansi.points);
        }
        KataYahtzee_Mansi.Finalpoints = KataYahtzee_Mansi.Finalpoints + KataYahtzee_Mansi.points;
        return KataYahtzee_Mansi.points;
    }

    //to check if there is one pair present
    public int checkPairs(int[] arr) {
        int i = 0;
        int j = 1;
        int pair = 0;
        while (i < arr.length && j < arr.length) {
            if (arr[i] == arr[j]) {//if two consecutive elements have same value
                pair = pair + 1;
                KataYahtzee_Mansi.points = arr[i] * 2;
                i = i + 2;//get the next to next index
                j = i + 1;
            } else {
                i = i + 1;
                j = i + 1;
            }
        }

        if (KataYahtzee_Mansi.points > 0) {//check if there are some points achieved
            System.out.println("Congratulations..You won One Pairs");
            System.out.println("Your points:" + KataYahtzee_Mansi.points);
        } else {
            System.out.println("Oops...No score!");
            KataYahtzee_Mansi.points = 0;
            System.out.println("Your points:" + KataYahtzee_Mansi.points);
        }
        KataYahtzee_Mansi.Finalpoints = KataYahtzee_Mansi.Finalpoints + KataYahtzee_Mansi.points;
        return KataYahtzee_Mansi.points;
    }

    //to check if there are three elements of the same kind
    public int checkThreeOfAKind(int[] arr) {
        int i = 0;
        int j = 1;

        while (i < arr.length && j < arr.length) {
            if (arr[i] == arr[j]) {//if two consecutive elements have same value
                if (i + 1 < arr.length && j + 1 < arr.length && arr[i + 1] == arr[j + 1]) {
                    KataYahtzee_Mansi.points = arr[i] * 3;
                    i = i + 2;//get the next to next index
                    j = i + 1;
                } else {
                    i = i + 1;
                    j = i + 1;
                }
            } else {
                i = i + 1;
                j = i + 1;
            }
        }

        if (KataYahtzee_Mansi.points > 0) {//check if there are some points achieved
            System.out.println("Congratulations..You won Three of a kind");
            System.out.println("Your points:" + KataYahtzee_Mansi.points);
        } else {
            System.out.println("Oops...No score!");
            KataYahtzee_Mansi.points = 0;
            System.out.println("Your points:" + KataYahtzee_Mansi.points);
        }
        KataYahtzee_Mansi.Finalpoints = KataYahtzee_Mansi.Finalpoints + KataYahtzee_Mansi.points;
        return KataYahtzee_Mansi.points;
    }

    //to check if there is small straight in the dice,i.e.,if elements are 1,2,3,4,5 
    public int smallStraight(int[] arr) {
        int i = 0;
        int j = 1;
        KataYahtzee_Mansi.points = 0;
        while (j < arr.length) {
            if (arr[i] == arr[j] - 1) { //if two consecutive elements are consecutive numbers
                KataYahtzee_Mansi.points = KataYahtzee_Mansi.points + arr[i];
                i = i + 1;
                j = j + 1;
                if (j == 4) {
                    KataYahtzee_Mansi.points = KataYahtzee_Mansi.points + arr[j];
                }
            } else {
                KataYahtzee_Mansi.points = 0;
            }
        }

        if (KataYahtzee_Mansi.points == 15) { //check if the numbers' total is 15
            System.out.println("Congratulations..You won Small Straight");
            System.out.println("Your points:" + KataYahtzee_Mansi.points);
        } else {
            System.out.println("Oops...No score!");
            KataYahtzee_Mansi.points = 0;
            System.out.println("Your points:" + KataYahtzee_Mansi.points);
        }
        KataYahtzee_Mansi.Finalpoints = KataYahtzee_Mansi.Finalpoints + KataYahtzee_Mansi.points;
        return KataYahtzee_Mansi.points;
    }

    //to check if there is small straight in the dice,i.e.,if elements are 1,2,3,4,5 
    public int yahtzee(int[] arr) {
        KataYahtzee_Mansi.points = 0;
// to check if all dice have same value
        if (arr[0] == arr[1] && arr[1] == arr[2] && arr[2] == arr[3] && arr[3] == arr[4]) { //if two consecutive elements are consecutive numbers
            KataYahtzee_Mansi.points = 50;
        } else {
            KataYahtzee_Mansi.points = 0;
        }

        if (KataYahtzee_Mansi.points == 50) { //check if the numbers' total is 15
            System.out.println("Congratulations..You won Small Straight");
            System.out.println("Your points:" + KataYahtzee_Mansi.points);
        } else {
            System.out.println("Oops...No score!");
            KataYahtzee_Mansi.points = 0;
            System.out.println("Your points:" + KataYahtzee_Mansi.points);
        }
        KataYahtzee_Mansi.Finalpoints = KataYahtzee_Mansi.Finalpoints + KataYahtzee_Mansi.points;
        return KataYahtzee_Mansi.points;
    }

}
