package edu.iu.aurabaza.Homework2.repository;

import edu.iu.aurabaza.Homework2.model.Guitar;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
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
        InventoryRepository inventoryRepository = new InventoryRepository();
        InventoryRepository.addGuitar("19111908", 500.0, "Austin", "Model1", "Electric", "Sycamore", "Maple");
        Guitar expectedGuitar = new Guitar("19111908", 500.0, "Austin", "Model1", "Electric", "Sycamore", "Maple");
        Guitar actualGuitar = inventoryRepository.getGuitar("19111908");
        assertEquals(expectedGuitar.getSerialNumber(), actualGuitar.getSerialNumber());
        assertEquals(expectedGuitar.getBuilder(), actualGuitar.getBuilder());
        assertEquals(expectedGuitar.getType(), actualGuitar.getType());
        assertEquals(expectedGuitar.getModel(), actualGuitar.getModel());
        assertEquals(expectedGuitar.getBackWood(), actualGuitar.getBackWood());
        assertEquals(expectedGuitar.getTopWood(), actualGuitar.getTopWood());
        assertEquals(expectedGuitar.getPrice(), actualGuitar.getPrice());
    }

    @Test
    void search() {
        Guitar criteriaGuitar = new Guitar(null, 500.0, null, null, null, "Sycamore", "Maple");
        InventoryRepository inventoryRepository = new InventoryRepository();
        inventoryRepository.search(criteriaGuitar).toString();
        List<Guitar> actualList = new ArrayList<Guitar>();
        assertArrayEquals(inventoryRepository.search(criteriaGuitar).toArray(), actualList.toArray());
    }
}