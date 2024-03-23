import org.faizr2.ShippingCalculator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
