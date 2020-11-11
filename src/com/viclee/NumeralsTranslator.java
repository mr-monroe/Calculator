package com.viclee;
import java.util.*;

public class NumeralsTranslator {
    // enum of valid input Roman numbers
    enum romanNumber{
        I, II, III, IV, V, VI, VII, VIII, IX, X
    }

    private final static TreeMap<Integer, String> map = new TreeMap<Integer, String>();
    static {
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
    }

    public static int ToArab(String romanNum) throws TranslatorException {
        int arabNum = romanNumber.valueOf(romanNum).ordinal() + 1;
        return arabNum;
    }

    public static String ToRoman(int num){
        int tmp =  map.floorKey(num);
        if ( num == tmp ) {
            return map.get(num);
        }
        return map.get(tmp) + ToRoman(num - tmp);
    }
}

class TranslatorException extends Exception{
    public TranslatorException(String message){
        super(message);
    }
}