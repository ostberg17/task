package com.task1;
/**
 * Have the function MatrixChallenge(strArr) take the strArr parameter
 * being passed which will be a 2D matrix of 0 and 1’s, and determine
 * the area of the largest square submatrix that contains all 1's.
 * A square submatrix is one of equal width and height, and your program
 * should return the area of the largest submatrix that contains only 1's.
 */

import java.util.Scanner;

public class MaximalSquare {

    public static void main(String[] args) {
//        int matrix[][] = {{0,1,1,1},
//                {1, 1, 1, 1},
//                {1, 1, 1, 1},
//                {1, 1, 1, 1}};
        Scanner input = new Scanner(System.in);

        System.out.println("Input matrix, use format like 0111,1111,1111,1111");
        String[] sub = input.nextLine().split(",");
        int [][] inputMatrix = new int[sub.length][sub[0].length()];

        for (int i = 0; i < sub.length; i++) {
            for (int j = 0; j < sub[0].length(); j++) {
                inputMatrix[i][j] = Character.getNumericValue(sub[i].charAt(j));
            }
        }

        int maxSubSquare = MatrixChallenge(inputMatrix);
        System.out.println("The largest square submatrix that contains all 1's: "+maxSubSquare);
    }

    /**
     * find looking for an area of our square
     * @param mass
     * @return
     */
    private static int MatrixChallenge(int[][] mass) {
        for (int probableMaxSquare = mass.length; probableMaxSquare >0 ; probableMaxSquare--) {
            for (int row = 0; row < mass.length-probableMaxSquare+1; row++) {
                for (int col = 0; col < mass.length-probableMaxSquare+1; col++){
                    if (check(mass,row,col,probableMaxSquare)) {
                        return probableMaxSquare*probableMaxSquare;
                    }
                }
            }
        }
        return 0;
    }

    /**
     * check whether there is a probable square in the matrix
     * @param mass our matrix
     * @param row row of our matrix
     * @param col column of our matrix
     * @param probableSquare size of probable square
     * @return is probable square in matrix or not
     */
    private static boolean check(int[][] mass, int row, int col, int probableSquare) {
        for (int j = 0; j < probableSquare; j++){
            if (mass[row][col+j] == 0) {
                return false;
            }
            if (mass[row+probableSquare-1][col+j] == 0){
                return false;
            }
        }

        for (int i=0; i < probableSquare - 1; i++){
            if (mass[row+i][col] == 0){
                return false;
            }
            if (mass[row+i][col+probableSquare-1] == 0){
                return false;
            }
        }
        return true;
    }
}
