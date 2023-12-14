package approximation;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;


public class Pi {

    MathContext mathContext;

    Pi(int precision){
        mathContext = new MathContext(precision, RoundingMode.HALF_UP);
    }

    BigDecimal approximatePi(int n) {
        BigDecimal pi = new BigDecimal(BigInteger.ZERO);

        for (int i = 0; i <= n; i++) {
            BigDecimal vorKlammer = BigDecimal.ONE.divide(BigDecimal.valueOf(16).pow(i), mathContext);

            BigDecimal klammerArgument1 = BigDecimal.valueOf(4.0).divide(BigDecimal.valueOf(8L * i).add(BigDecimal.ONE), mathContext);

            BigDecimal klammerArgument2 = BigDecimal.valueOf(2.0).divide(BigDecimal.valueOf(8L * i).add(BigDecimal.valueOf(4.0)), mathContext);

            BigDecimal klammerArgument3 = BigDecimal.ONE.divide(BigDecimal.valueOf(8L * i).add(BigDecimal.valueOf(5.0)), mathContext);

            BigDecimal klammerArgument4 = BigDecimal.ONE.divide(BigDecimal.valueOf(8L * i).add(BigDecimal.valueOf(6.0)), mathContext);

            BigDecimal klammer = klammerArgument1.subtract(klammerArgument2).subtract(klammerArgument3).subtract(klammerArgument4);

            pi = pi.add(vorKlammer.multiply(klammer), mathContext);
        }
        return pi;
    }

    public static void main(String[] args) {
        Pi pi = new Pi(25);
        System.out.println(pi.approximatePi(100));
    }
}
