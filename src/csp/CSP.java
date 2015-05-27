/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package csp;

import com.sun.org.apache.xpath.internal.functions.WrongNumberArgsException;
import javax.swing.JOptionPane;

/**
 *
 * @author Renato
 */
public class CSP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //int size of N
        int size = 0;
        
        //getting a N size
            try {
                String tmp = JOptionPane.showInputDialog("Enter the number of Queens/Board Size (bigger than 0)");
                size = Integer.parseInt(tmp);
                if (size <= 0) {
                    JOptionPane.showMessageDialog(null, "Value must be numeric bigger than 0.", "Invalid Value", JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                }
            }//try{
            catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Value must be numeric bigger than 0.", "Invalid Value", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }//catch(NumberFormatException e){

        
        //computation time
        long start = System.nanoTime();
        long elapsedTime;
        //board with selected size
        Board boardObj = new Board(size);
        
        //Start the recursion of BackTracking
     //   boardObj.findSolutionBT(0);
        
        //Start the forward checking
        boardObj.findSolutionFC(0);
        
        
        if(boardObj.getNumberOfSolutions()==0){
            System.out.println("*****************************************************");
            System.out.println("******The problem with "+size+" queens has no solution******");
            System.out.println("*****************************************************\n");
        }//if(boardObj.getNumberOfSolutions()==0){
        



        //Get the computation time
        elapsedTime = System.nanoTime() - start;
        System.out.println("Algorithm took " + elapsedTime + " nano seconds to run and found "+boardObj.getNumberOfSolutions()+" solutions.");
    }
}
