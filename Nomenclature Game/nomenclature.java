//&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
//Nomenclature Game
//By: Matthew Wong
//August 4th, 2016
//&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.*;
import java.io.IOException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class nomenclature implements ActionListener, KeyListener, MouseListener, MouseMotionListener{
  //Elements
  element[] metal = new element[40];
  element[] nonmetal = new element[15];
  element[] nobleg = new element[15];
  element[] polyatom10 = new element[10];
  element[] polyatom11 = new element[25];
  element[] acids10 = new element[18];
  element[] acids11 = new element[25];
  
  //List to determine which mode the player wants to play
  List<Integer> type = new ArrayList<Integer>();
  //Answer
  String strAnswer;
  String strIComp;
  //Ionic compounds
  int intRandE1; //Random first element(metal)
  int intRandE2; //Random second element(non-metal)
  int intRandE2V2; //Randoms for second nonmetal for covalent
  //Covalent Compounds
  int intRandC1; //Random first non-metal
  int intRandC2; //Random second non-metal
  int intRandCNum1; //Gives you random number for naming
  int intRandCNum2; //Gives you another random number for naming
  //Hydrates
  int intRandH;
  //Polyatomic
  int intRandP10;
  int intRandP11;
  //Acids
  int intRandA10;
  int intRandA11;
  //Random Stuff
  int intRandComp; //Random composition(either name --> form or form --> name)
  int intRandType; //Random type of question(0=ionic, 1=covalent, 3=hydrates)
  int intScore = 0;
  int intHScore = 0;
  
  //Properties
  Timer thetimer;
  JFrame theframe;
  JGraphics thepanel;
  JLabel lblQAns;
  JLabel lblPQuestion;
  JLabel lblMyself;
  JLabel lblScore;
  JTextField theanswer;
  JButton startbutton;
  JButton helpbutton;
  JButton aboutbutton;
  JButton backbutton;
  JButton chargebutton;
  JButton ptablebutton;
  JButton beginbutton;
  JButton testbutton;
  JButton ionicbutton;
  JButton covalentbutton;
  JButton hydratebutton;
  JButton acidbutton;
  JButton polyatomicbutton;
  JButton backbutton2;
  JRadioButton therb10;
  JRadioButton therb11;
  JRadioButton rbformula;
  JRadioButton rbname;
  JCheckBox cbionic;
  JCheckBox cbcovalent;
  JCheckBox cbpolyatomic10;
  JCheckBox cbhydrates;
  JCheckBox cbpolyatomic11;
  JCheckBox cbacids10;
  JCheckBox cbacids11;
  Font font1 = new Font("Arial", Font.BOLD,30);
  Font font2 = new Font("Arial",Font.PLAIN,10);
  Font font3 = new Font("Arial",Font.BOLD,20);
  
  boolean buttonpress = true;
  
  JLabel lblQuestion;
  JTextField tfAnswer;
  
  //Filewriting/reading
  PrintWriter fileout = null;
  BufferedReader thefile = null;
  
  //Periodic Table Images
  //Metals
  Image imgH;
  Image imgLi;
  Image imgBe;
  Image imgNa;
  Image imgMg;
  Image imgK;
  Image imgCa;
  Image imgRb;
  Image imgSr;
  Image imgCs;
  Image imgBa;
  Image imgFr;
  Image imgRa;
  Image imgTi;
  Image imgCr;
  Image imgMn;
  Image imgFe;
  Image imgCo;
  Image imgNi;
  Image imgCu;
  Image imgZn;
  Image imgAg;
  Image imgPt;
  Image imgAu;
  Image imgHg;
  Image imgSn;
  Image imgPb;
  //Non-metals
  Image imgHe;
  Image imgB;
  Image imgC;
  Image imgN;
  Image imgO;
  Image imgF;
  Image imgNe;
  Image imgAl;
  Image imgSi;
  Image imgP;
  Image imgS;
  Image imgCl;
  Image imgAr;
  Image imgAs;
  Image imgSe;
  Image imgBr;
  Image imgTe;
  Image imgI;
  Image imgAt;
  //Images for the buttons
  Image img1;
  Image img2;
  Image img3;
  Image img4;
  Image img5;
  Image img6;
  Image img7;
  Image img8;
  Image img9;
  Image img10;
  
  //Periodic Table Buttons
  JButton H;
  JButton Li;
  JButton Be;
  JButton Na;
  JButton Mg;
  JButton K;
  JButton Ca;
  JButton Rb;
  JButton Sr;
  JButton Cs;
  JButton Ba;
  JButton Fr;
  JButton Ra;
  JButton Ti;
  JButton Cr;
  JButton Mn;
  JButton Fe;
  JButton Co;
  JButton Ni;
  JButton Cu;
  JButton Zn;
  JButton Ag;
  JButton Pt;
  JButton Au;
  JButton Hg;
  JButton Sn;
  JButton Pb;
  
  JButton He;
  JButton B;
  JButton C;
  JButton N;
  JButton O;
  JButton F;
  JButton Ne;
  JButton Al;
  JButton Si;
  JButton P;
  JButton S;
  JButton Cl;
  JButton Ar;
  JButton As;
  JButton Se;
  JButton Br;
  JButton Te;
  JButton I;
  JButton At;
  
  JButton but1;
  JButton but2;
  JButton but3;
  JButton but4;
  JButton but5;
  JButton but6;
  JButton but7;
  JButton but8;
  JButton but9;
  JButton but10;
  
  JButton button1;
  JButton button2;
  
  //Labels/ButtonsBariables for the test button
  JLabel lblInput;
  JLabel lblOutput;
  JLabel lblAnswer;
  JLabel lblInstruction;
  
  //Keeps track of the answers
  element firstAns;
  element secondAns;
  int firstNumAns;
  int secondNumAns;
  
  boolean blnNameOrForm = false;
  
  JButton clearbutton;
  JButton donebutton;
  
  int intGroupChoice; //Keeps track of which group you are testing | ionic = 1 , covalent = 2, hydrates = 3
  int intStep = 0;
  
  //Methods
  
  public void keyReleased(KeyEvent evt){
  }
  public void keyPressed(KeyEvent evt){
  }
  public void keyTyped(KeyEvent evt){
  }
  public void mouseExited(MouseEvent e){
  }
  public void mouseEntered(MouseEvent e){
  }
  public void mouseReleased(MouseEvent e){
  }
  public void mousePressed(MouseEvent e){
  }
  public void mouseClicked(MouseEvent e){
  }
  public void mouseMoved(MouseEvent e){
  }
  public void mouseDragged(MouseEvent e){
  }
  
  public void actionPerformed(ActionEvent evt){
    if(evt.getSource() == thetimer){
      thepanel.repaint();
      if(cbionic.isSelected() || cbcovalent.isSelected() || cbpolyatomic10.isSelected() || cbhydrates.isSelected() || cbpolyatomic11.isSelected() || cbacids10.isSelected() || cbacids11.isSelected()){
        if(beginbutton.isEnabled() == false){
          tfAnswer.setEnabled(true);
        }
      }else{
        tfAnswer.setEnabled(false);
        beginbutton.setEnabled(true);
        lblQuestion.setText("!");
      }
    }
    //**************************
    //The menus' event sources
    //**************************
    if(evt.getSource() == startbutton){
      //removes everything from the screen in main menu
      thepanel.remove(startbutton);
      thepanel.remove(aboutbutton);
      thepanel.remove(helpbutton);
      thepanel.remove(testbutton);
      thepanel.remove(therb10);
      thepanel.remove(therb11);
      thepanel.remove(lblMyself);
      
      //Adds different objects for the game
      thepanel.add(backbutton);
      thepanel.add(lblQuestion);
      thepanel.add(tfAnswer);
      thepanel.add(chargebutton);
      thepanel.add(ptablebutton);
      thepanel.add(lblScore);
      thepanel.add(lblQAns);
      thepanel.add(therb10);
      thepanel.add(therb11);
      thepanel.add(cbionic);
      thepanel.add(cbcovalent);
      thepanel.add(cbpolyatomic10);
      thepanel.add(cbhydrates);
      thepanel.add(cbpolyatomic11);
      thepanel.add(cbacids10);
      thepanel.add(cbacids11);
      thepanel.add(beginbutton);
      thepanel.add(lblPQuestion);
      thepanel.intMenuSelect = 3;
    }
    if(evt.getSource() == helpbutton){
      //removes everything from the screen in main menu
      thepanel.remove(startbutton);
      thepanel.remove(aboutbutton);
      thepanel.remove(helpbutton);
      thepanel.remove(testbutton);
      thepanel.remove(therb10);
      thepanel.remove(therb11);
      thepanel.remove(lblMyself);
      
      //Adds the object for the help screen
      thepanel.add(backbutton);
      thepanel.intMenuSelect = 1;
    }
    if(evt.getSource() == aboutbutton){
      //removes everything from the screen in main menu
      thepanel.remove(startbutton);
      thepanel.remove(aboutbutton);
      thepanel.remove(helpbutton);
      thepanel.remove(testbutton);
      thepanel.remove(therb10);
      thepanel.remove(therb11);
      thepanel.remove(lblMyself);
      //adds objects for about screen
      thepanel.add(backbutton);
      thepanel.intMenuSelect = 2;
    }
    if(evt.getSource() == backbutton){ //**make it so that it doesn't fuck with instruction label
      //adds everything to the screen in main menu
      intScore = 0;
      thepanel.intPTableY = 700;
      thepanel.blnPTable = false;
      thepanel.add(startbutton);
      thepanel.add(aboutbutton);
      thepanel.add(helpbutton);
      thepanel.add(testbutton);
      thepanel.add(lblMyself);
      thepanel.remove(therb10);
      thepanel.remove(therb11);
      
      //removes everything that is not in the main menu
      thepanel.remove(backbutton);
      
      thepanel.remove(lblQuestion);
      thepanel.remove(tfAnswer);
      thepanel.remove(ptablebutton);
      thepanel.remove(chargebutton);
      thepanel.remove(beginbutton);
      thepanel.remove(lblScore);
      thepanel.remove(lblQAns);
      thepanel.remove(lblPQuestion);
      thepanel.remove(ionicbutton);
      thepanel.remove(covalentbutton);
      thepanel.remove(hydratebutton);
      thepanel.remove(acidbutton);
      thepanel.remove(polyatomicbutton);
      
      thepanel.remove(cbionic);
      thepanel.remove(cbcovalent);
      thepanel.remove(cbpolyatomic10);
      thepanel.remove(cbhydrates);
      thepanel.remove(cbpolyatomic11);
      thepanel.remove(cbacids10);
      thepanel.remove(cbacids11);
      thepanel.intMenuSelect = 0;
    }
    
    //**************************
    //The quizes' event sources
    //**************************
    if(evt.getSource() == therb10){ //allows you to select all options in the 10th grade
      therb11.setSelected(false);
      therb10.setSelected(true);
      cbionic.setSelected(true);
      cbcovalent.setSelected(true);
      cbacids10.setSelected(true);
      cbpolyatomic10.setSelected(true);
      cbhydrates.setSelected(false);
      cbpolyatomic11.setSelected(false);
      cbacids11.setSelected(false);
      
      type.clear();
      type.add(0);
      type.add(1);
      type.add(3);
      type.add(5);
    }else if(evt.getSource() == therb11){ //allows you to select all options in the 11th grade
      therb10.setSelected(false);
      therb11.setSelected(true);
      cbionic.setSelected(true);
      cbcovalent.setSelected(true);
      cbpolyatomic10.setSelected(true);
      cbhydrates.setSelected(true);
      cbpolyatomic11.setSelected(true);
      cbacids11.setSelected(true);
      cbacids10.setSelected(true);
      type.clear();
      type.add(0);
      type.add(1);
      type.add(2);
      type.add(3);
      type.add(4);
      type.add(5);
      type.add(6);
    }
    //Adds your options to a list to see which options you have selected=
    if(evt.getSource() == cbionic || evt.getSource() == cbcovalent || evt.getSource() == cbpolyatomic10 || evt.getSource() == cbhydrates || evt.getSource() == cbpolyatomic11 || evt.getSource() == cbacids10 || evt.getSource() == cbacids11){
      therb10.setSelected(false);
      therb11.setSelected(false);
      if(cbionic.isSelected() == true && type.contains(0) == false){
        type.add(0);
      }else if(type.contains(0) && cbionic.isSelected() == false){
        type.remove(type.indexOf(0));
      }
      if(cbcovalent.isSelected() == true && type.contains(1) == false){
        type.add(1);
      }else if(type.contains(1) && cbcovalent.isSelected() == false){
        type.remove(type.indexOf(1));
      }
      if(cbhydrates.isSelected() == true && type.contains(2) == false){
        type.add(2);
      }else if(type.contains(2) && cbhydrates.isSelected() == false){
        type.remove(type.indexOf(2));
      }
      if(cbpolyatomic10.isSelected() == true && type.contains(3) == false){
        type.add(3);
      }else if(type.contains(3) && cbpolyatomic10.isSelected() == false){
        type.remove(type.indexOf(3));
      }
      if(cbpolyatomic11.isSelected() == true && type.contains(4) == false){
        type.add(4);
      }else if(type.contains(4) && cbpolyatomic11.isSelected() == false){
        type.remove(type.indexOf(4));
      }
      if(cbacids10.isSelected() == true && type.contains(5) == false){
        type.add(5);
      }else if(type.contains(5) && cbacids10.isSelected() == false){
        type.remove(type.indexOf(5));
      }
      if(cbacids11.isSelected() == true && type.contains(6) == false){
        type.add(6);
      }else if(type.contains(6) && cbacids11.isSelected() == false){
        type.remove(type.indexOf(6));
      }
    }
    if(evt.getSource() == ptablebutton){ //clicked button to view ptable
      if(thepanel.blnPTable == true){
        thepanel.blnPTable = false;
        thepanel.add(cbionic);
        thepanel.add(cbcovalent);
        thepanel.add(cbpolyatomic10);
        thepanel.add(cbhydrates);
        thepanel.add(cbpolyatomic11);
        thepanel.add(cbacids10);
        thepanel.add(cbacids11);
        thepanel.add(therb10);
        thepanel.add(therb11);
      }else if(thepanel.blnCharge == true){
        thepanel.blnPTable = true;
        thepanel.blnCharge = false;
      }else if(thepanel.blnPTable == false && thepanel.blnCharge == false){
        thepanel.blnPTable = true;
        thepanel.remove(cbionic);
        thepanel.remove(cbcovalent);
        thepanel.remove(cbpolyatomic10);
        thepanel.remove(cbhydrates);
        thepanel.remove(cbpolyatomic11);
        thepanel.remove(cbacids10);
        thepanel.remove(cbacids11);
        thepanel.remove(therb10);
        thepanel.remove(therb11);
      }
    }
    if(evt.getSource() == chargebutton){ //clicked button to view charge chart
      if(thepanel.blnCharge == true){
        thepanel.blnCharge = false;
        thepanel.add(cbionic);
        thepanel.add(cbcovalent);
        thepanel.add(cbpolyatomic10);
        thepanel.add(cbhydrates);
        thepanel.add(cbpolyatomic11);
        thepanel.add(cbacids10);
        thepanel.add(cbacids11);
        thepanel.add(therb10);
        thepanel.add(therb11);
      }else if(thepanel.blnPTable == true){
        thepanel.blnPTable = false;
        thepanel.blnCharge = true;
      }else if(thepanel.blnPTable == false && thepanel.blnCharge == false){
        thepanel.blnCharge = true;
        thepanel.remove(cbionic);
        thepanel.remove(cbcovalent);
        thepanel.remove(cbpolyatomic10);
        thepanel.remove(cbhydrates);
        thepanel.remove(cbpolyatomic11);
        thepanel.remove(cbacids10);
        thepanel.remove(cbacids11);
        thepanel.remove(therb10);
        thepanel.remove(therb11);
      }
    }
    if(cbionic.isSelected() || cbcovalent.isSelected() || cbpolyatomic10.isSelected() || cbhydrates.isSelected() || cbpolyatomic11.isSelected() || cbacids10.isSelected() || cbacids11.isSelected()){
      if(evt.getSource() == beginbutton){
        beginbutton.setEnabled(false);
        //Also set the list in here and print out the first answer
        intRandE1 = (int)(Math.random()*36) + 1;
        intRandE2 = (int)(Math.random()*14);
        intRandE2V2 = (int)(Math.random()*14);
        intRandComp = (int)(Math.random()*2);
        intRandC1 = (int)(Math.random()*10) + 1;
        intRandC2 = (int)(Math.random()*10) + 1;
        intRandH = (int)(Math.random()*10) + 1;
        intRandA10 = (int)(Math.random()*18);
        intRandA11 = (int)(Math.random()*25);
        
        intRandP10 = (int)(Math.random()*9);
        intRandP11 = (int)(Math.random()*25);
        intRandType = type.get((int)(Math.random()*type.size()));
        
        //prints next question
        if(intRandComp == 0){ //name
          if(intRandType == 0){
            lblQuestion.setText(metal[intRandE1].strName + " " + nonmetal[intRandE2].strName2);
          }
          else if(intRandType == 1){
            //covalent compound label setting
            lblQuestion.setText(compound.covalent(nonmetal[intRandE2].strName, nonmetal[intRandE2V2].strName2,intRandC1,intRandC2));
          }
          else if(intRandType == 2){
            lblQuestion.setText(compound.hydrate(metal[intRandE1].strName.toLowerCase(),nonmetal[intRandE2].strName2.toLowerCase(),intRandH));
          }
          else if(intRandType == 3){
            lblQuestion.setText(metal[intRandE1].strName + " " + polyatom10[intRandP10].strName);
          }
          else if(intRandType == 4){
            lblQuestion.setText(metal[intRandE1].strName + " " + polyatom11[intRandP11].strName);
          }
          else if(intRandType == 5){
            lblQuestion.setText(acids10[intRandA10].strName);
          }
          else if(intRandType == 6){
            lblQuestion.setText(acids11[intRandA11].strName);
          }
        }else if(intRandComp == 1){ //formula
          if(intRandType == 0){
            strIComp = compound.displayionic(metal[intRandE1].strSymbol,nonmetal[intRandE2].strSymbol,metal[intRandE1].intCharge,nonmetal[intRandE2].intCharge);
            lblQuestion.setText(strIComp);
          }else if(intRandType == 1){
            //covalent compound label setting
            if(intRandC1 == 1 && intRandC2 == 1){
              lblQuestion.setText(nonmetal[intRandE2].strSymbol+nonmetal[intRandE2V2].strSymbol);
            }else if(intRandC2 == 1){
              lblQuestion.setText("<html>"+nonmetal[intRandE2].strSymbol+"<sub>"+intRandC1+"</sub>"+nonmetal[intRandE2V2].strSymbol+"</html>");
            }else if(intRandC1 == 1){
              lblQuestion.setText("<html>"+nonmetal[intRandE2].strSymbol+nonmetal[intRandE2V2].strSymbol+"<sub>"+intRandC2+"</sub></html>");
            }else{
              lblQuestion.setText("<html>"+nonmetal[intRandE2].strSymbol+"<sub>"+intRandC1+"</sub>"+nonmetal[intRandE2V2].strSymbol+"<sub>"+intRandC2+"</sub></html>");
            }
          }else if(intRandType == 2){
            lblQuestion.setText(compound.formulahydrate(metal[intRandE1].strSymbol,nonmetal[intRandE2].strSymbol,metal[intRandE1].intCharge,nonmetal[intRandE2].intCharge,intRandH));
          }else if(intRandType == 3){
            lblQuestion.setText(compound.displaypolyatomic(metal[intRandE1].strSymbol,polyatom10[intRandP10].strSymbol,polyatom10[intRandP10].strName2,metal[intRandE1].intCharge,polyatom10[intRandP10].intCharge));
          }else if(intRandType == 4){
            lblQuestion.setText(compound.displaypolyatomic(metal[intRandE1].strSymbol,polyatom11[intRandP11].strSymbol,polyatom11[intRandP11].strName2,metal[intRandE1].intCharge,polyatom11[intRandP11].intCharge));
          }else if(intRandType == 5){
            lblQuestion.setText("<html>" +compound.subscript(acids10[intRandA10].strSymbol) + "</html>");
          }else if(intRandType == 6){
            lblQuestion.setText("<html>" +compound.subscript(acids11[intRandA11].strSymbol) + "</html>");
          }
        }
      }
    }
    if(evt.getSource() == tfAnswer){
      if(intRandComp == 0){ //Decides to give a question to convert from name --> formula and outputs answer
        if(intRandType == 0){ //If it randoms to an ionic compound
          strAnswer = compound.ionic(metal[intRandE1].strSymbol,nonmetal[intRandE2].strSymbol,metal[intRandE1].intCharge,nonmetal[intRandE2].intCharge);
          if(strAnswer.equals(tfAnswer.getText())){ //If they are correct
            lblQAns.setForeground(Color.GREEN);
            lblQAns.setText(compound.displayionic(metal[intRandE1].strSymbol,nonmetal[intRandE2].strSymbol,metal[intRandE1].intCharge,nonmetal[intRandE2].intCharge));
            intScore++;
          }else{ //If they are wrong
            lblQAns.setForeground(Color.RED);
            lblQAns.setText(compound.displayionic(metal[intRandE1].strSymbol,nonmetal[intRandE2].strSymbol,metal[intRandE1].intCharge,nonmetal[intRandE2].intCharge));
            intScore--;
          }
        }else if(intRandType == 1){ //If it randoms to a covalent compound
          //CHANGE SHIT RIGHT HERE
          if(intRandC1 == 1 && intRandC2 == 1){
            strAnswer = nonmetal[intRandE2].strSymbol+nonmetal[intRandE2V2].strSymbol;
          }else if(intRandC2 == 1){
            strAnswer = nonmetal[intRandE2].strSymbol+intRandC1+nonmetal[intRandE2V2].strSymbol;
          }else if(intRandC1 == 1){
            strAnswer = nonmetal[intRandE2].strSymbol+nonmetal[intRandE2V2].strSymbol+intRandC2;
          }else{
            strAnswer = nonmetal[intRandE2].strSymbol+intRandC1+nonmetal[intRandE2V2].strSymbol+intRandC2;
          }
          if(strAnswer.equals(tfAnswer.getText())){ //If they are correct
            //covalent compound label setting
            if(intRandC1 == 1 && intRandC2 == 1){
              strAnswer = nonmetal[intRandE2].strSymbol+nonmetal[intRandE2V2].strSymbol;
            }else if(intRandC2 == 1){
              strAnswer = "<html>"+nonmetal[intRandE2].strSymbol+"<sub>"+intRandC1+"</sub>"+nonmetal[intRandE2V2].strSymbol+"</html>";
            }else if(intRandC1 == 1){
              strAnswer = "<html>"+nonmetal[intRandE2].strSymbol+nonmetal[intRandE2V2].strSymbol+"<sub>"+intRandC2+"</sub></html>";
            }else{
              strAnswer = "<html>"+nonmetal[intRandE2].strSymbol+"<sub>"+intRandC1+"</sub>"+nonmetal[intRandE2V2].strSymbol+"<sub>"+intRandC2+"</sub></html>";
            }
            
            lblQAns.setForeground(Color.GREEN);
            lblQAns.setText(strAnswer);
            intScore++;
          }else{ //If they are wrong
            //covalent compound label setting
            if(intRandC1 == 1 && intRandC2 == 1){
              strAnswer = nonmetal[intRandE2].strSymbol+nonmetal[intRandE2V2].strSymbol;
            }else if(intRandC2 == 1){
              strAnswer = "<html>"+nonmetal[intRandE2].strSymbol+"<sub>"+intRandC1+"</sub>"+nonmetal[intRandE2V2].strSymbol+"</html>";
            }else if(intRandC1 == 1){
              strAnswer = "<html>"+nonmetal[intRandE2].strSymbol+nonmetal[intRandE2V2].strSymbol+"<sub>"+intRandC2+"</sub></html>";
            }else{
              strAnswer = "<html>"+nonmetal[intRandE2].strSymbol+"<sub>"+intRandC1+"</sub>"+nonmetal[intRandE2V2].strSymbol+"<sub>"+intRandC2+"</sub></html>";
            }
            lblQAns.setForeground(Color.RED);
            lblQAns.setText(strAnswer);
            intScore--;
          }
          
        }else if(intRandType == 2){
          //Put code here for hydrates
          strAnswer = compound.answerforhydrates(metal[intRandE1].strSymbol,nonmetal[intRandE2].strSymbol,metal[intRandE1].intCharge,nonmetal[intRandE2].intCharge,intRandH);
          if(strAnswer.equals(tfAnswer.getText())){ //If they are correct
            lblQAns.setForeground(Color.GREEN);
            if(intRandH == 1){
              lblQAns.setText(compound.ansformulahydrate(metal[intRandE1].strSymbol,nonmetal[intRandE2].strSymbol,metal[intRandE1].intCharge,nonmetal[intRandE2].intCharge,intRandH));
            }else{
              lblQAns.setText(compound.ansformulahydrate(metal[intRandE1].strSymbol,nonmetal[intRandE2].strSymbol,metal[intRandE1].intCharge,nonmetal[intRandE2].intCharge,intRandH));
            }
            intScore++;
          }else{ //If they are wrong
            lblQAns.setForeground(Color.RED);
            if(intRandH == 1){
              lblQAns.setText(compound.ansformulahydrate(metal[intRandE1].strSymbol,nonmetal[intRandE2].strSymbol,metal[intRandE1].intCharge,nonmetal[intRandE2].intCharge,intRandH));
            }else{
              lblQAns.setText(compound.ansformulahydrate(metal[intRandE1].strSymbol,nonmetal[intRandE2].strSymbol,metal[intRandE1].intCharge,nonmetal[intRandE2].intCharge,intRandH));
            }
            intScore--;
          }
        }else if(intRandType == 3){ // code for polyatomic grade 10
          strAnswer = compound.polyatomic(metal[intRandE1].strSymbol,polyatom10[intRandP10].strSymbol,polyatom10[intRandP10].strName2,metal[intRandE1].intCharge,polyatom10[intRandP10].intCharge);
          if(strAnswer.equals(tfAnswer.getText())){ //If they are correct
            lblQAns.setForeground(Color.GREEN);
            lblQAns.setText(compound.displaypolyatomic(metal[intRandE1].strSymbol,polyatom10[intRandP10].strSymbol,polyatom10[intRandP10].strName2,metal[intRandE1].intCharge,polyatom10[intRandP10].intCharge));
            intScore++;
          }else{ //If they are wrong
            lblQAns.setForeground(Color.RED);
            lblQAns.setText(compound.displaypolyatomic(metal[intRandE1].strSymbol,polyatom10[intRandP10].strSymbol,polyatom10[intRandP10].strName2,metal[intRandE1].intCharge,polyatom10[intRandP10].intCharge));
            intScore--;
          }
        }else if(intRandType == 4){
          strAnswer = compound.polyatomic(metal[intRandE1].strSymbol,polyatom11[intRandP11].strSymbol,polyatom11[intRandP11].strName2,metal[intRandE1].intCharge,polyatom11[intRandP11].intCharge);
          if(strAnswer.equals(tfAnswer.getText())){ //If they are correct
            lblQAns.setForeground(Color.GREEN);
            lblQAns.setText(compound.displaypolyatomic(metal[intRandE1].strSymbol,polyatom11[intRandP11].strSymbol,polyatom11[intRandP11].strName2,metal[intRandE1].intCharge,polyatom11[intRandP11].intCharge));
            intScore++;
          }else{ //If they are wrong
            lblQAns.setForeground(Color.RED);
            lblQAns.setText(compound.displaypolyatomic(metal[intRandE1].strSymbol,polyatom11[intRandP11].strSymbol,polyatom11[intRandP11].strName2,metal[intRandE1].intCharge,polyatom11[intRandP11].intCharge));
            intScore--;
          }
        }else if(intRandType == 5){
          strAnswer = acids10[intRandA10].strSymbol;
          if(strAnswer.equals(tfAnswer.getText())){ //If they are correct
            lblQAns.setForeground(Color.GREEN);
            lblQAns.setText("<html>" +compound.subscript(acids10[intRandA10].strSymbol)+ "</html>");
            intScore++;
          }else{ //If they are wrong
            lblQAns.setForeground(Color.RED);
            lblQAns.setText("<html>" +compound.subscript(acids10[intRandA10].strSymbol) + "</html>");
            intScore--;
          }
        }else if(intRandType == 6){
          strAnswer = acids11[intRandA11].strSymbol;
          if(strAnswer.equals(tfAnswer.getText())){ //If they are correct
            lblQAns.setForeground(Color.GREEN);
            lblQAns.setText("<html>" +compound.subscript(acids11[intRandA11].strSymbol)+ "</html>");
            intScore++;
          }else{ //If they are wrong
            lblQAns.setForeground(Color.RED);
            lblQAns.setText("<html>" +compound.subscript(acids11[intRandA11].strSymbol) + "</html>");
            intScore--;
          }
        }
      }else if(intRandComp == 1){ //Decides to give a question to convert from formula --> name and outputs answer
        if(intRandType == 0){ //If it randoms to an ionic compound
          strAnswer = metal[intRandE1].strName + " "+ nonmetal[intRandE2].strName2;
          if(strAnswer.equalsIgnoreCase(tfAnswer.getText())){  //If they are correct
            lblQAns.setForeground(Color.GREEN);
            lblQAns.setText(strAnswer);
            intScore++;
          }else{  //If they are wrong
            lblQAns.setForeground(Color.RED);
            lblQAns.setText(strAnswer);
            intScore--;
          }
        }else if(intRandType == 1){ //If it randoms to a covalent compound
          strAnswer = compound.covalent(nonmetal[intRandE2].strName, nonmetal[intRandE2V2].strName2,intRandC1,intRandC2);
          if(strAnswer.equalsIgnoreCase(tfAnswer.getText())){ //If they are correct
            lblQAns.setForeground(Color.GREEN);
            lblQAns.setText(strAnswer);
            intScore++;
          }else{ //If they are wrong
            lblQAns.setForeground(Color.RED);
            lblQAns.setText(strAnswer);
            intScore--;
          }
        }else if(intRandType == 2){
          //Put code here for hydrates 
          strAnswer = metal[intRandE1].strName.toLowerCase() + " "+ nonmetal[intRandE2].strName2.toLowerCase() + " " + compound.prefix(intRandH) + "hydrate";
          if(strAnswer.equalsIgnoreCase(tfAnswer.getText())){ //If they are correct
            lblQAns.setForeground(Color.GREEN);
            lblQAns.setText(strAnswer);
            intScore++;
          }else{ //If they are wrong
            lblQAns.setForeground(Color.RED);
            lblQAns.setText(strAnswer);
            intScore--;
          }
        }else if(intRandType == 3){ //code for polyatomic grade 10
          strAnswer = metal[intRandE1].strName + " " + polyatom10[intRandP10].strName;
          if(strAnswer.equalsIgnoreCase(tfAnswer.getText())){ //If they are correct
            lblQAns.setForeground(Color.GREEN);
            lblQAns.setText(strAnswer);
            intScore++;
          }else{ //If they are wrong
            lblQAns.setForeground(Color.RED);
            lblQAns.setText(strAnswer);
            intScore--;
          }
        }else if(intRandType == 4){
          strAnswer = metal[intRandE1].strName + " " + polyatom11[intRandP11].strName;
          if(strAnswer.equalsIgnoreCase(tfAnswer.getText())){ //If they are correct
            lblQAns.setForeground(Color.GREEN);
            lblQAns.setText(strAnswer);
            intScore++;
          }else{ //If they are wrong
            lblQAns.setForeground(Color.RED);
            lblQAns.setText(strAnswer);
            intScore--;
          }
        }else if(intRandType == 5){
          strAnswer = acids10[intRandA10].strName;
          if(strAnswer.equalsIgnoreCase(tfAnswer.getText())){ //If they are correct
            lblQAns.setForeground(Color.GREEN);
            lblQAns.setText(strAnswer);
            intScore++;
          }else{ //If they are wrong
            lblQAns.setForeground(Color.RED);
            lblQAns.setText(strAnswer);
            intScore--;
          }
        }else if(intRandType == 6){
          strAnswer = acids11[intRandA11].strName;
          if(strAnswer.equalsIgnoreCase(tfAnswer.getText())){ //If they are correct
            lblQAns.setForeground(Color.GREEN);
            lblQAns.setText(strAnswer);
            intScore++;
          }else{ //If they are wrong
            lblQAns.setForeground(Color.RED);
            lblQAns.setText(strAnswer);
            intScore--;
          }
        }
        
      }
      //outputs your score and sends it to the highscore.txt to see if you beat the high score
      lblScore.setText("Your Score: " + intScore);
      lblPQuestion.setText("<html>Previous Question: " + lblQuestion.getText()+"</html>");
      //Resets random variables for the question
      intRandE1 = (int)(Math.random()*36) + 1;
      intRandE2 = (int)(Math.random()*14);
      intRandE2V2 = (int)(Math.random()*14);
      intRandComp = (int)(Math.random()*2);
      intRandC1 = (int)(Math.random()*10) + 1;
      intRandC2 = (int)(Math.random()*10) + 1;
      intRandH = (int)(Math.random()*10) + 1;
      intRandA10 = (int)(Math.random()*18);
      intRandA11 = (int)(Math.random()*25);
      intRandP10 = (int)(Math.random()*9);
      intRandP11 = (int)(Math.random()*25);
      intRandType = type.get((int)(Math.random()*type.size()));
      
      //prints next question
      if(intRandComp == 0){ //name
        if(intRandType == 0){
          lblQuestion.setText(metal[intRandE1].strName + " " + nonmetal[intRandE2].strName2);
        }
        else if(intRandType == 1){
          //covalent compound label setting
          lblQuestion.setText(compound.covalent(nonmetal[intRandE2].strName, nonmetal[intRandE2V2].strName2,intRandC1,intRandC2));
        }
        else if(intRandType == 2){
          lblQuestion.setText(compound.hydrate(metal[intRandE1].strName.toLowerCase(),nonmetal[intRandE2].strName2.toLowerCase(),intRandH));
        }
        else if(intRandType == 3){
          lblQuestion.setText(metal[intRandE1].strName + " " + polyatom10[intRandP10].strName);
        }
        else if(intRandType == 4){
          lblQuestion.setText(metal[intRandE1].strName + " " + polyatom11[intRandP11].strName);
        }
        else if(intRandType == 5){
          lblQuestion.setText(acids10[intRandA10].strName);
        }
        else if(intRandType == 6){
          lblQuestion.setText(acids11[intRandA11].strName);
        }
      }else if(intRandComp == 1){ //formula
        if(intRandType == 0){
          strIComp = compound.displayionic(metal[intRandE1].strSymbol,nonmetal[intRandE2].strSymbol,metal[intRandE1].intCharge,nonmetal[intRandE2].intCharge);
          lblQuestion.setText(strIComp);
        }else if(intRandType == 1){
          //covalent compound label setting
          if(intRandC1 == 1 && intRandC2 == 1){
            lblQuestion.setText(nonmetal[intRandE2].strSymbol+nonmetal[intRandE2V2].strSymbol);
          }else if(intRandC2 == 1){
            lblQuestion.setText("<html>"+nonmetal[intRandE2].strSymbol+"<sub>"+intRandC1+"</sub>"+nonmetal[intRandE2V2].strSymbol+"</html>");
          }else if(intRandC1 == 1){
            lblQuestion.setText("<html>"+nonmetal[intRandE2].strSymbol+nonmetal[intRandE2V2].strSymbol+"<sub>"+intRandC2+"</sub></html>");
          }else{
            lblQuestion.setText("<html>"+nonmetal[intRandE2].strSymbol+"<sub>"+intRandC1+"</sub>"+nonmetal[intRandE2V2].strSymbol+"<sub>"+intRandC2+"</sub></html>");
          }
        }else if(intRandType == 2){
          lblQuestion.setText(compound.formulahydrate(metal[intRandE1].strSymbol,nonmetal[intRandE2].strSymbol,metal[intRandE1].intCharge,nonmetal[intRandE2].intCharge,intRandH));
        }else if(intRandType == 3){
          lblQuestion.setText(compound.displaypolyatomic(metal[intRandE1].strSymbol,polyatom10[intRandP10].strSymbol,polyatom10[intRandP10].strName2,metal[intRandE1].intCharge,polyatom10[intRandP10].intCharge));
        }else if(intRandType == 4){
          lblQuestion.setText(compound.displaypolyatomic(metal[intRandE1].strSymbol,polyatom11[intRandP11].strSymbol,polyatom11[intRandP11].strName2,metal[intRandE1].intCharge,polyatom11[intRandP11].intCharge));
        }else if(intRandType == 5){
          lblQuestion.setText("<html>" +compound.subscript(acids10[intRandA10].strSymbol) + "</html>");
        }else if(intRandType == 6){
          lblQuestion.setText("<html>" +compound.subscript(acids11[intRandA11].strSymbol) + "</html>");
        }
      }
      tfAnswer.setText("");
    }
    //**************************
    //The test event sources
    //**************************
    if(evt.getSource() == testbutton){
      //removes everything from the screen in main menu
      thepanel.remove(startbutton);
      thepanel.remove(aboutbutton);
      thepanel.remove(helpbutton);
      thepanel.remove(testbutton);
      thepanel.remove(therb10);
      thepanel.remove(therb11);
      thepanel.remove(lblMyself);
      
      //adds the thing needed for a tutorial
      thepanel.intMenuSelect = 4;
      thepanel.add(backbutton);
      thepanel.add(ionicbutton);
      thepanel.add(covalentbutton);
      thepanel.add(acidbutton);
      thepanel.add(hydratebutton);
      thepanel.add(polyatomicbutton);
    }
    if(evt.getSource() == backbutton2){ //Goes back from the test to the choice screen
      lblInput.setText("");
      lblOutput.setText("");
      lblInstruction.setText("Please select a metal(elements with a positive charge)");
      thepanel.intMenuSelect = 4;
      thepanel.add(backbutton);
      thepanel.add(ionicbutton);
      thepanel.add(covalentbutton);
      thepanel.add(acidbutton);
      thepanel.add(hydratebutton);
      thepanel.add(polyatomicbutton);
      thepanel.add(backbutton);
      thepanel.remove(H);
      thepanel.remove(Li);
      thepanel.remove(Be);
      thepanel.remove(Na);
      thepanel.remove(Mg);
      thepanel.remove(K);
      thepanel.remove(Ca);
      thepanel.remove(Rb);
      thepanel.remove(Sr);
      thepanel.remove(Cs);
      thepanel.remove(Ba);
      thepanel.remove(Fr);
      thepanel.remove(Ra);
      
      thepanel.remove(Ti);
      thepanel.remove(Cr);
      thepanel.remove(Mn);
      thepanel.remove(Fe);
      thepanel.remove(Co);
      thepanel.remove(Ni);
      thepanel.remove(Cu);
      thepanel.remove(Zn);
      thepanel.remove(Ag);
      thepanel.remove(Pt);
      thepanel.remove(Au);
      thepanel.remove(Hg);
      thepanel.remove(Sn);
      thepanel.remove(Pb);
      
      thepanel.remove(F);
      thepanel.remove(O);
      thepanel.remove(N);
      thepanel.remove(Cl);
      thepanel.remove(S);
      thepanel.remove(P);
      thepanel.remove(As);
      thepanel.remove(Se);
      thepanel.remove(Br);
      thepanel.remove(Te);
      thepanel.remove(I);
      thepanel.remove(At);
      thepanel.remove(C);
      thepanel.remove(Si);
      
      thepanel.remove(but1);
      thepanel.remove(but2);
      thepanel.remove(but3);
      thepanel.remove(but4);
      thepanel.remove(but5);
      thepanel.remove(but6);
      thepanel.remove(but7);
      thepanel.remove(but8);
      thepanel.remove(but9);
      thepanel.remove(but10);
      
      thepanel.remove(button1);
      thepanel.remove(button2);
      
      thepanel.remove(lblInstruction);
      thepanel.remove(lblInput);
      thepanel.remove(lblOutput);
      thepanel.remove(clearbutton);
      thepanel.remove(donebutton);
      thepanel.remove(rbformula);
      thepanel.remove(rbname);
      thepanel.remove(backbutton2);
      
      intStep = 0;
      firstAns = null;
      secondAns = null;
      firstNumAns = 0;
      secondNumAns = 0;
    }
    if(evt.getSource() == ionicbutton){ //If you want to test ionic compounds
      intGroupChoice = 0;
      lblInstruction.setText("Please select a metal(elements with a positive charge)");
      thepanel.intMenuSelect = 5;
      thepanel.add(lblInstruction);
      thepanel.add(lblInput);
      thepanel.add(lblOutput);
      thepanel.add(clearbutton);
      thepanel.add(donebutton);
      thepanel.add(rbformula);
      thepanel.add(rbname);
      thepanel.add(backbutton2);
      
      thepanel.add(Li);
      thepanel.add(Be);
      thepanel.add(Na);
      thepanel.add(Mg);
      thepanel.add(K);
      thepanel.add(Ca);
      thepanel.add(Rb);
      thepanel.add(Sr);
      thepanel.add(Cs);
      thepanel.add(Ba);
      thepanel.add(Fr);
      thepanel.add(Ra);
      
      thepanel.add(Ti);
      thepanel.add(Cr);
      thepanel.add(Mn);
      thepanel.add(Fe);
      thepanel.add(Co);
      thepanel.add(Ni);
      thepanel.add(Cu);
      thepanel.add(Zn);
      thepanel.add(Ag);
      thepanel.add(Pt);
      thepanel.add(Au);
      thepanel.add(Hg);
      thepanel.add(Sn);
      thepanel.add(Pb);
      
      thepanel.remove(backbutton);
      thepanel.remove(ionicbutton);
      thepanel.remove(covalentbutton);
      thepanel.remove(acidbutton);
      thepanel.remove(hydratebutton);
      thepanel.remove(polyatomicbutton);
      
    }
    if(evt.getSource() == covalentbutton){ //If you want to test covalent compounds
      intGroupChoice = 1;
      intStep = 0;
      lblInstruction.setText("Please select a nonmetal(elements with a negative charge)");
      thepanel.intMenuSelect = 6;
      thepanel.add(lblInstruction);
      thepanel.add(lblInput);
      thepanel.add(lblOutput);
      thepanel.add(clearbutton);
      thepanel.add(donebutton);
      thepanel.add(rbformula);
      thepanel.add(rbname);
      thepanel.add(backbutton2);
      
      thepanel.add(F);
      thepanel.add(O);
      thepanel.add(N);
      thepanel.add(Cl);
      thepanel.add(S);
      thepanel.add(P);
      thepanel.add(C);
      thepanel.add(Si);
      thepanel.add(As);
      thepanel.add(Se);
      thepanel.add(Br);
      thepanel.add(Te);
      thepanel.add(I);
      thepanel.add(At);
      
      thepanel.remove(backbutton);
      thepanel.remove(ionicbutton);
      thepanel.remove(covalentbutton);
      thepanel.remove(acidbutton);
      thepanel.remove(hydratebutton);
      thepanel.remove(polyatomicbutton);
    }
    if(evt.getSource() == hydratebutton){ //to test hydrates
      intGroupChoice = 2;
      intStep = 0;
      lblInstruction.setText("Please select a metal(elements with a positive charge)");
      thepanel.intMenuSelect = 6;
      thepanel.add(lblInstruction);
      thepanel.add(lblInput);
      thepanel.add(lblOutput);
      thepanel.add(clearbutton);
      thepanel.add(donebutton);
      thepanel.add(rbformula);
      thepanel.add(rbname);
      thepanel.add(backbutton2);
      
      thepanel.add(Li);
      thepanel.add(Be);
      thepanel.add(Na);
      thepanel.add(Mg);
      thepanel.add(K);
      thepanel.add(Ca);
      thepanel.add(Rb);
      thepanel.add(Sr);
      thepanel.add(Cs);
      thepanel.add(Ba);
      thepanel.add(Fr);
      thepanel.add(Ra);
      
      thepanel.add(Ti);
      thepanel.add(Cr);
      thepanel.add(Mn);
      thepanel.add(Fe);
      thepanel.add(Co);
      thepanel.add(Ni);
      thepanel.add(Cu);
      thepanel.add(Zn);
      thepanel.add(Ag);
      thepanel.add(Pt);
      thepanel.add(Au);
      thepanel.add(Hg);
      thepanel.add(Sn);
      thepanel.add(Pb);
      
      thepanel.remove(backbutton);
      thepanel.remove(ionicbutton);
      thepanel.remove(covalentbutton);
      thepanel.remove(acidbutton);
      thepanel.remove(hydratebutton);
      thepanel.remove(polyatomicbutton);
    }
    if(evt.getSource() == acidbutton){ //sets everything up for the acid chart
      thepanel.intMenuSelect = 7;
      thepanel.add(backbutton2);
      
      thepanel.remove(backbutton);
      thepanel.remove(ionicbutton);
      thepanel.remove(covalentbutton);
      thepanel.remove(acidbutton);
      thepanel.remove(hydratebutton);
      thepanel.remove(polyatomicbutton);
    }
    if(evt.getSource() == polyatomicbutton){ //sets everything up for the polyatomic chart
      thepanel.intMenuSelect = 8;
      thepanel.add(backbutton2);
      
      thepanel.remove(backbutton);
      thepanel.remove(ionicbutton);
      thepanel.remove(covalentbutton);
      thepanel.remove(acidbutton);
      thepanel.remove(hydratebutton);
      thepanel.remove(polyatomicbutton);
    }
    if(evt.getSource() == rbformula){
      rbname.setSelected(false);
      rbformula.setSelected(true);
      //thepanel.blnAlgType = false;
    }else if(evt.getSource() == rbname){
      rbformula.setSelected(false);
      rbname.setSelected(true);
      //thepanel.blnAlgType = true;
    }
    if(evt.getSource() == clearbutton){
      //clears the input label and resets the clicking to ready the program for another input
      lblInput.setText("");
      lblOutput.setText("");
      if(intGroupChoice == 0){ //resets everything for ionic
        lblInstruction.setText("Please select a metal(elements with a positive charge)");
        intStep = 0;
        thepanel.add(Li);
        thepanel.add(Be);
        thepanel.add(Na);
        thepanel.add(Mg);
        thepanel.add(K);
        thepanel.add(Ca);
        thepanel.add(Rb);
        thepanel.add(Sr);
        thepanel.add(Cs);
        thepanel.add(Ba);
        thepanel.add(Fr);
        thepanel.add(Ra);
        thepanel.add(Ti);
        thepanel.add(Cr);
        thepanel.add(Mn);
        thepanel.add(Fe);
        thepanel.add(Co);
        thepanel.add(Ni);
        thepanel.add(Cu);
        thepanel.add(Zn);
        thepanel.add(Ag);
        thepanel.add(Pt);
        thepanel.add(Au);
        thepanel.add(Hg);
        thepanel.add(Sn);
        thepanel.add(Pb);
        thepanel.remove(F);
        thepanel.remove(O);
        thepanel.remove(N);
        thepanel.remove(Cl);
        thepanel.remove(S);
        thepanel.remove(P);
        thepanel.remove(C);
        thepanel.remove(Si);
        thepanel.remove(As);
        thepanel.remove(Se);
        thepanel.remove(Br);
        thepanel.remove(Te);
        thepanel.remove(I);
        thepanel.remove(At);
        thepanel.remove(button1);
        thepanel.remove(button2);
        secondAns = null;
        firstAns = null;
      }else if(intGroupChoice == 1){ //resets everything for covalent
        lblInstruction.setText("Please select a nonmetal(elements with a negative charge)");
        intStep = 0;
        thepanel.add(O);
        thepanel.add(N);
        thepanel.add(Cl);
        thepanel.add(S);
        thepanel.add(P);
        thepanel.add(F); 
        thepanel.add(C);
        thepanel.add(Si);
        thepanel.add(As);
        thepanel.add(Se);
        thepanel.add(Br);
        thepanel.add(Te);
        thepanel.add(I);
        thepanel.add(At);
        thepanel.remove(but1);
        thepanel.remove(but2);
        thepanel.remove(but3);
        thepanel.remove(but4);
        thepanel.remove(but5);
        thepanel.remove(but6);
        thepanel.remove(but7);
        thepanel.remove(but8);
        thepanel.remove(but9);
        thepanel.remove(but10);
        secondAns = null;
        firstAns = null;
        firstNumAns = 0;
        secondNumAns = 0;
      }else if(intGroupChoice == 2){ //resets everything for hydrates
        lblInstruction.setText("Please select a metal(elements with a positive charge)");
        intStep = 0;
        thepanel.add(Li);
        thepanel.add(Be);
        thepanel.add(Na);
        thepanel.add(Mg);
        thepanel.add(K);
        thepanel.add(Ca); 
        thepanel.add(Rb);
        thepanel.add(Sr);
        thepanel.add(Cs);
        thepanel.add(Ba);
        thepanel.add(Fr);
        thepanel.add(Ra);
        thepanel.add(Ti);
        thepanel.add(Cr);
        thepanel.add(Mn);
        thepanel.add(Fe);
        thepanel.add(Co);
        thepanel.add(Ni);
        thepanel.add(Cu);
        thepanel.add(Zn);
        thepanel.add(Ag);
        thepanel.add(Pt);
        thepanel.add(Au);
        thepanel.add(Hg);
        thepanel.add(Sn);
        thepanel.add(Pb);
        
        thepanel.remove(F);
        thepanel.remove(O);
        thepanel.remove(N);
        thepanel.remove(Cl);
        thepanel.remove(S);
        thepanel.remove(P);
        thepanel.remove(C);
        thepanel.remove(Si);
        thepanel.remove(As);
        thepanel.remove(Se);
        thepanel.remove(Br);
        thepanel.remove(Te);
        thepanel.remove(I);
        thepanel.remove(At);
        thepanel.remove(but1);
        thepanel.remove(but2);
        thepanel.remove(but3);
        thepanel.remove(but4);
        thepanel.remove(but5);
        thepanel.remove(but6);
        thepanel.remove(but7);
        thepanel.remove(but8);
        thepanel.remove(but9);
        thepanel.remove(but10);
        thepanel.remove(button1);
        thepanel.remove(button2);
        secondAns = null;
        firstAns = null;
        firstNumAns = 0;
        secondNumAns = 0;
      }
    }
    if(evt.getSource() == donebutton){ 
      //Allows one to click to find the answer of the inputted variables
      if(intGroupChoice == 0 && intStep == 3){ //Ionic finish condition
        lblInstruction.setText("Please select a metal(elements with a positive charge)");
        lblInput.setText("");
        thepanel.add(Li);
        thepanel.add(Be);
        thepanel.add(Na);
        thepanel.add(Mg);
        thepanel.add(K);
        thepanel.add(Rb);
        thepanel.add(Sr);
        thepanel.add(Cs);
        thepanel.add(Ba);
        thepanel.add(Fr);
        thepanel.add(Ra);
        thepanel.add(Ca);
        thepanel.add(Ti);
        thepanel.add(Cr);
        thepanel.add(Mn);
        thepanel.add(Fe);
        thepanel.add(Co);
        thepanel.add(Ni);
        thepanel.add(Cu);
        thepanel.add(Zn);
        thepanel.add(Ag);
        thepanel.add(Pt);
        thepanel.add(Au);
        thepanel.add(Hg);
        thepanel.add(Sn);
        thepanel.add(Pb);
        thepanel.remove(F);
        thepanel.remove(O);
        thepanel.remove(N);
        thepanel.remove(Cl);
        thepanel.remove(S);
        thepanel.remove(P);
        thepanel.remove(C);
        thepanel.remove(Si);
        thepanel.remove(As);
        thepanel.remove(Se);
        thepanel.remove(Br);
        thepanel.remove(Te);
        thepanel.remove(I);
        thepanel.remove(At);
        //changes label to the answer
        if(blnNameOrForm == true){
          lblOutput.setText(compound.displayionic(firstAns.strSymbol,secondAns.strSymbol,firstAns.intCharge,secondAns.intCharge));
        }else{
          lblOutput.setText(firstAns.strName + " " + secondAns.strName2);
        }
        secondAns = null;
        firstAns = null;
        intStep = 0;
      }else if(intGroupChoice == 1 && intStep == 4){ //Covalent finish condition
        lblInstruction.setText("Please select a nonmetal(elements with a negative charge)");
        lblInput.setText("");
        intStep = 0;
        thepanel.add(O);
        thepanel.add(N);
        thepanel.add(Cl);
        thepanel.add(S);
        thepanel.add(P);
        thepanel.add(F); 
        thepanel.add(C);
        thepanel.add(Si);
        thepanel.add(As);
        thepanel.add(Se);
        thepanel.add(Br);
        thepanel.add(Te);
        thepanel.add(I);
        thepanel.add(At);
        thepanel.remove(but1);
        thepanel.remove(but2);
        thepanel.remove(but3);
        thepanel.remove(but4);
        thepanel.remove(but5);
        thepanel.remove(but6);
        thepanel.remove(but7);
        thepanel.remove(but8);
        thepanel.remove(but9);
        thepanel.remove(but10);
        //changes label to the answer
        if(blnNameOrForm == true){
          lblOutput.setText(compound.formulacovalent(firstAns.strSymbol,secondAns.strSymbol,firstNumAns,secondNumAns));
        }else{
          lblOutput.setText(compound.covalent(firstAns.strName,secondAns.strName2,firstNumAns,secondNumAns));
        }
        secondAns = null;
        firstAns = null;
        firstNumAns = 0;
        secondNumAns = 0;
      }else if(intGroupChoice == 2 && intStep == 4){ //Hydrates finish condition
        lblInstruction.setText("Please select a metal(elements with a positive charge)");
        intStep = 0;
        lblInput.setText("");
        thepanel.add(Li);
        thepanel.add(Be);
        thepanel.add(Na);
        thepanel.add(Mg);
        thepanel.add(K);
        thepanel.add(Ca);
        thepanel.add(Rb);
        thepanel.add(Sr);
        thepanel.add(Cs);
        thepanel.add(Ba);
        thepanel.add(Fr);
        thepanel.add(Ra);
        thepanel.add(Ti);
        thepanel.add(Cr);
        thepanel.add(Mn);
        thepanel.add(Fe);
        thepanel.add(Co);
        thepanel.add(Ni);
        thepanel.add(Cu);
        thepanel.add(Zn);
        thepanel.add(Ag);
        thepanel.add(Pt);
        thepanel.add(Au);
        thepanel.add(Hg);
        thepanel.add(Sn);
        thepanel.add(Pb);
        thepanel.remove(F);
        thepanel.remove(O);
        thepanel.remove(N);
        thepanel.remove(Cl);
        thepanel.remove(S);
        thepanel.remove(P);
        thepanel.remove(C);
        thepanel.remove(Si);
        thepanel.remove(As);
        thepanel.remove(Se);
        thepanel.remove(Br);
        thepanel.remove(Te);
        thepanel.remove(I);
        thepanel.remove(At);
        thepanel.remove(but1);
        thepanel.remove(but2);
        thepanel.remove(but3);
        thepanel.remove(but4);
        thepanel.remove(but5);
        thepanel.remove(but6);
        thepanel.remove(but7);
        thepanel.remove(but8);
        thepanel.remove(but9);
        thepanel.remove(but10);
        if(blnNameOrForm == true){
          lblOutput.setText(compound.formulahydrate(firstAns.strSymbol,secondAns.strSymbol,firstAns.intCharge,secondAns.intCharge,firstNumAns));
        }else{
          lblOutput.setText(compound.hydrate(firstAns.strName,secondAns.strName2,firstNumAns));
        }
        secondAns = null;
        firstAns = null;
        firstNumAns = 0;
        secondNumAns = 0;
      }
    }
    if(intGroupChoice == 0){ // Ionic
      if(evt.getSource() == Li || evt.getSource() == Be || evt.getSource() == Na || evt.getSource() == Mg || evt.getSource() == K || evt.getSource() == Ca || evt.getSource() == Rb || evt.getSource() == Sr || evt.getSource() == Cs || evt.getSource() == Ba || evt.getSource() == Fr || evt.getSource() == Ra || evt.getSource() == Ti || evt.getSource() == Cr || evt.getSource() == Mn || evt.getSource() == Fe || evt.getSource() == Co || evt.getSource() == Ni || evt.getSource() == Cu || evt.getSource() == Zn || evt.getSource() == Ag || evt.getSource() == Pt || evt.getSource() == Au || evt.getSource() == Hg || evt.getSource() == Sn || evt.getSource() == Pb){ //If they click a metal
        if(intStep == 0){
          if(rbname.isSelected() == true){ //If they want to go from name --> formula
            if(evt.getSource() == Li){lblInput.setText(metal[1].strName); firstAns = metal[1];}
            else if(evt.getSource() == Be){lblInput.setText(metal[2].strName); firstAns = metal[2];}
            else if(evt.getSource() == Na){lblInput.setText(metal[3].strName); firstAns = metal[3];}
            else if(evt.getSource() == Mg){lblInput.setText(metal[4].strName); firstAns = metal[4];}
            else if(evt.getSource() == K){lblInput.setText(metal[5].strName); firstAns = metal[5];}
            else if(evt.getSource() == Ca){lblInput.setText(metal[6].strName); firstAns = metal[6];}
            else if(evt.getSource() == Rb){lblInput.setText(metal[7].strName); firstAns = metal[7];}
            else if(evt.getSource() == Sr){lblInput.setText(metal[8].strName); firstAns = metal[8];}
            else if(evt.getSource() == Cs){lblInput.setText(metal[9].strName); firstAns = metal[9];}
            else if(evt.getSource() == Ba){lblInput.setText(metal[10].strName); firstAns = metal[10];}
            else if(evt.getSource() == Fr){lblInput.setText(metal[11].strName); firstAns = metal[11];}
            else if(evt.getSource() == Ra){lblInput.setText(metal[12].strName); firstAns = metal[12];}
            else if(evt.getSource() == Ti){lblInput.setText(metal[13].strName2); firstAns = metal[13];}
            else if(evt.getSource() == Cr){lblInput.setText(metal[15].strName2); firstAns = metal[15];}
            else if(evt.getSource() == Mn){lblInput.setText(metal[17].strName2); firstAns = metal[17];}
            else if(evt.getSource() == Fe){lblInput.setText(metal[19].strName2); firstAns = metal[19];}
            else if(evt.getSource() == Co){lblInput.setText(metal[21].strName2); firstAns = metal[21];}
            else if(evt.getSource() == Ni){lblInput.setText(metal[23].strName2); firstAns = metal[23];}
            else if(evt.getSource() == Cu){lblInput.setText(metal[25].strName2); firstAns = metal[25];}
            else if(evt.getSource() == Zn){lblInput.setText(metal[27].strName2); firstAns = metal[27];}
            else if(evt.getSource() == Ag){lblInput.setText(metal[28].strName2); firstAns = metal[28];}
            else if(evt.getSource() == Pt){lblInput.setText(metal[29].strName2); firstAns = metal[29];}
            else if(evt.getSource() == Au){lblInput.setText(metal[31].strName2); firstAns = metal[31];}
            else if(evt.getSource() == Hg){lblInput.setText(metal[33].strName2); firstAns = metal[33];}
            else if(evt.getSource() == Sn){lblInput.setText(metal[35].strName2); firstAns = metal[35];}
            else if(evt.getSource() == Pb){lblInput.setText(metal[37].strName2); firstAns = metal[37];}
            blnNameOrForm = true;
          }else if(rbformula.isSelected() == true){ //If they want to go from formula --> name
            if(evt.getSource() == Li){lblInput.setText(metal[1].strSymbol); firstAns = metal[1];}
            else if(evt.getSource() == Be){lblInput.setText(metal[2].strSymbol); firstAns = metal[2];}
            else if(evt.getSource() == Na){lblInput.setText(metal[3].strSymbol); firstAns = metal[3];}
            else if(evt.getSource() == Mg){lblInput.setText(metal[4].strSymbol); firstAns = metal[4];}
            else if(evt.getSource() == K){lblInput.setText(metal[5].strSymbol); firstAns = metal[5];}
            else if(evt.getSource() == Ca){lblInput.setText(metal[6].strSymbol); firstAns = metal[6];}
            else if(evt.getSource() == Rb){lblInput.setText(metal[7].strSymbol); firstAns = metal[7];}
            else if(evt.getSource() == Sr){lblInput.setText(metal[8].strSymbol); firstAns = metal[8];}
            else if(evt.getSource() == Cs){lblInput.setText(metal[9].strSymbol); firstAns = metal[9];}
            else if(evt.getSource() == Ba){lblInput.setText(metal[10].strSymbol); firstAns = metal[10];}
            else if(evt.getSource() == Fr){lblInput.setText(metal[11].strSymbol); firstAns = metal[11];}
            else if(evt.getSource() == Ra){lblInput.setText(metal[12].strSymbol); firstAns = metal[12];}
            else if(evt.getSource() == Ti){lblInput.setText(metal[13].strSymbol); firstAns = metal[13]; }
            else if(evt.getSource() == Cr){lblInput.setText(metal[15].strSymbol); firstAns = metal[15];}
            else if(evt.getSource() == Mn){lblInput.setText(metal[17].strSymbol); firstAns = metal[17];}
            else if(evt.getSource() == Fe){lblInput.setText(metal[19].strSymbol); firstAns = metal[19];}
            else if(evt.getSource() == Co){lblInput.setText(metal[21].strSymbol); firstAns = metal[21];}
            else if(evt.getSource() == Ni){lblInput.setText(metal[23].strSymbol); firstAns = metal[23];}
            else if(evt.getSource() == Cu){lblInput.setText(metal[25].strSymbol); firstAns = metal[25];}
            else if(evt.getSource() == Zn){lblInput.setText(metal[27].strSymbol); firstAns = metal[27];}
            else if(evt.getSource() == Ag){lblInput.setText(metal[28].strSymbol); firstAns = metal[28];}
            else if(evt.getSource() == Pt){lblInput.setText(metal[29].strSymbol); firstAns = metal[29];}
            else if(evt.getSource() == Au){lblInput.setText(metal[31].strSymbol); firstAns = metal[31];}
            else if(evt.getSource() == Hg){lblInput.setText(metal[33].strSymbol); firstAns = metal[33];}
            else if(evt.getSource() == Sn){lblInput.setText(metal[35].strSymbol); firstAns = metal[35];}
            else if(evt.getSource() == Pb){lblInput.setText(metal[37].strSymbol); firstAns = metal[37];}
            blnNameOrForm = false;
          }
          thepanel.remove(H);
          thepanel.remove(Li);
          thepanel.remove(Be);
          thepanel.remove(Na);
          thepanel.remove(Mg);
          thepanel.remove(K);
          thepanel.remove(Ca);
          thepanel.remove(Rb);
          thepanel.remove(Sr);
          thepanel.remove(Cs);
          thepanel.remove(Ba);
          thepanel.remove(Fr);
          thepanel.remove(Ra);
          thepanel.remove(Ti);
          thepanel.remove(Cr);
          thepanel.remove(Mn);
          thepanel.remove(Fe);
          thepanel.remove(Co);
          thepanel.remove(Ni);
          thepanel.remove(Cu);
          thepanel.remove(Zn);
          thepanel.remove(Ag);
          thepanel.remove(Pt);
          thepanel.remove(Au);
          thepanel.remove(Hg);
          thepanel.remove(Sn);
          thepanel.remove(Pb);
          //IF statements here to add specific buttons(First button and second button)
          if(evt.getSource() == Ti){
            lblInstruction.setText("Please select a charge for the metal you have chosen");
            button1.setIcon(new ImageIcon(img3));
            button2.setIcon(new ImageIcon(img4));
            thepanel.add(button1);
            thepanel.add(button2);
            intStep = 1;
          }else if(evt.getSource() == Cr || evt.getSource() == Fe || evt.getSource() == Co || evt.getSource() == Ni){
            lblInstruction.setText("Please select a charge for the metal you have chosen");
            button1.setIcon(new ImageIcon(img2));
            button2.setIcon(new ImageIcon(img3));
            thepanel.add(button1);
            thepanel.add(button2);
            intStep = 1;
          }else if(evt.getSource() == Mn || evt.getSource() == Pt || evt.getSource() == Sn || evt.getSource() == Pb){
            lblInstruction.setText("Please select a charge for the metal you have chosen");
            button1.setIcon(new ImageIcon(img2));
            button2.setIcon(new ImageIcon(img4));
            thepanel.add(button1);
            thepanel.add(button2);
            intStep = 1;
          }else if(evt.getSource() == Cu || evt.getSource() == Hg){
            lblInstruction.setText("Please select a charge for the metal you have chosen");
            button1.setIcon(new ImageIcon(img1));
            button2.setIcon(new ImageIcon(img2));
            thepanel.add(button1);
            thepanel.add(button2);
            intStep = 1;
          }else{
            intStep = 2; 
            lblInstruction.setText("Please select a nonmetal(elements with a negative charge)");
            thepanel.add(F);
            thepanel.add(O);
            thepanel.add(N);
            thepanel.add(Cl);
            thepanel.add(S);
            thepanel.add(P);
            thepanel.add(C);
            thepanel.add(Si);
            thepanel.add(As);
            thepanel.add(Se);
            thepanel.add(Br);
            thepanel.add(Te);
            thepanel.add(I);
            thepanel.add(At);
          }
          
        }
      }
      if(evt.getSource() == button1 || evt.getSource() == button2){
        if(intStep == 1){
          if(evt.getSource() == button2){
            for(int i=0;i<39;i++){
              if(firstAns.strName == metal[i].strName){
                firstAns = metal[i+1];
                break;
              }
            }
          }
          if(blnNameOrForm == true){
            lblInput.setText(firstAns.strName);
          }
          thepanel.add(F);
          thepanel.add(O);
          thepanel.add(N);
          thepanel.add(Cl);
          thepanel.add(S);
          thepanel.add(P);
          thepanel.add(C);
          thepanel.add(Si);
          thepanel.add(As);
          thepanel.add(Se);
          thepanel.add(Br);
          thepanel.add(Te);
          thepanel.add(I);
          thepanel.add(At);
          thepanel.remove(button1);
          thepanel.remove(button2);
          intStep = 2;
        }
      }
      if(evt.getSource() == N || evt.getSource() == O || evt.getSource() == F || evt.getSource() == P || evt.getSource() == S || evt.getSource() == Cl|| evt.getSource() == C || evt.getSource() == Si || evt.getSource() == As || evt.getSource() == Se || evt.getSource() == Br || evt.getSource() == Te || evt.getSource() == I || evt.getSource() == At){ //If they click an nonmetal
        if(intStep == 2){
          lblInstruction.setText("Click the ans button for the answer");
          if(blnNameOrForm == true){  //If they first clicked from name --> formula
            if(evt.getSource() == N){secondAns = nonmetal[0]; lblInput.setText(lblInput.getText() + " " +nonmetal[0].strName2);}
            if(evt.getSource() == O){secondAns = nonmetal[1];lblInput.setText(lblInput.getText() + " " +nonmetal[1].strName2); }
            if(evt.getSource() == F){secondAns = nonmetal[2];lblInput.setText(lblInput.getText() + " " +nonmetal[2].strName2); }
            if(evt.getSource() == P){secondAns = nonmetal[3];lblInput.setText(lblInput.getText() + " " +nonmetal[3].strName2); }
            if(evt.getSource() == S){secondAns = nonmetal[4];lblInput.setText(lblInput.getText() + " " +nonmetal[4].strName2); }
            if(evt.getSource() == Cl){secondAns = nonmetal[5];lblInput.setText(lblInput.getText() + " " +nonmetal[5].strName2); }
            if(evt.getSource() == C){secondAns = nonmetal[6];lblInput.setText(lblInput.getText() + " " +nonmetal[6].strName2); }
            if(evt.getSource() == Si){secondAns = nonmetal[7];lblInput.setText(lblInput.getText() + " " +nonmetal[7].strName2); }
            if(evt.getSource() == As){secondAns = nonmetal[8];lblInput.setText(lblInput.getText() + " " +nonmetal[8].strName2); }
            if(evt.getSource() == Se){secondAns = nonmetal[9];lblInput.setText(lblInput.getText() + " " +nonmetal[9].strName2); }
            if(evt.getSource() == Br){secondAns = nonmetal[10];lblInput.setText(lblInput.getText() + " " +nonmetal[10].strName2); }
            if(evt.getSource() == Te){secondAns = nonmetal[11];lblInput.setText(lblInput.getText() + " " +nonmetal[11].strName2); }
            if(evt.getSource() == I){secondAns = nonmetal[12];lblInput.setText(lblInput.getText() + " " +nonmetal[12].strName2); }
            if(evt.getSource() == At){secondAns = nonmetal[13];lblInput.setText(lblInput.getText() + " " +nonmetal[13].strName2); }
          }else if(blnNameOrForm == false){  //If they first clicked from formula --> name
            if(evt.getSource() == N){secondAns = nonmetal[0];lblInput.setText(compound.displayionic(firstAns.strSymbol,secondAns.strSymbol,firstAns.intCharge,secondAns.intCharge)); }
            if(evt.getSource() == O){secondAns = nonmetal[1];lblInput.setText(compound.displayionic(firstAns.strSymbol,secondAns.strSymbol,firstAns.intCharge,secondAns.intCharge)); }
            if(evt.getSource() == F){secondAns = nonmetal[2];lblInput.setText(compound.displayionic(firstAns.strSymbol,secondAns.strSymbol,firstAns.intCharge,secondAns.intCharge)); }
            if(evt.getSource() == P){secondAns = nonmetal[3];lblInput.setText(compound.displayionic(firstAns.strSymbol,secondAns.strSymbol,firstAns.intCharge,secondAns.intCharge)); }
            if(evt.getSource() == S){secondAns = nonmetal[4];lblInput.setText(compound.displayionic(firstAns.strSymbol,secondAns.strSymbol,firstAns.intCharge,secondAns.intCharge)); }
            if(evt.getSource() == Cl){secondAns = nonmetal[5];lblInput.setText(compound.displayionic(firstAns.strSymbol,secondAns.strSymbol,firstAns.intCharge,secondAns.intCharge)); }
            if(evt.getSource() == C){secondAns = nonmetal[6];lblInput.setText(compound.displayionic(firstAns.strSymbol,secondAns.strSymbol,firstAns.intCharge,secondAns.intCharge)); }
            if(evt.getSource() == Si){secondAns = nonmetal[7];lblInput.setText(compound.displayionic(firstAns.strSymbol,secondAns.strSymbol,firstAns.intCharge,secondAns.intCharge)); }
            if(evt.getSource() == As){secondAns = nonmetal[8];lblInput.setText(compound.displayionic(firstAns.strSymbol,secondAns.strSymbol,firstAns.intCharge,secondAns.intCharge)); }
            if(evt.getSource() == Se){secondAns = nonmetal[9];lblInput.setText(compound.displayionic(firstAns.strSymbol,secondAns.strSymbol,firstAns.intCharge,secondAns.intCharge)); }
            if(evt.getSource() == Br){secondAns = nonmetal[10];lblInput.setText(compound.displayionic(firstAns.strSymbol,secondAns.strSymbol,firstAns.intCharge,secondAns.intCharge)); }
            if(evt.getSource() == Te){secondAns = nonmetal[11];lblInput.setText(compound.displayionic(firstAns.strSymbol,secondAns.strSymbol,firstAns.intCharge,secondAns.intCharge)); }
            if(evt.getSource() == I){secondAns = nonmetal[12];lblInput.setText(compound.displayionic(firstAns.strSymbol,secondAns.strSymbol,firstAns.intCharge,secondAns.intCharge)); }
            if(evt.getSource() == At){secondAns = nonmetal[13];lblInput.setText(compound.displayionic(firstAns.strSymbol,secondAns.strSymbol,firstAns.intCharge,secondAns.intCharge)); }
          }
          thepanel.remove(O);
          thepanel.remove(N);
          thepanel.remove(Cl);
          thepanel.remove(S);
          thepanel.remove(P);
          thepanel.remove(F);
          thepanel.remove(C);
          thepanel.remove(Si);
          thepanel.remove(As);
          thepanel.remove(Se);
          thepanel.remove(Br);
          thepanel.remove(Te);
          thepanel.remove(I);
          thepanel.remove(At);
          intStep = 3;
        }
      }
    }else if(intGroupChoice == 1){ //If they want to choose covalent compounds
      if(evt.getSource() == N || evt.getSource() == O || evt.getSource() == F || evt.getSource() == P || evt.getSource() == S || evt.getSource() == Cl|| evt.getSource() == C || evt.getSource() == Si || evt.getSource() == As || evt.getSource() == Se || evt.getSource() == Br || evt.getSource() == Te || evt.getSource() == I || evt.getSource() == At){ //If they click an nonmetal
        if(intStep == 0){
          lblInstruction.setText("Select a number for the subscript");
          if(rbname.isSelected() == true){  //If they first clicked from name --> formula
            if(evt.getSource() == N){firstAns = nonmetal[0];lblInput.setText(firstAns.strName);}
            if(evt.getSource() == O){firstAns = nonmetal[1];lblInput.setText(firstAns.strName); }
            if(evt.getSource() == F){firstAns = nonmetal[2];lblInput.setText(firstAns.strName); }
            if(evt.getSource() == P){firstAns = nonmetal[3];lblInput.setText(firstAns.strName); }
            if(evt.getSource() == S){firstAns = nonmetal[4];lblInput.setText(firstAns.strName); }
            if(evt.getSource() == Cl){firstAns = nonmetal[5];lblInput.setText(firstAns.strName); }
            if(evt.getSource() == C){firstAns = nonmetal[6];lblInput.setText(firstAns.strName); }
            if(evt.getSource() == Si){firstAns = nonmetal[7];lblInput.setText(firstAns.strName); }
            if(evt.getSource() == As){firstAns = nonmetal[8];lblInput.setText(firstAns.strName); }
            if(evt.getSource() == Se){firstAns = nonmetal[9];lblInput.setText(firstAns.strName); }
            if(evt.getSource() == Br){firstAns = nonmetal[10];lblInput.setText(firstAns.strName); }
            if(evt.getSource() == Te){firstAns = nonmetal[11];lblInput.setText(firstAns.strName); }
            if(evt.getSource() == I){firstAns = nonmetal[12];lblInput.setText(firstAns.strName); }
            if(evt.getSource() == At){firstAns = nonmetal[13];lblInput.setText(firstAns.strName); }
            blnNameOrForm = true;
          }else if(rbformula.isSelected() == true){  //If they first clicked from formula --> name
            if(evt.getSource() == N){firstAns = nonmetal[0];lblInput.setText(firstAns.strSymbol); }
            if(evt.getSource() == O){firstAns = nonmetal[1];lblInput.setText(firstAns.strSymbol); }
            if(evt.getSource() == F){firstAns = nonmetal[2];lblInput.setText(firstAns.strSymbol); }
            if(evt.getSource() == P){firstAns = nonmetal[3];lblInput.setText(firstAns.strSymbol); }
            if(evt.getSource() == S){firstAns = nonmetal[4];lblInput.setText(firstAns.strSymbol); }
            if(evt.getSource() == Cl){firstAns = nonmetal[5];lblInput.setText(firstAns.strSymbol); }
            if(evt.getSource() == C){firstAns = nonmetal[6];lblInput.setText(firstAns.strSymbol); }
            if(evt.getSource() == Si){firstAns = nonmetal[7];lblInput.setText(firstAns.strSymbol); }
            if(evt.getSource() == As){firstAns = nonmetal[8];lblInput.setText(firstAns.strSymbol); }
            if(evt.getSource() == Se){firstAns = nonmetal[9];lblInput.setText(firstAns.strSymbol); }
            if(evt.getSource() == Br){firstAns = nonmetal[10];lblInput.setText(firstAns.strSymbol); }
            if(evt.getSource() == Te){firstAns = nonmetal[11];lblInput.setText(firstAns.strSymbol); }
            if(evt.getSource() == I){firstAns = nonmetal[12];lblInput.setText(firstAns.strSymbol); }
            if(evt.getSource() == At){firstAns = nonmetal[13];lblInput.setText(firstAns.strSymbol); }
            blnNameOrForm = false;
          }
          thepanel.remove(O);
          thepanel.remove(N);
          thepanel.remove(Cl);
          thepanel.remove(S);
          thepanel.remove(P);
          thepanel.remove(F); 
          thepanel.remove(C);
          thepanel.remove(Si);
          thepanel.remove(As);
          thepanel.remove(Se);
          thepanel.remove(Br);
          thepanel.remove(Te);
          thepanel.remove(I);
          thepanel.remove(At);
          thepanel.add(but1);
          thepanel.add(but2);
          thepanel.add(but3);
          thepanel.add(but4);
          thepanel.add(but5);
          thepanel.add(but6);
          thepanel.add(but7);
          thepanel.add(but8);
          thepanel.add(but9);
          thepanel.add(but10);
          intStep = 1;
        }
      }
      if(evt.getSource() == but1 || evt.getSource() == but2 || evt.getSource() == but3 || evt.getSource() == but4 || evt.getSource() == but5 || evt.getSource() == but6 || evt.getSource() == but7 || evt.getSource() == but8 || evt.getSource() == but9 || evt.getSource() == but10){
        if(intStep == 1){
          lblInstruction.setText("Please select a nonmetal(elements with a negative charge)");
          if(blnNameOrForm == true){ //If they first clicked from name --> formula
            if(evt.getSource() == but1){firstNumAns = 1; lblInput.setText(compound.prefix(firstNumAns)+lblInput.getText());}
            if(evt.getSource() == but2){firstNumAns = 2; lblInput.setText(compound.prefix(firstNumAns)+lblInput.getText());}
            if(evt.getSource() == but3){firstNumAns = 3; lblInput.setText(compound.prefix(firstNumAns)+lblInput.getText());}
            if(evt.getSource() == but4){firstNumAns = 4; lblInput.setText(compound.prefix(firstNumAns)+lblInput.getText());}
            if(evt.getSource() == but5){firstNumAns = 5; lblInput.setText(compound.prefix(firstNumAns)+lblInput.getText());}
            if(evt.getSource() == but6){firstNumAns = 6; lblInput.setText(compound.prefix(firstNumAns)+lblInput.getText());}
            if(evt.getSource() == but7){firstNumAns = 7; lblInput.setText(compound.prefix(firstNumAns)+lblInput.getText());}
            if(evt.getSource() == but8){firstNumAns = 8; lblInput.setText(compound.prefix(firstNumAns)+lblInput.getText());}
            if(evt.getSource() == but9){firstNumAns = 9; lblInput.setText(compound.prefix(firstNumAns)+lblInput.getText());}
            if(evt.getSource() == but10){firstNumAns = 10; lblInput.setText(compound.prefix(firstNumAns)+lblInput.getText());}
          }else if(blnNameOrForm == false){ //If they first clicked from formula --> name
            if(evt.getSource() == but1){firstNumAns = 1; lblInput.setText(lblInput.getText() + "" + firstNumAns);}
            if(evt.getSource() == but2){firstNumAns = 2; lblInput.setText(lblInput.getText() + "" + firstNumAns);}
            if(evt.getSource() == but3){firstNumAns = 3; lblInput.setText(lblInput.getText() + "" + firstNumAns);}
            if(evt.getSource() == but4){firstNumAns = 4; lblInput.setText(lblInput.getText() + "" + firstNumAns);}
            if(evt.getSource() == but5){firstNumAns = 5; lblInput.setText(lblInput.getText() + "" + firstNumAns);}
            if(evt.getSource() == but6){firstNumAns = 6; lblInput.setText(lblInput.getText() + "" + firstNumAns);}
            if(evt.getSource() == but7){firstNumAns = 7; lblInput.setText(lblInput.getText() + "" + firstNumAns);}
            if(evt.getSource() == but8){firstNumAns = 8; lblInput.setText(lblInput.getText() + "" + firstNumAns);}
            if(evt.getSource() == but9){firstNumAns = 9; lblInput.setText(lblInput.getText() + "" + firstNumAns);}
            if(evt.getSource() == but10){firstNumAns = 10; lblInput.setText(lblInput.getText() + "" + firstNumAns);}
          }
          thepanel.add(O);
          thepanel.add(N);
          thepanel.add(Cl);
          thepanel.add(S);
          thepanel.add(P);
          thepanel.add(F); 
          thepanel.add(C);
          thepanel.add(Si);
          thepanel.add(As);
          thepanel.add(Se);
          thepanel.add(Br);
          thepanel.add(Te);
          thepanel.add(I);
          thepanel.add(At);
          thepanel.remove(but1);
          thepanel.remove(but2);
          thepanel.remove(but3);
          thepanel.remove(but4);
          thepanel.remove(but5);
          thepanel.remove(but6);
          thepanel.remove(but7);
          thepanel.remove(but8);
          thepanel.remove(but9);
          thepanel.remove(but10);
          intStep = 2;
        }
      }
      if(evt.getSource() == N || evt.getSource() == O || evt.getSource() == F || evt.getSource() == P || evt.getSource() == S || evt.getSource() == Cl|| evt.getSource() == C || evt.getSource() == Si || evt.getSource() == As || evt.getSource() == Se || evt.getSource() == Br || evt.getSource() == Te || evt.getSource() == I || evt.getSource() == At){ //If they click an nonmetal
        if(intStep == 2){
          lblInstruction.setText("Select a number for the second subscript");
          if(blnNameOrForm == true){  //If they first clicked from name --> formula
            if(evt.getSource() == N){secondAns = nonmetal[0];lblInput.setText(lblInput.getText() + " " + secondAns.strName2);}
            if(evt.getSource() == O){secondAns = nonmetal[1];lblInput.setText(lblInput.getText() + " " + secondAns.strName2);}
            if(evt.getSource() == F){secondAns = nonmetal[2];lblInput.setText(lblInput.getText() + " " + secondAns.strName2);}
            if(evt.getSource() == P){secondAns = nonmetal[3];lblInput.setText(lblInput.getText() + " " + secondAns.strName2);}
            if(evt.getSource() == S){secondAns = nonmetal[4];lblInput.setText(lblInput.getText() + " " + secondAns.strName2);}
            if(evt.getSource() == Cl){secondAns = nonmetal[5];lblInput.setText(lblInput.getText() + " " + secondAns.strName2);}
            if(evt.getSource() == C){secondAns = nonmetal[6];lblInput.setText(lblInput.getText() + " " +secondAns.strName2);}
            if(evt.getSource() == Si){secondAns = nonmetal[7];lblInput.setText(lblInput.getText() + " " +secondAns.strName2);}
            if(evt.getSource() == As){secondAns = nonmetal[8];lblInput.setText(lblInput.getText() + " " +secondAns.strName2);}
            if(evt.getSource() == Se){secondAns = nonmetal[9];lblInput.setText(lblInput.getText() + " " +secondAns.strName2);}
            if(evt.getSource() == Br){secondAns = nonmetal[10];lblInput.setText(lblInput.getText() + " " +secondAns.strName2);}
            if(evt.getSource() == Te){secondAns = nonmetal[11];lblInput.setText(lblInput.getText() + " " + secondAns.strName2);}
            if(evt.getSource() == I){secondAns = nonmetal[12];lblInput.setText(lblInput.getText() + " " +secondAns.strName2);}
            if(evt.getSource() == At){secondAns = nonmetal[13];lblInput.setText(lblInput.getText() + " " +secondAns.strName2);}
          }else if(blnNameOrForm == false){  //If they first clicked from formula --> name
            if(evt.getSource() == N){secondAns = nonmetal[0];lblInput.setText(lblInput.getText() + secondAns.strSymbol); }
            if(evt.getSource() == O){secondAns = nonmetal[1];lblInput.setText(lblInput.getText() + secondAns.strSymbol); }
            if(evt.getSource() == F){secondAns = nonmetal[2];lblInput.setText(lblInput.getText() + secondAns.strSymbol); }
            if(evt.getSource() == P){secondAns = nonmetal[3];lblInput.setText(lblInput.getText() + secondAns.strSymbol); }
            if(evt.getSource() == S){secondAns = nonmetal[4];lblInput.setText(lblInput.getText() + secondAns.strSymbol); }
            if(evt.getSource() == Cl){secondAns = nonmetal[5];lblInput.setText(lblInput.getText() + secondAns.strSymbol); }
            if(evt.getSource() == C){secondAns = nonmetal[6];lblInput.setText(lblInput.getText() + " " +secondAns.strSymbol);}
            if(evt.getSource() == Si){secondAns = nonmetal[7];lblInput.setText(lblInput.getText() + " " +secondAns.strSymbol);}
            if(evt.getSource() == As){secondAns = nonmetal[8];lblInput.setText(lblInput.getText() + " " +secondAns.strSymbol);}
            if(evt.getSource() == Se){secondAns = nonmetal[9];lblInput.setText(lblInput.getText() + " " +secondAns.strSymbol);}
            if(evt.getSource() == Br){secondAns = nonmetal[10];lblInput.setText(lblInput.getText() + " " +secondAns.strSymbol);}
            if(evt.getSource() == Te){secondAns = nonmetal[11];lblInput.setText(lblInput.getText() + " " + secondAns.strSymbol);}
            if(evt.getSource() == I){secondAns = nonmetal[12];lblInput.setText(lblInput.getText() + " " +secondAns.strSymbol);}
            if(evt.getSource() == At){secondAns = nonmetal[13];lblInput.setText(lblInput.getText() + " " +secondAns.strSymbol);}
          }
          thepanel.remove(O);
          thepanel.remove(N);
          thepanel.remove(Cl);
          thepanel.remove(S);
          thepanel.remove(P);
          thepanel.remove(F); 
          thepanel.remove(C);
          thepanel.remove(Si);
          thepanel.remove(As);
          thepanel.remove(Se);
          thepanel.remove(Br);
          thepanel.remove(Te);
          thepanel.remove(I);
          thepanel.remove(At);
          thepanel.add(but1);
          thepanel.add(but2);
          thepanel.add(but3);
          thepanel.add(but4);
          thepanel.add(but5);
          thepanel.add(but6);
          thepanel.add(but7);
          thepanel.add(but8);
          thepanel.add(but9);
          thepanel.add(but10);
          intStep = 3;
        }
      }
      if(evt.getSource() == but1 || evt.getSource() == but2 || evt.getSource() == but3 || evt.getSource() == but4 || evt.getSource() == but5 || evt.getSource() == but6 || evt.getSource() == but7 || evt.getSource() == but8 || evt.getSource() == but9 || evt.getSource() == but10){
        if(intStep == 3){
          lblInstruction.setText("Click the ans button for the answer");
          if(blnNameOrForm == true){ //If they first clicked from name --> formula
            if(evt.getSource() == but1){secondNumAns = 1; lblInput.setText(compound.covalent(firstAns.strName,secondAns.strName2,firstNumAns,secondNumAns));}
            if(evt.getSource() == but2){secondNumAns = 2; lblInput.setText(compound.covalent(firstAns.strName,secondAns.strName2,firstNumAns,secondNumAns));}
            if(evt.getSource() == but3){secondNumAns = 3; lblInput.setText(compound.covalent(firstAns.strName,secondAns.strName2,firstNumAns,secondNumAns));}
            if(evt.getSource() == but4){secondNumAns = 4; lblInput.setText(compound.covalent(firstAns.strName,secondAns.strName2,firstNumAns,secondNumAns));}
            if(evt.getSource() == but5){secondNumAns = 5; lblInput.setText(compound.covalent(firstAns.strName,secondAns.strName2,firstNumAns,secondNumAns));}
            if(evt.getSource() == but6){secondNumAns = 6; lblInput.setText(compound.covalent(firstAns.strName,secondAns.strName2,firstNumAns,secondNumAns));}
            if(evt.getSource() == but7){secondNumAns = 7; lblInput.setText(compound.covalent(firstAns.strName,secondAns.strName2,firstNumAns,secondNumAns));}
            if(evt.getSource() == but8){secondNumAns = 8; lblInput.setText(compound.covalent(firstAns.strName,secondAns.strName2,firstNumAns,secondNumAns));}
            if(evt.getSource() == but9){secondNumAns = 9; lblInput.setText(compound.covalent(firstAns.strName,secondAns.strName2,firstNumAns,secondNumAns));}
            if(evt.getSource() == but10){secondNumAns = 10; lblInput.setText(compound.covalent(firstAns.strName,secondAns.strName2,firstNumAns,secondNumAns));}
          }else if(blnNameOrForm == false){ //If they first clicked from formula --> name
            if(evt.getSource() == but1){secondNumAns = 1; lblInput.setText(compound.formulacovalent(firstAns.strSymbol,secondAns.strSymbol,firstNumAns,secondNumAns));}
            if(evt.getSource() == but2){secondNumAns = 2; lblInput.setText(compound.formulacovalent(firstAns.strSymbol,secondAns.strSymbol,firstNumAns,secondNumAns));}
            if(evt.getSource() == but3){secondNumAns = 3; lblInput.setText(compound.formulacovalent(firstAns.strSymbol,secondAns.strSymbol,firstNumAns,secondNumAns));}
            if(evt.getSource() == but4){secondNumAns = 4; lblInput.setText(compound.formulacovalent(firstAns.strSymbol,secondAns.strSymbol,firstNumAns,secondNumAns));}
            if(evt.getSource() == but5){secondNumAns = 5; lblInput.setText(compound.formulacovalent(firstAns.strSymbol,secondAns.strSymbol,firstNumAns,secondNumAns));}
            if(evt.getSource() == but6){secondNumAns = 6; lblInput.setText(compound.formulacovalent(firstAns.strSymbol,secondAns.strSymbol,firstNumAns,secondNumAns));}
            if(evt.getSource() == but7){secondNumAns = 7; lblInput.setText(compound.formulacovalent(firstAns.strSymbol,secondAns.strSymbol,firstNumAns,secondNumAns));}
            if(evt.getSource() == but8){secondNumAns = 8; lblInput.setText(compound.formulacovalent(firstAns.strSymbol,secondAns.strSymbol,firstNumAns,secondNumAns));}
            if(evt.getSource() == but9){secondNumAns = 9; lblInput.setText(compound.formulacovalent(firstAns.strSymbol,secondAns.strSymbol,firstNumAns,secondNumAns));}
            if(evt.getSource() == but10){secondNumAns = 10; lblInput.setText(compound.formulacovalent(firstAns.strSymbol,secondAns.strSymbol,firstNumAns,secondNumAns));}
          }
          thepanel.remove(O);
          thepanel.remove(N);
          thepanel.remove(Cl);
          thepanel.remove(S);
          thepanel.remove(P);
          thepanel.remove(F); 
          thepanel.remove(C);
          thepanel.remove(Si);
          thepanel.remove(As);
          thepanel.remove(Se);
          thepanel.remove(Br);
          thepanel.remove(Te);
          thepanel.remove(I);
          thepanel.remove(At);
          thepanel.remove(but1);
          thepanel.remove(but2);
          thepanel.remove(but3);
          thepanel.remove(but4);
          thepanel.remove(but5);
          thepanel.remove(but6);
          thepanel.remove(but7);
          thepanel.remove(but8);
          thepanel.remove(but9);
          thepanel.remove(but10);
          intStep = 4;
        }
      }
    }else if(intGroupChoice == 2){ //For Hydrates
      if(evt.getSource() == Li || evt.getSource() == Be || evt.getSource() == Na || evt.getSource() == Mg || evt.getSource() == K || evt.getSource() == Ca || evt.getSource() == Rb || evt.getSource() == Sr || evt.getSource() == Cs || evt.getSource() == Ba || evt.getSource() == Fr || evt.getSource() == Ra || evt.getSource() == Ti || evt.getSource() == Cr || evt.getSource() == Mn || evt.getSource() == Fe || evt.getSource() == Co || evt.getSource() == Ni || evt.getSource() == Cu || evt.getSource() == Zn || evt.getSource() == Ag || evt.getSource() == Pt || evt.getSource() == Au || evt.getSource() == Hg || evt.getSource() == Sn || evt.getSource() == Pb){ //If they click a metal
        if(intStep == 0){
          if(rbname.isSelected() == true){ //If they want to go from name --> formula
            if(evt.getSource() == Li){lblInput.setText(metal[1].strName); firstAns = metal[1];}
            else if(evt.getSource() == Be){lblInput.setText(metal[2].strName); firstAns = metal[2];}
            else if(evt.getSource() == Na){lblInput.setText(metal[3].strName); firstAns = metal[3];}
            else if(evt.getSource() == Mg){lblInput.setText(metal[4].strName); firstAns = metal[4];}
            else if(evt.getSource() == K){lblInput.setText(metal[5].strName); firstAns = metal[5];}
            else if(evt.getSource() == Ca){lblInput.setText(metal[6].strName); firstAns = metal[6];}
            else if(evt.getSource() == Rb){lblInput.setText(metal[7].strName); firstAns = metal[7];}
            else if(evt.getSource() == Sr){lblInput.setText(metal[8].strName); firstAns = metal[8];}
            else if(evt.getSource() == Cs){lblInput.setText(metal[9].strName); firstAns = metal[9];}
            else if(evt.getSource() == Ba){lblInput.setText(metal[10].strName); firstAns = metal[10];}
            else if(evt.getSource() == Fr){lblInput.setText(metal[11].strName); firstAns = metal[11];}
            else if(evt.getSource() == Ra){lblInput.setText(metal[12].strName); firstAns = metal[12];}
            else if(evt.getSource() == Ti){lblInput.setText(metal[13].strName2); firstAns = metal[13];}
            else if(evt.getSource() == Cr){lblInput.setText(metal[15].strName2); firstAns = metal[15];}
            else if(evt.getSource() == Mn){lblInput.setText(metal[17].strName2); firstAns = metal[17];}
            else if(evt.getSource() == Fe){lblInput.setText(metal[19].strName2); firstAns = metal[19];}
            else if(evt.getSource() == Co){lblInput.setText(metal[21].strName2); firstAns = metal[21];}
            else if(evt.getSource() == Ni){lblInput.setText(metal[23].strName2); firstAns = metal[23];}
            else if(evt.getSource() == Cu){lblInput.setText(metal[25].strName2); firstAns = metal[25];}
            else if(evt.getSource() == Zn){lblInput.setText(metal[27].strName2); firstAns = metal[27];}
            else if(evt.getSource() == Ag){lblInput.setText(metal[28].strName2); firstAns = metal[28];}
            else if(evt.getSource() == Pt){lblInput.setText(metal[29].strName2); firstAns = metal[29];}
            else if(evt.getSource() == Au){lblInput.setText(metal[31].strName2); firstAns = metal[31];}
            else if(evt.getSource() == Hg){lblInput.setText(metal[33].strName2); firstAns = metal[33];}
            else if(evt.getSource() == Sn){lblInput.setText(metal[35].strName2); firstAns = metal[35];}
            else if(evt.getSource() == Pb){lblInput.setText(metal[37].strName2); firstAns = metal[37];}
            blnNameOrForm = true;
          }else if(rbformula.isSelected() == true){ //If they want to go from formula --> name
            if(evt.getSource() == Li){lblInput.setText(metal[1].strSymbol); firstAns = metal[1];}
            else if(evt.getSource() == Be){lblInput.setText(metal[2].strSymbol); firstAns = metal[2];}
            else if(evt.getSource() == Na){lblInput.setText(metal[3].strSymbol); firstAns = metal[3];}
            else if(evt.getSource() == Mg){lblInput.setText(metal[4].strSymbol); firstAns = metal[4];}
            else if(evt.getSource() == K){lblInput.setText(metal[5].strSymbol); firstAns = metal[5];}
            else if(evt.getSource() == Ca){lblInput.setText(metal[6].strSymbol); firstAns = metal[6];}
            else if(evt.getSource() == Rb){lblInput.setText(metal[7].strSymbol); firstAns = metal[7];}
            else if(evt.getSource() == Sr){lblInput.setText(metal[8].strSymbol); firstAns = metal[8];}
            else if(evt.getSource() == Cs){lblInput.setText(metal[9].strSymbol); firstAns = metal[9];}
            else if(evt.getSource() == Ba){lblInput.setText(metal[10].strSymbol); firstAns = metal[10];}
            else if(evt.getSource() == Fr){lblInput.setText(metal[11].strSymbol); firstAns = metal[11];}
            else if(evt.getSource() == Ra){lblInput.setText(metal[12].strSymbol); firstAns = metal[12];}
            else if(evt.getSource() == Ti){lblInput.setText(metal[13].strSymbol); firstAns = metal[13]; }
            else if(evt.getSource() == Cr){lblInput.setText(metal[15].strSymbol); firstAns = metal[15];}
            else if(evt.getSource() == Mn){lblInput.setText(metal[17].strSymbol); firstAns = metal[17];}
            else if(evt.getSource() == Fe){lblInput.setText(metal[19].strSymbol); firstAns = metal[19];}
            else if(evt.getSource() == Co){lblInput.setText(metal[21].strSymbol); firstAns = metal[21];}
            else if(evt.getSource() == Ni){lblInput.setText(metal[23].strSymbol); firstAns = metal[23];}
            else if(evt.getSource() == Cu){lblInput.setText(metal[25].strSymbol); firstAns = metal[25];}
            else if(evt.getSource() == Zn){lblInput.setText(metal[27].strSymbol); firstAns = metal[27];}
            else if(evt.getSource() == Ag){lblInput.setText(metal[28].strSymbol); firstAns = metal[28];}
            else if(evt.getSource() == Pt){lblInput.setText(metal[29].strSymbol); firstAns = metal[29];}
            else if(evt.getSource() == Au){lblInput.setText(metal[31].strSymbol); firstAns = metal[31];}
            else if(evt.getSource() == Hg){lblInput.setText(metal[33].strSymbol); firstAns = metal[33];}
            else if(evt.getSource() == Sn){lblInput.setText(metal[35].strSymbol); firstAns = metal[35];}
            else if(evt.getSource() == Pb){lblInput.setText(metal[37].strSymbol); firstAns = metal[37];}
            blnNameOrForm = false;
          }
          thepanel.remove(H);
          thepanel.remove(Li);
          thepanel.remove(Be);
          thepanel.remove(Na);
          thepanel.remove(Mg);
          thepanel.remove(K);
          thepanel.remove(Ca);
          thepanel.remove(Rb);
          thepanel.remove(Sr);
          thepanel.remove(Cs);
          thepanel.remove(Ba);
          thepanel.remove(Fr);
          thepanel.remove(Ra);
          thepanel.remove(Ti);
          thepanel.remove(Cr);
          thepanel.remove(Mn);
          thepanel.remove(Fe);
          thepanel.remove(Co);
          thepanel.remove(Ni);
          thepanel.remove(Cu);
          thepanel.remove(Zn);
          thepanel.remove(Ag);
          thepanel.remove(Pt);
          thepanel.remove(Au);
          thepanel.remove(Hg);
          thepanel.remove(Sn);
          thepanel.remove(Pb);
          //IF statements here to add specific buttons(First button and second button)
          if(evt.getSource() == Ti){
            lblInstruction.setText("Please select a charge for the metal you have chosen");
            button1.setIcon(new ImageIcon(img3));
            button2.setIcon(new ImageIcon(img4));
            thepanel.add(button1);
            thepanel.add(button2);
            intStep = 1;
          }else if(evt.getSource() == Cr || evt.getSource() == Fe || evt.getSource() == Co || evt.getSource() == Ni){
            lblInstruction.setText("Please select a charge for the metal you have chosen");
            button1.setIcon(new ImageIcon(img2));
            button2.setIcon(new ImageIcon(img3));
            thepanel.add(button1);
            thepanel.add(button2);
            intStep = 1;
          }else if(evt.getSource() == Mn || evt.getSource() == Pt || evt.getSource() == Sn || evt.getSource() == Pb){
            lblInstruction.setText("Please select a charge for the metal you have chosen");
            button1.setIcon(new ImageIcon(img2));
            button2.setIcon(new ImageIcon(img4));
            thepanel.add(button1);
            thepanel.add(button2);
            intStep = 1;
          }else if(evt.getSource() == Cu || evt.getSource() == Hg){
            lblInstruction.setText("Please select a charge for the metal you have chosen");
            button1.setIcon(new ImageIcon(img1));
            button2.setIcon(new ImageIcon(img2));
            thepanel.add(button1);
            thepanel.add(button2);
            intStep = 1;
          }else{
            intStep = 2; 
            lblInstruction.setText("Please select a nonmetal(elements with a negative charge)");
            thepanel.add(F);
            thepanel.add(O);
            thepanel.add(N);
            thepanel.add(Cl);
            thepanel.add(S);
            thepanel.add(P);
            thepanel.add(C);
            thepanel.add(Si);
            thepanel.add(As);
            thepanel.add(Se);
            thepanel.add(Br);
            thepanel.add(Te);
            thepanel.add(I);
            thepanel.add(At);
          }
          
        }
      }
      if(evt.getSource() == button1 || evt.getSource() == button2){
        if(intStep == 1){
          if(evt.getSource() == button2){
            for(int i=0;i<40;i++){
              if(firstAns == metal[i]){
                firstAns = metal[i+1];
                break;
              }
            }
          }
          if(blnNameOrForm == true){
            lblInput.setText(firstAns.strName);
          }
          thepanel.add(F);
          thepanel.add(O);
          thepanel.add(N);
          thepanel.add(Cl);
          thepanel.add(S);
          thepanel.add(P);
          thepanel.add(C);
          thepanel.add(Si);
          thepanel.add(As);
          thepanel.add(Se);
          thepanel.add(Br);
          thepanel.add(Te);
          thepanel.add(I);
          thepanel.add(At);
          thepanel.remove(button1);
          thepanel.remove(button2);
          intStep = 2;
        }
      }
      if(evt.getSource() == N || evt.getSource() == O || evt.getSource() == F || evt.getSource() == P || evt.getSource() == S || evt.getSource() == Cl|| evt.getSource() == C || evt.getSource() == Si || evt.getSource() == As || evt.getSource() == Se || evt.getSource() == Br || evt.getSource() == Te || evt.getSource() == I || evt.getSource() == At){ //If they click an nonmetal
        if(intStep == 2){
          lblInstruction.setText("Click a number for the amount of H2O");
          if(blnNameOrForm == true){  //If they first clicked from name --> formula
            if(evt.getSource() == N){secondAns = nonmetal[0]; lblInput.setText(lblInput.getText() + " " +nonmetal[0].strName2);}
            if(evt.getSource() == O){secondAns = nonmetal[1];lblInput.setText(lblInput.getText() + " " +nonmetal[1].strName2); }
            if(evt.getSource() == F){secondAns = nonmetal[2];lblInput.setText(lblInput.getText() + " " +nonmetal[2].strName2); }
            if(evt.getSource() == P){secondAns = nonmetal[3];lblInput.setText(lblInput.getText() + " " +nonmetal[3].strName2); }
            if(evt.getSource() == S){secondAns = nonmetal[4];lblInput.setText(lblInput.getText() + " " +nonmetal[4].strName2); }
            if(evt.getSource() == Cl){secondAns = nonmetal[5];lblInput.setText(lblInput.getText() + " " +nonmetal[5].strName2); }
            if(evt.getSource() == C){secondAns = nonmetal[6];lblInput.setText(lblInput.getText() + " " +nonmetal[6].strName2); }
            if(evt.getSource() == Si){secondAns = nonmetal[7];lblInput.setText(lblInput.getText() + " " +nonmetal[7].strName2); }
            if(evt.getSource() == As){secondAns = nonmetal[8];lblInput.setText(lblInput.getText() + " " +nonmetal[8].strName2); }
            if(evt.getSource() == Se){secondAns = nonmetal[9];lblInput.setText(lblInput.getText() + " " +nonmetal[9].strName2); }
            if(evt.getSource() == Br){secondAns = nonmetal[10];lblInput.setText(lblInput.getText() + " " +nonmetal[10].strName2); }
            if(evt.getSource() == Te){secondAns = nonmetal[11];lblInput.setText(lblInput.getText() + " " +nonmetal[11].strName2); }
            if(evt.getSource() == I){secondAns = nonmetal[12];lblInput.setText(lblInput.getText() + " " +nonmetal[12].strName2); }
            if(evt.getSource() == At){secondAns = nonmetal[13];lblInput.setText(lblInput.getText() + " " +nonmetal[13].strName2); }
          }else if(blnNameOrForm == false){  //If they first clicked from formula --> name
            if(evt.getSource() == N){secondAns = nonmetal[0];lblInput.setText(compound.displayionic(firstAns.strSymbol,secondAns.strSymbol,firstAns.intCharge,secondAns.intCharge)); }
            if(evt.getSource() == O){secondAns = nonmetal[1];lblInput.setText(compound.displayionic(firstAns.strSymbol,secondAns.strSymbol,firstAns.intCharge,secondAns.intCharge)); }
            if(evt.getSource() == F){secondAns = nonmetal[2];lblInput.setText(compound.displayionic(firstAns.strSymbol,secondAns.strSymbol,firstAns.intCharge,secondAns.intCharge)); }
            if(evt.getSource() == P){secondAns = nonmetal[3];lblInput.setText(compound.displayionic(firstAns.strSymbol,secondAns.strSymbol,firstAns.intCharge,secondAns.intCharge)); }
            if(evt.getSource() == S){secondAns = nonmetal[4];lblInput.setText(compound.displayionic(firstAns.strSymbol,secondAns.strSymbol,firstAns.intCharge,secondAns.intCharge)); }
            if(evt.getSource() == Cl){secondAns = nonmetal[5];lblInput.setText(compound.displayionic(firstAns.strSymbol,secondAns.strSymbol,firstAns.intCharge,secondAns.intCharge)); }
            if(evt.getSource() == C){secondAns = nonmetal[6];lblInput.setText(compound.displayionic(firstAns.strSymbol,secondAns.strSymbol,firstAns.intCharge,secondAns.intCharge)); }
            if(evt.getSource() == Si){secondAns = nonmetal[7];lblInput.setText(compound.displayionic(firstAns.strSymbol,secondAns.strSymbol,firstAns.intCharge,secondAns.intCharge)); }
            if(evt.getSource() == As){secondAns = nonmetal[8];lblInput.setText(compound.displayionic(firstAns.strSymbol,secondAns.strSymbol,firstAns.intCharge,secondAns.intCharge)); }
            if(evt.getSource() == Se){secondAns = nonmetal[9];lblInput.setText(compound.displayionic(firstAns.strSymbol,secondAns.strSymbol,firstAns.intCharge,secondAns.intCharge)); }
            if(evt.getSource() == Br){secondAns = nonmetal[10];lblInput.setText(compound.displayionic(firstAns.strSymbol,secondAns.strSymbol,firstAns.intCharge,secondAns.intCharge)); }
            if(evt.getSource() == Te){secondAns = nonmetal[11];lblInput.setText(compound.displayionic(firstAns.strSymbol,secondAns.strSymbol,firstAns.intCharge,secondAns.intCharge)); }
            if(evt.getSource() == I){secondAns = nonmetal[12];lblInput.setText(compound.displayionic(firstAns.strSymbol,secondAns.strSymbol,firstAns.intCharge,secondAns.intCharge)); }
            if(evt.getSource() == At){secondAns = nonmetal[13];lblInput.setText(compound.displayionic(firstAns.strSymbol,secondAns.strSymbol,firstAns.intCharge,secondAns.intCharge)); }
          }
          thepanel.remove(O);
          thepanel.remove(N);
          thepanel.remove(Cl);
          thepanel.remove(S);
          thepanel.remove(P);
          thepanel.remove(F);
          thepanel.remove(C);
          thepanel.remove(Si);
          thepanel.remove(As);
          thepanel.remove(Se);
          thepanel.remove(Br);
          thepanel.remove(Te);
          thepanel.remove(I);
          thepanel.remove(At);
          thepanel.add(but1);
          thepanel.add(but2);
          thepanel.add(but3);
          thepanel.add(but4);
          thepanel.add(but5);
          thepanel.add(but6);
          thepanel.add(but7);
          thepanel.add(but8);
          thepanel.add(but9);
          thepanel.add(but10);
          intStep = 3;
        }
      }
      if(evt.getSource() == but1 || evt.getSource() == but2 || evt.getSource() == but3 || evt.getSource() == but4 || evt.getSource() == but5 || evt.getSource() == but6 || evt.getSource() == but7 || evt.getSource() == but8 || evt.getSource() == but9 || evt.getSource() == but10){
        if(intStep == 3){
          lblInstruction.setText("Click the ans button for the answer");
          if(blnNameOrForm == true){ //If they first clicked from name --> formula
            if(evt.getSource() == but1){firstNumAns = 1; lblInput.setText(compound.hydrate(firstAns.strName,secondAns.strName2,firstNumAns));}
            if(evt.getSource() == but2){firstNumAns = 2; lblInput.setText(compound.hydrate(firstAns.strName,secondAns.strName2,firstNumAns));}
            if(evt.getSource() == but3){firstNumAns = 3; lblInput.setText(compound.hydrate(firstAns.strName,secondAns.strName2,firstNumAns));}
            if(evt.getSource() == but4){firstNumAns = 4; lblInput.setText(compound.hydrate(firstAns.strName,secondAns.strName2,firstNumAns));}
            if(evt.getSource() == but5){firstNumAns = 5; lblInput.setText(compound.hydrate(firstAns.strName,secondAns.strName2,firstNumAns));}
            if(evt.getSource() == but6){firstNumAns = 6; lblInput.setText(compound.hydrate(firstAns.strName,secondAns.strName2,firstNumAns));}
            if(evt.getSource() == but7){firstNumAns = 7; lblInput.setText(compound.hydrate(firstAns.strName,secondAns.strName2,firstNumAns));}
            if(evt.getSource() == but8){firstNumAns = 8; lblInput.setText(compound.hydrate(firstAns.strName,secondAns.strName2,firstNumAns));}
            if(evt.getSource() == but9){firstNumAns = 9; lblInput.setText(compound.hydrate(firstAns.strName,secondAns.strName2,firstNumAns));}
            if(evt.getSource() == but10){firstNumAns = 10; lblInput.setText(compound.hydrate(firstAns.strName,secondAns.strName2,firstNumAns));}
          }else if(blnNameOrForm == false){ //If they first clicked from formula --> name
            if(evt.getSource() == but1){firstNumAns = 1; lblInput.setText(compound.formulahydrate(firstAns.strSymbol,secondAns.strSymbol,firstAns.intCharge,secondAns.intCharge,firstNumAns));}
            if(evt.getSource() == but2){firstNumAns = 2; lblInput.setText(compound.formulahydrate(firstAns.strSymbol,secondAns.strSymbol,firstAns.intCharge,secondAns.intCharge,firstNumAns));}
            if(evt.getSource() == but3){firstNumAns = 3; lblInput.setText(compound.formulahydrate(firstAns.strSymbol,secondAns.strSymbol,firstAns.intCharge,secondAns.intCharge,firstNumAns));}
            if(evt.getSource() == but4){firstNumAns = 4; lblInput.setText(compound.formulahydrate(firstAns.strSymbol,secondAns.strSymbol,firstAns.intCharge,secondAns.intCharge,firstNumAns));}
            if(evt.getSource() == but5){firstNumAns = 5; lblInput.setText(compound.formulahydrate(firstAns.strSymbol,secondAns.strSymbol,firstAns.intCharge,secondAns.intCharge,firstNumAns));}
            if(evt.getSource() == but6){firstNumAns = 6; lblInput.setText(compound.formulahydrate(firstAns.strSymbol,secondAns.strSymbol,firstAns.intCharge,secondAns.intCharge,firstNumAns));}
            if(evt.getSource() == but7){firstNumAns = 7; lblInput.setText(compound.formulahydrate(firstAns.strSymbol,secondAns.strSymbol,firstAns.intCharge,secondAns.intCharge,firstNumAns));}
            if(evt.getSource() == but8){firstNumAns = 8; lblInput.setText(compound.formulahydrate(firstAns.strSymbol,secondAns.strSymbol,firstAns.intCharge,secondAns.intCharge,firstNumAns));}
            if(evt.getSource() == but9){firstNumAns = 9; lblInput.setText(compound.formulahydrate(firstAns.strSymbol,secondAns.strSymbol,firstAns.intCharge,secondAns.intCharge,firstNumAns));}
            if(evt.getSource() == but10){firstNumAns = 10; lblInput.setText(compound.formulahydrate(firstAns.strSymbol,secondAns.strSymbol,firstAns.intCharge,secondAns.intCharge,firstNumAns));}
          }
        }
        thepanel.remove(but1);
        thepanel.remove(but2);
        thepanel.remove(but3);
        thepanel.remove(but4);
        thepanel.remove(but5);
        thepanel.remove(but6);
        thepanel.remove(but7);
        thepanel.remove(but8);
        thepanel.remove(but9);
        thepanel.remove(but10);
        intStep = 4;
      }
    }
  }
  
  //Constructor
  public nomenclature(){
    
    //If it is an ionic compound
    intRandE1 = (int)(Math.random()*36) + 1;
    intRandE2 = (int)(Math.random()*14);
    intRandE2V2 = (int)(Math.random()*14);
    intRandC1 = (int)(Math.random()*10) + 1;
    intRandC2 = (int)(Math.random()*10) + 1;
    intRandH = (int)(Math.random()*10) + 1;
    intRandA10 = (int)(Math.random()*18);
    intRandA11 = (int)(Math.random()*25);
    intRandP10 = (int)(Math.random()*9);
    intRandP11 = (int)(Math.random()*25);
    intRandComp = (int)(Math.random()*2);
    intRandType = (int)(Math.random()*6);
    
    //Elements(nonmetal)
    metal[0] = new element("hydrogen","hydride","H",1);
    metal[1] = new element("lithium","lithide","Li",1);
    metal[2] = new element("berylium","berilide","Be",2);
    metal[3] = new element("sodium","sodide","Na",1);
    metal[4] = new element("magnesium","magneside","Mg",2);
    metal[5] = new element("potassium","potasside","K",1);
    metal[6] = new element("calcium","calcide","Ca",2);
    metal[7] = new element("rubidium", "rubidide","Rb",1);
    metal[8] = new element("strontium","strontide","Sr",2);
    metal[9] = new element("caesium", "caeside", "Cs",1);
    metal[10] = new element("barium", "baride", "Ba",2);
    metal[11] = new element("francium","francide","Fr",1);
    metal[12] = new element("radium" , "radide", "Ra",2);
    metal[13] = new element("titanium(III)","titanium","Ti",3);
    metal[14] = new element("titanium(IV)","titanium","Ti",4);
    metal[15] = new element("chromium(II)","chromium","Cr",2);
    metal[16] = new element("chromium(III)","chromium","Cr",3);
    metal[17] = new element("manganese(II)","manganese","Mn",2);
    metal[18] = new element("manganese{IV}","manganese","Mn",4);
    metal[19] = new element("iron(II)","iron","Fe",2);
    metal[20] = new element("iron(III)","iron","Fe",3);
    metal[21] = new element("cobalt(II)","cobalt","Co",2);
    metal[22] = new element("cobalt(III)","cobalt","Co",3);
    metal[23] = new element("nickel(II)","nickel","Ni",2);
    metal[24] = new element("nickel(III)","nickel","Ni",3);
    metal[25] = new element("copper(I)","copper","Cu",1);
    metal[26] = new element("copper(II)","copper","Cu",2);
    metal[27] = new element("zinc","zinc","Zn",2);
    metal[28] = new element("silver","silver","Ag",1);
    metal[29] = new element("platinum(II)","platinum","Pt",2);
    metal[30] = new element("platinum(IV)","platinum","Pt",4);
    metal[31] = new element("gold(I)","gold","Au",1);
    metal[32] = new element("gold(III)","gold","Au",3);
    metal[33] = new element("mercury(I)","gold","Hg",1);
    metal[34] = new element("mercury(II)","gold","Hg",2);
    metal[35] = new element("tin(II)","tin","Sn",2);
    metal[36] = new element("tin(IV)","tin","Sn",4);
    metal[37] = new element("lead(II)","lead","Pb",2);
    metal[38] = new element("lead(IV)","lead","Pb",4);
    metal[39] = new element("ammonium","","NH4",1);
    
    //Elements(metal)
    nonmetal[0] = new element("nitrogen","nitride","N",3);
    nonmetal[1] = new element("oxygen","oxide","O",2);
    nonmetal[2] = new element("fluorine","fluoride","F",1);
    nonmetal[3] = new element("phosphorus","phosphide","P",3);
    nonmetal[4] = new element("sulphur","sulphide","S",2);
    nonmetal[5] = new element("chlorine","chloride","Cl",1);
    nonmetal[6] = new element("carbon","carbide","C",4);
    nonmetal[7] = new element("silicon","silicide","Si",4);
    nonmetal[8] = new element("arsenic","arsenide","As",3);
    nonmetal[9] = new element("selenium","selenide","Se",2);
    nonmetal[10] = new element("bromine","bromide","Br",1);
    nonmetal[11] =  new element("tellurium","telluride","Te",2);
    nonmetal[12] =  new element("iodine","iodide","I",1);
    nonmetal[13] = new element("astatine","astatide","At",1);
    
    //Elements(can be both)
    //nonmetal[1] = new element("Carbon","Carbide","C",6,4);
    
    //Elements(noble gases) or hard elements
    nobleg[0] = new element("helium","DNE","He",0);
    nobleg[1] = new element("neon","DNE","Ne",0);
    nobleg[2] = new element("argon","DNE","Ar",0);
    nobleg[3] = new element("boron","Boride", "B",3);
    
    //Polatomic ions(Grade 10)
    polyatom10[0] = new element("nitrate","","NO3",1);
    polyatom10[1] = new element("hydrogen carbonate","","HCO3",1);
    polyatom10[2] = new element("hydroxide","","OH",1);
    polyatom10[3] = new element("chlorate","","ClO3",1);
    polyatom10[4] = new element("bromate","","BrO3",1);
    polyatom10[5] = new element("iodate","","IO3",1);
    polyatom10[6] = new element("carbonate","","CO3",2);
    polyatom10[7] = new element("sulphate","","SO4",2);
    polyatom10[8] = new element("phosphate","","PO4",3);
    polyatom10[9] = new element("ammonia","","NH3",1);
    
    //Polyatomic ions(Grade 11)
    polyatom11[0] = new element("cyanide","","CN",1);
    polyatom11[1] = new element("acetate","","C2H3O2",1);
    polyatom11[2] = new element("hypochlorite","","ClO",1);
    polyatom11[3] = new element("chlorite","","ClO2",1);
    polyatom11[4] = new element("perchlorate","","ClO4",1);
    polyatom11[5] = new element("hydrogen oxalate","","HC2O4",1);
    polyatom11[6] = new element("hydrogen sulphite","","HSO3",1);
    polyatom11[7] = new element("hydrogen sulphate","","HSO4",1);
    polyatom11[8] = new element("dihydrogen phosphite ","","H2PO3",1);
    polyatom11[9] = new element("dihydrogen phosphate","","H2PO4",1);
    polyatom11[10] = new element("manganate","","MnO4",1);
    polyatom11[11] = new element("nitrite","","NO2",1);
    polyatom11[12] = new element("cyanate","","OCN",1);
    polyatom11[13] = new element("thiocyanate","","SCN",1);
    
    polyatom11[14] = new element("oxalate","","C2O4",2);
    polyatom11[15] = new element("chromate","","CrO4",2);
    polyatom11[16] = new element("dichromate","","Cr2O7",2);
    polyatom11[17] = new element("hydrogen phosphite","","HPO3",2);
    polyatom11[18] = new element("hydrogen phosphate","","HPO4",2);
    polyatom11[19] = new element("peroxide","","O2",2);
    polyatom11[20] = new element("sulphite","","SO3",2);
    polyatom11[21] = new element("thiosulphate","","S2O3",2);
    
    polyatom11[22] = new element("arsenite","","AsO3",3);
    polyatom11[23] = new element("arsenate","","AsO4",3);
    polyatom11[24] = new element("phosphite","","PO3",3);
    
    //Acids Grade 10
    acids10[0] = new element("hydronitric acid","","H3N",0);
    acids10[1] = new element("water","","H2O",0);
    acids10[2] = new element("hydrofluoric acid","","HF",0);
    acids10[3] = new element("hydrophosphoric acid","","H3P",0);
    acids10[4] = new element("hydrosulphuric acid","","H2S",0);
    acids10[5] = new element("hydrochloric acid","","HCl",0);
    acids10[6] = new element("hydroarsenic acid","","H3As",0);
    acids10[7] = new element("hydroselenic acid","","H2Se",0);
    acids10[8] = new element("hydrobromic acid","","HBr",0);
    acids10[9] = new element("hydroiodic acid","","HI",0);
    acids10[10] = new element("nitric acid","","HNO3",0);
    acids10[11] = new element("chloric acid","","HClO3",0);
    acids10[12] = new element("bromic acid","","HBrO3",0);
    acids10[13] = new element("acetic acid","","HC2H3O2",0);
    acids10[14] = new element("iodic acid","","HIO3",0);
    acids10[15] = new element("carbonic acid","","H2CO3",0);
    acids10[16] = new element("phosphoric acid","","H3PO4",0);
    acids10[17] = new element("sulphuric acid","","H2SO4",0);
    
    //Acids Grade 11
    acids11[0] = new element("bromous acid","","BrO2",0);
    acids11[1] = new element("hypobromous acid","","BrO",0);
    acids11[2] = new element("hypoiodous acid","","HIO",0);
    acids11[3] = new element("iodous acid","","HIO2",0);
    acids11[4] = new element("periodic acid","","HIO4",0);
    acids11[5] = new element("hypocarbonous acid","","H2CO",0);
    acids11[6] = new element("hyposulphurous acid","","H2SO2",0);
    acids11[7] = new element("persulphuric acid","","H2SO5",0);
    acids11[8] = new element("hydrocyanic acid","","HCN",0);
    acids11[9] = new element("hypochlorous acid","","HClO",0);
    acids11[10] = new element("chlorous acid","","HClO2",0);
    acids11[11] = new element("perchloric acid","","HClO4",0);
    acids11[12] = new element("manganic acid","","HMnO4",0);
    acids11[13] = new element("nitrous acid","","HNO2",0);
    acids11[14] = new element("hyponitrous acid","","HNO",0);
    acids11[15] = new element("pernitric acid","","HNO4",0);
    acids11[16] = new element("percarbonic acid","","H2CO4",0);
    acids11[17] = new element("cyanic acid","","HCNO",0);
    acids11[18] = new element("thiocyanic acid","","HSCN",0);
    acids11[19] = new element("oxalic acid","","H2C2O4",0);
    acids11[20] = new element("chromic acid","","H2Cr2O4",0);
    acids11[21] = new element("dichromic acid","","H2Cr2O7",0);
    acids11[22] = new element("sulphurous acid","","H2SO3",0);
    acids11[23] = new element("arsenic acid","","H3AsO4",0);
    acids11[24] = new element("phosphorous acid","","H3PO3",0);
    
    theframe = new JFrame();
    thepanel = new JGraphics();
    
    //************************************
    //The main menu
    //************************************
    thepanel.setLayout(null);
    thepanel.setPreferredSize(new Dimension(800,600));
    thepanel.addMouseListener(this);
    thepanel.addMouseMotionListener(this);
    thepanel.setFocusable(true);
    thepanel.requestFocusInWindow();
    
    theframe.setResizable(false);
    theframe.setContentPane(thepanel);
    theframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    theframe.addKeyListener(this);
    
    startbutton = new JButton("Begin!");
    startbutton.setSize(200, 100);
    startbutton.setLocation(300, 100);
    startbutton.setFont(font1);
    startbutton.addActionListener(this);
    thepanel.add(startbutton);
    
    helpbutton = new JButton("Help");
    helpbutton.setSize(200, 100);
    helpbutton.setLocation(300, 200);
    helpbutton.setFont(font1);
    helpbutton.addActionListener(this);
    thepanel.add(helpbutton);
    
    aboutbutton = new JButton("About");
    aboutbutton.setSize(200, 100);
    aboutbutton.setLocation(300, 300);
    aboutbutton.setFont(font1);
    aboutbutton.addActionListener(this);
    thepanel.add(aboutbutton);
    
    testbutton = new JButton("Test");
    testbutton.setSize(200, 100);
    testbutton.setLocation(300, 400);
    testbutton.setFont(font1);
    testbutton.addActionListener(this);
    thepanel.add(testbutton);
    
    lblMyself = new JLabel("By:Matthew Wong");
    lblMyself.setSize(400,50);
    lblMyself.setLocation(530,550);
    lblMyself.setFont(font1);
    thepanel.add(lblMyself);
    
    //************************************
    //The quiz
    //************************************
    
    lblQuestion = new JLabel("!");
    lblQuestion.setSize(400, 50);
    lblQuestion.setLocation(300, 10);
    lblQuestion.setFont(font3);
    
    tfAnswer = new JTextField();
    tfAnswer.setSize(200, 50);
    tfAnswer.setLocation(300, 100);
    tfAnswer.addActionListener(this);
    tfAnswer.setEnabled(false);
    
    lblQAns = new JLabel("!");
    lblQAns.setSize(470, 35);
    lblQAns.setLocation(300, 50);
    
    lblPQuestion = new JLabel("Previous Question:");
    lblPQuestion.setSize(300,35);
    lblPQuestion.setLocation(0,50);
    
    chargebutton = new JButton("Charges");
    chargebutton.setSize(100,50);
    chargebutton.setLocation(700, 500);
    chargebutton.addActionListener(this);
    
    ptablebutton = new JButton("P-Table");
    ptablebutton.setSize(100, 50);
    ptablebutton.setLocation(700, 450);
    ptablebutton.addActionListener(this);
    
    beginbutton = new JButton("Begin");
    beginbutton.setSize(100,50);
    beginbutton.setLocation(700, 0);
    beginbutton.addActionListener(this);
    
    lblScore = new JLabel("Your Score: " + intScore);
    lblScore.setSize(400, 35);
    lblScore.setLocation(0, 0);
    lblScore.setFont(font1);
    
    therb10 = new JRadioButton("Grade 10");
    therb10.setSize(100, 50);
    therb10.setLocation(250, 155);
    therb10.addActionListener(this);
    
    therb11 = new JRadioButton("Grade 11");
    therb11.setSize(100, 50);
    therb11.setLocation(450, 155);
    therb11.addActionListener(this);
    
    cbionic = new JCheckBox("Ionic");
    cbionic.setSize(100,50);
    cbionic.setLocation(250,200);
    cbionic.addActionListener(this);
    
    cbcovalent = new JCheckBox("Covalent");
    cbcovalent.setSize(100,50);
    cbcovalent.setLocation(250,250);
    cbcovalent.addActionListener(this);
    
    cbacids10 = new JCheckBox("Acids (Gr.10)");
    cbacids10.setSize(100,50);
    cbacids10.setLocation(250,300);
    cbacids10.addActionListener(this);
    
    cbpolyatomic10 = new JCheckBox("Polyatomic (Gr.10)");
    cbpolyatomic10.setSize(150,50);
    cbpolyatomic10.setLocation(250,350);
    cbpolyatomic10.addActionListener(this);
    
    
    cbhydrates = new JCheckBox("Hydrates");
    cbhydrates.setSize(100,50);
    cbhydrates.setLocation(450,200);
    cbhydrates.addActionListener(this);
    
    cbacids11 = new JCheckBox("Acids (Gr.11)");
    cbacids11.setSize(100,50);
    cbacids11.setLocation(450,250);
    cbacids11.addActionListener(this);
    
    cbpolyatomic11 = new JCheckBox("Polyatomic (Gr.11)");
    cbpolyatomic11.setSize(150,50);
    cbpolyatomic11.setLocation(450,300);
    cbpolyatomic11.addActionListener(this);
    
    //***********************************
    //The new button for people who are not very good(Not visible in main menu)
    //************************************
    rbformula = new JRadioButton("Formula >>> Name");
    rbformula.setSelected(true);
    rbformula.setSize(150, 50);
    rbformula.setLocation(50, 500);
    rbformula.addActionListener(this);
    
    rbname = new JRadioButton("Name >>> Formula");
    rbname.setSize(150, 50);
    rbname.setLocation(50, 550);
    rbname.addActionListener(this);
    
    ionicbutton = new JButton("Ionic");
    ionicbutton.setSize(200,100);
    ionicbutton.setLocation(300,50);
    ionicbutton.setFont(font1);
    ionicbutton.addActionListener(this);
    
    covalentbutton = new JButton("Covalent");
    covalentbutton.setSize(200,100);
    covalentbutton.setLocation(300,150);
    covalentbutton.setFont(font1);
    covalentbutton.addActionListener(this);
    
    hydratebutton = new JButton("Hydrates");
    hydratebutton.setSize(200,100);
    hydratebutton.setLocation(300,250);
    hydratebutton.setFont(font1);
    hydratebutton.addActionListener(this);
    
    acidbutton = new JButton("Acids");
    acidbutton.setSize(200,100);
    acidbutton.setLocation(300,350);
    acidbutton.setFont(font1);
    acidbutton.addActionListener(this);
    
    polyatomicbutton = new JButton("Polyatomic");
    polyatomicbutton.setSize(200,100);
    polyatomicbutton.setLocation(300,450);
    polyatomicbutton.setFont(font1);
    polyatomicbutton.addActionListener(this);
    
    backbutton2 = new JButton("Back");
    backbutton2.setSize(100, 50);
    backbutton2.setLocation(700, 550);
    backbutton2.addActionListener(this);
    
    lblInstruction = new JLabel("Please select a metal(elements with a positive charge)");
    lblInstruction.setSize(400, 20);
    lblInstruction.setLocation(135, 10);
    
    lblInput = new JLabel("!");
    lblInput.setSize(400, 35);
    lblInput.setLocation(135, 30);
    lblInput.setFont(font3);
    
    lblOutput = new JLabel("");
    lblOutput.setForeground(Color.RED);
    lblOutput.setSize(400, 35);
    lblOutput.setLocation(135, 100);
    lblOutput.setFont(font3);
    
    clearbutton = new JButton("Clear");
    clearbutton.setSize(70, 25);
    clearbutton.setLocation(135, 70);
    clearbutton.addActionListener(this);
    
    
    donebutton = new JButton("Ans");
    donebutton.setSize(70, 25);
    donebutton.setLocation(220, 70);
    donebutton.addActionListener(this);
    
    button1 = new JButton("");
    button1.setSize(41,45);
    button1.setLocation(0,0);
    button1.addActionListener(this);
    
    button2 = new JButton("");
    button2.setSize(41,45);
    button2.setLocation(41,0);
    button2.addActionListener(this);
    
    //************************************
    //A bunch of element and # pictures
    //************************************
    try{ //sets the logo for the buttons in the screen
      imgH = ImageIO.read(getClass().getResource("Elements/H.png")); 
      imgLi = ImageIO.read(getClass().getResource("Elements/Li.png")); 
      imgBe = ImageIO.read(getClass().getResource("Elements/Be.png")); 
      imgNa = ImageIO.read(getClass().getResource("Elements/Na.png"));
      imgMg = ImageIO.read(getClass().getResource("Elements/Mg.png"));
      imgK = ImageIO.read(getClass().getResource("Elements/K.png"));
      imgCa = ImageIO.read(getClass().getResource("Elements/Ca.png"));
      imgRb = ImageIO.read(getClass().getResource("Elements/Rb.png"));
      imgSr = ImageIO.read(getClass().getResource("Elements/Sr.png"));
      imgCs = ImageIO.read(getClass().getResource("Elements/Cs.png"));
      imgBa = ImageIO.read(getClass().getResource("Elements/Ba.png"));
      imgFr = ImageIO.read(getClass().getResource("Elements/Fr.png"));
      imgRa = ImageIO.read(getClass().getResource("Elements/Ra.png"));
      imgTi = ImageIO.read(getClass().getResource("Elements/Ti.png"));
      imgCr = ImageIO.read(getClass().getResource("Elements/Cr.png"));
      imgMn = ImageIO.read(getClass().getResource("Elements/Mn.png"));
      imgFe = ImageIO.read(getClass().getResource("Elements/Fe.png"));
      imgCo = ImageIO.read(getClass().getResource("Elements/Co.png"));
      imgNi = ImageIO.read(getClass().getResource("Elements/Ni.png"));
      imgCu = ImageIO.read(getClass().getResource("Elements/Cu.png"));
      imgZn = ImageIO.read(getClass().getResource("Elements/Zn.png"));
      imgAg = ImageIO.read(getClass().getResource("Elements/Ag.png"));
      imgPt = ImageIO.read(getClass().getResource("Elements/Pt.png"));
      imgAu = ImageIO.read(getClass().getResource("Elements/Au.png"));
      imgHg = ImageIO.read(getClass().getResource("Elements/Hg.png"));
      imgSn = ImageIO.read(getClass().getResource("Elements/Sn.png"));
      imgPb = ImageIO.read(getClass().getResource("Elements/Pb.png"));
      
      imgHe = ImageIO.read(getClass().getResource("Elements/He.png"));
      imgB = ImageIO.read(getClass().getResource("Elements/B.png"));
      imgC = ImageIO.read(getClass().getResource("Elements/C.png"));
      imgN = ImageIO.read(getClass().getResource("Elements/N.png"));
      imgO = ImageIO.read(getClass().getResource("Elements/O.png"));
      imgF = ImageIO.read(getClass().getResource("Elements/F.png"));
      imgNe = ImageIO.read(getClass().getResource("Elements/Ne.png"));
      imgAl = ImageIO.read(getClass().getResource("Elements/Al.png"));
      imgSi = ImageIO.read(getClass().getResource("Elements/Si.png"));
      imgP = ImageIO.read(getClass().getResource("Elements/P.png"));
      imgS = ImageIO.read(getClass().getResource("Elements/S.png"));
      imgCl = ImageIO.read(getClass().getResource("Elements/Cl.png"));
      imgAr = ImageIO.read(getClass().getResource("Elements/Ar.png"));
      imgAs = ImageIO.read(getClass().getResource("Elements/As.png"));
      imgSe = ImageIO.read(getClass().getResource("Elements/Se.png"));
      imgBr = ImageIO.read(getClass().getResource("Elements/Br.png"));
      imgTe = ImageIO.read(getClass().getResource("Elements/Te.png"));
      imgI = ImageIO.read(getClass().getResource("Elements/I.png"));
      imgAt = ImageIO.read(getClass().getResource("Elements/At.png"));
      
      
      img1 = ImageIO.read(getClass().getResource("Numbers/1.png"));
      img2 = ImageIO.read(getClass().getResource("Numbers/2.png"));
      img3 = ImageIO.read(getClass().getResource("Numbers/3.png"));
      img4 = ImageIO.read(getClass().getResource("Numbers/4.png"));
      img5 = ImageIO.read(getClass().getResource("Numbers/5.png"));
      img6 = ImageIO.read(getClass().getResource("Numbers/6.png"));
      img7 = ImageIO.read(getClass().getResource("Numbers/7.png"));
      img8 = ImageIO.read(getClass().getResource("Numbers/8.png"));
      img9 = ImageIO.read(getClass().getResource("Numbers/9.png"));
      img10 = ImageIO.read(getClass().getResource("Numbers/10.png"));
    }catch(IOException e){}
    
    H = new JButton("");
    H.setIcon(new ImageIcon(imgH));
    H.setSize(41, 45);
    H.setLocation(16, 8);
    H.addActionListener(this);
    
    Li = new JButton("");
    Li.setIcon(new ImageIcon(imgLi));
    Li.setSize(41, 45);
    Li.setLocation(16, 54);
    Li.addActionListener(this);
    
    Be = new JButton("");
    Be.setIcon(new ImageIcon(imgBe));
    Be.setSize(41, 45);
    Be.setLocation(56, 54);
    Be.addActionListener(this);
    
    Na = new JButton("");
    Na.setIcon(new ImageIcon(imgNa));
    Na.setSize(41, 45);
    Na.setLocation(16, 99);
    Na.addActionListener(this);
    
    Mg = new JButton("");
    Mg.setIcon(new ImageIcon(imgMg));
    Mg.setSize(41, 45);
    Mg.setLocation(56, 99);
    Mg.addActionListener(this);
    
    K = new JButton("");
    K.setIcon(new ImageIcon(imgK));
    K.setSize(41, 45);
    K.setLocation(16, 144);
    K.addActionListener(this);
    
    Ca = new JButton("");
    Ca.setIcon(new ImageIcon(imgCa));
    Ca.setSize(41, 45);
    Ca.setLocation(56, 144);
    Ca.addActionListener(this);
    
    Rb = new JButton("");
    Rb.setIcon(new ImageIcon(imgRb));
    Rb.setSize(41, 45);
    Rb.setLocation(16, 189);
    Rb.addActionListener(this);
    
    Sr = new JButton("");
    Sr.setIcon(new ImageIcon(imgSr));
    Sr.setSize(41, 45);
    Sr.setLocation(56, 189);
    Sr.addActionListener(this);
    
    Cs = new JButton("");
    Cs.setIcon(new ImageIcon(imgCs));
    Cs.setSize(41, 45);
    Cs.setLocation(16, 234);
    Cs.addActionListener(this);
    
    Ba = new JButton("");
    Ba.setIcon(new ImageIcon(imgBa));
    Ba.setSize(41, 45);
    Ba.setLocation(56, 234);
    Ba.addActionListener(this);
    
    Fr = new JButton("");
    Fr.setIcon(new ImageIcon(imgFr));
    Fr.setSize(41, 45);
    Fr.setLocation(16, 279);
    Fr.addActionListener(this);
    
    Ra = new JButton("");
    Ra.setIcon(new ImageIcon(imgRa));
    Ra.setSize(41, 45);
    Ra.setLocation(56, 279);
    Ra.addActionListener(this);
    
    Ti = new JButton("");
    Ti.setIcon(new ImageIcon(imgTi));
    Ti.setSize(41, 45);
    Ti.setLocation(175, 144);
    Ti.addActionListener(this);
    
    Cr = new JButton("");
    Cr.setIcon(new ImageIcon(imgCr));
    Cr.setSize(41, 45);
    Cr.setLocation(254, 144);
    Cr.addActionListener(this);
    
    Mn = new JButton("");
    Mn.setIcon(new ImageIcon(imgMn));
    Mn.setSize(41, 45);
    Mn.setLocation(294, 144);
    Mn.addActionListener(this);
    
    Fe = new JButton("");
    Fe.setIcon(new ImageIcon(imgFe));
    Fe.setSize(41, 45);
    Fe.setLocation(332, 144);
    Fe.addActionListener(this);
    
    Co = new JButton("");
    Co.setIcon(new ImageIcon(imgCo));
    Co.setSize(41, 45);
    Co.setLocation(372, 144);
    Co.addActionListener(this);
    
    Ni = new JButton("");
    Ni.setIcon(new ImageIcon(imgNi));
    Ni.setSize(41, 45);
    Ni.setLocation(412, 144);
    Ni.addActionListener(this);
    
    Cu = new JButton("");
    Cu.setIcon(new ImageIcon(imgCu));
    Cu.setSize(41, 45);
    Cu.setLocation(452, 144);
    Cu.addActionListener(this);
    
    Zn = new JButton("");
    Zn.setIcon(new ImageIcon(imgZn));
    Zn.setSize(41, 45);
    Zn.setLocation(492, 144);
    Zn.addActionListener(this);
    
    Ag = new JButton("");
    Ag.setIcon(new ImageIcon(imgAg));
    Ag.setSize(41, 45);
    Ag.setLocation(452, 189);
    Ag.addActionListener(this);
    
    Pt = new JButton("");
    Pt.setIcon(new ImageIcon(imgPt));
    Pt.setSize(41, 45);
    Pt.setLocation(412, 233);
    Pt.addActionListener(this);
    
    Au = new JButton("");
    Au.setIcon(new ImageIcon(imgAu));
    Au.setSize(41, 45);
    Au.setLocation(452, 233);
    Au.addActionListener(this);
    
    Hg = new JButton("");
    Hg.setIcon(new ImageIcon(imgHg));
    Hg.setSize(41, 45);
    Hg.setLocation(492, 233);
    Hg.addActionListener(this);
    
    Sn = new JButton("");
    Sn.setIcon(new ImageIcon(imgSn));
    Sn.setSize(41, 45);
    Sn.setLocation(569, 189);
    Sn.addActionListener(this);
    
    Pb = new JButton("");
    Pb.setIcon(new ImageIcon(imgPb));
    Pb.setSize(41, 45);
    Pb.setLocation(569, 234);
    Pb.addActionListener(this);
    
    He = new JButton("");
    He.setIcon(new ImageIcon(imgHe));
    He.setSize(41, 45);
    He.setLocation(729, 8);
    He.addActionListener(this);   
    
    Ne = new JButton("");
    Ne.setIcon(new ImageIcon(imgNe));
    Ne.setSize(41, 45);
    Ne.setLocation(729, 53);
    Ne.addActionListener(this);
    
    F = new JButton("");
    F.setIcon(new ImageIcon(imgF));
    F.setSize(41, 45);
    F.setLocation(689, 54);
    F.addActionListener(this);
    
    O = new JButton("");
    O.setIcon(new ImageIcon(imgO));
    O.setSize(41, 45);
    O.setLocation(650, 54);
    O.addActionListener(this);  
    
    N = new JButton("");
    N.setIcon(new ImageIcon(imgN));
    N.setSize(41, 45);
    N.setLocation(610, 54);
    N.addActionListener(this);
    
    C = new JButton("");
    C.setIcon(new ImageIcon(imgC));
    C.setSize(41, 45);
    C.setLocation(570, 54);
    C.addActionListener(this);
    //thepanel.add(C);
    
    B = new JButton("");
    B.setIcon(new ImageIcon(imgB));
    B.setSize(41, 45);
    B.setLocation(530, 54);
    B.addActionListener(this);
    
    Ar = new JButton("");
    Ar.setIcon(new ImageIcon(imgAr));
    Ar.setSize(41, 45);
    Ar.setLocation(729, 99);
    Ar.addActionListener(this);
    
    Cl = new JButton("");
    Cl.setIcon(new ImageIcon(imgCl));
    Cl.setSize(41, 45);
    Cl.setLocation(689, 99);
    Cl.addActionListener(this);
    
    
    S = new JButton("");
    S.setIcon(new ImageIcon(imgS));
    S.setSize(41, 45);
    S.setLocation(650, 99);
    S.addActionListener(this);
    
    
    P = new JButton("");
    P.setIcon(new ImageIcon(imgP));
    P.setSize(41, 45);
    P.setLocation(610, 99);
    P.addActionListener(this);
    
    
    Si = new JButton("");
    Si.setIcon(new ImageIcon(imgSi));
    Si.setSize(41, 45);
    Si.setLocation(570, 99);
    Si.addActionListener(this);
    //thepanel.add(Si);
    
    Al = new JButton("");
    Al.setIcon(new ImageIcon(imgAl));
    Al.setSize(41, 45);
    Al.setLocation(530, 99);
    Al.addActionListener(this);
    //thepanel.add(Al);
    
    As = new JButton("");
    As.setIcon(new ImageIcon(imgAs));
    As.setSize(41, 45);
    As.setLocation(610, 144);
    As.addActionListener(this);
    
    Se = new JButton("");
    Se.setIcon(new ImageIcon(imgSe));
    Se.setSize(41, 45);
    Se.setLocation(650, 144);
    Se.addActionListener(this);
    
    Br = new JButton("");
    Br.setIcon(new ImageIcon(imgBr));
    Br.setSize(41, 45);
    Br.setLocation(689, 144);
    Br.addActionListener(this);
    
    Te = new JButton("");
    Te.setIcon(new ImageIcon(imgTe));
    Te.setSize(41, 45);
    Te.setLocation(650, 189);
    Te.addActionListener(this);
    
    I = new JButton("");
    I.setIcon(new ImageIcon(imgI));
    I.setSize(41, 45);
    I.setLocation(689, 189);
    I.addActionListener(this);
    
    At = new JButton("");
    At.setIcon(new ImageIcon(imgAt));
    At.setSize(41, 45);
    At.setLocation(689, 234);
    At.addActionListener(this);
    
    but1 = new JButton("");
    but1.setIcon(new ImageIcon(img1));
    but1.setSize(40,45);
    but1.setLocation(250,530);
    but1.addActionListener(this);
    
    but2 = new JButton("");
    but2.setIcon(new ImageIcon(img2));
    but2.setSize(40,45);
    but2.setLocation(290,530);
    but2.addActionListener(this);
    
    but3 = new JButton("");
    but3.setIcon(new ImageIcon(img3));
    but3.setSize(40,45);
    but3.setLocation(330,530);
    but3.addActionListener(this);
    
    but4 = new JButton("");
    but4.setIcon(new ImageIcon(img4));
    but4.setSize(40,45);
    but4.setLocation(370,530);
    but4.addActionListener(this);
    
    but5 = new JButton("");
    but5.setIcon(new ImageIcon(img5));
    but5.setSize(40,45);
    but5.setLocation(410,530);
    but5.addActionListener(this);
    
    but6 = new JButton("");
    but6.setIcon(new ImageIcon(img6));
    but6.setSize(40,45);
    but6.setLocation(450,530);
    but6.addActionListener(this);
    
    but7 = new JButton("");
    but7.setIcon(new ImageIcon(img7));
    but7.setSize(40,45);
    but7.setLocation(490,530);
    but7.addActionListener(this);
    
    but8 = new JButton("");
    but8.setIcon(new ImageIcon(img8));
    but8.setSize(40,45);
    but8.setLocation(530,530);
    but8.addActionListener(this);
    
    but9 = new JButton("");
    but9.setIcon(new ImageIcon(img9));
    but9.setSize(40,45);
    but9.setLocation(570,530);
    but9.addActionListener(this);
    
    but10 = new JButton("");
    but10.setIcon(new ImageIcon(img10));
    but10.setSize(38,45);
    but10.setLocation(610,530);
    but10.addActionListener(this);
    
    //************************************
    //***NON VISIBLE THINGS***
    //************************************
    backbutton = new JButton("Back");
    backbutton.setSize(100, 50);
    backbutton.setLocation(700, 550);
    backbutton.addActionListener(this);
    
    //Timer
    thetimer = new Timer(1000/60,this);
    thetimer.start();
    
    //Sets the frame based on panel not frame itself
    theframe.pack();
    theframe.setVisible(true);
  }
  
  
  
  //Main Method
  public static void main(String[] args){
    nomenclature start = new nomenclature();
  }
  
}
