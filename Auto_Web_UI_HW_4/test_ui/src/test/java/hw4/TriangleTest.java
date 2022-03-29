package hw4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTest {
    @Test
    void succsessCalculationTest() throws Exception {
        Assertions.assertEquals(TriangleArea.calculateArea(4, 4, 4), 6.928203230275509);
    }

}
