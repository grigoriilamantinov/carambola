package com.lamantinov.carambola.carambola.features.owners.controllers;

import com.lamantinov.carambola.carambola.features.owners.dto.OwnersCarDTO;
import com.lamantinov.carambola.carambola.features.owners.dto.OwnerWithoutCarsDTO;
import com.lamantinov.carambola.carambola.features.owners.entity.Owner;
import com.lamantinov.carambola.carambola.features.owners.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(
        @Autowired final OwnerService ownerService
    ) {
        this.ownerService = ownerService;
    }

    @GetMapping("/owners")
    public List<OwnerWithoutCarsDTO> showAllOwners() {
        return ownerService.getAllWithoutCarsInfo();
    }

    @GetMapping("/owners/{id}")
    public OwnerWithoutCarsDTO getOwner(@PathVariable final int id) {
        return ownerService.getByIdWithoutCar(id);
    }

    @PostMapping("/owners")
    public Owner addNewOwner(@RequestBody final Owner owner) {
        ownerService.save(owner);
        return owner;
    }

    @PutMapping("/owners")
    public Owner updateOwner(@RequestBody final Owner owner) {
        ownerService.save(owner);
        return owner;
    }

    @DeleteMapping("/owners/{id}")
    public String deleteOwner(@PathVariable final int id) {
        ownerService.delete(id);
        return "Owner with ID = " + id + " was deleted";
    }

    @GetMapping("/owners/{id}/car")
    public OwnersCarDTO getOwnersCar(@PathVariable final int id) {
        return ownerService.getOwnersCarById(id);
    }
}
