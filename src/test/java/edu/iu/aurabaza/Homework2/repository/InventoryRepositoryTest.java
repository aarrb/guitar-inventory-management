package edu.iu.aurabaza.Homework2.repository;

import edu.iu.aurabaza.Homework2.model.Guitar;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import edu.iu.aurabaza.Homework2.model.Builder;
import edu.iu.aurabaza.Homework2.model.Type;
import edu.iu.aurabaza.Homework2.model.Wood;

import static org.junit.jupiter.api.Assertions.*;

class InventoryRepositoryTest {

    @Test
    void addGuitar1() throws IOException {
        String expected = "19111908" + ", " + 500.0 + ", " + "Fender" +
                ", Model1, Electric, Maple, Alder";
        InventoryRepository.addGuitar("19111908", 500.0, Builder.FENDER, "Model1", Type.ELECTRIC, Wood.MAPLE, Wood.ALDER);
        assertTrue(Files.readAllLines(Path.of("guitars_database.txt"))
                        .contains(expected),
                "inventory must contain added guitar");
    }

    @Test
    void addGuitar2() throws IOException {
        String expected = "19201906" + ", " + 750.0 + ", " + "Martin" +
                ", Mizuramu, Acoustic, Mahogany, Sitka";
        InventoryRepository.addGuitar("19201906", 750.0, Builder.MARTIN, "Mizuramu", Type.ACOUSTIC, Wood.MAHOGANY, Wood.SITKA);
        assertTrue(Files.readAllLines(Path.of("guitars_database.txt"))
                        .contains(expected),
                "inventory must contain added guitar");
    }

    @Test
    void getGuitar() {
        InventoryRepository inventoryRepository = new InventoryRepository();
        InventoryRepository.addGuitar("19111908", 500.0, Builder.FENDER, "Model1", Type.ELECTRIC, Wood.MAPLE, Wood.ALDER);
        Guitar expectedGuitar = new Guitar("19111908", 500.0, Builder.FENDER, "Model1", Type.ELECTRIC, Wood.MAPLE, Wood.ALDER);
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
        Guitar criteriaGuitar = new Guitar(null, 500.0, null, null, null, Wood.MAPLE, Wood.ALDER);
        InventoryRepository inventoryRepository = new InventoryRepository();
        assertTrue(inventoryRepository.search(criteriaGuitar).toArray().length >= 1);
    }
}