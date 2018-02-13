/*
 * Author: George Othen
 * Date: 18/11/2015
 * Title: Calculator Logic
 */

package calculator;


public class CalculatorLogic {

    float memory; //Store values in memory
    private float answer; //Store answer
    float leftVarFlo, rightVarFlo; //Store conversions from Strings as Floats, left representing String1 & right representing String2
    String displayedValueStr = "   ", displayedValueStr2 = "", operand = "", operandDisplay = "", percentage = "", percentage2 = ""; //Initialise Strings
    boolean hasInitiated, decimal, lastEquals, complete, calculateNow; //Intialise booleans
    int counter = 0; //Counter to prevent random calculations
    
    //decimal keeps track of whether decimal has already been placed
    //lastEquals keeps track of which if statement within operands (Add, Subtract, etc) is used at which time
    //complete prevents multiple if statements from being used
    //calculateNow is to force percentages to be immediately calculated, rather than replaced when converting Strings to Floats
    
    public CalculatorLogic(){
    
}
    
    /**
     * 
     * @return answer float
     */
    
    public String getAnswer(){
        return Float.toString(answer); //reproduction of the MR button
    }
    
    /**
     * 
     * @param paste data copied using copy menuitem
     */
    
    public void setString(String paste){
        displayedValueStr2 = paste; //Very simple Paste from within the calculator, essentially a reproduction of the MS button
    }
    
    public String RefreshText(){ //Refreshes text on the JTextfield
        if(answer == 0){
        return displayedValueStr + percentage + " " + operandDisplay + " " + displayedValueStr2 + percentage2;} //String format to go onto the textfield
        if(answer != 0){
        return answer + displayedValueStr + percentage + " " + operandDisplay + " " + displayedValueStr2 + percentage2;} //String format to go onto the textfield after intiation
        
        return "How do I calculator?"; //Unlikely event that the calculator can't even
    }
    
    public void MemoryClear(){
        memory = 0; 
    }
    
    public void MemoryRead(){
    if(memory != 0){
        displayedValueStr2 = Float.toString(memory); //Read memory into 2nd String
    }
    }
    
    public void MemorySave(){
        if(answer == 0 && displayedValueStr2.equals("")){ //Save String1 if there is no answer & no String2
            memory = Float.parseFloat(displayedValueStr);
        }
        
        if(answer == 0 && !operand.equals("")){ //Save String2 if there is no answer but there is already an Operand
            memory = Float.parseFloat(displayedValueStr2);
        }
            
        if(answer != 0){
            memory = answer; //Save answer if there is one
        }
    }
    
    public void MemoryAdd(){
        if(displayedValueStr2.equals(""))
            memory += Float.parseFloat(displayedValueStr); //add String1 to memory if String2 is empty
        if(displayedValueStr.equals(""))
            memory += Float.parseFloat(displayedValueStr2); //add String2 to memory if String1 is empty
    }
    
    public void Clear(){        //Set everything back to Default
        SetString(); answer = 0;
        percentage = ""; percentage2 = "";
        operand = ""; operandDisplay = "";
        leftVarFlo = 0; rightVarFlo = 0;
        calculateNow = false; lastEquals = false;
        hasInitiated = false; decimal = false;        
    }
    
    public void ClearEntry(){ //Remove everything except for the answer
        if(answer != 0){
            displayedValueStr = "";
            operand = "";
            operandDisplay = "";
            displayedValueStr2 = "";
        }        
    }
    
    public void Zero(){ //Adds Zero
       if(!displayedValueStr.equals("0") && hasInitiated == false || decimal == true && hasInitiated == false) //Only add zero to String1 if it doesn't already exist or if using a decimal
            displayedValueStr += "0";
       if(!displayedValueStr.equals("0") && hasInitiated == true && !operandDisplay.equals("") || decimal == true && hasInitiated == true) //Add zero to String2 once initiated and Operand has been put in place and there isn't already a zero OR a decimal has been placed
            displayedValueStr2 += "0";
    }
    
    public void One(){
       if(hasInitiated == false || operand.equals("")) //add a 1 to String1 if it hasn't initiated and if there is no operand.
            displayedValueStr += "1";
       if(hasInitiated == true && !operandDisplay.equals("")) //add a 1 to String2 if calc has initiated & an operand is being displayed
            displayedValueStr2 += "1";
       lastEquals = false; //reset lastEquals to accept new input into operands
    }
    
    public void Two(){
       if(hasInitiated == false || operand.equals(""))
            displayedValueStr += "2";
       if(hasInitiated == true && !operandDisplay.equals(""))
            displayedValueStr2 += "2";
       lastEquals = false;
    }
    
    public void Three(){
       if(hasInitiated == false || operand.equals(""))
            displayedValueStr += "3";
       if(hasInitiated == true && !operandDisplay.equals(""))
            displayedValueStr2 += "3";
       lastEquals = false;
    }
    
    public void Four(){
       if(hasInitiated == false || operand.equals(""))
            displayedValueStr += "4";
       if(hasInitiated == true && !operandDisplay.equals(""))
            displayedValueStr2 += "4";
       lastEquals = false;
    }
    
    public void Five(){
       if(hasInitiated == false || operand.equals(""))
            displayedValueStr += "5";
       if(hasInitiated == true && !operandDisplay.equals(""))
            displayedValueStr2 += "5";
       lastEquals = false;
    }
    
    public void Six(){
       if(hasInitiated == false || operand.equals(""))
            displayedValueStr += "6";
       if(hasInitiated == true && !operandDisplay.equals(""))
            displayedValueStr2 += "6";
       lastEquals = false;
    }
    
    public void Seven(){
       if(hasInitiated == false || operand.equals(""))
            displayedValueStr += "7";
       if(hasInitiated == true && !operandDisplay.equals(""))
            displayedValueStr2 += "7";
       lastEquals = false;
    }
    
    public void Eight(){
       if(hasInitiated == false || operand.equals(""))
            displayedValueStr += "8";
       if(hasInitiated == true && !operandDisplay.equals(""))
            displayedValueStr2 += "8";
       lastEquals = false;
    }
    
    public void Nine(){
        if(hasInitiated == false || operand.equals(""))
            displayedValueStr += "9";
       if(hasInitiated == true && !operandDisplay.equals(""))
            displayedValueStr2 += "9";
       lastEquals = false;
    }
    
    public void Decimal(){
        if(decimal == false && hasInitiated == false) //add a decimal point to String1 if calc hasn't been initiated and there isn't already a decimal
            displayedValueStr += ".";
        if(decimal == false && hasInitiated == true) //add a decimal point to String2 if calc has been initiated and there isn't already a decimal
            displayedValueStr2 += ".";
        
        decimal = true; //set decimal to true so there isn't 2 decimals
    }
    
    public void SquareRoot(){
        if(answer == 0){
            StringToFloat(); //Convert String 1 & 2 to Floats for calculations
            answer = (float) Math.sqrt(leftVarFlo); //immediately calculate squareroot of String1 if there is no answer
        }
        else{
            answer = (float) Math.sqrt(answer); //immediately calculate squareroot of answer
        }
        HasInitiated();       //set has initiated to true so String1 can be dropped in favour of Answer
        displayedValueStr = ""; //set String1 to nothing so it doesn't interfere
    }
    
    public void Percentage(){
        StringToFloat();
        if(hasInitiated == true && !displayedValueStr2.equals("")){
            percentage2 = "%"; RefreshText(); //refresh text with new symbol
            rightVarFlo = ((rightVarFlo * leftVarFlo) / 100); //String2's float equivalent is set to percentage of String1's float equivalent
        }
        if(displayedValueStr2.equals("")){
            percentage = "%"; RefreshText();
            leftVarFlo = ((answer * leftVarFlo) / 100);
        }
        calculateNow = true; //ensure Strings aren't reconverted to Floats over above calculated floats
    }
    
    public void OneOver(){
        StringToFloat(); //convert strings to floats
        if(hasInitiated == true && !displayedValueStr2.equals("")){
            rightVarFlo = (1 / rightVarFlo);
            displayedValueStr2 = Float.toString(rightVarFlo); //set String2 immediately
        }
        if(displayedValueStr2.equals("") && !displayedValueStr.equals("")){
            leftVarFlo = (1 / leftVarFlo);
            displayedValueStr = Float.toString(leftVarFlo); //set String immediately
        }
        if(answer != 0 && operandDisplay.equals("")){ 
            answer = 1/answer;
            rightVarFlo = 0;
        }
    }
    
    
    
    public void Add(){  
        
        
        if(hasInitiated == true  && operand.equals("+") && counter >= 1){      //only add if there is an operand, only add if the operand is add, only add if counter is or has exceeded 1(remove random calculations)
            if(displayedValueStr.equals("") && lastEquals == false){ //if String1 is empty and equals hasn't already been used
                if(calculateNow == false)//if calculateNow has been set, don't convert strings to floats
                    StringToFloat();
                answer += rightVarFlo; //answer = answer plus String2 as a float
                complete = true; //add method is now complete, don't do anymore
            }

            if(answer == 0 && complete == false && lastEquals == false){ // if there is no answer, add float representatives of Strings 1 & 2 together to make answer
                if(calculateNow == true){
                    leftVarFlo = Float.parseFloat(displayedValueStr); 
                }else{StringToFloat();}
                answer = leftVarFlo + rightVarFlo;
                complete = true;
            }

            if(displayedValueStr2.equals("") && complete == false){
                answer += rightVarFlo;
            }        
            SetString(); //make strings empty for new calculation
        }
        HasInitiated(); //Make operand methods aware of initiation (use correct if statements)
        SetDecimal(); //Reset Decimal, calculation finished
        complete = false; //Reset complete, so operands can work again
        calculateNow = false; //Reset calculateNow, so operands will work normally
        operand = "+"; operandDisplay = "+"; //set invisible and visible operands
        }
    
    
    
    public void Subtract(){     
        if(hasInitiated == true && operand.equals("-") && counter >= 1){       
            if(displayedValueStr.equals("") && lastEquals == false){
                if(calculateNow == false)
                    StringToFloat();           
                answer -= rightVarFlo;
                complete = true;
            }

            if(answer == 0 && complete == false && lastEquals == false){
                if(calculateNow == true){
                    leftVarFlo = Float.parseFloat(displayedValueStr);
                }else{StringToFloat();}
                answer = leftVarFlo - rightVarFlo;
                complete = true;
            }

            if(displayedValueStr2.equals("") && complete == false){
                answer -= rightVarFlo;
            }
            SetString();
        }
        HasInitiated();
        SetDecimal();    
        complete = false;
        calculateNow = false;
        operand = "-"; operandDisplay = "-";
        }
    
    
    
    public void Multiply(){
        if(hasInitiated == true && operand.equals("*") && counter >= 1){       
            if(displayedValueStr.equals("") && lastEquals == false){
                if(calculateNow == false)
                    StringToFloat();
                answer *= rightVarFlo;
                complete = true;
            }

            if(answer == 0 && complete == false && lastEquals == false){
                if(calculateNow == true){
                    leftVarFlo = Float.parseFloat(displayedValueStr);
                }else{StringToFloat();}
                answer = leftVarFlo * rightVarFlo;
                complete = true;
            }

            if(displayedValueStr2.equals("") && complete == false){
                answer *= rightVarFlo;
            }
            SetString();

        }
        HasInitiated();
        SetDecimal();    
        complete = false;
        calculateNow = false;
        operand = "*"; operandDisplay = "*";
        }
    
    
    
    public void Divide(){
        if(hasInitiated == true && operand.equals("/") && counter >= 1){       
            if(displayedValueStr.equals("") && lastEquals == false){
                if(calculateNow == false)
                    StringToFloat();
                answer /= rightVarFlo;
                complete = true;
            }

            if(answer == 0 && complete == false && lastEquals == false){
                if(calculateNow == true){
                    leftVarFlo = Float.parseFloat(displayedValueStr);
                }else{StringToFloat();}
                answer = leftVarFlo / rightVarFlo;
                complete = true;
            }

            if(displayedValueStr2.equals("") && complete == false && lastEquals == false){
                answer /= rightVarFlo;
            }
            SetString();
        }
        HasInitiated();
        SetDecimal();    
        complete = false;
        calculateNow = false;
        operand = "/"; operandDisplay = "/";
        }
    
    public void Equals(){
        counter++; //add 1 to counter everytime it is called
        if(hasInitiated == true && operand.equals("+")){
            Add(); operandDisplay = "";} //remove visible operand if equals button is spammed for continous addition
        if(hasInitiated == true && operand.equals("-")){
            Subtract(); operandDisplay = "";}
        if(hasInitiated == true && operand.equals("*")){
            Multiply(); operandDisplay = "";}
        if(hasInitiated == true && operand.equals("/")){
            Divide(); operandDisplay = "";}
        if(percentage.equals("%") || percentage2.equals("%")){
            calculateNow = false; percentage = ""; percentage2 = "";} //set percentages invisible again, reset calculateNow
        
        if(counter >= 1){ //if equals button has been pressed twice in a row, reset equals button
            counter = 0;
        }
    }
    
    public void SetString(){ //set Strings to be empty
        displayedValueStr = "";
        displayedValueStr2 = "";
    }
    
    public void SetDecimal(){ //allow use of decimals again
        decimal = false;
    }
    
    public void StringToFloat(){ //Convert strings to floats
        if(!displayedValueStr.equals(""))
            leftVarFlo = Float.parseFloat(displayedValueStr);
        if(!displayedValueStr2.equals(""))
            rightVarFlo = Float.parseFloat(displayedValueStr2);
    }
        
    public void HasInitiated(){ //inform operands that program has been initiated
        hasInitiated = true;
    }
}
