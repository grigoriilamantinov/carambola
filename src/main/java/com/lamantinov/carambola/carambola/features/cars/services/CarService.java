package com.lamantinov.carambola.carambola.features.cars.services;

import com.lamantinov.carambola.carambola.features.cars.dto.CarIntoShopsDTO;
import com.lamantinov.carambola.carambola.features.cars.dto.CarWithoutShopsDTO;
import com.lamantinov.carambola.carambola.features.cars.entity.Car;
import com.lamantinov.carambola.carambola.features.common.CarambolaCRUD;

import java.util.List;

public interface CarService extends CarambolaCRUD<Car> {
    List<CarWithoutShopsDTO> getAllWithoutShopsInfo();

    CarIntoShopsDTO getCarIntoShops(int carId);

    CarWithoutShopsDTO getCarsWithoutShopsById(int carId);
}
