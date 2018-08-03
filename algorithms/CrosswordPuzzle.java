import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


public class CrossWordPuzzle {
    
    public static void displayPuzzle(char[][] grid){
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }
    
    
    private static boolean search(char[][] grid, ArrayList<String> wordsList) {
        // exist
        if (wordsList.isEmpty()) {
            return true;
        }
        
        // decompose the problem
        String word = wordsList.remove(0);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {

                char[][] rowDeepCopy = new char[grid.length][grid.length];
                char[][] colDeepCopy = new char[grid.length][grid.length];
                
                for (int z = 0; z < grid.length; z++) {
                    rowDeepCopy[z] = grid[z].clone();
                    colDeepCopy[z] = grid[z].clone();
                }
             
                if ((checkCol(colDeepCopy, word, i, j) && search(colDeepCopy, wordsList))) {
                    for (int z = 0; z < grid.length; z++) {
                        grid[z] = colDeepCopy[z].clone();
                    }
                    //display(grid);
                    return true;
                }
                if ((checkRow(rowDeepCopy, word, i, j) && search(rowDeepCopy, wordsList))) {
                    for (int z = 0; z < grid.length; z++) {
                        grid[z] = rowDeepCopy[z].clone();
                    }
                    //display(grid);
                    return true;
                }
            }
        }
        // backtrack
        wordsList.add(word);
        return false;
    }

    private static boolean checkCol(char[][] grid, String word, int x, int y) { 
        for (int i = 0; i < word.length(); i++) {
            
            if (x + i < grid.length && (grid[x + i][y] == '-' 
                || grid[x + i][y] == word.charAt(i))) {
                grid[x + i][y] = word.charAt(i);
               
            } else {
                return false;
            }
        }
        // make sure it is full filled
        //display(grid);
        if(x + word.length() >= grid.length || grid[x + word.length()][y] != '-'){
            return true;
        }
        
        return false;
    }

    private static boolean checkRow(char[][] grid, String word, int x, int y) {
        for (int i = 0; i < word.length(); i++) {
            if (y + i < grid.length && (grid[x][y + i] == '-' || grid[x][y + i] == word.charAt(i))) {
                grid[x][y + i] = word.charAt(i);
            } else {
                return false;
            }
        }
        // make sure it is full filled
        // display(grid);
        if(y + word.length() >= grid.length || grid[x][y + word.length()] != '-'){
            return true;
        }       
        return false;
    }
    
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args)throws IOException {
        String[] crossword = new String[10];
        char[][] grid = new char[10][10];
        for (int i = 0; i < 10; i++) {
            String crosswordItem = scanner.nextLine();
            crossword[i] = crosswordItem;
        }
        // convert to char[][]
        for(int i = 0; i < crossword.length; i++){
            for(int j = 0; j < crossword[i].length(); j++){
                grid[i][j] = crossword[i].charAt(j);
            }
        
        }
        
        String words = scanner.nextLine();
        String[] wordsArray = words.split(";");
        ArrayList<String> wordsList = new ArrayList<>(Arrays.asList(wordsArray));
    
        search(grid, wordsList);
        displayPuzzle(grid);
        
        
        scanner.close();
    }
}
