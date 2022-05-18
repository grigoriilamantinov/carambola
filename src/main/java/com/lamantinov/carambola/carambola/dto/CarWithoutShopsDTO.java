package com.lamantinov.carambola.carambola.dto;

import com.lamantinov.carambola.carambola.entity.Car;
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

    public CarWithoutShopsDTO(int id, String brand, int yearOfProduce, int netWorth) {
        this.id = id;
        this.brand = brand;
        this.yearOfProduce = yearOfProduce;
        this.netWorth = netWorth;
    }

    public static CarWithoutShopsDTO of(Car car) {
        CarWithoutShopsDTO carsWithoutShopsDTO = new CarWithoutShopsDTO();
        carsWithoutShopsDTO.setId(car.getId());
        carsWithoutShopsDTO.setBrand(car.getBrand());
        carsWithoutShopsDTO.setYearOfProduce(car.getYearOfProduce());
        carsWithoutShopsDTO.setNetWorth(car.getNetWorth());
        return carsWithoutShopsDTO;
    }
}
