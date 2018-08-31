/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arithmeticcoding;

import java.math.BigDecimal;

/**
 *
 * @author Edward
 */
public class Range {

    private BigDecimal high;
    private BigDecimal low;
    private String character;

    Range(BigDecimal low, BigDecimal high) {
        this.high = high.stripTrailingZeros();
        this.low = low.stripTrailingZeros();
    }

    Range(BigDecimal low, BigDecimal high, String character) {
        this.high = high.stripTrailingZeros();
        this.low = low.stripTrailingZeros();
        this.character = character;
    }

    public Range incrementValues(BigDecimal value) {
        return new Range(low, high.add(value));
    }

    public BigDecimal getHigh() {
        return high.stripTrailingZeros();
    }

    public BigDecimal getLow() {
        return low.stripTrailingZeros();
    }

    public BigDecimal getRange() {
        return high.subtract(low).stripTrailingZeros();
    }

    public String getCharacter() {
        return character;
    }

    public boolean inRange(BigDecimal value) {
        return (value.compareTo(low) == 1 || value.compareTo(low) == 0) && (value.compareTo(high) == -1);
    }

    public String toString() {
        return "low: " + low + " high: " + high;
    }
}
