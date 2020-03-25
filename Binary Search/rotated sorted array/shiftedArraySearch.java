import java.io.*;
import java.util.*;

class Solution {

  static int shiftedArrSearch(int[] shiftArr, int num) {
    int l = 0;
    int r = shiftArr.length - 1;
    
    while(l <= r) { // l <= r to take care of the case when array contains one element
      int mid = l + (r - l)/2;
      if (shiftArr[mid] == num) {
        return mid;
      } else if (shiftArr[mid] > shiftArr[l]) {
        if (num >= shiftArr[l] && num < shiftArr[mid]) { // >= so that we take left into account.
          r = mid -1;
        } else {
          l = mid + 1;
        }
      } else {
        // right half
        if (num > shiftArr[mid] && num <= shiftArr[r]) { // <= so that we take right into account.
          l = mid + 1;
        } else {
          r = mid - 1;
        }
      }
    }
    return -1;
  }

  public static void main(String[] args) {

  }

}