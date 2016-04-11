# KataYahtzee_Mansi
This repository is made for Cardinal Fuse coding challenge and it ontains source code for KataYahtzee game and its JUnit test.

I have implemented below 5 cases from the requirements:

1. Pair: The player scores the sum of the two highest matching dice. 

2. Two pairs: If there are two pairs of dice with the same number, the player scores the sum of these dice. 

3. Three of a kind: If there are three dice with the same number, the player scores the sum of these dice.

4. Small straight: If the dice read 1,2,3,4,5, the player scores 15 (the sum of all the dice), otherwise 0.

5. Yahtzee: If all dice are the have the same number, the player scores 50 points, otherwise 0.

TO implement this game:

Common Logic

1. I have created an array with values {1,2,3,4,5,6} these are possible dice values. 

2. Then I have sent this array to a random number generator function getRandom, that will give a random value out of above created array.

3. I am looping step 2nd 5 times to get five random numbers between 1-6 for five dices.

4. Now I am storing these random number to an array --> diceScores

5. Now, I am sorting this array in increasing order so I have sorted array for each methods(logic for each category).


Users view:

User will be asked to choose from above cases. enter (1-5)

A user can play this game for with three chances.

Each category points will be shown.

Final points will be shown after 3 chances.

I have also written Junit test for this program based on values form the Yatzee game problem link provided to me. 


