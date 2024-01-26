package edu.iu.aurabaza.Homework2.repository;

import edu.iu.aurabaza.Homework2.model.Guitar;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class InventoryRepository {

    private static final String DATABASE_FILE = "guitars_database.txt";
    private static List<Guitar> guitarList = new ArrayList<>();

    public static void addGuitar(String serialNumber, double price, String builder,
                                 String model, String type, String backWood, String topWood) {
        Guitar guitar = new Guitar(serialNumber, price, builder, model, type, backWood, topWood);
        guitarList.add(guitar);
        System.out.println("Guitar added to list");

        // Now adding guitar to the text file
        try (FileWriter writer = new FileWriter(DATABASE_FILE, true)) {
            // Append the guitar information to the file
            writer.write(serialNumber + ", " + price + ", " + builder + ", " + model + ", " + type + ", " +
                    backWood + ", " + topWood + "\n");
            System.out.println("Guitar added to the database.");
        } catch (IOException e) {
            System.out.println("Error writing to the database file.");
            e.printStackTrace();
        }
    }

    public Guitar getGuitar(String serialNumber) {
        for (Guitar guitar : guitarList) {
            if (guitar.getSerialNumber().equals(serialNumber)) {
                return guitar;
            }
        }
        return null; //serial number not found
    }


    public List<Guitar> search(Guitar searchCriteria) {
        List<Guitar> matchingGuitars = new ArrayList<>();
        for (Guitar guitar : guitarList) {
            if (matchesCriteria(guitar, searchCriteria)) {
                matchingGuitars.add(guitar);
            }
        }
        return matchingGuitars;
    }

    private boolean matchesCriteria(Guitar guitar, Guitar criteria) {
        if (criteria.getSerialNumber() != null && !guitar.getSerialNumber().equals(criteria.getSerialNumber())) {
            return false;
        }
        if (criteria.getPrice() != 0 && guitar.getPrice() != criteria.getPrice()) {
            return false;
        }
        if (criteria.getBuilder() != null && !guitar.getBuilder().equalsIgnoreCase(criteria.getBuilder())) {
            return false;
        }
        if (criteria.getModel() != null && !guitar.getModel().equalsIgnoreCase(criteria.getModel())) {
            return false;
        }
        if (criteria.getType() != null && !guitar.getType().equalsIgnoreCase(criteria.getType())) {
            return false;
        }
        if (criteria.getBackWood() != null && !guitar.getBackWood().equalsIgnoreCase(criteria.getBackWood())) {
            return false;
        }
        if (criteria.getTopWood() != null && !guitar.getTopWood().equalsIgnoreCase(criteria.getTopWood())) {
            return false;
        }
        return true; // Guitar matches all provided criteria
    }


    private Guitar stringToGuitar(String str) {
        // Convert a String representation back to a Guitar object
        String[] parts = str.split(",");
        return new Guitar(parts[0], Double.parseDouble(parts[1]), parts[2],
                parts[3], parts[4], parts[5], parts[6]);
    }
}