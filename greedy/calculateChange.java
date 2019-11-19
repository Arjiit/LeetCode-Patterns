import java.util.*;
class Main {
  public static void main(String[] args) {
    calculateChange(50, 8.75);
  }
    static String[] notesInWords = new String[]{"Fifty Pounds","Twenty Pounds","Ten Pounds","Five Pounds","Two Pounds","One Pound", "Fifty Pence","Twenty Pence","Ten Pence","Five Pence","Two Pence","One Pence"};
    static String[] notesInWordsDecimal = new String[]{"Fifty Pence","Twenty Pence","Ten Pence","Five Pence","Two Pence","One Pence"};
    static double[] notes = new double[]{50, 20, 10, 5, 2, 1, 0.50, 0.20, 0.10, 0.05, 0.02, 0.01};
    static double[] noteCounter = new double[12];
    
  public static void calculateChange(double purchasePrice, double cash) {

    if (cash == purchasePrice) {
      System.out.println(0);
    }
    
    if (cash < purchasePrice) {
      System.out.println("ERROR");
      return;
    }
    
    double change = cash - purchasePrice;
    double decimalChange = change - Math.floor(change);
    change = Math.floor(change);
    
    getNoteCount(noteCounter, change, decimalChange);
    
    StringBuilder sb = new StringBuilder();
    sb.append(getString(noteCounter, notesInWords));
    sb.setLength(sb.length() -1);
    System.out.println(sb.toString());
    
  }
  
  public static void getNoteCount(double[] noteCounter, double change, double decimalChange) {
    for (int i=0; i<12; i++) {
      if (i < 6 && change >= notes[i]) {
        noteCounter[i] = Math.floor(change/notes[i]);
        change = change - noteCounter[i]*notes[i];
      } else {
          if (decimalChange >= notes[i]) {
        noteCounter[i] = 1;
        double newDecimalChange = decimalChange*100;
        double newDecimaNote = notes[i]*100;
        decimalChange = decimalChange - notes[i];
        decimalChange = (double) (newDecimalChange - newDecimaNote)/100;
      }
      }
    }
  }
  
  
  public static String getString(double[] count, String[] notesInWords) {
    StringBuilder sb = new StringBuilder();
    for (int i=0; i<count.length; i++) {
      if (count[i] != 0) {
        for (int j =0; j< count[i]; j++) {
          sb.append(notesInWords[i]);
          sb.append(" ,");
        } 
      }
    }
    return sb.toString();
  }
}
  
  
