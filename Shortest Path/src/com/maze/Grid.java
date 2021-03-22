/**
 * @Author: Araika Singh <NonZeroExitCode>
 * @Date:   2021-03-21
 * @Email:  roseymods@gmail.com
 */

package com.maze;

import java.io.File;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Grid {
	 
    // Size of the maze, greX, greY--> source, hanX, hanY --> destination
    static int row, col, greX=0, greY=0, hanX=0, hanY=0;
    
    public static void main(String args[]) throws Exception
    {
//    	Input file  |  output file
//    	mz1.txt     |  opmz1.txt
//    	mz2.txt     |  opmz2.txt
        solve("mz1.txt");
        solve("mz2.txt");
    }
    
    static void solve(String filename) throws Exception {
    	File file = new File(System.getProperty("user.dir") + "/" + filename);
        
        Scanner sc = new Scanner(file, StandardCharsets.UTF_8.name());
        String[] s = sc.nextLine().split("\\s+");
        
        row = Integer.parseInt(s[0].trim());
        col = Integer.parseInt(s[1].trim());
        
        char[][] forest = new char[row][col];
        int r = 0;
        while (sc.hasNextLine()){
//        	System.out.println("hello");
        	String str = sc.nextLine().trim();
//        	System.out.println(str);
        	for(int i = 0; i < str.length(); i++) {
        		forest[r][i] = str.charAt(i);
//        		System.out.print(forest[r][i]);
        	}
//        	System.out.println();
        	r++;
       }
        Grid gretal = new Grid();
        gretal.sourceDestGeneration(forest);
        gretal.findPath(forest, filename);
    }
 
    //Random source and destination generation
    void sourceDestGeneration(char forest[][]) {
    	while(!isSafe(forest, greX, greY)) {
    		greX = (int) (Math.random() * (row - 1));
        	greY = (int) (Math.random() * (col - 1));
    	}
    	
    	while(!isSafe(forest, hanX, hanY)) {
        	hanX = (int) (Math.random() * (row - 1));
        	hanY = (int) (Math.random() * (col - 1));
    	}
    }
    
//    A utility function to print 
//    solution matrix
    void printSolution(char sol[][])
    {
    	sol[greX][greY] = 'G';
    	sol[hanX][hanY] = 'H';
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(sol[i][j]);
            }
            System.out.println();
        }
    }
 
//    Check if it's valid index or not
    boolean isSafe(
        char forest[][], int x, int y)
    {
        return (x >= 0 && x < row && y >= 0 && y < col && forest[x][y] != '#');
    }
    
 
    boolean findPath(char maze[][], String filename) throws Exception
    {
        char sol[][] = new char[row][col];
//        System.out.println("Sol");
        for(int r = 0; r < row; r++) {
        	for(int c = 0; c < col; c++) {
        		sol[r][c] = maze[r][c];
//        		System.out.print(sol[r][c]);
        	}
//        	System.out.println();
        }
        
        if (solveMazeUtil(maze, greX, greY, sol) == false) {
            System.out.print("Solution doesn't exist");
            return false;
        }
        
        printSolution(sol);
        outputFile(sol, filename);
        return true;
    }
 
 
    boolean solveMazeUtil(char maze[][], int x, int y,
                          char sol[][])
    {
//    	System.out.println("Loading....");
//    	for(int r = 0; r < row; r++) {
//        	for(int c = 0; c < col; c++) {
////        		sol[r][c] = maze[r][c];
//        		System.out.print(sol[r][c]);
//        	}
//        	System.out.println();
//        }
        // if (x, y is destination) return true
        if (x == hanX && y == hanY && maze[x][y] != '#' && maze[x][y] != '.') {
            sol[x][y] = '.';
            maze[x][y] = '.';
            return true;
        }

        if(isSafe(maze, x, y)) {
        	char ch = sol[x][y];    
              if (sol[x][y] == '>' || sol[x][y] == '<' || sol[x][y] == '^' || sol[x][y] == 'v')
                  return false;
           
            
            sol[x][y] = 'v';
            if (solveMazeUtil(maze, x + 1, y, sol)) 
                return true;
       
            sol[x][y] = '>';
            if (solveMazeUtil(maze, x, y + 1, sol))
                return true;
           
            sol[x][y] = '^';
            if (solveMazeUtil(maze, x - 1, y, sol))
                return true;
 
            sol[x][y] ='<';
            if (solveMazeUtil(maze, x, y - 1, sol))
                return true;
 
            sol[x][y] = ch;
            return false;
        }
 
        return false;
    }
    
    void outputFile(char sol[][], String filename) throws Exception {
    	FileWriter myWriter = new FileWriter(System.getProperty("user.dir") + "/" + "op" + filename);
    	for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				myWriter.write(sol[i][j]);
			}
			myWriter.write('\n');
		}
    	myWriter.close();
    	System.out.println("File written succesfully");
    }
}