import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the matrixRotation function below.
    static void matrixRotation(int[][] matrix,int rotationNum) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) { 
            return;
        }
        
        if(rotationNum == 0) {
          displayBoard(matrix);
          return;
        }
        
        /*
        Example:
        
         1  2  3  4      2  3  4  8      3  4  8 12
         5  6  7  8      1  7 11 12      2 11 10 16
         9 10 11 12  ->  5  6 10 16  ->  1  7  6 15
        13 14 15 16      9 13 14 15      5  9 13 14
        
        */
        int rows = matrix.length; // x
        int cols = matrix[0].length; // y
        
        int ringNums = Math.min(rows,cols) / 2; // 2 rings
       
        for(int i = 0 ; i < ringNums; i++){
            // mod with num of elements in the ring
            int reducedRotationNum = rotationNum % ( 2*(rows + cols - 4*i ) - 4);
            for(int r = 0; r < reducedRotationNum; r++){
                // rotate top
                for(int y = i; y < cols - i - 1; y++){
                     int temp = matrix[i][y];
                     matrix[i][y]= matrix[i][y+1];
                     matrix[i][y+1] = temp;
                }
               // rotate right side
                for(int x = i; x < rows - i - 1; x++){
                    int temp = matrix[x][cols - i - 1];
                    matrix[x][cols - i - 1] =  matrix[x+1][cols - i - 1];
                    matrix[x+1][cols - i - 1] = temp;
                }
                // rotate bottom
                for(int y = cols - i - 1; y > i; y--){
                     int temp = matrix[rows - i - 1][y];
                     matrix[rows - i - 1][y]= matrix[rows - i - 1][y-1];
                     matrix[rows - i - 1][y-1] = temp;
                }
                
               // left
                for(int x = rows - i - 1; x > i + 1; x--){
                    int temp = matrix[x][i]; 
                    matrix[x][i] = matrix[x-1][i];
                    matrix[x-1][i] = temp; 
                }
              
            }
             
        }
        displayBoard(matrix);
    }
    
    static void displayBoard(int[][] matrix){
        if(matrix == null){
            return;
        }
        int m = matrix.length; // x, rows
        int n = matrix[0].length; // y, rols
        for(int x = 0 ; x < m; x++){
           for(int y = 0 ; y < n; y++){
               System.out.print(matrix[x][y]+" ");
           } 
           System.out.println();
        }
        
        
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mnr = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mnr[0]);

        int n = Integer.parseInt(mnr[1]);

        int r = Integer.parseInt(mnr[2]);

        int[][] matrix = new int[m][n];

        for (int i = 0; i < m; i++) {
            String[] matrixRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < n; j++) {
                int matrixItem = Integer.parseInt(matrixRowItems[j]);
                matrix[i][j] = matrixItem;
            }
        }

        matrixRotation(matrix, r);

        scanner.close();
    }
}
