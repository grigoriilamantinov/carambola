package com.lamantinov.carambola.carambola.controller;

import com.lamantinov.carambola.carambola.entity.Car;
import com.lamantinov.carambola.carambola.entity.Owner;
import com.lamantinov.carambola.carambola.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(
        @Autowired OwnerService ownerService
    ) {
        this.ownerService = ownerService;
    }

    @GetMapping("/owners")
    public List<Owner> showAllOwners() {
        return ownerService.getAll();
    }

    @GetMapping("/owners/{id}")
    public Owner getOwner(@PathVariable int id) {
        return ownerService.getById(id);
    }
    @PostMapping("/owners")
    public Owner addNewOwner(@RequestBody Owner owner) {
        ownerService.save(owner);
        return owner;
    }

    @PutMapping("/owners")
    public Owner updateOwner(@RequestBody Owner owner) {
        ownerService.save(owner);
        return owner;
    }

    @DeleteMapping("/owners/{id}")
    public String deleteOwner(@PathVariable int id) {
        ownerService.delete(id);
        return "Owner with ID = " + id + " was deleted";
    }
}
