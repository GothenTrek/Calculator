/*
 * Author: George Othen
 * Date: 18/11/2015
 * Title: Help Dialog Frame
 */

package calculator;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class HelpDialogFrame extends JFrame{

    private JButton ok;
    private JLabel help;
    
    class OkButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e){
           dispose(); //if clicking 'ok' close jframe
        }    
}
    
    public HelpDialogFrame(){
        //create help frame gui elements
        createButton();
        addText();
    }
    
    public void createButton(){
        //create button
        ok = new JButton("Ok");
        
        //create button actionListener
        ActionListener okListen = new OkButtonListener();
        
        //give button actionListener
        ok.addActionListener(okListen);
        
        //set layout
        this.setLayout(new BorderLayout());
        
        //set location to bottom of frame
        add(ok, BorderLayout.SOUTH);
    }
    
    public void addText(){
        //create JLabel with "help" text, formatted with HTML
        help = new JLabel("<html>The first answer won't appear till a calculation has been input. <br> 1/x will calculate immediately. Percentage will only work with the value on the RHS</html>");
        
        //set location of JLabel to middle of frame
        add(help, BorderLayout.CENTER);
    }
}
