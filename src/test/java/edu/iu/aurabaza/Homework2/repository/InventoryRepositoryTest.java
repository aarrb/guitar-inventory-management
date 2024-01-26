package edu.iu.aurabaza.Homework2.repository;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class InventoryRepositoryTest {

    @Test
    void addGuitar1() throws IOException {
        String expected = "19111908" + ", " + 500.0 + ", " + "Austin" +
                ", Model1, Electric, Sycamore, Maple";
        InventoryRepository.addGuitar("19111908", 500.0, "Austin", "Model1", "Electric", "Sycamore", "Maple");
        assertTrue(Files.readAllLines(Path.of("guitars_database.txt"))
                        .contains(expected),
                "inventory must contain added guitar");
    }

    @Test
    void addGuitar2() throws IOException{
        String expected = "19201906" + ", " + 750.0 + ", " + "Stevey" +
                ", Mizuramu, Acoustic, Oak, Birch";
        InventoryRepository.addGuitar("19201906", 750.0, "Stevey", "Mizuramu", "Acoustic", "Oak", "Birch");
        assertTrue(Files.readAllLines(Path.of("guitars_database.txt"))
                        .contains(expected),
                "inventory must contain added guitar");
    }

    @Test
    void getGuitar() {

    }

    @Test
    void search() {
    }
}