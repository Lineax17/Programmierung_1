package mathproblems;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

public class Sequence {
    private MathContext mathcontext;
    BigDecimal lustig(int n) {

        if (n < 0) {
            throw new IllegalArgumentException("n has to be greater then 0! n = " + n);
        }

        mathcontext = new MathContext(300, RoundingMode.HALF_UP);
        BigDecimal sequence = new BigDecimal(BigInteger.ZERO);

        for (int i = 0; i <= n; i++) {

            BigDecimal zaehler         = BigDecimal.valueOf(i + 1).pow(i);
            BigDecimal nenner          = BigDecimal.valueOf(2).pow(i);
            sequence                   = sequence.add(zaehler.divide(nenner, mathcontext));
        }

        return sequence;
    }

    public static void main(String[] args) {
        Sequence sequence = new Sequence();

        System.out.println(sequence.lustig(100));


    }
}
