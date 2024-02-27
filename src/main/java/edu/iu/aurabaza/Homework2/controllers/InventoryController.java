package edu.iu.aurabaza.Homework2.controllers;
import edu.iu.aurabaza.Homework2.model.Guitar;
import edu.iu.aurabaza.Homework2.repository.InventoryRepository;

import edu.iu.aurabaza.Homework2.model.Builder;
import edu.iu.aurabaza.Homework2.model.Type;
import edu.iu.aurabaza.Homework2.model.Wood;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class InventoryController {

    private final InventoryRepository inventoryRepository;

    public InventoryController(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }




    @GetMapping("/search")
    public List<Guitar> searchGuitars(@RequestParam(required = false) String serialNumber,
                                      @RequestParam(required = false) Double price,
                                      @RequestParam(required = false) Builder builder,
                                      @RequestParam(required = false) String model,
                                      @RequestParam(required = false) Type type,
                                      @RequestParam(required = false) Wood backWood,
                                      @RequestParam(required = false) Wood topWood) {
        // Handle null value for price
        Double priceValue = (price != null) ? price : 0.0;

        Guitar searchCriteria = new Guitar(serialNumber, priceValue, builder, model, type, backWood, topWood);
        return inventoryRepository.search(searchCriteria);
    }
//    @CrossOrigin(origins = "*")
    @PostMapping("/add")
    public Guitar addGuitar(@RequestBody Guitar guitar) {
        inventoryRepository.addGuitar(guitar.getSerialNumber(), guitar.getPrice(), guitar.getBuilder(),
                guitar.getModel(), guitar.getType(), guitar.getBackWood(), guitar.getTopWood());
        return guitar; // Return the added guitar
    }


    @GetMapping("/find/{serialNumber}")
    public Guitar findGuitarBySerialNumber(@PathVariable String serialNumber) {
        // Use the repository to find a guitar by its serial number
        return inventoryRepository.getGuitar(serialNumber);
    }


}