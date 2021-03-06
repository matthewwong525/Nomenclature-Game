import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.File;
import java.io.IOException;

public class JGraphics extends JPanel{
  //Properties
  //control boolean values to change the picture
  //Images
  BufferedImage help1 = null;
  BufferedImage ptable = null;
  BufferedImage about = null;
  BufferedImage title = null;
  BufferedImage logo = null;
  BufferedImage numberline = null;
  BufferedImage acid = null;
  BufferedImage polyatom = null;
  BufferedImage polyatom2 = null;
  BufferedImage myself = null;
  
  int intMenuSelect = 0; //0 is main menu; 1 is help; 2 is about; 3 is game; 4 is new
  boolean blnPTable = false;
  boolean blnCharge = false;
  boolean blnAlgType = false; //false is Formula; true is Name
  int intPTableY = 700;
  int intChargeY = 700;
  
  //Methods
  public void paintComponent(Graphics g){
    //paint image here
    g.clearRect(0, 0, 800, 600);
    if(intMenuSelect == 0){ //the mainmenu
      g.drawImage(title,0,0,null);
      g.drawImage(logo,5,412,null);
    }
    else if(intMenuSelect == 1){ //help screen
      g.drawImage(help1,0,0,null);
    }else if(intMenuSelect == 2){ //about screen
      g.drawImage(about,0,0,null);
      g.drawImage(logo,314,425,null);
      g.drawImage(myself,272,120,null);
    }else if(intMenuSelect == 3){ //the game itself
      if(blnPTable == true){ 
        if(intPTableY > 150){
          intPTableY -= 5;
        }
        g.drawImage(ptable,0,intPTableY,null);
      }else{
        if(intPTableY < 600){
          intPTableY += 5;
        }
        g.drawImage(ptable,0,intPTableY,null);
      }
      if(blnCharge == true){ 
        if(intChargeY > 150){
          intChargeY -= 5;
        }
        g.drawImage(polyatom2,200,intChargeY,null);
      }else{
        if(intChargeY < 600){
          intChargeY += 5;
        }
        g.drawImage(polyatom2,200,intChargeY,null);
      }
    }else if(intMenuSelect == 4){
      
    }else if(intMenuSelect == 5){
      g.drawImage(ptable,10,0,null);
    }else if(intMenuSelect == 6){
      g.drawImage(ptable,10,0,null);
      g.drawImage(numberline,250,530,null);
    }else if(intMenuSelect == 7){
      g.drawImage(acid,0,0,null);
    }else if(intMenuSelect == 8){
      g.drawImage(polyatom,0,0,null);
    }
    
  }
  
  //Constructor
  public JGraphics(){
    super();
    try{
      help1 = ImageIO.read(getClass().getResource("Images/help.png"));
      ptable = ImageIO.read(getClass().getResource("Images/ptable.png"));
      about = ImageIO.read(getClass().getResource("Images/about.png"));
      title = ImageIO.read(getClass().getResource("Images/title.png"));
      logo = ImageIO.read(getClass().getResource("Images/staulogo.png"));
      numberline = ImageIO.read(getClass().getResource("Images/numberline.png"));
      acid = ImageIO.read(getClass().getResource("Images/acid.png"));
      polyatom = ImageIO.read(getClass().getResource("Images/polyatom.png"));
      polyatom2 = ImageIO.read(getClass().getResource("Images/polyatom2.png"));
      myself = ImageIO.read(getClass().getResource("Images/myself.png"));
    }catch(IOException e){}
  }
  
  
  
  
}