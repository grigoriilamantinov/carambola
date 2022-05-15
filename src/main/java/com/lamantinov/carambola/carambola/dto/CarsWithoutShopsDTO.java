package com.lamantinov.carambola.carambola.dto;

import com.lamantinov.carambola.carambola.entity.Car;
import lombok.*;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CarsWithoutShopsDTO {
    private int id;
    private String brand;
    private int yearOfProduce;
    private int netWorth;


    public static CarsWithoutShopsDTO of(Car car) {
        return new CarsWithoutShopsDTO(
            car.getId(),
            car.getBrand(),
            car.getYearOfProduce(),
            car.getNetWorth()
        );
    }
}
