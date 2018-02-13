/*
 * Author: George Othen
 * Date: 12/11/2015
 * Title: Calculator Viewer
 */

package calculator;
 


import javax.swing.JFrame;

/**
 *
 * @author Gurge
 */
public class CalculatorViewer {

    public static int diceShowing; //declare variable to hold die object face value
    static JFrame frame, help; //declare frame
    
    public static void main(String[] args)
    {
        frame = new CalculatorFrame(); //create frame frame
        help = new HelpDialogFrame();
        final int FRAME_HEIGHT = 310;
        final int FRAME_WIDTH = 300;
        
        //set help attributes
        help.setSize(400, 100);
        help.setResizable(false);
        help.setTitle("Help");
        help.setDefaultCloseOperation(help.DISPOSE_ON_CLOSE); //set help cross to close just the help frame

        //set frame attributes
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setResizable(false);
        frame.setTitle("Calculator");
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setVisible(true);       
    }
    
}
