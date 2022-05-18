package com.lamantinov.carambola.carambola.service;

import com.lamantinov.carambola.carambola.dao.CarRepository;
import com.lamantinov.carambola.carambola.dto.CarIntoShopsDTO;
import com.lamantinov.carambola.carambola.dto.CarWithoutShopsDTO;
import com.lamantinov.carambola.carambola.entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService implements ServiceInterface <Car> {

    private final CarRepository carRepository;

    public CarService(
        @Autowired CarRepository carRepository
    ) {
        this.carRepository = carRepository;
    }

    @Override
    public List<Car> getAll() {
        List <Car> allCars = carRepository.findAll();
        return allCars;
    }

    public List<CarWithoutShopsDTO> getAllWithoutShopsInfo() {
        return carRepository.findAll().stream()
            .map(car -> CarWithoutShopsDTO.of(car))
            .collect(Collectors.toList());
    }

    public CarIntoShopsDTO getCarIntoShops(int id) {
        return CarIntoShopsDTO.of(carRepository.getById(id));
    }

    @Override
    public void save(Car car) {
        carRepository.save(car);
    }

    @Override
    public Car getById(int id) {
        return carRepository.getById(id);
    }

    public CarWithoutShopsDTO getCarsWithoutShopsById(int id) {
        return CarWithoutShopsDTO.of(carRepository.getById(id));
    }

    @Override
    public void delete(int id) {
        carRepository.deleteById(id);
    }
}
