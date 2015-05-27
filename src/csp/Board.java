/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package csp;

import java.util.ArrayList;

/**
 *
 * @author Renato
 */
public class Board {

    private int boardSize;
    private int numberOfSolutions;
    private ArrayList<ArrayList<String>> domain;

    public Board(int boardSize) {
        this.boardSize = boardSize;
        this.numberOfSolutions = 0;
        this.domain = new ArrayList<ArrayList<String>>();

        //Adding Coordinates to the domain of avaible spots
        ArrayList<String> arrayCoord;
        for (int i = 0; i < boardSize; i++) {
            arrayCoord = new ArrayList<String>();
            for (int j = 0; j < boardSize; j++) {
                arrayCoord.add("-");
            }
            domain.add(arrayCoord);
        }

    }

    public void changeDomainFC(int row, int col, boolean fix) {
        
        if (!fix) {
            //Removing slots from domain
            for (int j = col + 1; j < boardSize; j++) {
                if (domain.get(row).get(j).equals("-")) {
                    domain.get(row).set(j, col + "");
                }//if (domain.get(row).get(j).equals("-")) {
            }//for (int j = col + 1; j < boardSize; j++) {

            //check right/down diagonal
            for (int i = row + 1, j = col + 1; i < boardSize && j < boardSize; i++, j++) {
                if (domain.get(i).get(j).equals("-")) {
                    domain.get(i).set(j, col + "");
                }//if (domain.get(i).get(j).equals("-")) {
            }//for (int i = row + 1, j = col + 1; i < boardSize && j < boardSize; i++, j++) {
            
            
            //check right/up diagonal
            for (int i = row - 1, j = col + 1; j < boardSize && i >= 0; i--, j++) {
                if (domain.get(i).get(j).equals("-")) {
                    domain.get(i).set(j, col + "");
                }//if (domain.get(i).get(j).equals("-")) {
            }//for (int i = row - 1, j = col + 1; j < boardSize && i >= 0; i--, j++) {
        }
        else {
            //Fixing slots from domain front
            for (int j = col + 1; j < boardSize; j++) {
                if (domain.get(row).get(j).equals(""+col)) {
                    domain.get(row).set(j, "-");
                }//if (domain.get(row).get(j).equals(""+col)) {
            }//for (int j = col + 1; j < boardSize; j++) {

            //Fixing right/down diagonal
            for (int i = row + 1, j = col + 1; i < boardSize && j < boardSize; i++, j++) {
                if (domain.get(i).get(j).equals(""+col)) {
                    domain.get(i).set(j, "-");
                }//if (domain.get(i).get(j).equals(""+col)) {
            }//for (int i = row + 1, j = col + 1; i < boardSize && j < boardSize; i++, j++) {
            
            //Fixing right/up diagonal
            for (int i = row - 1, j = col + 1; j < boardSize && i >= 0; i--, j++) {
                if (domain.get(i).get(j).equals(""+col)) {
                    domain.get(i).set(j, "-");
                }//if (domain.get(i).get(j).equals(""+col)) {
            }//for (int i = row - 1, j = col + 1; j < boardSize && i >= 0; i--, j++) {
        }

    }

    public int getNumberOfSolutions() {
        return numberOfSolutions;
    }

    public void setNumberOfSolutions(int numberOfSolutions) {
        this.numberOfSolutions = numberOfSolutions;
    }

    public boolean findSolutionBT(int col) {

        if (col >= boardSize) {
            numberOfSolutions++;
         //   System.out.println(toString());
            return true;
        }//if (col >= boardSize) {

        for (int i = 0; i < boardSize; i++) {
            if (validSpotBT(col, i)) {
                domain.get(i).set(col, "Q");
                findSolutionBT(col + 1);                
                domain.get(i).set(col, "-");
            }//if (validSpotBT(col, i)) {
        }//for (int i = 0; i < boardSize; i++) {


        return false;
    }

    public int getBoardSize() {
        return boardSize;
    }

    public void setBoardSize(int boardSize) {
        this.boardSize = boardSize;
    }

    public boolean validSpotBT(int col, int row) {

        //check left horizontal for queens
        for (int i = 0; i < boardSize; i++) {
            if (domain.get(row).get(i).equals("Q")) {
                return false;
            }//if (domain.get(row).get(i).equals("Q")) {
        }//for (int i = 0; i < boardSize; i++) {

       //check left/up diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (domain.get(i).get(j).equals("Q")) {
                return false;
            }//if (domain.get(i).get(j).equals("Q")) {
        }//for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {

        //check left/down diagonal
        for (int i = row, j = col; j >= 0 && i < boardSize; i++, j--) {
            if (domain.get(i).get(j).equals("Q")) {
                return false;
            }//if (domain.get(i).get(j).equals("Q")) {
        }//for (int i = row, j = col; j >= 0 && i < boardSize; i++, j--) {


        return true;
    }

    public boolean findSolutionFC(int col) {

        if (col >= boardSize) {
            numberOfSolutions++;
          System.out.println(toString());
            return true;
        }//if (col >= boardSize) {
        
        for (int i = 0; i < boardSize; i++) {
            if (validSpotFC(col)) {
                if (domain.get(i).get(col).equals("-")) {
                    domain.get(i).set(col, "Q");
                    changeDomainFC(i, col, false);
                    findSolutionFC(col + 1);
                    changeDomainFC(i, col, true);
                    domain.get(i).set(col, "-");
                }// if (domain.get(i).get(col).equals("-")) {
            }//if (validSpotFC(col)){
            else {
                return false;
            }//else {
        }//for (int i = 0; i < boardSize; i++) {


        return false;
    }

    @Override
    public String toString() {
        System.out.println("Current Number of Solutions: " + numberOfSolutions + "\n");

        String out = "";
        for (int i = 0; i < boardSize; i++) {
            out += "| ";

            for (int j = 0; j < boardSize; j++) {
                out += domain.get(i).get(j) + " ";
            }//for (int j = 0; j < boardSize; j++) {
            out += "| \n";
        }//for (int i = 0; i < boardSize; i++) {
        return out;
    }

    public boolean validSpotFC(int col) {
        
        if (col == boardSize - 1) {
            return true;
        }//if (col == boardSize - 1) {
    
        for (int i = 0; i < boardSize; i++) {
            if (!domain.get(i).get(col + 1).equals("X")) {
                return true;
            }//if (!domain.get(i).get(col + 1).equals("X")) {
        }//for (int i = 0; i < boardSize; i++) {
        return false;
    }
}
