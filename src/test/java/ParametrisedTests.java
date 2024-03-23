import org.faizr2.ShippingCalculator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Всё вроде бы работает, но стало появляться непонятное сообщение:
//"
//SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
//SLF4J: Defaulting to no-operation (NOP) logger implementation
//SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
//"
// В целом тему поняла и разобралась, надеюсь в гите тоже всё видно, что сумела сваять.

public class ParametrisedTests {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    void sourceTest(int distance) throws Exception {
        String dimensions = "small";
        boolean fragile = false;
        String workload = "light";
        int expectedShippingCost = 400;
        assertEquals(expectedShippingCost, ShippingCalculator.calculateShippingCost(distance, dimensions, fragile, workload),
                "Значения должны быть одинаковыми");

    }
}
