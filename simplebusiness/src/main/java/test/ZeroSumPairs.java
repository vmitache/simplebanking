package test;

import java.util.HashSet;
import java.util.Set;

public class ZeroSumPairs {

  static class SimetricalIntPair {
    public int i1;
    public int i2;
    
    

    public SimetricalIntPair(int pI1, int pI2) {
      super();
      i1 = pI1;
      i2 = pI2;
    }

    @Override
    public String toString() {
      return "IntPair [i1=" + i1 + ", i2=" + i2 + "]";
    }

    @Override
    public int hashCode() {
      return Integer.valueOf(i1 + i2).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (getClass() != obj.getClass())
        return false;
      SimetricalIntPair other = (SimetricalIntPair) obj;
      if (i1 != other.i1) {
        if (i1 != other.i2) {
          return false;
        }
        // i1 === other.i2
        if (i2 != other.i1) {
          return false;
        }
        // i1 == other.i2 && i2 == other.i1
        return true;
      }
      // i1 == other.i1
      if (i2 != other.i2) {
        return false;
      }
      return true;
    }

  }

  static Set<SimetricalIntPair> getZeroSumPairs(int[] pArray) {
    Set<SimetricalIntPair> result = new HashSet<>();
    for (int i = 0; i < pArray.length; i++) {
      for (int j = i+1; j < pArray.length; j++) {
        if(pArray[i] + pArray[j] == 0) {
          if(i != j) {
            result.add(new SimetricalIntPair(pArray[i], pArray[j]));
          }
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(getZeroSumPairs(new int [] {
        -1,0,3,5,1,-5,1,0
    }));

  }

}
