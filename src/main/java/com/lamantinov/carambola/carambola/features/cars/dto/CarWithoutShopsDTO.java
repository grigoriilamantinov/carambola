package com.lamantinov.carambola.carambola.features.cars.dto;

import com.lamantinov.carambola.carambola.features.cars.entity.Car;
import lombok.*;

@EqualsAndHashCode
@NoArgsConstructor
@Getter
@Setter
public class CarWithoutShopsDTO {
    private int id;
    private String brand;
    private int yearOfProduce;
    private int netWorth;

    public static CarWithoutShopsDTO of(final Car car) {
        final CarWithoutShopsDTO carsWithoutShopsDTO = new CarWithoutShopsDTO();
        carsWithoutShopsDTO.setId(car.getId());
        carsWithoutShopsDTO.setBrand(car.getBrand());
        carsWithoutShopsDTO.setYearOfProduce(car.getYearOfProduce());
        carsWithoutShopsDTO.setNetWorth(car.getNetWorth());
        return carsWithoutShopsDTO;
    }
}
