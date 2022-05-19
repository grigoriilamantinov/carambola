package com.lamantinov.carambola.carambola.controller;

import com.lamantinov.carambola.carambola.dto.CarIntoShopsDTO;
import com.lamantinov.carambola.carambola.dto.CarWithoutShopsDTO;
import com.lamantinov.carambola.carambola.entity.Car;
import com.lamantinov.carambola.carambola.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping("/")
    public class CarController {

        private final CarService carService;

        public CarController(
            @Autowired CarService carService
        ) {
            this.carService = carService;
        }

        @GetMapping("/cars")
        public List<CarWithoutShopsDTO> showAllCars() {
            return carService.getAllWithoutShopsInfo();
        }

        @GetMapping("/cars/{id}")
        public CarWithoutShopsDTO getCar(@PathVariable int id) {
            return carService.getCarsWithoutShopsById(id);
        }

        @GetMapping("/cars/{id}/shops")
        public CarIntoShopsDTO getCarIntoAllShops(@PathVariable int id) {
            return carService.getCarIntoShops(id);
        }

        @PostMapping("/cars")
        public Car addNewCar(@RequestBody Car car) {
            carService.save(car);
            return car;
        }

        @PutMapping("/cars")
        public Car updateCar(@RequestBody Car car) {
            carService.save(car);
            return car;
        }

        @DeleteMapping("/cars/{id}")
        public String deleteCar(@PathVariable int id) {
            carService.delete(id);
            return "Car with ID = " + id + " was deleted";
        }
    }
