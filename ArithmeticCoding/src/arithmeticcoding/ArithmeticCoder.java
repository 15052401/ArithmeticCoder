/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arithmeticcoding;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author Edward
 */
public class ArithmeticCoder {


    private HashMap<String, Range> createRange(String string) {
        char[] charArray = string.toCharArray();
        Arrays.sort(charArray);
        HashMap<String, Range> ranges = new HashMap<>();
        int numberOfDecimals = ((string.length() + 5) / 10) + 2;//calculates the number of decimal places that are required to be able to store the string correctly

        BigDecimal spacePerValue = new BigDecimal("1.0");
        spacePerValue = spacePerValue.divide(new BigDecimal(string.length()), numberOfDecimals, RoundingMode.HALF_UP);

        BigDecimal current = new BigDecimal("0");
        for (char c : charArray) {
            if (ranges.containsKey(String.valueOf(c))) {
                ranges.put((String.valueOf(c)), ranges.get(String.valueOf(c)).incrementValues(spacePerValue));
                current = current.add(spacePerValue);
            } else {
                ranges.put((String.valueOf(c)), new Range(current, current.add(spacePerValue)));
                current = current.add(spacePerValue);
            }
        }
        return ranges;
    }

    public EncodedString encode(String string) {
        EncodedString result;
        if (string.length() > 0) {
            HashMap<String, Range> ranges = createRange(string);
            BigDecimal high = new BigDecimal("1.0");
            BigDecimal low = new BigDecimal("0.0");
            BigDecimal range;
            for (char c : string.toCharArray()) {
                range = high.subtract(low);
                high = new BigDecimal(String.valueOf(ranges.get((String.valueOf(c))).getHigh())).multiply(range).add(low);
                low = new BigDecimal(String.valueOf(ranges.get((String.valueOf(c))).getLow())).multiply(range).add(low);
            }
            result = new EncodedString(createDecodingArray(ranges), low, string.length());
        } else {
            result = new EncodedString(null, null, 0);
        }
        return result;
    }

    private ArrayList<Range> createDecodingArray(HashMap<String, Range> ranges) {
        ArrayList<Range> rangesArray = new ArrayList();
        for (Map.Entry<String, Range> entry : ranges.entrySet()) {
            rangesArray.add(new Range(entry.getValue().getLow(), entry.getValue().getHigh(), entry.getKey()));
        }
        return rangesArray;

    }

    public String decode(EncodedString encodedString) {
        String result = "Encoded object empty";
        if (encodedString.getLength() != 0) {
            result = "";
            BigDecimal low = encodedString.getStringLow();
            Iterator<Range> itr;
            boolean found;
            for (int i = 0; i < encodedString.getLength(); i++) {
                found = false;
                itr = encodedString.getRanges().iterator();
                while(itr.hasNext() && !found){
                    Range r = itr.next();
                    if (r.inRange(low)) {
                        result += r.getCharacter();
                        low = low.subtract(r.getLow()).divide(r.getRange());
                        found = true;
                    }
                }
            }
        }
        return result;
    }

}
