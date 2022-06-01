package com.lamantinov.carambola.carambola.features.cars.services;

import com.lamantinov.carambola.carambola.features.cars.dao.CarRepository;
import com.lamantinov.carambola.carambola.features.cars.dto.CarIntoShopsDTO;
import com.lamantinov.carambola.carambola.features.cars.dto.CarWithoutShopsDTO;
import com.lamantinov.carambola.carambola.features.cars.entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    public CarServiceImpl(
        @Autowired CarRepository carRepository
    ) {
        this.carRepository = carRepository;
    }

    @Override
    public List<Car> getAll() {
        return carRepository.findAll();
    }

    @Override
    public List<CarWithoutShopsDTO> getAllWithoutShopsInfo() {
        return carRepository.findAll().stream()
            .map(car -> CarWithoutShopsDTO.of(car))
            .collect(Collectors.toList());
    }

    @Override
    public CarIntoShopsDTO getCarIntoShops(final int carId) {
        return CarIntoShopsDTO.of(carRepository.getById(carId));
    }

    @Override
    public void save(Car car) {
        carRepository.save(car);
    }

    @Override
    public Car getById(final int carId) {
        return carRepository.getById(carId);
    }

    @Override
    public CarWithoutShopsDTO getCarsWithoutShopsById(final int carId) {
        return CarWithoutShopsDTO.of(carRepository.getById(carId));
    }

    @Override
    public void updateCar(Car car) {
        carRepository.saveAndFlush(car);
    }

    @Override
    public void delete(final int carId) {
        carRepository.deleteById(carId);
    }

}
