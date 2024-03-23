package org.faizr2;
public class ShippingCalculator {

    public static int calculateShippingCost(int distance, String dimensions, boolean fragile, String workload) throws Exception {

        if ((dimensions == null) || (workload == null)) {
            throw new NullPointerException("Значения размерности и загруженности не должны быть null");
        }

        int baseCost = 0;

        if (distance < 2) {
            baseCost += 50;
        } else if (distance < 10) {
            baseCost += 100;
        } else if (distance <30) {
            baseCost += 200;
        } else {
            baseCost += 300;
        }

        if (dimensions.equals("large")) {
            baseCost += 200;
        } else {
            baseCost += 100;
        }

        if (fragile) {
            if (distance >= 30) {
                throw new Exception("Хрупкие грузы не доставляются на расстояние более 30 км");
                // System.out.println("Хрупкие грузы не доставляются на расстояние более 30 км");
            } else {
                baseCost += 300;
            }
        }

        double deliveryFactor = 1.0;
        switch (workload) {
            case "very high":
                deliveryFactor = 1.6;
                break;
            case "high":
                deliveryFactor = 1.4;
                break;
            case "hard":
                deliveryFactor = 1.2;
                break;
            default:
                break;
        }

        int totalCost = (int) Math.round(baseCost * deliveryFactor);
        return Math.max(totalCost, 400); // Minimum delivery amount is 400 rubles
    }
}