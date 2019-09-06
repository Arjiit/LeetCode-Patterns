class Solution {
    public boolean validUtf8(int[] data) {
       for (int i=0; i< data.length; i++){
           int noOfBytes = 0;
           int val = data[i];
           if (val >= 255){
               return false;
           } else if ((val & 128) == 0) {
               noOfBytes = 1;
           } else if ((val & 224) == 192) {
               noOfBytes = 2;
           } else if ((val & 240) == 224) {
               noOfBytes = 3;
           } else if ((val & 248) == 240) {
               noOfBytes = 4;
           } else {
               return false;
           }
           
           for (int j=1; j<noOfBytes; j++) {
               // checkinf first byte
               if (i + j >= data.length) {
                   return false;
               } else if ((data[i+j] & 192) != 128) { // 192 represents 11000000
                   // 128 means MSB is 10
                   return false;
               }
           }
           i = i + noOfBytes - 1;
       }
        return true;
    }
}