/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arithmeticcoding;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Edward
 */
public class EncodedString {

    private ArrayList<Range> rangesArray;
    private BigDecimal encodedStringLow;
    private int length;

    EncodedString(ArrayList<Range> rangesArray, BigDecimal encodedStringLow,int length) {
        this.rangesArray = rangesArray;
        this.encodedStringLow = encodedStringLow;
        this.length = length;
    }

    public BigDecimal getStringLow() {
        return encodedStringLow;
    }
    public int getLength(){
        return length;
    }

    public ArrayList<Range> getRanges() {
        return rangesArray;
    }


}
