package org.faizr2;

import static org.faizr2.ShippingCalculator.calculateShippingCost;

public class Main {

    public static void main(String[] args) throws Exception {
        int distance = 30; // Example distance in km
        String dimensions = "large"; // Example cargo dimensions
        boolean fragile = true; // Example fragility of cargo (true or false)
        String workload = "high"; // Example delivery service workload (very high, high, hard)

        int shippingCost = calculateShippingCost(distance, dimensions, fragile, workload);
        System.out.println("Shipping cost: " + shippingCost + " rubles");
    }

}
