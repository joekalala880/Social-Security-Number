package ssn1;
import acm.graphics.*;
import acm.program.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Scanner;
/**
 *
 * @author kalalajoel
 */
public class SSN1 extends GraphicsProgram  {
 
//public class SSN_Validator extends GraphicsProgram {
   static SSN1 myWindow = new SSN1();
   JTextField myInputBox;
   JTextField myInputBox1;
   JButton myButton;
   JButton myButton1;
   
   public static void main(String[] args) {
       myWindow.start();
    }
   @Override
   public void init(){
       myWindow.setSize(1000,800);
       // add a window title to the sreen.
       myWindow.setTitle("SSN Validator");
       
        //add an output text for userInput 
       GLabel ssnLabel = new GLabel("Enter SSN with's");
       Font myFont = new Font("Times",Font.BOLD,24);
       ssnLabel.setFont(myFont);
       ssnLabel.setColor(Color.RED);
        myWindow.add(ssnLabel ,280,220);
        
        //add a SSN font text fort user SSN input
        GLabel myLabel1 = new GLabel(" SSN");
       myLabel1.setFont(myFont);
       myLabel1.setColor(Color.RED);
       myWindow.add(  myLabel1 ,160,280);
      
     
        GLabel myLabel2 = new GLabel(" Results");
       myLabel2.setFont(myFont);
       myLabel2.setColor(Color.RED);
       myWindow.add(  myLabel2 ,180,330);
       
       //inpunt first Box and set it to true
       myInputBox = new JTextField(18);
       myInputBox.setForeground(Color.black);
       myInputBox.setEditable(true );
       myWindow.add(myInputBox,280,250);
       
       //Result print Box set it false
        myInputBox1 = new JTextField(12);
       myInputBox1.setForeground(Color.black);
        myInputBox1.setFont(myFont);
       myInputBox1.setEditable(false);
       myWindow.add(myInputBox1,280,300);
        
       //add a Reset button
       myButton = new JButton("Reset");
       myWindow.add(myButton,400,350);
       myButton.addActionListener(this);
       
       // add a Validete SSN
       myButton1 = new JButton("Validate SSN");
       myWindow.add(myButton1,280,350);
       
       myWindow.addActionListeners();
       
       
}
   @Override
   public void actionPerformed(ActionEvent myAction){
           
     
     String temp ;
    temp = myInputBox.getText();
     
     String command =myAction.getActionCommand();
     if(command.equals("Reset")){
         myInputBox.setText("");
         myInputBox1.setText("");
         
     }
     
    if(command.equals("Validate SSN")){
        int index = 0;
        int numDigits = 0;
        while(index<temp.length()) {
            if(Character.isDigit(temp.charAt(index))) {
                numDigits = numDigits + 1;
                // checking each characte its number 
            }
            index ++ ;
        }
         // checking if the first character is 9
          if (temp.length()==0){
             myInputBox1.setText("error no input");
         
          }else if (temp.length()!=11){
         myInputBox1.setText("Wrong length");     
        } else if (temp.substring(0,1).equals("9")) {
           myInputBox1.setText("invalid"); 
       
        } 
        // checking the first to three character if its invalid 
        else if (temp.substring(0,temp.indexOf("-")).equals("666")) {
            myInputBox1.setText("invalid");
        }
        // checking the fist to fourth character if its invalid 
         else if (temp.substring(temp.lastIndexOf("-"),temp.length()).equals("0000")) {
             myInputBox1.setText("invalid");
             
             //if the group of number equals 000
         } else if (temp.substring(0,temp.indexOf("-")).equals("000")) { 
             myInputBox1.setText("invalid");
             
             // if the group of number equals 00
        } else if (temp.substring(temp.indexOf("-")+1,temp.lastIndexOf("-")).equals("00")) {
            myInputBox1.setText("ivalid");
            
            // checking if the dashes are on the rigth space 
        } else if (temp.indexOf("-")!=3 ||(temp.lastIndexOf("-")!=6)) {
            myInputBox1.setText("ivalid");
            
            // checking if input ist rigth length
         } else if (temp.length()!=11) {
             
          myInputBox1.setText("missing work");
             
         } // checking if the are 9 numberas in input
         else if(numDigits !=9){
             myInputBox1.setText("invalid format");
         
         
         }
         else {
             // otherwise input is valid
             myInputBox1.setText("valid");
         }
    }
}
}
