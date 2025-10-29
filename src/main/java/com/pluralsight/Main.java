package com.pluralsight;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Asset> myAssets = new ArrayList<>() {{
            add(new Cash("10 Bands", "2025-10-01", 10000 ));
            add(new Vehicle("well-maintained Toyota Corolla", "2020-10-01", 15000.00,
                    "Toyota Corolla 2014", 2014, 105000));
            add(new House("older farmhouse with acreage", "2025-09-01", 150000.00,
                    "555 Old Mill Rd", 2, 2000, 12000));
            add(new House("luxury penthouse with skyline view", "2023-08-01", 1200000.00,
                    "101 Skyline Blvd", 4, 3500, 15000));
            add(new Vehicle("older sedan with low mileage", "2022-07-01", 12000.00,
                    "Honda Civic 2015", 2015, 130000));
            add(new House("beautiful beachfront property", "2021-06-01", 500000.00,
                    "123 Ocean Drive", 3, 3000, 10000));
            add(new Vehicle("compact hatchback with great fuel economy", "2019-05-01", 18000.00,
                    "Ford Fiesta 2018", 2018, 60000));
            add(new Vehicle("sports car with high performance", "2022-04-01", 30000.00,
                    "Chevrolet Camaro 2020", 2020, 25000));
            add(new House("spacious suburban home", "2024-02-01", 350000.00,
                    "456 Maple St", 4, 2500, 8000));
            add(new House("charming cottage in the mountains", "2023-01-01", 275000.00,
                    "789 Pine Ridge", 2, 1800, 6000));
            add(new Vehicle("luxury SUV with low mileage", "2024-10-01", 45000.00,
                    "BMW X5 2021", 2021, 15000));
        }};

        System.out.println("Your assets are: ");
        for (Asset asset : myAssets) {
            displayAssetInfo(asset);
        }
    }

    public static void displayAssetInfo(Asset asset) {
        System.out.printf("|%-70s|%-20s|%-22s|\n", "Description", "Date Acquired", "Current Value");
        System.out.printf("|%-70s|%-20s|$%-21.2f|\n", asset.getDescription(), asset.getDateAcquired(), asset.getValue());

        if (asset instanceof House h) {
            System.out.printf("|%-49s|%-20s|%-20s|%-22s|\n", "Address", "Condition (1 - 4)", "Square Footage", "Lot Size (sq ft)");
            System.out.printf("|%-49s|%-20d|%-20d|%-22d|\n", h.getAddress(), h.getCondition(), h.getSquareFoot(), h.getLotSize());
        }
        if (asset instanceof Vehicle v) {
            System.out.printf("|%-70s|%-20s|%-22s|\n", "Make & Model", "Year", "Mileage");
            System.out.printf("|%-70s|%-20d|%-22d|\n", v.getMakeModel(), v.getYear(), v.getOdometer());
        }
    }

}