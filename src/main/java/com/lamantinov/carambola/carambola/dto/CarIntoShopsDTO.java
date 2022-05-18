package com.lamantinov.carambola.carambola.dto;

import com.lamantinov.carambola.carambola.entity.Car;
import com.lamantinov.carambola.carambola.entity.Owner;
import com.lamantinov.carambola.carambola.entity.Shop;
import lombok.*;

import java.util.List;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CarIntoShopsDTO {
    private List<Shop> shop;

    public static CarIntoShopsDTO of(Car car) {
        CarIntoShopsDTO carIntoShopsDTO = new CarIntoShopsDTO();
        carIntoShopsDTO.setShop(car.getShops());
        return carIntoShopsDTO;
    }
}
