public class compound{
  //Properties

  
  //Methods
  //Make a method to get and return LCM
  public static int getLCM(int intCharge1, int intCharge2){
    if(intCharge1 > intCharge2){
      if(intCharge1 % intCharge2 == 0){
       return intCharge1; 
      }else{
        return intCharge1*intCharge2;
      }   
    }else if(intCharge1 < intCharge2){
      if(intCharge2 % intCharge1 == 0){
       return intCharge2; 
      }else{
        return intCharge1*intCharge2;
      } 
    }else{
      return intCharge1;
    }
  }
  public static String subscript(String strName){
    int intLength;
    String strTemp = "";
    String strTotal = "";
    intLength = strName.length();
    for(int intCount = 0; intCount < intLength;intCount++){
      strTemp = strName.substring(intCount,intCount+1);
      if(strTemp.equals("1") || strTemp.equals("2") || strTemp.equals("3") || strTemp.equals("4") || strTemp.equals("5") || strTemp.equals("6") || strTemp.equals("7") || strTemp.equals("8") || strTemp.equals("9") || strTemp.equals("0")){
        strTotal = strTotal + "<sub>" + strName.substring(intCount,intCount+1) + "</sub>";
      }else{
        strTotal = strTotal + strName.substring(intCount,intCount+1);
      }
    }
    return strTotal;
  }
  
  //Make a method to combine the two names together and return a formula
  public static String ionic(String strName1,String strName2,int intCharge1, int intCharge2){
    String strAnswer;
    int intLCM;
    int intSubScript1;
    int intSubScript2;
    String strSubScript1;
    String strSubScript2;
    
    intLCM = getLCM(intCharge1,intCharge2);
    intSubScript1 = intLCM/intCharge1;
    intSubScript2 = intLCM/intCharge2;
    
    //Creates the subscript aspect of the answer
    if(intSubScript1 == 1){
      strSubScript1 = "";
    }else{
      strSubScript1 = intSubScript1 + "";
    }   
    if(intSubScript2 == 1){
      strSubScript2 = ""; 
    }else{
      strSubScript2 = intSubScript2 + ""; 
    }
      strAnswer = strName1+strSubScript1+strName2+strSubScript2;   
    return strAnswer;
  }
  
  public static String displayionic(String strName1,String strName2, int intCharge1, int intCharge2){
    String strAnswer;
    int intLCM;
    int intSubScript1;
    int intSubScript2;
    String strSubScript1;
    String strSubScript2;
    
    intLCM = getLCM(intCharge1,intCharge2);
    intSubScript1 = intLCM/intCharge1;
    intSubScript2 = intLCM/intCharge2;
    
    //Creates the subscript aspect of the answer
    if(intSubScript1 == 1){
      strSubScript1 = "";
    }else{
      strSubScript1 = intSubScript1 + "";
    }   
    if(intSubScript2 == 1){
      strSubScript2 = ""; 
    }else{
      strSubScript2 = intSubScript2 + ""; 
    }
      strAnswer = "<html>"+strName1+"<sub>"+strSubScript1+"</sub>"+strName2+"<sub>"+strSubScript2+"</sub></html>";
      //strName1+strSubScript1+strName2+strSubScript2;   
    return strAnswer;
  }
  
  public static String firstletter(String strPrefix,String strCompoundName){
    String strAnswer = "";
    int intLength = strPrefix.length();
    if(strCompoundName.substring(0,1).equalsIgnoreCase("a") || strCompoundName.substring(0,1).equalsIgnoreCase("o")){
      return strPrefix.substring(0,intLength-1);
    }else{
      return strPrefix;
    } 
  }
  
  //Gives out the name of the covalent compound
  public static String covalent(String strName1, String strName2, int intRandCharge1, int intRandCharge2){
    String strAnswer;
    String strName11 = "";
    String strName21 = "";
    //Get the first letter of the name and see if it is the same(just for oxygen)
    //and also take into account the fact that it might get the 2 same elements(not happen)
    if(intRandCharge1 == 2){strName11 = "di";}
    else if(intRandCharge1 == 3){strName11 = "tri";}
    else if(intRandCharge1 == 4){strName11 = compound.firstletter("tetra",strName1);}
    else if(intRandCharge1 == 5){strName11 = compound.firstletter("penta",strName1);}
    else if(intRandCharge1 == 6){strName11 = compound.firstletter("hexa",strName1);}
    else if(intRandCharge1 == 7){strName11 = compound.firstletter("hepta",strName1);}
    else if(intRandCharge1 == 8){strName11 = compound.firstletter("octa",strName1);}
    else if(intRandCharge1 == 9){strName11 = compound.firstletter("nona",strName1);}
    else if(intRandCharge1 == 10){strName11 = compound.firstletter("deca",strName1);}
    if(intRandCharge2 == 1){ strName21 = compound.firstletter("mono",strName2);}
    else if(intRandCharge2 == 2){ strName21 = "di";}
    else if(intRandCharge2 == 3){ strName21 = "tri";}
    else if(intRandCharge2 == 4){ strName21 = compound.firstletter("tetra",strName2);}
    else if(intRandCharge2 == 5){ strName21 = compound.firstletter("penta",strName2);}
    else if(intRandCharge2 == 6){ strName21 = compound.firstletter("hexa",strName2);}
    else if(intRandCharge2 == 7){ strName21 = compound.firstletter("hepta",strName2);}
    else if(intRandCharge2 == 8){ strName21 = compound.firstletter("octa",strName2);}
    else if(intRandCharge2 == 9){ strName21 = compound.firstletter("nona",strName2);}
    else if(intRandCharge2 == 10){ strName21 = compound.firstletter("deca",strName2);}
    strAnswer = strName11+strName1.toLowerCase()+ " " +strName21+ strName2.toLowerCase();
    return strAnswer;      
  }
  
  public static String formulacovalent(String strName1, String strName2,int intRandCharge1, int intRandCharge2){
    String strAnswer;
    if(intRandCharge1 == 1 && intRandCharge2 == 1){
              strAnswer = strName1+strName2;
            }else if(intRandCharge2 == 1){
              strAnswer = "<html>"+strName1+"<sub>"+intRandCharge1+"</sub>"+strName2+"</html>";
            }else if(intRandCharge1 == 1){
              strAnswer = "<html>"+strName1+strName2+"<sub>"+intRandCharge2+"</sub></html>";
            }else{
              strAnswer = "<html>"+strName1+"<sub>"+intRandCharge1+"</sub>"+strName2+"<sub>"+intRandCharge2+"</sub></html>";
            }
            return strAnswer;
  }
  public static String prefix(int intRandCharge){
    String strPrefix = "";
    if(intRandCharge == 1){ strPrefix = "";}
    else if(intRandCharge == 2){ strPrefix = "di";}
    else if(intRandCharge == 3){ strPrefix = "tri";}
    else if(intRandCharge == 4){ strPrefix = "tetra";}
    else if(intRandCharge == 5){ strPrefix = "penta";}
    else if(intRandCharge == 6){ strPrefix = "hexa";}
    else if(intRandCharge == 7){ strPrefix = "hepta";}
    else if(intRandCharge == 8){ strPrefix = "octa";}
    else if(intRandCharge == 9){ strPrefix = "nona";}
    else if(intRandCharge == 10){ strPrefix = "deca";}
    return strPrefix;
  }
  //Gives out name of the covalent compound from formula
  public static String hydrate(String strName1,String strName2,int intRandCharge){
    String strAnswer = "";
    String strPrefix = "";
    if(intRandCharge == 1){ strPrefix = "";}
    else if(intRandCharge == 2){ strPrefix = "di";}
    else if(intRandCharge == 3){ strPrefix = "tri";}
    else if(intRandCharge == 4){ strPrefix = "tetra";}
    else if(intRandCharge == 5){ strPrefix = "penta";}
    else if(intRandCharge == 6){ strPrefix = "hexa";}
    else if(intRandCharge == 7){ strPrefix = "hepta";}
    else if(intRandCharge == 8){ strPrefix = "octa";}
    else if(intRandCharge == 9){ strPrefix = "nona";}
    else if(intRandCharge == 10){ strPrefix = "deca";}
    strAnswer = strName1 + " "+ strName2 + " " + strPrefix + "hydrate";
    return strAnswer;
  }
  public static String formulahydrate(String strName1,String strName2, int intCharge1, int intCharge2,int intRandCharge){
    String strAnswer;
    int intLCM;
    int intSubScript1;
    int intSubScript2;
    String strSubScript1;
    String strSubScript2;
    String strRand;
    
    if(intRandCharge == 1){
      strRand = "";
    }else{
      strRand = intRandCharge + "";
    }
    
    intLCM = getLCM(intCharge1,intCharge2);
    intSubScript1 = intLCM/intCharge1;
    intSubScript2 = intLCM/intCharge2;
    
    //Creates the subscript aspect of the answer
    if(intSubScript1 == 1){
      strSubScript1 = "";
    }else{
      strSubScript1 = intSubScript1 + "";
    }   
    if(intSubScript2 == 1){
      strSubScript2 = ""; 
    }else{
      strSubScript2 = intSubScript2 + ""; 
    }
     strAnswer = "<html>"+strName1+"<sub>"+strSubScript1+"</sub>"+strName2+"<sub>"+strSubScript2+"</sub>" + "•" + strRand + "H<sub>2</sub>O</html>";
     return strAnswer;
  }
 public static String ansformulahydrate(String strName1,String strName2, int intCharge1, int intCharge2,int intRandCharge){
    String strAnswer;
    int intLCM;
    int intSubScript1;
    int intSubScript2;
    String strSubScript1;
    String strSubScript2;
    String strRand;
    
    if(intRandCharge == 1){
      strRand = "";
    }else{
      strRand = intRandCharge + "";
    }
    
    intLCM = getLCM(intCharge1,intCharge2);
    intSubScript1 = intLCM/intCharge1;
    intSubScript2 = intLCM/intCharge2;
    
    //Creates the subscript aspect of the answer
    if(intSubScript1 == 1){
      strSubScript1 = "";
    }else{
      strSubScript1 = intSubScript1 + "";
    }   
    if(intSubScript2 == 1){
      strSubScript2 = ""; 
    }else{
      strSubScript2 = intSubScript2 + ""; 
    }
     strAnswer = "<html>"+strName1+"<sub>"+strSubScript1+"</sub>"+strName2+"<sub>"+strSubScript2+"</sub>" + "-" + strRand + "H<sub>2</sub>O</html>";
     return strAnswer;
  }
 public static String answerforhydrates(String strName1,String strName2, int intCharge1, int intCharge2,int intRandCharge){
    String strAnswer;
    int intLCM;
    int intSubScript1;
    int intSubScript2;
    String strSubScript1;
    String strSubScript2;
    String strRand;
    
    if(intRandCharge == 1){
      strRand = "";
    }else{
      strRand = intRandCharge + "";
    }
    
    intLCM = getLCM(intCharge1,intCharge2);
    intSubScript1 = intLCM/intCharge1;
    intSubScript2 = intLCM/intCharge2;
    
    //Creates the subscript aspect of the answer
    if(intSubScript1 == 1){
      strSubScript1 = "";
    }else{
      strSubScript1 = intSubScript1 + "";
    }   
    if(intSubScript2 == 1){
      strSubScript2 = ""; 
    }else{
      strSubScript2 = intSubScript2 + ""; 
    }
     strAnswer = strName1+strSubScript1+strName2+strSubScript2 + "-" + strRand + "H2O";
     return strAnswer;
  }
 
                                         
  public static String polyatomic(String strName1,String strName2,String strPreName, int intCharge1, int intCharge2){ //Generates a formula
    String strAnswer;
    String strPolyAtom;
    int intLCM;
    int intSubScript1;
    int intSubScript2;
    String strSubScript1 = "";
    String strSubScript2 = "";
    
    intLCM = getLCM(intCharge1,intCharge2);
    intSubScript1 = intLCM/intCharge1;
    intSubScript2 = intLCM/intCharge2;
    
    //Creates the subscript aspect of the answer
    if(intSubScript1 == 1){
      strSubScript1 = "";
    }else{
      strSubScript1 = intSubScript1 + "";
    }   
    if(intSubScript2 == 1){
      strPolyAtom = strName2 + ""; 
    }else{
      strPolyAtom = "(" + strName2 + ")" + intSubScript2; 
    }
      strAnswer = strName1+strSubScript1+strPolyAtom;   
    return strAnswer;
  }
  public static String displaypolyatomic(String strName1,String strName2,String strPreName, int intCharge1, int intCharge2){ //Generates a formula
    String strAnswer;
    String strPolyAtom;
    int intLCM;
    int intSubScript1;
    int intSubScript2;
    String strSubScript1 = "";
    String strSubScript2 = "";
    
    intLCM = getLCM(intCharge1,intCharge2);
    intSubScript1 = intLCM/intCharge1;
    intSubScript2 = intLCM/intCharge2;
    
    //Creates the subscript aspect of the answer
    if(intSubScript1 == 1){
      strSubScript1 = "";
    }else{
      strSubScript1 = intSubScript1 + "";
    }   
    if(intSubScript2 == 1){
      strPolyAtom = compound.subscript(strName2) + ""; 
    }else{
      strPolyAtom = "(" + compound.subscript(strName2) + ")" + "<sub>" +intSubScript2 + "</sub>"; 
    }
      strAnswer = "<html>"+strName1+"<sub>"+strSubScript1+"</sub>"+strPolyAtom+"<html>";   
    return strAnswer;
  }
  
}