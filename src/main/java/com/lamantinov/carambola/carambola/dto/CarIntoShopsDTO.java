package com.lamantinov.carambola.carambola.dto;

import com.lamantinov.carambola.carambola.entity.Car;
import com.lamantinov.carambola.carambola.entity.Owner;
import com.lamantinov.carambola.carambola.entity.Shop;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CarIntoShopsDTO {
    private int id;
    private String brand;
    private List<ShopWithoutCarsDTO> shopWithoutCarsDTO;

    public static CarIntoShopsDTO of(Car car) {
        CarIntoShopsDTO carIntoShopsDTO = new CarIntoShopsDTO();
        carIntoShopsDTO.setId(car.getId());
        carIntoShopsDTO.setBrand(car.getBrand());
        List<ShopWithoutCarsDTO> shopPojoList = car.getShops().stream()
            .map(shop -> ShopWithoutCarsDTO.of(shop))
            .collect(Collectors.toList());

        carIntoShopsDTO.setShopWithoutCarsDTO(shopPojoList);
        return carIntoShopsDTO;
    }
}
