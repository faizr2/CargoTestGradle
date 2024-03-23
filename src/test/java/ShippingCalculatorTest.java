import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.faizr2.ShippingCalculator.calculateShippingCost;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ShippingCalculatorTest {

    @Test
    @Tag("Smoke")
    @DisplayName("Всё по-лёгкому")
    void lightTest() throws Exception {
        int distance = 1; // Example distance in km
        String dimensions = "small"; // Example cargo dimensions
        boolean fragile = false; // Example fragility of cargo (true or false)
        String workload = "hard"; // Example delivery service workload (very high, high, hard)
        int expectedShippingCost = 400;
        assertEquals(expectedShippingCost, calculateShippingCost(distance, dimensions, fragile, workload),
                "Значения должны быть одинаковыми");
    }

    @Test
    @Tag("Smoke")
    @DisplayName("Всё по-тяжелому, но не хрупкое")
    void hardTest() throws Exception {
        int distance = 105; // Example distance in km
        String dimensions = "large"; // Example cargo dimensions
        boolean fragile = false; // Example fragility of cargo (true or false)
        String workload = "very high"; // Example delivery service workload (very high, high, hard)
        int expectedShippingCost = 800;
        assertEquals(expectedShippingCost, calculateShippingCost(distance, dimensions, fragile, workload),
                "Значения должны быть одинаковыми");
    }

    @Test
    @Tag("Smoke")
    @DisplayName("Большое, хрупкое, на границе дальности, средняя загруженность")
    void fragileLargeTest() throws Exception {
        int distance = 29; // Example distance in km
        String dimensions = "large"; // Example cargo dimensions
        boolean fragile = true; // Example fragility of cargo (true or false)
        String workload = "high"; // Example delivery service workload (very high, high, hard)
        int expectedShippingCost = 980;
        assertEquals(expectedShippingCost, calculateShippingCost(distance, dimensions, fragile, workload),
                "Значения должны быть одинаковыми");
    }

    @Test
    @Tag("Smoke")
    @DisplayName("Небольшое, хрупкое, недалеко, незагруженное")
    void fragileNotLargeTest() throws Exception {
        int distance = 9; // Example distance in km
        String dimensions = "small"; // Example cargo dimensions
        boolean fragile = true; // Example fragility of cargo (true or false)
        String workload = "light"; // Example delivery service workload (very high, high, hard)
        int expectedShippingCost = 500;
        assertEquals(expectedShippingCost, calculateShippingCost(distance, dimensions, fragile, workload),
                "Значения должны быть одинаковыми");
    }

    @Test
    @Tag("Negative")
    @DisplayName("Далеко, большое, незагружено и хрупкое")
    void fragileFarTest() throws Exception {
        int distance = 30; // Example distance in km
        String dimensions = "large"; // Example cargo dimensions
        boolean fragile = true; // Example fragility of cargo (true or false)
        String workload = "light"; // Example delivery service workload (very high, high, hard)
        assertThrows(Exception.class, () -> calculateShippingCost(distance, dimensions, fragile, workload),
                "Должно быть выброшено исключение");
    }

    @Test
    @Tag("Negative")
    @DisplayName("Неалеко, пусто, хрупкое, пусто")
    void nullExeptionTest() throws Exception {
        int distance = 11; // Example distance in km
        String dimensions = null; // Example cargo dimensions
        boolean fragile = true; // Example fragility of cargo (true or false)
        String workload = null; // Example delivery service workload (very high, high, hard)
        assertThrows(NullPointerException.class, () -> calculateShippingCost(distance, dimensions, fragile, workload),
                "Должно быть выброшено исключение");
    }

}
