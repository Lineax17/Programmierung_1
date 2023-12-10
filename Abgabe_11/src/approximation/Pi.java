package approximation;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;


public class Pi {

    MathContext mathContext;

    Pi(int precision){
        mathContext = new MathContext(precision, RoundingMode.HALF_UP);
    }

    BigDecimal approximatePi(int n) {
        BigDecimal pi = BigDecimal.valueOf(0);

        for (int i = 0; i <= n; i++) {
            BigDecimal VorKlammer = BigDecimal.ONE.divide(BigDecimal.valueOf(16).pow(i), mathContext);

            BigDecimal KlammerArgument1 = BigDecimal.valueOf(4.0).divide(BigDecimal.valueOf(8L * i).add(BigDecimal.ONE), mathContext);

            BigDecimal KlammerArgument2 = BigDecimal.valueOf(2.0).divide(BigDecimal.valueOf(8L * i).add(BigDecimal.valueOf(4.0)), mathContext);

            BigDecimal KlammerArgument3 = BigDecimal.ONE.divide(BigDecimal.valueOf(8L * i).add(BigDecimal.valueOf(5.0)), mathContext);

            BigDecimal KlammerArgument4 = BigDecimal.ONE.divide(BigDecimal.valueOf(8L * i).add(BigDecimal.valueOf(6.0)), mathContext);

            BigDecimal Klammer = KlammerArgument1.subtract(KlammerArgument2).subtract(KlammerArgument3).subtract(KlammerArgument4);

            pi = pi.add(VorKlammer.multiply(Klammer));
        }
        return pi;
    }

    public static void main(String[] args) {
        Pi pi = new Pi(25);
        System.out.println(pi.approximatePi(100));
    }
}
