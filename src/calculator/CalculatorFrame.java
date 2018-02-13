/*
 * Author: George Othen
 * Date: 12/11/2015
 * Title: Calculator Frame
 */

package calculator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public final class CalculatorFrame extends JFrame{
    
    private GridBagConstraints c, d, e; //create constraints for individual use in methods
    private JPanel arithmeticPanel, buttonPanel, mainPanel, textPanel; //create panels
    private static JTextField calculatorTextBox; //create textfield
    private JButton button;
    private JMenuBar menuBar;
    private JMenu edit, view, help;
    private JMenuItem copy, paste, standard, scientific, digitGrouping, helpTopics, about;
    private String store;
    ActionListener listener, menuListener; //create actionlisteners for menu and for buttons
    CalculatorLogic logic = new CalculatorLogic(); //create Logic object to manipulate calc
    
    
    class CalculatorFrameListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            //set buttonValue to text on buttons 
            String buttonValue = e.getActionCommand().toString();
            
            //if statements for buttons
            if(buttonValue.equals("MC"))
                logic.MemoryClear();
            if(buttonValue.equals("MR"))
                logic.MemoryRead();
            if(buttonValue.equals("MS"))
                logic.MemorySave();
            if(buttonValue.equals("M+"))
                logic.MemoryAdd();
            if(buttonValue.equals("C"))
                logic.Clear();
            if(buttonValue.equals("CE"))
                logic.ClearEntry();
            if(buttonValue.equals("0"))
                logic.Zero();
            if(buttonValue.equals("1"))
                logic.One();
            if(buttonValue.equals("2"))
                logic.Two();
            if(buttonValue.equals("3"))
                logic.Three();
            if(buttonValue.equals("4"))
                logic.Four();
            if(buttonValue.equals("5"))
                logic.Five();
            if(buttonValue.equals("6"))
                logic.Six();
            if(buttonValue.equals("7"))
                logic.Seven();
            if(buttonValue.equals("8"))
                logic.Eight();
            if(buttonValue.equals("9"))
                logic.Nine();
            if(buttonValue.equals("."))
                logic.Decimal();
            if(buttonValue.equals("+"))
                logic.Add();
            if(buttonValue.equals("-"))
                logic.Subtract();
            if(buttonValue.equals("*"))
                logic.Multiply();
            if(buttonValue.equals("/"))
                logic.Divide();
            if(buttonValue.equals("="))
                logic.Equals();
            if(buttonValue.equals("sqrt"))
                logic.SquareRoot();
            if(buttonValue.equals("%"))
                logic.Percentage();
            if(buttonValue.equals("1/x"))
                logic.OneOver();
            
            //refresh text box with new string after button press
            calculatorTextBox.setText(logic.RefreshText());            
        }
        
    }
    
    class MenuListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            //set menu string to string of menuitem clicked
            String menu = e.getActionCommand().toString();
            
            //if statements to determine menuitem use
            if(menu.equals("Copy")){
                store = logic.getAnswer();
            }
            if(menu.equals("Paste")){
                logic.setString(store);
            }
            if(menu.equals("Help Topics")){
                CalculatorViewer.help.setVisible(true);
            }
            if(menu.equals("About Calculator")){
                JOptionPane.showMessageDialog(null,"Calculator created in Java by George Othen"); //Code from StackOverflow
            }
            
            //refresh text on textfield
            calculatorTextBox.setText(logic.RefreshText());
        }
    }
    
    public CalculatorFrame(){
        
        //create GUI for frame
        createActionListener();
        addTextField();
        topRowButtons();
        createMemoryButtons();
        calculatorButtons();    
        createMenu();

        //set borderlayout for mainPanel
        this.setLayout(new BorderLayout());
        
        //add gui elements to main panel & add frame
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(textPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.EAST);
        mainPanel.add(arithmeticPanel, BorderLayout.SOUTH);       
        add(mainPanel);
       
    }
    
    public void createActionListener(){
        //create actionlisteners for buttons & menuitems
        listener = new CalculatorFrameListener();
        menuListener = new MenuListener();
    }
    
    public void createMenu(){
        //create menuBar
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        //create menu bar names
        edit = new JMenu("Edit");
        view = new JMenu("View");
        help = new JMenu("Help");
        
        //create menu bar names items
        copy = new JMenuItem("Copy");
        paste = new JMenuItem("Paste");
        standard = new JMenuItem("Standard");
        scientific = new JMenuItem("Scientific");
        digitGrouping = new JMenuItem("Digit Grouping");
        helpTopics = new JMenuItem("Help Topics");
        about = new JMenuItem("About Calculator");
        
        //add menuListener to all menuitems
        copy.addActionListener(menuListener);
        paste.addActionListener(menuListener);
        standard.addActionListener(menuListener);
        scientific.addActionListener(menuListener);
        digitGrouping.addActionListener(menuListener);
        helpTopics.addActionListener(menuListener);
        about.addActionListener(menuListener);
        
        
        //add menu bar names to menuBar
        menuBar.add(edit);
        menuBar.add(view);
        menuBar.add(help);
        
        //add menu bar names items to names
        edit.add(copy);
        edit.add(paste);
        view.add(standard);
        view.add(scientific);
        view.add(digitGrouping);
        help.add(helpTopics);
        help.add(about);
        
    }
    
    public void addTextField(){
        //create gridbagconstraints
        c = new GridBagConstraints();
        
        //set insets for textfield
        c.insets = new Insets(3,2,0,2);
        
        //give textpanel gridbaglayout
        textPanel = new JPanel(new GridBagLayout());
        c.fill = GridBagConstraints.HORIZONTAL;
        
        //give textfield weight inside panel
        c.weightx = 1;
        c.weighty = 1;
        
        //create textfield
        calculatorTextBox = new JTextField();
        
        //allign text to the right in textfield
        calculatorTextBox.setHorizontalAlignment(SwingConstants.RIGHT); //code from StackOverflow
        
        //set size of textfield within frame
        calculatorTextBox.setPreferredSize(new Dimension(280, 30));                
        
        //add textfield to textpanel
        textPanel.add(calculatorTextBox, c);
    }
    
    public void createMemoryButtons(){
        e = new GridBagConstraints();
        
        arithmeticPanel = new JPanel(new GridBagLayout());
        
        e.fill = GridBagConstraints.HORIZONTAL;
        //sets distance between buttons
        e.insets = new Insets(2,2,2,6);
        
        
        //create button
        button = new JButton ("MC");
        
        //set button size
        button.setPreferredSize(new Dimension(47,37));
        
        //ensure button displays text
        button.setMargin(new Insets(0,0,0,0));
        
        //set button text colour
        button.setForeground(Color.red);
        
        //add actionlistener to button
        button.addActionListener(listener);
        
        //set button location with gridbag
        e.gridx = 0;
        e.gridy = 1;
        
        //add button to arithmetic buttonpanel
        arithmeticPanel.add(button, e);

        button = new JButton ("MR");
        button.setPreferredSize(new Dimension(47,37));
        button.setMargin(new Insets(0,0,0,0));
        button.setForeground(Color.red);
        button.addActionListener(listener);
        e.gridx = 0;
        e.gridy = 2;
        arithmeticPanel.add(button, e);

        button = new JButton ("MS");
        button.setPreferredSize(new Dimension(47,37));
        button.setMargin(new Insets(0,0,0,0));
        button.setForeground(Color.red);
        button.addActionListener(listener);
        e.gridx = 0;
        e.gridy = 3;
        arithmeticPanel.add(button, e);

        button = new JButton ("M+");
        button.setPreferredSize(new Dimension(47,37));
        button.setMargin(new Insets(0,0,0,0));
        button.setForeground(Color.red);
        button.addActionListener(listener);
        e.gridx = 0;
        e.gridy = 4;
        arithmeticPanel.add(button, e);
}


    
    public void topRowButtons(){
        d = new GridBagConstraints();
        
        buttonPanel = new JPanel();
        
        d.gridx = 0;
        d.gridy = 0;
        
        button = new JButton("Backspace");
        button.setForeground(Color.red);
        button.setPreferredSize(new Dimension(70, 37));
        button.setMargin(new Insets(0, 0, 0, 0));
        button.addActionListener(listener);
        
        buttonPanel.add(button);        
        
        
        button = new JButton("CE");
        button.setForeground(Color.red);
        button.setPreferredSize(new Dimension(70, 37));
        button.addActionListener(listener);
        d.gridx = 0;
        
        buttonPanel.add(button);     
        
        
        button = new JButton("C");
        button.setForeground(Color.red);
        button.setPreferredSize(new Dimension(70, 37));
        button.addActionListener(listener);
        d.gridx = 0;
        
        
        buttonPanel.add(button);
    }
    
    public void calculatorButtons(){
        
        e.insets = new Insets(2,2,2,2);
        
        //ROW 1
        button = new JButton("7");
        button.setPreferredSize(new Dimension(41,37)); //set size of button
        button.addActionListener(listener);
        //set grid reference
        e.gridx = 1; 
        e.gridy = 1;
        //set button width
        e.gridwidth = 1;
        //add button to panel
        arithmeticPanel.add(button, e);
        
        button = new JButton("8");
        button.setPreferredSize(new Dimension(41,37));
        button.addActionListener(listener);
        e.gridx = 2;
        e.gridwidth = 1;
        arithmeticPanel.add(button, e);
        
        button = new JButton("9");
        button.setPreferredSize(new Dimension(41,37));
        button.addActionListener(listener);
        e.gridx = 3;
        e.gridwidth = 1;
        arithmeticPanel.add(button, e);
        
        button = new JButton("/");
        button.setPreferredSize(new Dimension(41,37));
        button.setForeground(Color.red);
        button.addActionListener(listener);
        e.gridx = 4;
        e.gridwidth = 1;
        arithmeticPanel.add(button, e);
        
        button = new JButton("sqrt");
        button.setPreferredSize(new Dimension(41,37));
        button.setForeground(Color.blue);
        button.setMargin(new Insets(0, 0, 0, 0)); //ensure button displays text
        button.addActionListener(listener);
        e.gridx = 5;
        e.gridwidth = 1;
        arithmeticPanel.add(button, e);
        
        

        //ROW 2       
        button = new JButton("4");
        button.setPreferredSize(new Dimension(41,37));
        button.addActionListener(listener);
        e.gridx = 1;
        e.gridy = 2;
        e.gridwidth = 1;
        arithmeticPanel.add(button, e);       
        
        button = new JButton("5");
        button.setPreferredSize(new Dimension(41,37));
        button.addActionListener(listener);
        e.gridx = 2;
        e.gridwidth = 1;
        arithmeticPanel.add(button, e);
        
        button = new JButton("6");
        button.setPreferredSize(new Dimension(41,37));
        button.addActionListener(listener);
        e.gridx = 3;
        e.gridwidth = 1;
        arithmeticPanel.add(button, e);
        
        button = new JButton("*");
        button.setPreferredSize(new Dimension(41,37));
        button.setForeground(Color.red);
        button.addActionListener(listener);
        e.gridx = 4;
        e.gridwidth = 1;
        arithmeticPanel.add(button, e);
        
        button = new JButton("%");
        button.setPreferredSize(new Dimension(41,37));
        button.setForeground(Color.blue);
        button.setMargin(new Insets(0, 0, 0, 0));
        button.addActionListener(listener);
        e.gridx = 5;
        e.gridwidth = 1;
        arithmeticPanel.add(button, e);
        
        
        
        
        //Row 3    
        button = new JButton("1");
        button.setPreferredSize(new Dimension(41,37));
        button.addActionListener(listener);
        e.gridx = 1;
        e.gridy = 3;
        e.gridwidth = 1;
        arithmeticPanel.add(button, e);       
        
        button = new JButton("2");
        button.setPreferredSize(new Dimension(41,37));
        button.addActionListener(listener);
        e.gridx = 2;
        e.gridwidth = 1;
        arithmeticPanel.add(button, e);
        
        button = new JButton("3");
        button.setPreferredSize(new Dimension(41,37));
        button.addActionListener(listener);
        e.gridx = 3;
        e.gridwidth = 1;
        arithmeticPanel.add(button, e);
        
        button = new JButton("-");
        button.setPreferredSize(new Dimension(41,37));
        button.addActionListener(listener);
        button.setForeground(Color.red);
        e.gridx = 4;
        e.gridwidth = 1;
        arithmeticPanel.add(button, e);
        
        button = new JButton("1/x");
        button.setPreferredSize(new Dimension(41,37));
        button.addActionListener(listener);
        button.setForeground(Color.blue);
        button.setMargin(new Insets(0, 0, 0, 0));
        e.gridx = 5;
        e.gridwidth = 1;
        arithmeticPanel.add(button, e);
        
        

        //Row 4   
        button = new JButton("0");
        button.setPreferredSize(new Dimension(41,37));
        button.addActionListener(listener);
        e.gridx = 1;
        e.gridy = 4;
        e.gridwidth = 1;
        arithmeticPanel.add(button, e);       
        
        button = new JButton("+/-");
        button.setPreferredSize(new Dimension(41,37));
        button.addActionListener(listener);
        button.setMargin(new Insets(0,0,0,0));
        e.gridx = 2;
        e.gridwidth = 1;
        arithmeticPanel.add(button, e);
        
        button = new JButton(".");
        button.setPreferredSize(new Dimension(41,37));
        button.addActionListener(listener);
        e.gridx = 3;
        e.gridwidth = 1;
        arithmeticPanel.add(button, e);
        
        button = new JButton("+");
        button.setPreferredSize(new Dimension(41,37));
        button.setForeground(Color.red);
        button.addActionListener(listener);
        e.gridx = 4;
        e.gridwidth = 1;
        arithmeticPanel.add(button, e);
        
        button = new JButton("=");
        button.setPreferredSize(new Dimension(41,37));
        button.setForeground(Color.red);
        button.setMargin(new Insets(0, 0, 0, 0));
        button.addActionListener(listener);
        e.gridx = 5;
        e.gridwidth = 1;
        arithmeticPanel.add(button, e);
    }
}