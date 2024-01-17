package mathproblems;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class SequenceTest {
    @Test
    void sequence() {
        Sequence sequence = new Sequence();
        assertEquals(BigDecimal.valueOf(1), sequence.lustig(0));

    }
}
