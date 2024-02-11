package mathproblems;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class SequenceTest {

    Sequence sequence;

    @BeforeEach
    void setUp() {
        sequence = new Sequence();
    }

    @Test
    void lustigTest() {
        assertEquals(BigDecimal.valueOf(1), sequence.lustig(0));
        assertEquals(BigDecimal.valueOf(2), sequence.lustig(1));
        assertEquals(BigDecimal.valueOf(4.25), sequence.lustig(2));
        assertEquals(BigDecimal.valueOf(12.25), sequence.lustig(3));
        assertEquals(BigDecimal.valueOf(51.3125), sequence.lustig(4));
        assertEquals(BigDecimal.valueOf(294.3125), sequence.lustig(5));
        assertEquals(BigDecimal.valueOf(2132.578125), sequence.lustig(6));
        assertEquals(BigDecimal.valueOf(18516.578125), sequence.lustig(7));
        assertEquals(BigDecimal.valueOf(186667.83203125), sequence.lustig(8));
        assertEquals(BigDecimal.valueOf(2139792.83203125), sequence.lustig(9));
    }
}
